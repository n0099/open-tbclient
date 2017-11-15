package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<g, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private int mIsGood;
    private int mLoadType;
    private int mSortType;
    private boolean needCache;
    private g responseData;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FRSPageSocketResponsedMessage() {
        super(301001);
        this.mSortType = 0;
        this.mIsGood = 0;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof FRSPageRequestMessage) {
            FRSPageRequestMessage fRSPageRequestMessage = (FRSPageRequestMessage) message.getExtra();
            this.updateType = fRSPageRequestMessage.getUpdateType();
            this.needCache = fRSPageRequestMessage.isNeedCache();
            this.mCategoryId = fRSPageRequestMessage.getCategoryId();
            this.hasNetworkError = hasError();
        } else if (message.getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) message.getExtra();
            if (mvcNetMessage.getRequestData() instanceof FrsRequestData) {
                FrsRequestData frsRequestData = (FrsRequestData) mvcNetMessage.getRequestData();
                this.updateType = frsRequestData.getUpdateType();
                this.needCache = frsRequestData.isNeedCache();
                this.mCategoryId = frsRequestData.getCategoryId();
                this.hasNetworkError = hasError();
                this.mSortType = frsRequestData.Pj();
                this.mIsGood = frsRequestData.getIsGood();
                this.mLoadType = frsRequestData.getLoadType();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new g();
        FrsPageResIdl D = this.responseData.D(bArr);
        setError(D.error.errorno.intValue());
        setErrorString(D.error.usermsg);
        setData(this.responseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int g;
        CustomResponsedMessage runTask;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.responseData.btd() != null && !StringUtils.isNull(this.responseData.btd().pJ(), true) && !this.responseData.btd().pJ().equals("0") && this.responseData.btd().pK() == 3 && (g = com.baidu.adp.lib.g.b.g(this.responseData.btd().pJ(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
            this.responseData.j(Integer.valueOf(((Integer) runTask.getData()).intValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.responseData != null) {
            boolean z = com.baidu.tbadk.core.util.v.u(this.responseData.getThreadList()) >= 15;
            if (this.needCache && this.responseData.aPU() != null && z) {
                c.bsx().c(c.bsx().d(this.responseData.aPU().getName(), this.mSortType, this.mIsGood, this.mCategoryId), bArr, true);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<FrsPageResIdl> getProtobufResponseIdlClass() {
        return FrsPageResIdl.class;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public g getResponseData() {
        return this.responseData;
    }

    public void setResponseData(g gVar) {
        this.responseData = gVar;
    }
}

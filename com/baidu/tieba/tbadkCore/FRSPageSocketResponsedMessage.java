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
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<n, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private int mIsGood;
    private int mSortType;
    private boolean needCache;
    private n responseData;
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
            if (mvcNetMessage.getRequestData() instanceof m) {
                m mVar = (m) mvcNetMessage.getRequestData();
                this.updateType = mVar.getUpdateType();
                this.needCache = mVar.isNeedCache();
                this.mCategoryId = mVar.getCategoryId();
                this.hasNetworkError = hasError();
                this.mSortType = mVar.agy();
                this.mIsGood = mVar.getIsGood();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new n();
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
        if (this.responseData.bkF() != null && !StringUtils.isNull(this.responseData.bkF().getBookId(), true) && !this.responseData.bkF().getBookId().equals("0") && this.responseData.bkF().pB() == 3 && (g = com.baidu.adp.lib.h.b.g(this.responseData.bkF().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
            this.responseData.h(Integer.valueOf(((Integer) runTask.getData()).intValue()));
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.responseData != null) {
            boolean z = com.baidu.tbadk.core.util.x.s(this.responseData.getThreadList()) >= 15;
            if (this.needCache && this.responseData.aOk() != null && z) {
                d.bkd().a(d.bkd().e(this.responseData.aOk().getName(), this.mSortType, this.mIsGood, this.mCategoryId), bArr, true);
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

    public n getResponseData() {
        return this.responseData;
    }

    public void setResponseData(n nVar) {
        this.responseData = nVar;
    }
}

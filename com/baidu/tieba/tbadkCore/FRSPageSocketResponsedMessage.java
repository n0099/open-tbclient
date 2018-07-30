package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes2.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<i, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private int mIsGood;
    private int mLoadType;
    private int mSortType;
    private boolean needCache;
    private i responseData;
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
                this.mSortType = frsRequestData.Vk();
                this.mIsGood = frsRequestData.getIsGood();
                this.mLoadType = frsRequestData.getLoadType();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new i();
        FrsPageResIdl E = this.responseData.E(bArr);
        if (E != null && E.error != null) {
            if (E.error.errorno != null) {
                setError(E.error.errorno.intValue());
                this.responseData.dsU = E.error.errorno.intValue();
            }
            setErrorString(E.error.usermsg);
        }
        setData(this.responseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int g;
        CustomResponsedMessage runTask;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.responseData.buw() != null && !StringUtils.isNull(this.responseData.buw().tN(), true) && !this.responseData.buw().tN().equals("0") && this.responseData.buw().tO() == 3 && (g = com.baidu.adp.lib.g.b.g(this.responseData.buw().tN(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
            this.responseData.q(Integer.valueOf(((Integer) runTask.getData()).intValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.responseData != null && this.needCache && this.responseData.aZl() != null) {
            int Vk = this.responseData.Vk();
            String c = c.btR().c(this.responseData.aZl().getName(), Vk, this.mIsGood, this.mCategoryId);
            if (Vk == 3) {
                c.btR().o(c, bArr);
            } else {
                c.btR().c(c, bArr, true);
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

    public i getResponseData() {
        return this.responseData;
    }

    public void setResponseData(i iVar) {
        this.responseData = iVar;
    }
}

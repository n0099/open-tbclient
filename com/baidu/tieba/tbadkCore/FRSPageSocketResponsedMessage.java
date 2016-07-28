package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.Message;
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
                this.mSortType = mVar.bdy();
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

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.responseData != null && this.responseData.aGX() != null) {
            d.bdv().a(d.bdv().e(this.responseData.aGX().getName(), this.mSortType, this.mIsGood, this.mCategoryId), bArr, true);
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

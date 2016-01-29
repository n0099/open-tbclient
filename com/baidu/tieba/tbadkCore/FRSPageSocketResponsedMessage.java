package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<m, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private boolean needCache;
    private m responseData;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FRSPageSocketResponsedMessage() {
        super(301001);
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
            if (mvcNetMessage.getRequestData() instanceof l) {
                l lVar = (l) mvcNetMessage.getRequestData();
                this.updateType = lVar.getUpdateType();
                this.needCache = lVar.isNeedCache();
                this.mCategoryId = lVar.getCategoryId();
                this.hasNetworkError = hasError();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.responseData = new m();
        FrsPageResIdl T = this.responseData.T(bArr);
        setError(T.error.errorno.intValue());
        setErrorString(T.error.usermsg);
        setData(this.responseData);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.responseData != null && this.responseData.aoE() != null) {
            c.aKN().a(c.aKN().al(this.responseData.aoE().getName(), this.mCategoryId), bArr, true);
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

    public m getResponseData() {
        return this.responseData;
    }

    public void setResponseData(m mVar) {
        this.responseData = mVar;
    }
}

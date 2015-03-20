package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<u, FrsPageResIdl> {
    private boolean hasNetworkError;
    private boolean needCache;
    private u responseData;
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
            this.hasNetworkError = hasError();
        } else if (message.getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) message.getExtra();
            if (mvcNetMessage.getRequestData() instanceof t) {
                t tVar = (t) mvcNetMessage.getRequestData();
                this.updateType = tVar.getUpdateType();
                this.needCache = tVar.isNeedCache();
                this.hasNetworkError = hasError();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.responseData = new u();
        FrsPageResIdl D = this.responseData.D(bArr);
        setError(D.error.errorno.intValue());
        setErrorString(D.error.usermsg);
        setData(this.responseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.responseData != null && this.responseData.YO() != null) {
            d.ako().a(this.responseData.YO().getName(), bArr, true);
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

    public u getResponseData() {
        return this.responseData;
    }

    public void setResponseData(u uVar) {
        this.responseData = uVar;
    }
}

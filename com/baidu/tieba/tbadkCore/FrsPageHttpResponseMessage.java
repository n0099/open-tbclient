package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FrsPageHttpResponseMessage extends MvcProtobufHttpResponsedMessage<l, FrsPageResIdl> {
    private boolean hasNetworkError;
    private boolean needCache;
    private l responseData;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FrsPageHttpResponseMessage(int i) {
        super(i);
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
            if (mvcNetMessage.getRequestData() instanceof k) {
                k kVar = (k) mvcNetMessage.getRequestData();
                this.updateType = kVar.getUpdateType();
                this.needCache = kVar.isNeedCache();
                this.hasNetworkError = hasError();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.responseData = new l();
        FrsPageResIdl U = this.responseData.U(bArr);
        if (U != null && U.error != null) {
            if (U.error.errorno != null) {
                setError(U.error.errorno.intValue());
            }
            setErrorString(U.error.usermsg);
        }
        setData(this.responseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.responseData != null && this.responseData.acG() != null) {
            c.aoQ().a(this.responseData.acG().getName(), bArr, true);
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<FrsPageResIdl> getProtobufResponseIdlClass() {
        return FrsPageResIdl.class;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public l getResponseData() {
        return this.responseData;
    }

    public void setResponseData(l lVar) {
        this.responseData = lVar;
    }
}

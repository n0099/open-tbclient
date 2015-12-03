package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FrsPageHttpResponseMessage extends MvcProtobufHttpResponsedMessage<n, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private boolean needCache;
    private n responseData;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FrsPageHttpResponseMessage() {
        super(CmdConfigHttp.FRS_HTTP_CMD);
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
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.responseData = new n();
        FrsPageResIdl U = this.responseData.U(bArr);
        if (U != null && U.error != null) {
            if (U.error.errorno != null) {
                setError(U.error.errorno.intValue());
            }
            setErrorString(U.error.usermsg);
        }
        setData(this.responseData);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.responseData != null && this.responseData.ajy() != null) {
            d.aBA().a(d.aBA().ai(this.responseData.ajy().getName(), this.mCategoryId), bArr, true);
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

    public n getResponseData() {
        return this.responseData;
    }

    public void setResponseData(n nVar) {
        this.responseData = nVar;
    }
}

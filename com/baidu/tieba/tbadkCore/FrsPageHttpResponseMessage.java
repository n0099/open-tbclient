package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FrsPageHttpResponseMessage extends MvcProtobufHttpResponsedMessage<m, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private int mIsGood;
    private int mSortType;
    private boolean needCache;
    private m responseData;
    private int updateType;

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public FrsPageHttpResponseMessage() {
        super(CmdConfigHttp.FRS_HTTP_CMD);
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
            if (mvcNetMessage.getRequestData() instanceof l) {
                l lVar = (l) mvcNetMessage.getRequestData();
                this.updateType = lVar.getUpdateType();
                this.needCache = lVar.isNeedCache();
                this.mCategoryId = lVar.getCategoryId();
                this.hasNetworkError = hasError();
                this.mSortType = lVar.aSc();
                this.mIsGood = lVar.getIsGood();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.responseData = new m();
        FrsPageResIdl A = this.responseData.A(bArr);
        if (A != null && A.error != null) {
            if (A.error.errorno != null) {
                setError(A.error.errorno.intValue());
            }
            setErrorString(A.error.usermsg);
        }
        setData(this.responseData);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.needCache && this.responseData != null && this.responseData.avD() != null) {
            c.aRZ().a(c.aRZ().d(this.responseData.avD().getName(), this.mSortType, this.mIsGood, this.mCategoryId), bArr, true);
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

    public m getResponseData() {
        return this.responseData;
    }

    public void setResponseData(m mVar) {
        this.responseData = mVar;
    }
}

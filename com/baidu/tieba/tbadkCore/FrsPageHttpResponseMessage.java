package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes2.dex */
public class FrsPageHttpResponseMessage extends MvcProtobufHttpResponsedMessage<i, FrsPageResIdl> {
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
            if (mvcNetMessage.getRequestData() instanceof FrsRequestData) {
                FrsRequestData frsRequestData = (FrsRequestData) mvcNetMessage.getRequestData();
                this.updateType = frsRequestData.getUpdateType();
                this.needCache = frsRequestData.isNeedCache();
                this.mCategoryId = frsRequestData.getCategoryId();
                this.hasNetworkError = hasError();
                this.mSortType = frsRequestData.Vb();
                this.mIsGood = frsRequestData.getIsGood();
                this.mLoadType = frsRequestData.getLoadType();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new i();
        FrsPageResIdl G = this.responseData.G(bArr);
        if (G != null && G.error != null) {
            if (G.error.errorno != null) {
                setError(G.error.errorno.intValue());
                this.responseData.dqh = G.error.errorno.intValue();
            }
            setErrorString(G.error.usermsg);
        }
        setData(this.responseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int g;
        CustomResponsedMessage runTask;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.responseData.bvS() != null && !StringUtils.isNull(this.responseData.bvS().ub(), true) && !this.responseData.bvS().ub().equals("0") && this.responseData.bvS().getBookType() == 3 && (g = com.baidu.adp.lib.g.b.g(this.responseData.bvS().ub(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
            this.responseData.q(Integer.valueOf(((Integer) runTask.getData()).intValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.responseData != null && this.needCache && this.responseData.baT() != null) {
            int Vb = this.responseData.Vb();
            String d = c.bvo().d(this.responseData.baT().getName(), Vb, this.mIsGood, this.mCategoryId);
            if (Vb == 3) {
                c.bvo().o(d, bArr);
            } else {
                c.bvo().c(d, bArr, true);
            }
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

    public i getResponseData() {
        return this.responseData;
    }

    public void setResponseData(i iVar) {
        this.responseData = iVar;
    }
}

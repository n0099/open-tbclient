package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes3.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<j, FrsPageResIdl> {
    private boolean hasNetworkError;
    private int mCategoryId;
    private int mIsGood;
    private int mLoadType;
    private int mSortType;
    private boolean needCache;
    private j responseData;
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
                this.mSortType = frsRequestData.getSortType();
                this.mIsGood = frsRequestData.getIsGood();
                this.mLoadType = frsRequestData.getLoadType();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.responseData = new j();
        FrsPageResIdl parserProtobuf = this.responseData.parserProtobuf(bArr);
        if (parserProtobuf != null && parserProtobuf.error != null) {
            if (parserProtobuf.error.errorno != null) {
                setError(parserProtobuf.error.errorno.intValue());
                this.responseData.mErrorNo = parserProtobuf.error.errorno.intValue();
            }
            setErrorString(parserProtobuf.error.usermsg);
        }
        setData(this.responseData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int f;
        CustomResponsedMessage runTask;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.responseData.getBookInfo() != null && !StringUtils.isNull(this.responseData.getBookInfo().abL(), true) && !this.responseData.getBookInfo().abL().equals("0") && this.responseData.getBookInfo().abM() == 3 && (f = com.baidu.adp.lib.g.b.f(this.responseData.getBookInfo().abL(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(f))) != null) {
            this.responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && this.responseData != null && this.needCache && this.responseData.getForum() != null) {
            int sortType = this.responseData.getSortType();
            String c = d.clw().c("1~" + this.responseData.getForum().getName(), sortType, this.mIsGood, this.mCategoryId);
            if (sortType == 3) {
                d.clw().n(c, bArr);
            } else {
                d.clw().c(c, bArr, true);
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

    public j getResponseData() {
        return this.responseData;
    }

    public void setResponseData(j jVar) {
        this.responseData = jVar;
    }
}

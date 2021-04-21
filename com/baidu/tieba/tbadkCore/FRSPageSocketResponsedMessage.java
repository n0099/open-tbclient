package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import d.b.c.e.m.b;
import d.b.j0.d3.e;
import d.b.j0.d3.m;
import tbclient.Error;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes5.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<m, FrsPageResIdl> {
    public int mCategoryId;
    public int mIsGood;
    public boolean needCache;
    public m responseData;
    public int updateType;

    public FRSPageSocketResponsedMessage() {
        super(301001);
        this.mIsGood = 0;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<FrsPageResIdl> getProtobufResponseIdlClass() {
        return FrsPageResIdl.class;
    }

    public m getResponseData() {
        return this.responseData;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof FRSPageRequestMessage) {
            FRSPageRequestMessage fRSPageRequestMessage = (FRSPageRequestMessage) message.getExtra();
            this.updateType = fRSPageRequestMessage.getUpdateType();
            this.needCache = fRSPageRequestMessage.isNeedCache();
            this.mCategoryId = fRSPageRequestMessage.getCategoryId();
        } else if (message.getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) message.getExtra();
            if (mvcNetMessage.getRequestData() instanceof FrsRequestData) {
                FrsRequestData frsRequestData = (FrsRequestData) mvcNetMessage.getRequestData();
                this.updateType = frsRequestData.getUpdateType();
                this.needCache = frsRequestData.isNeedCache();
                this.mCategoryId = frsRequestData.t();
                this.mIsGood = frsRequestData.u();
            }
        }
    }

    public void setResponseData(m mVar) {
        this.responseData = mVar;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        m mVar;
        if (hasError() || (mVar = this.responseData) == null || !this.needCache || mVar.getForum() == null) {
            return;
        }
        int sortType = this.responseData.getSortType();
        e i2 = e.i();
        String g2 = i2.g("1~" + this.responseData.getForum().getName(), sortType, this.mIsGood, this.mCategoryId);
        if (sortType == 3) {
            e.i().m(g2, bArr);
        } else {
            e.i().a(g2, bArr, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int d2;
        CustomResponsedMessage runTask;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.responseData.getBookInfo() == null || StringUtils.isNull(this.responseData.getBookInfo().a(), true) || this.responseData.getBookInfo().a().equals("0") || this.responseData.getBookInfo().b() != 3 || (d2 = b.d(this.responseData.getBookInfo().a(), -1)) <= 0 || (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(d2))) == null) {
            return;
        }
        this.responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        m mVar = new m();
        this.responseData = mVar;
        FrsPageResIdl parserProtobuf = mVar.parserProtobuf(bArr, true);
        if (parserProtobuf != null && (error = parserProtobuf.error) != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
                this.responseData.mErrorNo = parserProtobuf.error.errorno.intValue();
            }
            setErrorString(parserProtobuf.error.usermsg);
        }
        setData(this.responseData);
    }
}

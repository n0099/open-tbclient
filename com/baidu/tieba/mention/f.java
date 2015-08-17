package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.mvc.model.a;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e<SingleMentionActivity> implements NetModel.b<h, i>, a.InterfaceC0052a<i> {
    private com.baidu.tbadk.mvc.d.a aKr;
    private SingleMentionActivity bVG;
    private h bVH;
    private g bVI;
    private a bVJ;
    private FeedData bVK;
    private t bVL;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bVG = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.bVH = new h();
        this.bVI = new g(this.bVG.getPageContext(), this.bVH);
        this.bVI.a(this);
        this.bVI.setUniqueId(getUniqueId());
        this.bVJ = new a(this.bVG.getPageContext());
        this.bVJ.a(this);
        this.bVJ.setUniqueId(getUniqueId());
        this.bVL = new t();
        this.aKr = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HF() {
        if (this.bVI.isLoading() || !this.aKr.Df()) {
            return false;
        }
        this.aKr.bf(true);
        this.aKr.bh(true);
        this.bVH.b(this.bVK);
        this.bVI.setNeedCache(false);
        this.bVI.CV();
        this.bVG.abI().d(this.aKr);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bz(boolean z) {
        if (this.bVI.isLoading()) {
            return false;
        }
        this.bVK = null;
        this.bVH.reset();
        this.bVI.setNeedCache(true);
        this.bVI.CV();
        return true;
    }

    public boolean oT() {
        this.bVJ.a((com.baidu.tbadk.mvc.b.e) this.bVH);
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.bVL.abF().clear();
        }
        this.bVL.a(iVar);
        if (iVar != null && iVar.abF() != null && iVar.abF().size() > 0) {
            this.bVK = iVar.abF().get(iVar.abF().size() - 1);
            if (this.bVL.getPage() != null) {
                this.aKr.bg(this.bVL.getPage().rT() == 1);
            } else {
                this.aKr.bg(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aKr.bh(true);
        } else {
            this.bVK = null;
            this.aKr.bg(false);
            this.aKr.bh(false);
        }
        this.aKr.bf(false);
        this.aKr.be(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wT().xj();
        this.bVG.abL().m(2, true);
        this.bVG.abI().a(this.bVL);
        this.bVG.abI().d(this.aKr);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bVH, readCacheRespMsg.getData().get(0));
        }
        this.bVK = null;
        this.bVH.reset();
        this.bVI.setNeedCache(true);
        this.bVI.CV();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgAtme(0);
            iVar = null;
        }
        if (r1 == null || iVar == null || !a(r1, iVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bVG.a(errorData);
            this.bVG.abI().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgAtme(0);
            iVar = null;
        }
        if (r1 == null || iVar == null || !a(r1, iVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bVG.a(errorData);
            this.bVG.abI().a(errorData);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}

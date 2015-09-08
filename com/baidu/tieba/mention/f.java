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
    private com.baidu.tbadk.mvc.d.a aKE;
    private SingleMentionActivity bWm;
    private h bWn;
    private g bWo;
    private a bWp;
    private FeedData bWq;
    private t bWr;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bWm = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.bWn = new h();
        this.bWo = new g(this.bWm.getPageContext(), this.bWn);
        this.bWo.a(this);
        this.bWo.setUniqueId(getUniqueId());
        this.bWp = new a(this.bWm.getPageContext());
        this.bWp.a(this);
        this.bWp.setUniqueId(getUniqueId());
        this.bWr = new t();
        this.aKE = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ht() {
        if (this.bWo.isLoading() || !this.aKE.Dp()) {
            return false;
        }
        this.aKE.bm(true);
        this.aKE.bo(true);
        this.bWn.b(this.bWq);
        this.bWo.setNeedCache(false);
        this.bWo.Df();
        this.bWm.abN().d(this.aKE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bE(boolean z) {
        if (this.bWo.isLoading()) {
            return false;
        }
        this.bWq = null;
        this.bWn.reset();
        this.bWo.setNeedCache(true);
        this.bWo.Df();
        return true;
    }

    public boolean oQ() {
        this.bWp.a((com.baidu.tbadk.mvc.b.e) this.bWn);
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.bWr.abK().clear();
        }
        this.bWr.a(iVar);
        if (iVar != null && iVar.abK() != null && iVar.abK().size() > 0) {
            this.bWq = iVar.abK().get(iVar.abK().size() - 1);
            if (this.bWr.getPage() != null) {
                this.aKE.bn(this.bWr.getPage().rQ() == 1);
            } else {
                this.aKE.bn(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aKE.bo(true);
        } else {
            this.bWq = null;
            this.aKE.bn(false);
            this.aKE.bo(false);
        }
        this.aKE.bm(false);
        this.aKE.bl(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xp();
        this.bWm.abQ().n(2, true);
        this.bWm.abN().a(this.bWr);
        this.bWm.abN().d(this.aKE);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bWn, readCacheRespMsg.getData().get(0));
        }
        this.bWq = null;
        this.bWn.reset();
        this.bWo.setNeedCache(true);
        this.bWo.Df();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgAtme(0);
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
            this.bWm.a(errorData);
            this.bWm.abN().a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgAtme(0);
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
            this.bWm.a(errorData);
            this.bWm.abN().a(errorData);
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

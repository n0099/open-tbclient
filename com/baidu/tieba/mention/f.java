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
    private com.baidu.tbadk.mvc.d.a aJx;
    private SingleMentionActivity bZY;
    private h bZZ;
    private g caa;
    private a cab;
    private FeedData cac;
    private t cad;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bZY = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.bZZ = new h();
        this.caa = new g(this.bZY.getPageContext(), this.bZZ);
        this.caa.a(this);
        this.caa.setUniqueId(getUniqueId());
        this.cab = new a(this.bZY.getPageContext());
        this.cab.a(this);
        this.cab.setUniqueId(getUniqueId());
        this.cad = new t();
        this.aJx = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hn() {
        if (this.caa.isLoading() || !this.aJx.Dc()) {
            return false;
        }
        this.aJx.bk(true);
        this.aJx.bm(true);
        this.bZZ.b(this.cac);
        this.caa.setNeedCache(false);
        this.caa.CS();
        this.bZY.adf().d(this.aJx);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bB(boolean z) {
        if (this.caa.isLoading()) {
            return false;
        }
        this.cac = null;
        this.bZZ.reset();
        this.caa.setNeedCache(true);
        this.caa.CS();
        return true;
    }

    public boolean oR() {
        this.cab.a((com.baidu.tbadk.mvc.b.e) this.bZZ);
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cad.adc().clear();
        }
        this.cad.a(iVar);
        if (iVar != null && iVar.adc() != null && iVar.adc().size() > 0) {
            this.cac = iVar.adc().get(iVar.adc().size() - 1);
            if (this.cad.getPage() != null) {
                this.aJx.bl(this.cad.getPage().rL() == 1);
            } else {
                this.aJx.bl(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aJx.bm(true);
        } else {
            this.cac = null;
            this.aJx.bl(false);
            this.aJx.bm(false);
        }
        this.aJx.bk(false);
        this.aJx.bj(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().xa();
        this.bZY.adi().o(2, true);
        this.bZY.adf().a(this.cad);
        this.bZY.adf().d(this.aJx);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bZZ, readCacheRespMsg.getData().get(0));
        }
        this.cac = null;
        this.bZZ.reset();
        this.caa.setNeedCache(true);
        this.caa.CS();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgAtme(0);
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
            this.bZY.a(errorData);
            this.bZY.adf().a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgAtme(0);
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
            this.bZY.a(errorData);
            this.bZY.adf().a(errorData);
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

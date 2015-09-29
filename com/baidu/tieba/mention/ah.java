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
public class ah extends com.baidu.adp.base.e<SingleMentionActivity> implements NetModel.b<aj, ak>, a.InterfaceC0052a<ak> {
    private com.baidu.tbadk.mvc.d.a aJx;
    private SingleMentionActivity bZY;
    private aj caD;
    private ai caE;
    private z caF;
    private FeedData cac;
    private t cad;

    public ah(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bZY = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.caD = new aj();
        this.caE = new ai(this.bZY.getPageContext(), this.caD);
        this.caE.a(this);
        this.caE.setUniqueId(getUniqueId());
        this.caF = new z(this.bZY.getPageContext());
        this.caF.a(this);
        this.caF.setUniqueId(getUniqueId());
        this.cad = new t();
        this.aJx = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hn() {
        if (this.caE.isLoading() || !this.aJx.Dc()) {
            return false;
        }
        this.aJx.bk(true);
        this.aJx.bm(true);
        this.caD.b(this.cac);
        this.caE.setNeedCache(false);
        this.caE.CS();
        this.bZY.ade().d(this.aJx);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bB(boolean z) {
        if (this.caE.isLoading()) {
            return false;
        }
        this.cac = null;
        this.caD.reset();
        this.caE.setNeedCache(true);
        this.caE.CS();
        return true;
    }

    public boolean oR() {
        this.caF.a((com.baidu.tbadk.mvc.b.e) this.caD);
        return true;
    }

    protected boolean a(aj ajVar, ak akVar) {
        if (ajVar.getUpdateType() != 4) {
            this.cad.adc().clear();
        }
        this.cad.a(akVar);
        if (akVar != null && akVar.adc() != null && akVar.adc().size() > 0) {
            this.cac = akVar.adc().get(akVar.adc().size() - 1);
            if (this.cad.getPage() != null) {
                this.aJx.bl(this.cad.getPage().rL() == 1);
            } else {
                this.aJx.bl(true);
            }
            if (ajVar != null) {
                ajVar.toNextPage();
            }
            this.aJx.bm(true);
        } else {
            this.cac = null;
            this.aJx.bl(false);
            this.aJx.bm(false);
        }
        this.aJx.bk(false);
        this.aJx.bj(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().wZ();
        this.bZY.adi().o(1, true);
        this.bZY.ade().a(this.cad);
        this.bZY.ade().d(this.aJx);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<ak>> readCacheRespMsg, ReadCacheMessage<ak> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.caD, readCacheRespMsg.getData().get(0));
        }
        this.cac = null;
        this.caD.reset();
        this.caE.setNeedCache(true);
        this.caE.CS();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<ak>> writeCacheRespMsg, WriteCacheMessage<ak> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ak> mvcHttpResponsedMessage, MvcHttpMessage<aj, ak> mvcHttpMessage, MvcNetMessage<aj, ak> mvcNetMessage) {
        ak akVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            akVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgReplyme(0);
            akVar = null;
        }
        if (r1 == null || akVar == null || !a(r1, akVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bZY.a(errorData);
            this.bZY.ade().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ak, ?> mvcSocketResponsedMessage, MvcSocketMessage<aj, ak> mvcSocketMessage, MvcNetMessage<aj, ak> mvcNetMessage) {
        ak akVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            akVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgReplyme(0);
            akVar = null;
        }
        if (r1 == null || akVar == null || !a(r1, akVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bZY.a(errorData);
            this.bZY.ade().a(errorData);
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

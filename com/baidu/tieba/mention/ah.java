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
    private com.baidu.tbadk.mvc.d.a aJI;
    private aj caO;
    private ai caP;
    private z caQ;
    private SingleMentionActivity caj;
    private FeedData can;
    private t cao;

    public ah(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.caj = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.caO = new aj();
        this.caP = new ai(this.caj.getPageContext(), this.caO);
        this.caP.a(this);
        this.caP.setUniqueId(getUniqueId());
        this.caQ = new z(this.caj.getPageContext());
        this.caQ.a(this);
        this.caQ.setUniqueId(getUniqueId());
        this.cao = new t();
        this.aJI = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hj() {
        if (this.caP.isLoading() || !this.aJI.CZ()) {
            return false;
        }
        this.aJI.bk(true);
        this.aJI.bm(true);
        this.caO.b(this.can);
        this.caP.setNeedCache(false);
        this.caP.CP();
        this.caj.ada().d(this.aJI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bB(boolean z) {
        if (this.caP.isLoading()) {
            return false;
        }
        this.can = null;
        this.caO.reset();
        this.caP.setNeedCache(true);
        this.caP.CP();
        return true;
    }

    public boolean oR() {
        this.caQ.a((com.baidu.tbadk.mvc.b.e) this.caO);
        return true;
    }

    protected boolean a(aj ajVar, ak akVar) {
        if (ajVar.getUpdateType() != 4) {
            this.cao.acY().clear();
        }
        this.cao.a(akVar);
        if (akVar != null && akVar.acY() != null && akVar.acY().size() > 0) {
            this.can = akVar.acY().get(akVar.acY().size() - 1);
            if (this.cao.getPage() != null) {
                this.aJI.bl(this.cao.getPage().rI() == 1);
            } else {
                this.aJI.bl(true);
            }
            if (ajVar != null) {
                ajVar.toNextPage();
            }
            this.aJI.bm(true);
        } else {
            this.can = null;
            this.aJI.bl(false);
            this.aJI.bm(false);
        }
        this.aJI.bk(false);
        this.aJI.bj(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wH().wW();
        this.caj.ade().o(1, true);
        this.caj.ada().a(this.cao);
        this.caj.ada().d(this.aJI);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<ak>> readCacheRespMsg, ReadCacheMessage<ak> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.caO, readCacheRespMsg.getData().get(0));
        }
        this.can = null;
        this.caO.reset();
        this.caP.setNeedCache(true);
        this.caP.CP();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgReplyme(0);
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
            this.caj.a(errorData);
            this.caj.ada().a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgReplyme(0);
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
            this.caj.a(errorData);
            this.caj.ada().a(errorData);
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

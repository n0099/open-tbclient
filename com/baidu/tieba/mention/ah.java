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
    private com.baidu.tbadk.mvc.d.a aIC;
    private SingleMentionActivity caK;
    private FeedData caO;
    private t caP;
    private aj cbp;
    private ai cbq;
    private z cbr;

    public ah(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.caK = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.cbp = new aj();
        this.cbq = new ai(this.caK.getPageContext(), this.cbp);
        this.cbq.a(this);
        this.cbq.setUniqueId(getUniqueId());
        this.cbr = new z(this.caK.getPageContext());
        this.cbr.a(this);
        this.cbr.setUniqueId(getUniqueId());
        this.caP = new t();
        this.aIC = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hg() {
        if (this.cbq.isLoading() || !this.aIC.CS()) {
            return false;
        }
        this.aIC.bn(true);
        this.aIC.bp(true);
        this.cbp.b(this.caO);
        this.cbq.setNeedCache(false);
        this.cbq.CI();
        this.caK.adv().d(this.aIC);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bD(boolean z) {
        if (this.cbq.isLoading()) {
            return false;
        }
        this.caO = null;
        this.cbp.reset();
        this.cbq.setNeedCache(true);
        this.cbq.CI();
        return true;
    }

    public boolean oS() {
        this.cbr.a((com.baidu.tbadk.mvc.b.e) this.cbp);
        return true;
    }

    protected boolean a(aj ajVar, ak akVar) {
        if (ajVar.getUpdateType() != 4) {
            this.caP.adt().clear();
        }
        this.caP.a(akVar);
        if (akVar != null && akVar.adt() != null && akVar.adt().size() > 0) {
            this.caO = akVar.adt().get(akVar.adt().size() - 1);
            if (this.caP.getPage() != null) {
                this.aIC.bo(this.caP.getPage().rK() == 1);
            } else {
                this.aIC.bo(true);
            }
            if (ajVar != null) {
                ajVar.toNextPage();
            }
            this.aIC.bp(true);
        } else {
            this.caO = null;
            this.aIC.bo(false);
            this.aIC.bp(false);
        }
        this.aIC.bn(false);
        this.aIC.bm(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().xb();
        this.caK.adz().o(1, true);
        this.caK.adv().a(this.caP);
        this.caK.adv().d(this.aIC);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<ak>> readCacheRespMsg, ReadCacheMessage<ak> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cbp, readCacheRespMsg.getData().get(0));
        }
        this.caO = null;
        this.cbp.reset();
        this.cbq.setNeedCache(true);
        this.cbq.CI();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgReplyme(0);
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
            this.caK.a(errorData);
            this.caK.adv().a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgReplyme(0);
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
            this.caK.a(errorData);
            this.caK.adv().a(errorData);
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

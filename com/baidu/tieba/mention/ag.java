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
public class ag extends com.baidu.adp.base.e<SingleMentionActivity> implements NetModel.b<ai, aj>, a.InterfaceC0052a<aj> {
    private com.baidu.tbadk.mvc.d.a aKE;
    private ai bWP;
    private ah bWQ;
    private y bWR;
    private SingleMentionActivity bWm;
    private FeedData bWq;
    private t bWr;

    public ag(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bWm = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.bWP = new ai();
        this.bWQ = new ah(this.bWm.getPageContext(), this.bWP);
        this.bWQ.a(this);
        this.bWQ.setUniqueId(getUniqueId());
        this.bWR = new y(this.bWm.getPageContext());
        this.bWR.a(this);
        this.bWR.setUniqueId(getUniqueId());
        this.bWr = new t();
        this.aKE = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ht() {
        if (this.bWQ.isLoading() || !this.aKE.Dp()) {
            return false;
        }
        this.aKE.bm(true);
        this.aKE.bo(true);
        this.bWP.b(this.bWq);
        this.bWQ.setNeedCache(false);
        this.bWQ.Df();
        this.bWm.abM().d(this.aKE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bE(boolean z) {
        if (this.bWQ.isLoading()) {
            return false;
        }
        this.bWq = null;
        this.bWP.reset();
        this.bWQ.setNeedCache(true);
        this.bWQ.Df();
        return true;
    }

    public boolean oQ() {
        this.bWR.a((com.baidu.tbadk.mvc.b.e) this.bWP);
        return true;
    }

    protected boolean a(ai aiVar, aj ajVar) {
        if (aiVar.getUpdateType() != 4) {
            this.bWr.abK().clear();
        }
        this.bWr.a(ajVar);
        if (ajVar != null && ajVar.abK() != null && ajVar.abK().size() > 0) {
            this.bWq = ajVar.abK().get(ajVar.abK().size() - 1);
            if (this.bWr.getPage() != null) {
                this.aKE.bn(this.bWr.getPage().rQ() == 1);
            } else {
                this.aKE.bn(true);
            }
            if (aiVar != null) {
                aiVar.toNextPage();
            }
            this.aKE.bo(true);
        } else {
            this.bWq = null;
            this.aKE.bn(false);
            this.aKE.bo(false);
        }
        this.aKE.bm(false);
        this.aKE.bl(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xo();
        this.bWm.abQ().n(1, true);
        this.bWm.abM().a(this.bWr);
        this.bWm.abM().d(this.aKE);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<aj>> readCacheRespMsg, ReadCacheMessage<aj> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bWP, readCacheRespMsg.getData().get(0));
        }
        this.bWq = null;
        this.bWP.reset();
        this.bWQ.setNeedCache(true);
        this.bWQ.Df();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<aj>> writeCacheRespMsg, WriteCacheMessage<aj> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<aj> mvcHttpResponsedMessage, MvcHttpMessage<ai, aj> mvcHttpMessage, MvcNetMessage<ai, aj> mvcNetMessage) {
        aj ajVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ajVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgReplyme(0);
            ajVar = null;
        }
        if (r1 == null || ajVar == null || !a(r1, ajVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bWm.a(errorData);
            this.bWm.abM().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<aj, ?> mvcSocketResponsedMessage, MvcSocketMessage<ai, aj> mvcSocketMessage, MvcNetMessage<ai, aj> mvcNetMessage) {
        aj ajVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ajVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgReplyme(0);
            ajVar = null;
        }
        if (r1 == null || ajVar == null || !a(r1, ajVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bWm.a(errorData);
            this.bWm.abM().a(errorData);
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

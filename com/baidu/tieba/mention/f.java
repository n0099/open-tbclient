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
    private com.baidu.tbadk.mvc.d.a aIC;
    private SingleMentionActivity caK;
    private h caL;
    private g caM;
    private a caN;
    private FeedData caO;
    private t caP;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.caK = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.caL = new h();
        this.caM = new g(this.caK.getPageContext(), this.caL);
        this.caM.a(this);
        this.caM.setUniqueId(getUniqueId());
        this.caN = new a(this.caK.getPageContext());
        this.caN.a(this);
        this.caN.setUniqueId(getUniqueId());
        this.caP = new t();
        this.aIC = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hg() {
        if (this.caM.isLoading() || !this.aIC.CS()) {
            return false;
        }
        this.aIC.bn(true);
        this.aIC.bp(true);
        this.caL.b(this.caO);
        this.caM.setNeedCache(false);
        this.caM.CI();
        this.caK.adw().d(this.aIC);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bD(boolean z) {
        if (this.caM.isLoading()) {
            return false;
        }
        this.caO = null;
        this.caL.reset();
        this.caM.setNeedCache(true);
        this.caM.CI();
        return true;
    }

    public boolean oS() {
        this.caN.a((com.baidu.tbadk.mvc.b.e) this.caL);
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.caP.adt().clear();
        }
        this.caP.a(iVar);
        if (iVar != null && iVar.adt() != null && iVar.adt().size() > 0) {
            this.caO = iVar.adt().get(iVar.adt().size() - 1);
            if (this.caP.getPage() != null) {
                this.aIC.bo(this.caP.getPage().rK() == 1);
            } else {
                this.aIC.bo(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aIC.bp(true);
        } else {
            this.caO = null;
            this.aIC.bo(false);
            this.aIC.bp(false);
        }
        this.aIC.bn(false);
        this.aIC.bm(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().xc();
        this.caK.adz().o(2, true);
        this.caK.adw().a(this.caP);
        this.caK.adw().d(this.aIC);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.caL, readCacheRespMsg.getData().get(0));
        }
        this.caO = null;
        this.caL.reset();
        this.caM.setNeedCache(true);
        this.caM.CI();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgAtme(0);
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
            this.caK.a(errorData);
            this.caK.adw().a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgAtme(0);
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
            this.caK.a(errorData);
            this.caK.adw().a(errorData);
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

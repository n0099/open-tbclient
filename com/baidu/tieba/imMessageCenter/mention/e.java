package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class e extends com.baidu.adp.base.e<be> implements NetModel.b<h, i>, a.InterfaceC0055a<i> {
    final CustomMessageListener ML;
    private com.baidu.tbadk.mvc.d.a aWP;
    private be cxj;
    private h cxk;
    private g cxl;
    private a cxm;
    private FeedData cxn;
    private af cxo;

    public e(be beVar) {
        super(com.baidu.adp.base.l.s(beVar.getPageContext().getPageActivity()));
        this.ML = new f(this, 2000994);
        this.cxj = beVar;
    }

    public void c(Bundle bundle) {
        this.cxk = new h();
        this.cxl = new g((TbPageContext) com.baidu.adp.base.l.s(this.cxj.getPageContext().getPageActivity()), this.cxk);
        this.cxl.a(this);
        if (this.cxj != null) {
            this.cxl.setUniqueId(this.cxj.getUniqueId());
        }
        this.cxl.registerListener(this.ML);
        this.cxm = new a((TbPageContext) com.baidu.adp.base.l.s(this.cxj.getPageContext().getPageActivity()));
        this.cxm.a(this);
        if (this.cxj != null) {
            this.cxm.setUniqueId(this.cxj.getUniqueId());
        }
        this.cxo = new af();
        this.aWP = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Md() {
        if (!this.cxl.isLoading() && this.aWP.FP() && akW()) {
            this.aWP.bC(true);
            this.aWP.bE(true);
            this.cxk.d(this.cxn);
            this.cxl.setNeedCache(false);
            this.cxl.FG();
            this.cxj.alp().d(this.aWP);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ce(boolean z) {
        if (this.cxl.isLoading() || !akW()) {
            return false;
        }
        this.cxn = null;
        this.cxk.reset();
        this.cxl.setNeedCache(true);
        this.cxl.FG();
        return true;
    }

    protected boolean akW() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cxo != null && this.cxo.cxL != null) {
            this.cxo.cxL.clear();
        }
        this.cxj.alp().akY();
        this.cxj.alp().a(this.cxo);
        return false;
    }

    public boolean oK() {
        if (akW()) {
            if (this.cxj != null && this.cxj.alp() != null) {
                this.cxj.alp().akX();
            }
            this.cxm.a((com.baidu.tbadk.mvc.b.e) this.cxk);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cxo.alk().clear();
        }
        this.cxo.a(iVar);
        if (iVar != null && iVar.alk() != null && iVar.alk().size() > 0) {
            this.cxn = iVar.alk().get(iVar.alk().size() - 1);
            if (this.cxo.getPage() != null) {
                this.aWP.bD(this.cxo.getPage().sq() == 1);
            } else {
                this.aWP.bD(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aWP.bE(true);
        } else {
            this.cxn = null;
            this.aWP.bD(false);
            this.aWP.bE(false);
        }
        this.aWP.bC(false);
        this.aWP.bB(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().zF();
        this.cxj.alt().p(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.cxo.alk().clear();
        } else {
            this.cxj.alp().d(this.aWP);
        }
        this.cxj.alp().a(this.cxo);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cxk, readCacheRespMsg.getData().get(0));
        }
        this.cxn = null;
        this.cxk.reset();
        this.cxl.setNeedCache(true);
        this.cxl.FG();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cxj.alp().akY();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().setMsgAtme(0);
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
            this.cxj.a(errorData);
            this.cxj.alp().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cxj.alp().akY();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().setMsgAtme(0);
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
            this.cxj.a(errorData);
            this.cxj.alp().a(errorData);
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

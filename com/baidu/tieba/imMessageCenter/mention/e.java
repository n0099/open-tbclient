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
public class e extends com.baidu.adp.base.e<bf> implements NetModel.b<h, i>, a.InterfaceC0046a<i> {
    final CustomMessageListener Dd;
    private com.baidu.tbadk.mvc.d.a aWe;
    private bf ddD;
    private h ddE;
    private g ddF;
    private a ddG;
    private FeedData ddH;
    private ag ddI;

    public e(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.Dd = new f(this, 2000994);
        this.ddD = bfVar;
    }

    public void d(Bundle bundle) {
        this.ddE = new h();
        this.ddF = new g((TbPageContext) com.baidu.adp.base.l.s(this.ddD.getPageContext().getPageActivity()), this.ddE);
        this.ddF.a(this);
        if (this.ddD != null) {
            this.ddF.setUniqueId(this.ddD.getUniqueId());
        }
        this.ddF.registerListener(this.Dd);
        this.ddG = new a((TbPageContext) com.baidu.adp.base.l.s(this.ddD.getPageContext().getPageActivity()));
        this.ddG.a(this);
        if (this.ddD != null) {
            this.ddG.setUniqueId(this.ddD.getUniqueId());
        }
        this.ddI = new ag();
        this.aWe = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean LL() {
        if (!this.ddF.DK() && this.aWe.DR() && atr()) {
            this.aWe.bH(true);
            this.aWe.bJ(true);
            this.ddE.d(this.ddH);
            this.ddF.setNeedCache(false);
            this.ddF.DH();
            this.ddD.atM().d(this.aWe);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cl(boolean z) {
        if (this.ddF.DK() || !atr()) {
            return false;
        }
        this.ddH = null;
        this.ddE.reset();
        this.ddF.setNeedCache(true);
        this.ddF.DH();
        return true;
    }

    protected boolean atr() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.ddI != null && this.ddI.deg != null) {
            this.ddI.deg.clear();
        }
        this.ddD.atM().att();
        this.ddD.atM().a(this.ddI);
        return false;
    }

    public boolean lb() {
        if (atr()) {
            if (this.ddD != null && this.ddD.atM() != null) {
                this.ddD.atM().ats();
            }
            this.ddG.a((com.baidu.tbadk.mvc.b.e) this.ddE);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.ddI.atG().clear();
        }
        this.ddI.a(iVar);
        if (iVar != null && iVar.atG() != null && iVar.atG().size() > 0) {
            this.ddH = iVar.atG().get(iVar.atG().size() - 1);
            if (this.ddI.getPage() != null) {
                this.aWe.bI(this.ddI.getPage().pE() == 1);
            } else {
                this.aWe.bI(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aWe.bJ(true);
        } else {
            this.ddH = null;
            this.aWe.bI(false);
            this.aWe.bJ(false);
        }
        this.aWe.bH(false);
        this.aWe.bG(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().xD();
        this.ddD.atQ().G(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.ddI.atG().clear();
        } else {
            this.ddD.atM().d(this.aWe);
        }
        this.ddD.atM().a(this.ddI);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.ddE, readCacheRespMsg.getData().get(0));
        }
        this.ddH = null;
        this.ddE.reset();
        this.ddF.setNeedCache(true);
        this.ddF.DH();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.ddD.atM().att();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgAtme(0);
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
            this.ddD.a(errorData);
            this.ddD.atM().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.ddD.atM().att();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgAtme(0);
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
            this.ddD.a(errorData);
            this.ddD.atM().a(errorData);
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

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
public class au extends com.baidu.adp.base.e<bf> implements NetModel.b<ax, ay>, a.InterfaceC0046a<ay> {
    final CustomMessageListener Dd;
    private com.baidu.tbadk.mvc.d.a aWe;
    private bf ddD;
    private FeedData ddH;
    private ag ddI;
    private ax der;
    private aw det;
    private am deu;

    public au(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.Dd = new av(this, 2000994);
        this.ddD = bfVar;
    }

    public void d(Bundle bundle) {
        this.der = new ax();
        this.det = new aw((TbPageContext) com.baidu.adp.base.l.s(this.ddD.getPageContext().getPageActivity()), this.der);
        this.det.a(this);
        this.det.setUniqueId(getUniqueId());
        this.det.registerListener(this.Dd);
        this.deu = new am((TbPageContext) com.baidu.adp.base.l.s(this.ddD.getPageContext().getPageActivity()));
        this.deu.a(this);
        this.deu.setUniqueId(getUniqueId());
        this.ddI = new ag();
        this.aWe = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean LL() {
        if (!this.det.DK() && this.aWe.DR() && atr()) {
            this.aWe.bH(true);
            this.aWe.bJ(true);
            this.der.d(this.ddH);
            this.det.setNeedCache(false);
            this.det.DH();
            this.ddD.atL().d(this.aWe);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cl(boolean z) {
        if (this.det.DK() || !atr()) {
            return false;
        }
        this.ddH = null;
        this.der.reset();
        this.det.setNeedCache(true);
        this.det.DH();
        return true;
    }

    protected boolean atr() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.ddI != null && this.ddI.deg != null) {
            this.ddI.deg.clear();
        }
        this.ddD.atL().att();
        this.ddD.atL().a(this.ddI);
        return false;
    }

    public boolean lb() {
        if (atr()) {
            if (this.ddD != null && this.ddD.atL() != null) {
                this.ddD.atL().ats();
            }
            this.deu.a((com.baidu.tbadk.mvc.b.e) this.der);
            return true;
        }
        return true;
    }

    protected boolean a(ax axVar, ay ayVar) {
        if (axVar.getUpdateType() != 4) {
            this.ddI.atG().clear();
        }
        this.ddI.a(ayVar);
        if (ayVar != null && ayVar.atG() != null && ayVar.atG().size() > 0) {
            this.ddH = ayVar.atG().get(ayVar.atG().size() - 1);
            if (this.ddI.getPage() != null) {
                this.aWe.bI(this.ddI.getPage().pE() == 1);
            } else {
                this.aWe.bI(true);
            }
            if (axVar != null) {
                axVar.toNextPage();
            }
            this.aWe.bJ(true);
        } else {
            this.ddH = null;
            this.aWe.bI(false);
            this.aWe.bJ(false);
        }
        this.aWe.bH(false);
        this.aWe.bG(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().xC();
        this.ddD.atQ().G(1, true);
        this.ddD.atL().a(this.ddI);
        this.ddD.atL().d(this.aWe);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(ReadCacheRespMsg<List<ay>> readCacheRespMsg, ReadCacheMessage<ay> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.der, readCacheRespMsg.getData().get(0));
        }
        this.ddH = null;
        this.der.reset();
        this.det.setNeedCache(true);
        this.det.DH();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(WriteCacheRespMsg<List<ay>> writeCacheRespMsg, WriteCacheMessage<ay> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ay> mvcHttpResponsedMessage, MvcHttpMessage<ax, ay> mvcHttpMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.ddD.atL().att();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ayVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgReplyme(0);
            ayVar = null;
        }
        if (r1 == null || ayVar == null || !a(r1, ayVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.ddD.a(errorData);
                this.ddD.atL().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ay, ?> mvcSocketResponsedMessage, MvcSocketMessage<ax, ay> mvcSocketMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.ddD.atL().att();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ayVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgReplyme(0);
            ayVar = null;
        }
        if (r1 == null || ayVar == null || !a(r1, ayVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.ddD.a(errorData);
                this.ddD.atL().a(errorData);
            }
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

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
public class e extends com.baidu.adp.base.e<bf> implements NetModel.b<h, i>, a.InterfaceC0047a<i> {
    final CustomMessageListener DE;
    private com.baidu.tbadk.mvc.d.a aXc;
    private h dgA;
    private g dgB;
    private a dgC;
    private FeedData dgD;
    private ag dgE;
    private bf dgz;

    public e(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.DE = new f(this, 2000994);
        this.dgz = bfVar;
    }

    public void d(Bundle bundle) {
        this.dgA = new h();
        this.dgB = new g((TbPageContext) com.baidu.adp.base.l.s(this.dgz.getPageContext().getPageActivity()), this.dgA);
        this.dgB.a(this);
        if (this.dgz != null) {
            this.dgB.setUniqueId(this.dgz.getUniqueId());
        }
        this.dgB.registerListener(this.DE);
        this.dgC = new a((TbPageContext) com.baidu.adp.base.l.s(this.dgz.getPageContext().getPageActivity()));
        this.dgC.a(this);
        if (this.dgz != null) {
            this.dgC.setUniqueId(this.dgz.getUniqueId());
        }
        this.dgE = new ag();
        this.aXc = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean LK() {
        if (!this.dgB.DJ() && this.aXc.DQ() && aud()) {
            this.aXc.bK(true);
            this.aXc.bM(true);
            this.dgA.d(this.dgD);
            this.dgB.setNeedCache(false);
            this.dgB.DG();
            this.dgz.auy().d(this.aXc);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean co(boolean z) {
        if (this.dgB.DJ() || !aud()) {
            return false;
        }
        this.dgD = null;
        this.dgA.reset();
        this.dgB.setNeedCache(true);
        this.dgB.DG();
        return true;
    }

    protected boolean aud() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dgE != null && this.dgE.dhd != null) {
            this.dgE.dhd.clear();
        }
        this.dgz.auy().auf();
        this.dgz.auy().a(this.dgE);
        return false;
    }

    public boolean kX() {
        if (aud()) {
            if (this.dgz != null && this.dgz.auy() != null) {
                this.dgz.auy().aue();
            }
            this.dgC.a((com.baidu.tbadk.mvc.b.e) this.dgA);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.dgE.aus().clear();
        }
        this.dgE.a(iVar);
        if (iVar != null && iVar.aus() != null && iVar.aus().size() > 0) {
            this.dgD = iVar.aus().get(iVar.aus().size() - 1);
            if (this.dgE.getPage() != null) {
                this.aXc.bL(this.dgE.getPage().pn() == 1);
            } else {
                this.aXc.bL(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aXc.bM(true);
        } else {
            this.dgD = null;
            this.aXc.bL(false);
            this.aXc.bM(false);
        }
        this.aXc.bK(false);
        this.aXc.bJ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().xD();
        this.dgz.auC().H(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.dgE.aus().clear();
        } else {
            this.dgz.auy().d(this.aXc);
        }
        this.dgz.auy().a(this.dgE);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dgA, readCacheRespMsg.getData().get(0));
        }
        this.dgD = null;
        this.dgA.reset();
        this.dgB.setNeedCache(true);
        this.dgB.DG();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dgz.auy().auf();
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
            this.dgz.a(errorData);
            this.dgz.auy().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dgz.auy().auf();
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
            this.dgz.a(errorData);
            this.dgz.auy().a(errorData);
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

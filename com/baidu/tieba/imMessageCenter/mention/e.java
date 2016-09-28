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
    final CustomMessageListener FQ;
    private com.baidu.tbadk.mvc.d.a bdp;
    private bf dtC;
    private h dtD;
    private g dtE;
    private a dtF;
    private FeedData dtG;
    private ag dtH;

    public e(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.FQ = new f(this, 2000994);
        this.dtC = bfVar;
    }

    public void d(Bundle bundle) {
        this.dtD = new h();
        this.dtE = new g((TbPageContext) com.baidu.adp.base.l.C(this.dtC.getPageContext().getPageActivity()), this.dtD);
        this.dtE.a(this);
        if (this.dtC != null) {
            this.dtE.setUniqueId(this.dtC.getUniqueId());
        }
        this.dtE.registerListener(this.FQ);
        this.dtF = new a((TbPageContext) com.baidu.adp.base.l.C(this.dtC.getPageContext().getPageActivity()));
        this.dtF.a(this);
        if (this.dtC != null) {
            this.dtF.setUniqueId(this.dtC.getUniqueId());
        }
        this.dtH = new ag();
        this.bdp = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean OR() {
        if (!this.dtE.wG() && this.bdp.Fj() && azp()) {
            this.bdp.bL(true);
            this.bdp.bN(true);
            this.dtD.d(this.dtG);
            this.dtE.setNeedCache(false);
            this.dtE.Fa();
            this.dtC.azJ().d(this.bdp);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cv(boolean z) {
        if (this.dtE.wG() || !azp()) {
            return false;
        }
        this.dtG = null;
        this.dtD.reset();
        this.dtE.setNeedCache(true);
        this.dtE.Fa();
        return true;
    }

    protected boolean azp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dtH != null && this.dtH.dug != null) {
            this.dtH.dug.clear();
        }
        this.dtC.azJ().azr();
        this.dtC.azJ().a(this.dtH);
        return false;
    }

    public boolean lS() {
        if (azp()) {
            if (this.dtC != null && this.dtC.azJ() != null) {
                this.dtC.azJ().azq();
            }
            this.dtF.a((com.baidu.tbadk.mvc.b.e) this.dtD);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.dtH.azD().clear();
        }
        this.dtH.a(iVar);
        if (iVar != null && iVar.azD() != null && iVar.azD().size() > 0) {
            this.dtG = iVar.azD().get(iVar.azD().size() - 1);
            if (this.dtH.getPage() != null) {
                this.bdp.bM(this.dtH.getPage().qB() == 1);
            } else {
                this.bdp.bM(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.bdp.bN(true);
        } else {
            this.dtG = null;
            this.bdp.bM(false);
            this.bdp.bN(false);
        }
        this.bdp.bL(false);
        this.bdp.bK(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yD().yT();
        this.dtC.azN().H(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.dtH.azD().clear();
        } else {
            this.dtC.azJ().d(this.bdp);
        }
        this.dtC.azJ().a(this.dtH);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dtD, readCacheRespMsg.getData().get(0));
        }
        this.dtG = null;
        this.dtD.reset();
        this.dtE.setNeedCache(true);
        this.dtE.Fa();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dtC.azJ().azr();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgAtme(0);
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
            this.dtC.a(errorData);
            this.dtC.azJ().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dtC.azJ().azr();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgAtme(0);
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
            this.dtC.a(errorData);
            this.dtC.azJ().a(errorData);
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

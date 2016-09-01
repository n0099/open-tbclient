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
    private com.baidu.tbadk.mvc.d.a bcV;
    private bf dsf;
    private h dsg;
    private g dsh;
    private a dsi;
    private FeedData dsj;
    private ag dsk;

    public e(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.FQ = new f(this, 2000994);
        this.dsf = bfVar;
    }

    public void d(Bundle bundle) {
        this.dsg = new h();
        this.dsh = new g((TbPageContext) com.baidu.adp.base.l.C(this.dsf.getPageContext().getPageActivity()), this.dsg);
        this.dsh.a(this);
        if (this.dsf != null) {
            this.dsh.setUniqueId(this.dsf.getUniqueId());
        }
        this.dsh.registerListener(this.FQ);
        this.dsi = new a((TbPageContext) com.baidu.adp.base.l.C(this.dsf.getPageContext().getPageActivity()));
        this.dsi.a(this);
        if (this.dsf != null) {
            this.dsi.setUniqueId(this.dsf.getUniqueId());
        }
        this.dsk = new ag();
        this.bcV = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Op() {
        if (!this.dsh.Fd() && this.bcV.Fk() && ayR()) {
            this.bcV.bM(true);
            this.bcV.bO(true);
            this.dsg.d(this.dsj);
            this.dsh.setNeedCache(false);
            this.dsh.Fa();
            this.dsf.azl().d(this.bcV);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cu(boolean z) {
        if (this.dsh.Fd() || !ayR()) {
            return false;
        }
        this.dsj = null;
        this.dsg.reset();
        this.dsh.setNeedCache(true);
        this.dsh.Fa();
        return true;
    }

    protected boolean ayR() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dsk != null && this.dsk.dsJ != null) {
            this.dsk.dsJ.clear();
        }
        this.dsf.azl().ayT();
        this.dsf.azl().a(this.dsk);
        return false;
    }

    public boolean lS() {
        if (ayR()) {
            if (this.dsf != null && this.dsf.azl() != null) {
                this.dsf.azl().ayS();
            }
            this.dsi.a((com.baidu.tbadk.mvc.b.e) this.dsg);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.dsk.azf().clear();
        }
        this.dsk.a(iVar);
        if (iVar != null && iVar.azf() != null && iVar.azf().size() > 0) {
            this.dsj = iVar.azf().get(iVar.azf().size() - 1);
            if (this.dsk.getPage() != null) {
                this.bcV.bN(this.dsk.getPage().qq() == 1);
            } else {
                this.bcV.bN(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.bcV.bO(true);
        } else {
            this.dsj = null;
            this.bcV.bN(false);
            this.bcV.bO(false);
        }
        this.bcV.bM(false);
        this.bcV.bL(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().yQ();
        this.dsf.azp().H(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.dsk.azf().clear();
        } else {
            this.dsf.azl().d(this.bcV);
        }
        this.dsf.azl().a(this.dsk);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dsg, readCacheRespMsg.getData().get(0));
        }
        this.dsj = null;
        this.dsg.reset();
        this.dsh.setNeedCache(true);
        this.dsh.Fa();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dsf.azl().ayT();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgAtme(0);
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
            this.dsf.a(errorData);
            this.dsf.azl().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dsf.azl().ayT();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgAtme(0);
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
            this.dsf.a(errorData);
            this.dsf.azl().a(errorData);
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

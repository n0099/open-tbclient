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
public class au extends com.baidu.adp.base.e<bf> implements NetModel.b<ax, ay>, a.InterfaceC0047a<ay> {
    final CustomMessageListener FQ;
    private com.baidu.tbadk.mvc.d.a bcV;
    private ax dsU;
    private aw dsV;
    private am dsW;
    private bf dsf;
    private FeedData dsj;
    private ag dsk;

    public au(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.FQ = new av(this, 2000994);
        this.dsf = bfVar;
    }

    public void d(Bundle bundle) {
        this.dsU = new ax();
        this.dsV = new aw((TbPageContext) com.baidu.adp.base.l.C(this.dsf.getPageContext().getPageActivity()), this.dsU);
        this.dsV.a(this);
        this.dsV.setUniqueId(getUniqueId());
        this.dsV.registerListener(this.FQ);
        this.dsW = new am((TbPageContext) com.baidu.adp.base.l.C(this.dsf.getPageContext().getPageActivity()));
        this.dsW.a(this);
        this.dsW.setUniqueId(getUniqueId());
        this.dsk = new ag();
        this.bcV = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Op() {
        if (!this.dsV.Fd() && this.bcV.Fk() && ayR()) {
            this.bcV.bM(true);
            this.bcV.bO(true);
            this.dsU.d(this.dsj);
            this.dsV.setNeedCache(false);
            this.dsV.Fa();
            this.dsf.azk().d(this.bcV);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cu(boolean z) {
        if (this.dsV.Fd() || !ayR()) {
            return false;
        }
        this.dsj = null;
        this.dsU.reset();
        this.dsV.setNeedCache(true);
        this.dsV.Fa();
        return true;
    }

    protected boolean ayR() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dsk != null && this.dsk.dsJ != null) {
            this.dsk.dsJ.clear();
        }
        this.dsf.azk().ayT();
        this.dsf.azk().a(this.dsk);
        return false;
    }

    public boolean lS() {
        if (ayR()) {
            if (this.dsf != null && this.dsf.azk() != null) {
                this.dsf.azk().ayS();
            }
            this.dsW.a((com.baidu.tbadk.mvc.b.e) this.dsU);
            return true;
        }
        return true;
    }

    protected boolean a(ax axVar, ay ayVar) {
        if (axVar.getUpdateType() != 4) {
            this.dsk.azf().clear();
        }
        this.dsk.a(ayVar);
        if (ayVar != null && ayVar.azf() != null && ayVar.azf().size() > 0) {
            this.dsj = ayVar.azf().get(ayVar.azf().size() - 1);
            if (this.dsk.getPage() != null) {
                this.bcV.bN(this.dsk.getPage().qq() == 1);
            } else {
                this.bcV.bN(true);
            }
            if (axVar != null) {
                axVar.toNextPage();
            }
            this.bcV.bO(true);
        } else {
            this.dsj = null;
            this.bcV.bN(false);
            this.bcV.bO(false);
        }
        this.bcV.bM(false);
        this.bcV.bL(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().yP();
        this.dsf.azp().H(1, true);
        this.dsf.azk().a(this.dsk);
        this.dsf.azk().d(this.bcV);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<ay>> readCacheRespMsg, ReadCacheMessage<ay> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dsU, readCacheRespMsg.getData().get(0));
        }
        this.dsj = null;
        this.dsU.reset();
        this.dsV.setNeedCache(true);
        this.dsV.Fa();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<ay>> writeCacheRespMsg, WriteCacheMessage<ay> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ay> mvcHttpResponsedMessage, MvcHttpMessage<ax, ay> mvcHttpMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dsf.azk().ayT();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ayVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgReplyme(0);
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
                this.dsf.a(errorData);
                this.dsf.azk().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ay, ?> mvcSocketResponsedMessage, MvcSocketMessage<ax, ay> mvcSocketMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dsf.azk().ayT();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ayVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgReplyme(0);
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
                this.dsf.a(errorData);
                this.dsf.azk().a(errorData);
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

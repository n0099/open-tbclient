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
    final CustomMessageListener FT;
    private com.baidu.tbadk.mvc.d.a bgo;
    private bf dzh;
    private h dzi;
    private g dzj;
    private a dzk;
    private FeedData dzl;
    private ag dzm;

    public e(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.FT = new f(this, 2000994);
        this.dzh = bfVar;
    }

    public void d(Bundle bundle) {
        this.dzi = new h();
        this.dzj = new g((TbPageContext) com.baidu.adp.base.l.C(this.dzh.getPageContext().getPageActivity()), this.dzi);
        this.dzj.a(this);
        if (this.dzh != null) {
            this.dzj.setUniqueId(this.dzh.getUniqueId());
        }
        this.dzj.registerListener(this.FT);
        this.dzk = new a((TbPageContext) com.baidu.adp.base.l.C(this.dzh.getPageContext().getPageActivity()));
        this.dzk.a(this);
        if (this.dzh != null) {
            this.dzk.setUniqueId(this.dzh.getUniqueId());
        }
        this.dzm = new ag();
        this.bgo = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean PU() {
        if (!this.dzj.wL() && this.bgo.Fo() && aBm()) {
            this.bgo.bP(true);
            this.bgo.bR(true);
            this.dzi.d(this.dzl);
            this.dzj.setNeedCache(false);
            this.dzj.Ff();
            this.dzh.aBF().d(this.bgo);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cA(boolean z) {
        if (this.dzj.wL() || !aBm()) {
            return false;
        }
        this.dzl = null;
        this.dzi.reset();
        this.dzj.setNeedCache(true);
        this.dzj.Ff();
        return true;
    }

    protected boolean aBm() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dzm != null && this.dzm.dzL != null) {
            this.dzm.dzL.clear();
        }
        this.dzh.aBF().aBo();
        this.dzh.aBF().a(this.dzm);
        return false;
    }

    public boolean lV() {
        if (aBm()) {
            if (this.dzh != null && this.dzh.aBF() != null) {
                this.dzh.aBF().aBn();
            }
            this.dzk.a((com.baidu.tbadk.mvc.b.e) this.dzi);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.dzm.aBz().clear();
        }
        this.dzm.a(iVar);
        if (iVar != null && iVar.aBz() != null && iVar.aBz().size() > 0) {
            this.dzl = iVar.aBz().get(iVar.aBz().size() - 1);
            if (this.dzm.getPage() != null) {
                this.bgo.bQ(this.dzm.getPage().qD() == 1);
            } else {
                this.bgo.bQ(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.bgo.bR(true);
        } else {
            this.dzl = null;
            this.bgo.bQ(false);
            this.bgo.bR(false);
        }
        this.bgo.bP(false);
        this.bgo.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().za();
        this.dzh.aBJ().J(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.dzm.aBz().clear();
        } else {
            this.dzh.aBF().d(this.bgo);
        }
        this.dzh.aBF().a(this.dzm);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dzi, readCacheRespMsg.getData().get(0));
        }
        this.dzl = null;
        this.dzi.reset();
        this.dzj.setNeedCache(true);
        this.dzj.Ff();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dzh.aBF().aBo();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
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
            this.dzh.a(errorData);
            this.dzh.aBF().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dzh.aBF().aBo();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
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
            this.dzh.a(errorData);
            this.dzh.aBF().a(errorData);
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

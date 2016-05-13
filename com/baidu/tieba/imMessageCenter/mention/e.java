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
    final CustomMessageListener Dc;
    private com.baidu.tbadk.mvc.d.a aSJ;
    private bf cyh;
    private h cyi;
    private g cyj;
    private a cyk;
    private FeedData cyl;
    private ag cym;

    public e(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.Dc = new f(this, 2000994);
        this.cyh = bfVar;
    }

    public void c(Bundle bundle) {
        this.cyi = new h();
        this.cyj = new g((TbPageContext) com.baidu.adp.base.l.s(this.cyh.getPageContext().getPageActivity()), this.cyi);
        this.cyj.a(this);
        if (this.cyh != null) {
            this.cyj.setUniqueId(this.cyh.getUniqueId());
        }
        this.cyj.registerListener(this.Dc);
        this.cyk = new a((TbPageContext) com.baidu.adp.base.l.s(this.cyh.getPageContext().getPageActivity()));
        this.cyk.a(this);
        if (this.cyh != null) {
            this.cyk.setUniqueId(this.cyh.getUniqueId());
        }
        this.cym = new ag();
        this.aSJ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KO() {
        if (!this.cyj.isLoading() && this.aSJ.DI() && ale()) {
            this.aSJ.bI(true);
            this.aSJ.bK(true);
            this.cyi.d(this.cyl);
            this.cyj.setNeedCache(false);
            this.cyj.Dz();
            this.cyh.alz().d(this.aSJ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ck(boolean z) {
        if (this.cyj.isLoading() || !ale()) {
            return false;
        }
        this.cyl = null;
        this.cyi.reset();
        this.cyj.setNeedCache(true);
        this.cyj.Dz();
        return true;
    }

    protected boolean ale() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cym != null && this.cym.cyK != null) {
            this.cym.cyK.clear();
        }
        this.cyh.alz().alg();
        this.cyh.alz().a(this.cym);
        return false;
    }

    public boolean kX() {
        if (ale()) {
            if (this.cyh != null && this.cyh.alz() != null) {
                this.cyh.alz().alf();
            }
            this.cyk.a((com.baidu.tbadk.mvc.b.e) this.cyi);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cym.alt().clear();
        }
        this.cym.a(iVar);
        if (iVar != null && iVar.alt() != null && iVar.alt().size() > 0) {
            this.cyl = iVar.alt().get(iVar.alt().size() - 1);
            if (this.cym.getPage() != null) {
                this.aSJ.bJ(this.cym.getPage().pK() == 1);
            } else {
                this.aSJ.bJ(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aSJ.bK(true);
        } else {
            this.cyl = null;
            this.aSJ.bJ(false);
            this.aSJ.bK(false);
        }
        this.aSJ.bI(false);
        this.aSJ.bH(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xj().xz();
        this.cyh.alD().s(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.cym.alt().clear();
        } else {
            this.cyh.alz().d(this.aSJ);
        }
        this.cyh.alz().a(this.cym);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cyi, readCacheRespMsg.getData().get(0));
        }
        this.cyl = null;
        this.cyi.reset();
        this.cyj.setNeedCache(true);
        this.cyj.Dz();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cyh.alz().alg();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgAtme(0);
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
            this.cyh.a(errorData);
            this.cyh.alz().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cyh.alz().alg();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgAtme(0);
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
            this.cyh.a(errorData);
            this.cyh.alz().a(errorData);
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

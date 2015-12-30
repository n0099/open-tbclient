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
public class e extends com.baidu.adp.base.e<bd> implements NetModel.b<h, i>, a.InterfaceC0054a<i> {
    private com.baidu.tbadk.mvc.d.a aQW;
    private bd cih;
    private h cii;
    private g cij;
    private a cik;
    private FeedData cil;
    private ae cim;
    final CustomMessageListener mNetworkChangedMessageListener;

    public e(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new f(this, 2000994);
        this.cih = bdVar;
    }

    public void b(Bundle bundle) {
        this.cii = new h();
        this.cij = new g((TbPageContext) com.baidu.adp.base.l.C(this.cih.getPageContext().getPageActivity()), this.cii);
        this.cij.a(this);
        if (this.cih != null) {
            this.cij.setUniqueId(this.cih.getUniqueId());
        }
        this.cij.registerListener(this.mNetworkChangedMessageListener);
        this.cik = new a((TbPageContext) com.baidu.adp.base.l.C(this.cih.getPageContext().getPageActivity()));
        this.cik.a(this);
        if (this.cih != null) {
            this.cik.setUniqueId(this.cih.getUniqueId());
        }
        this.cim = new ae();
        this.aQW = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IR() {
        if (!this.cij.isLoading() && this.aQW.DI() && aes()) {
            this.aQW.bv(true);
            this.aQW.bx(true);
            this.cii.b(this.cil);
            this.cij.setNeedCache(false);
            this.cij.Dy();
            this.cih.aeM().d(this.aQW);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bP(boolean z) {
        if (this.cij.isLoading() || !aes()) {
            return false;
        }
        this.cil = null;
        this.cii.reset();
        this.cij.setNeedCache(true);
        this.cij.Dy();
        return true;
    }

    protected boolean aes() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cim != null && this.cim.ciJ != null) {
            this.cim.ciJ.clear();
        }
        this.cih.aeM().aeu();
        this.cih.aeM().a(this.cim);
        return false;
    }

    public boolean ow() {
        if (aes()) {
            if (this.cih != null && this.cih.aeM() != null) {
                this.cih.aeM().aet();
            }
            this.cik.a((com.baidu.tbadk.mvc.b.e) this.cii);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cim.aeH().clear();
        }
        this.cim.a(iVar);
        if (iVar != null && iVar.aeH() != null && iVar.aeH().size() > 0) {
            this.cil = iVar.aeH().get(iVar.aeH().size() - 1);
            if (this.cim.getPage() != null) {
                this.aQW.bw(this.cim.getPage().rO() == 1);
            } else {
                this.aQW.bw(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aQW.bx(true);
        } else {
            this.cil = null;
            this.aQW.bw(false);
            this.aQW.bx(false);
        }
        this.aQW.bv(false);
        this.aQW.bu(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xv().xL();
        this.cih.aeQ().o(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.cim.aeH().clear();
        } else {
            this.cih.aeM().d(this.aQW);
        }
        this.cih.aeM().a(this.cim);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cii, readCacheRespMsg.getData().get(0));
        }
        this.cil = null;
        this.cii.reset();
        this.cij.setNeedCache(true);
        this.cij.Dy();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cih.aeM().aeu();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgAtme(0);
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
            this.cih.a(errorData);
            this.cih.aeM().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cih.aeM().aeu();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgAtme(0);
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
            this.cih.a(errorData);
            this.cih.aeM().a(errorData);
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

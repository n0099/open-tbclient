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
public class e extends com.baidu.adp.base.e<bd> implements NetModel.b<h, i>, a.InterfaceC0055a<i> {
    final CustomMessageListener MF;
    private com.baidu.tbadk.mvc.d.a aTd;
    private bd cmH;
    private h cmI;
    private g cmJ;
    private a cmK;
    private FeedData cmL;
    private ae cmM;

    public e(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.MF = new f(this, 2000994);
        this.cmH = bdVar;
    }

    public void c(Bundle bundle) {
        this.cmI = new h();
        this.cmJ = new g((TbPageContext) com.baidu.adp.base.l.C(this.cmH.getPageContext().getPageActivity()), this.cmI);
        this.cmJ.a(this);
        if (this.cmH != null) {
            this.cmJ.setUniqueId(this.cmH.getUniqueId());
        }
        this.cmJ.registerListener(this.MF);
        this.cmK = new a((TbPageContext) com.baidu.adp.base.l.C(this.cmH.getPageContext().getPageActivity()));
        this.cmK.a(this);
        if (this.cmH != null) {
            this.cmK.setUniqueId(this.cmH.getUniqueId());
        }
        this.cmM = new ae();
        this.aTd = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KJ() {
        if (!this.cmJ.isLoading() && this.aTd.Fc() && ahC()) {
            this.aTd.bx(true);
            this.aTd.bz(true);
            this.cmI.b(this.cmL);
            this.cmJ.setNeedCache(false);
            this.cmJ.ET();
            this.cmH.ahV().d(this.aTd);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bU(boolean z) {
        if (this.cmJ.isLoading() || !ahC()) {
            return false;
        }
        this.cmL = null;
        this.cmI.reset();
        this.cmJ.setNeedCache(true);
        this.cmJ.ET();
        return true;
    }

    protected boolean ahC() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cmM != null && this.cmM.cnj != null) {
            this.cmM.cnj.clear();
        }
        this.cmH.ahV().ahE();
        this.cmH.ahV().a(this.cmM);
        return false;
    }

    public boolean oR() {
        if (ahC()) {
            if (this.cmH != null && this.cmH.ahV() != null) {
                this.cmH.ahV().ahD();
            }
            this.cmK.a((com.baidu.tbadk.mvc.b.e) this.cmI);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cmM.ahQ().clear();
        }
        this.cmM.a(iVar);
        if (iVar != null && iVar.ahQ() != null && iVar.ahQ().size() > 0) {
            this.cmL = iVar.ahQ().get(iVar.ahQ().size() - 1);
            if (this.cmM.getPage() != null) {
                this.aTd.by(this.cmM.getPage().sv() == 1);
            } else {
                this.aTd.by(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aTd.bz(true);
        } else {
            this.cmL = null;
            this.aTd.by(false);
            this.aTd.bz(false);
        }
        this.aTd.bx(false);
        this.aTd.bw(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zd();
        this.cmH.ahZ().p(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.cmM.ahQ().clear();
        } else {
            this.cmH.ahV().d(this.aTd);
        }
        this.cmH.ahV().a(this.cmM);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cmI, readCacheRespMsg.getData().get(0));
        }
        this.cmL = null;
        this.cmI.reset();
        this.cmJ.setNeedCache(true);
        this.cmJ.ET();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cmH.ahV().ahE();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(0);
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
            this.cmH.a(errorData);
            this.cmH.ahV().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.cmH.ahV().ahE();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(0);
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
            this.cmH.a(errorData);
            this.cmH.ahV().a(errorData);
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

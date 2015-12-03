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
public class e extends com.baidu.adp.base.e<bc> implements NetModel.b<h, i>, a.InterfaceC0054a<i> {
    private com.baidu.tbadk.mvc.d.a aNd;
    private bc ceg;
    private h ceh;
    private g cei;
    private a cej;
    private FeedData cek;
    private ad cel;
    final CustomMessageListener mNetworkChangedMessageListener;

    public e(bc bcVar) {
        super(com.baidu.adp.base.l.C(bcVar.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new f(this, 2000994);
        this.ceg = bcVar;
    }

    public void f(Bundle bundle) {
        this.ceh = new h();
        this.cei = new g((TbPageContext) com.baidu.adp.base.l.C(this.ceg.getPageContext().getPageActivity()), this.ceh);
        this.cei.a(this);
        this.cei.setUniqueId(getUniqueId());
        this.cei.registerListener(this.mNetworkChangedMessageListener);
        this.cej = new a((TbPageContext) com.baidu.adp.base.l.C(this.ceg.getPageContext().getPageActivity()));
        this.cej.a(this);
        this.cej.setUniqueId(getUniqueId());
        this.cel = new ad();
        this.aNd = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Iz() {
        if (!this.cei.isLoading() && this.aNd.DT() && adj()) {
            this.aNd.bv(true);
            this.aNd.bx(true);
            this.ceh.b(this.cek);
            this.cei.setNeedCache(false);
            this.cei.DJ();
            this.ceg.adE().d(this.aNd);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bO(boolean z) {
        if (this.cei.isLoading() || !adj()) {
            return false;
        }
        this.cek = null;
        this.ceh.reset();
        this.cei.setNeedCache(true);
        this.cei.DJ();
        return true;
    }

    protected boolean adj() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cel != null && this.cel.ceH != null) {
            this.cel.ceH.clear();
        }
        this.ceg.adE().adl();
        this.ceg.adE().a(this.cel);
        return false;
    }

    public boolean oY() {
        if (adj()) {
            if (this.ceg != null && this.ceg.adE() != null) {
                this.ceg.adE().adk();
            }
            this.cej.a((com.baidu.tbadk.mvc.b.e) this.ceh);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cel.adz().clear();
        }
        this.cel.a(iVar);
        if (iVar != null && iVar.adz() != null && iVar.adz().size() > 0) {
            this.cek = iVar.adz().get(iVar.adz().size() - 1);
            if (this.cel.getPage() != null) {
                this.aNd.bw(this.cel.getPage().sf() == 1);
            } else {
                this.aNd.bw(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aNd.bx(true);
        } else {
            this.cek = null;
            this.aNd.bw(false);
            this.aNd.bx(false);
        }
        this.aNd.bv(false);
        this.aNd.bu(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xZ();
        this.ceg.adI().n(2, true);
        if (!TbadkCoreApplication.isLogin()) {
            this.cel.adz().clear();
        } else {
            this.ceg.adE().d(this.aNd);
        }
        this.ceg.adE().a(this.cel);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.ceh, readCacheRespMsg.getData().get(0));
        }
        this.cek = null;
        this.ceh.reset();
        this.cei.setNeedCache(true);
        this.cei.DJ();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.ceg.adE().adl();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgAtme(0);
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
            this.ceg.a(errorData);
            this.ceg.adE().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.ceg.adE().adl();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgAtme(0);
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
            this.ceg.a(errorData);
            this.ceg.adE().a(errorData);
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

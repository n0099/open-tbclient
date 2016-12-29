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
public class e extends com.baidu.adp.base.e<AtMessageActivity> implements NetModel.b<h, i>, a.InterfaceC0047a<i> {
    final CustomMessageListener FT;
    private com.baidu.tbadk.mvc.d.a bfE;
    private AtMessageActivity dcb;
    private h dcc;
    private g dcd;
    private a dce;
    private FeedData dcf;
    private af dcg;

    public e(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.l.C(atMessageActivity.getPageContext().getPageActivity()));
        this.FT = new f(this, 2000994);
        this.dcb = atMessageActivity;
    }

    public void d(Bundle bundle) {
        this.dcc = new h();
        this.dcd = new g((TbPageContext) com.baidu.adp.base.l.C(this.dcb.getPageContext().getPageActivity()), this.dcc);
        this.dcd.a(this);
        if (this.dcb != null) {
            this.dcd.setUniqueId(this.dcb.getUniqueId());
        }
        this.dcd.registerListener(this.FT);
        this.dce = new a((TbPageContext) com.baidu.adp.base.l.C(this.dcb.getPageContext().getPageActivity()));
        this.dce.a(this);
        if (this.dcb != null) {
            this.dce.setUniqueId(this.dcb.getUniqueId());
        }
        this.dcg = new af();
        this.bfE = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Pt() {
        if (!this.dcd.wv() && this.bfE.EW() && auJ()) {
            this.bfE.bP(true);
            this.bfE.bR(true);
            this.dcc.f(this.dcf);
            this.dcd.setNeedCache(false);
            this.dcd.EN();
            this.dcb.d(this.bfE);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean auI() {
        if (this.dcd.wv() || !auJ()) {
            return false;
        }
        this.dcf = null;
        this.dcc.reset();
        this.dcd.setNeedCache(true);
        this.dcd.EN();
        return true;
    }

    protected boolean auJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dcg != null && this.dcg.dcM != null) {
            this.dcg.dcM.clear();
        }
        this.dcb.auK();
        this.dcb.a(this.dcg);
        return false;
    }

    public boolean lV() {
        if (auJ()) {
            if (this.dcb != null) {
                this.dcb.auL();
            }
            this.dce.a((com.baidu.tbadk.mvc.b.e) this.dcc);
            return true;
        }
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.dcg.auS().clear();
        }
        this.dcg.a(iVar);
        if (iVar != null && iVar.auS() != null && iVar.auS().size() > 0) {
            this.dcf = iVar.auS().get(iVar.auS().size() - 1);
            if (this.dcg.getPage() != null) {
                this.bfE.bQ(this.dcg.getPage().qE() == 1);
            } else {
                this.bfE.bQ(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.bfE.bR(true);
        } else {
            this.dcf = null;
            this.bfE.bQ(false);
            this.bfE.bR(false);
        }
        this.bfE.bP(false);
        this.bfE.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yy().yO();
        if (!TbadkCoreApplication.isLogin()) {
            this.dcg.auS().clear();
        } else {
            this.dcb.d(this.bfE);
        }
        this.dcb.a(this.dcg);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dcc, readCacheRespMsg.getData().get(0));
        }
        this.dcf = null;
        this.dcc.reset();
        this.dcd.setNeedCache(true);
        this.dcd.EN();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dcb.auK();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgAtme(0);
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
            this.dcb.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        this.dcb.auK();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgAtme(0);
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
            this.dcb.a(errorData);
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

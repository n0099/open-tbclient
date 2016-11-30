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
    final CustomMessageListener FT;
    private com.baidu.tbadk.mvc.d.a bgo;
    private ax dzW;
    private aw dzX;
    private am dzY;
    private bf dzh;
    private FeedData dzl;
    private ag dzm;

    public au(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.FT = new av(this, 2000994);
        this.dzh = bfVar;
    }

    public void d(Bundle bundle) {
        this.dzW = new ax();
        this.dzX = new aw((TbPageContext) com.baidu.adp.base.l.C(this.dzh.getPageContext().getPageActivity()), this.dzW);
        this.dzX.a(this);
        this.dzX.setUniqueId(getUniqueId());
        this.dzX.registerListener(this.FT);
        this.dzY = new am((TbPageContext) com.baidu.adp.base.l.C(this.dzh.getPageContext().getPageActivity()));
        this.dzY.a(this);
        this.dzY.setUniqueId(getUniqueId());
        this.dzm = new ag();
        this.bgo = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean PU() {
        if (!this.dzX.wL() && this.bgo.Fo() && aBm()) {
            this.bgo.bP(true);
            this.bgo.bR(true);
            this.dzW.d(this.dzl);
            this.dzX.setNeedCache(false);
            this.dzX.Ff();
            this.dzh.aBE().d(this.bgo);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cA(boolean z) {
        if (this.dzX.wL() || !aBm()) {
            return false;
        }
        this.dzl = null;
        this.dzW.reset();
        this.dzX.setNeedCache(true);
        this.dzX.Ff();
        return true;
    }

    protected boolean aBm() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dzm != null && this.dzm.dzL != null) {
            this.dzm.dzL.clear();
        }
        this.dzh.aBE().aBo();
        this.dzh.aBE().a(this.dzm);
        return false;
    }

    public boolean lV() {
        if (aBm()) {
            if (this.dzh != null && this.dzh.aBE() != null) {
                this.dzh.aBE().aBn();
            }
            this.dzY.a((com.baidu.tbadk.mvc.b.e) this.dzW);
            return true;
        }
        return true;
    }

    protected boolean a(ax axVar, ay ayVar) {
        if (axVar.getUpdateType() != 4) {
            this.dzm.aBz().clear();
        }
        this.dzm.a(ayVar);
        if (ayVar != null && ayVar.aBz() != null && ayVar.aBz().size() > 0) {
            this.dzl = ayVar.aBz().get(ayVar.aBz().size() - 1);
            if (this.dzm.getPage() != null) {
                this.bgo.bQ(this.dzm.getPage().qD() == 1);
            } else {
                this.bgo.bQ(true);
            }
            if (axVar != null) {
                axVar.toNextPage();
            }
            this.bgo.bR(true);
        } else {
            this.dzl = null;
            this.bgo.bQ(false);
            this.bgo.bR(false);
        }
        this.bgo.bP(false);
        this.bgo.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().yZ();
        this.dzh.aBJ().J(1, true);
        this.dzh.aBE().a(this.dzm);
        this.dzh.aBE().d(this.bgo);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<ay>> readCacheRespMsg, ReadCacheMessage<ay> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dzW, readCacheRespMsg.getData().get(0));
        }
        this.dzl = null;
        this.dzW.reset();
        this.dzX.setNeedCache(true);
        this.dzX.Ff();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<ay>> writeCacheRespMsg, WriteCacheMessage<ay> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ay> mvcHttpResponsedMessage, MvcHttpMessage<ax, ay> mvcHttpMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dzh.aBE().aBo();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ayVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
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
                this.dzh.a(errorData);
                this.dzh.aBE().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ay, ?> mvcSocketResponsedMessage, MvcSocketMessage<ax, ay> mvcSocketMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dzh.aBE().aBo();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ayVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
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
                this.dzh.a(errorData);
                this.dzh.aBE().a(errorData);
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

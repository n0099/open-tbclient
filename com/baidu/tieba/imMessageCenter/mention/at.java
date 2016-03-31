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
public class at extends com.baidu.adp.base.e<be> implements NetModel.b<aw, ax>, a.InterfaceC0055a<ax> {
    final CustomMessageListener ML;
    private com.baidu.tbadk.mvc.d.a aWP;
    private aw cxW;
    private av cxX;
    private al cxY;
    private be cxj;
    private FeedData cxn;
    private af cxo;

    public at(be beVar) {
        super(com.baidu.adp.base.l.s(beVar.getPageContext().getPageActivity()));
        this.ML = new au(this, 2000994);
        this.cxj = beVar;
    }

    public void c(Bundle bundle) {
        this.cxW = new aw();
        this.cxX = new av((TbPageContext) com.baidu.adp.base.l.s(this.cxj.getPageContext().getPageActivity()), this.cxW);
        this.cxX.a(this);
        this.cxX.setUniqueId(getUniqueId());
        this.cxX.registerListener(this.ML);
        this.cxY = new al((TbPageContext) com.baidu.adp.base.l.s(this.cxj.getPageContext().getPageActivity()));
        this.cxY.a(this);
        this.cxY.setUniqueId(getUniqueId());
        this.cxo = new af();
        this.aWP = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Md() {
        if (!this.cxX.isLoading() && this.aWP.FP() && akW()) {
            this.aWP.bC(true);
            this.aWP.bE(true);
            this.cxW.d(this.cxn);
            this.cxX.setNeedCache(false);
            this.cxX.FG();
            this.cxj.alo().d(this.aWP);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ce(boolean z) {
        if (this.cxX.isLoading() || !akW()) {
            return false;
        }
        this.cxn = null;
        this.cxW.reset();
        this.cxX.setNeedCache(true);
        this.cxX.FG();
        return true;
    }

    protected boolean akW() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cxo != null && this.cxo.cxL != null) {
            this.cxo.cxL.clear();
        }
        this.cxj.alo().akY();
        this.cxj.alo().a(this.cxo);
        return false;
    }

    public boolean oK() {
        if (akW()) {
            if (this.cxj != null && this.cxj.alo() != null) {
                this.cxj.alo().akX();
            }
            this.cxY.a((com.baidu.tbadk.mvc.b.e) this.cxW);
            return true;
        }
        return true;
    }

    protected boolean a(aw awVar, ax axVar) {
        if (awVar.getUpdateType() != 4) {
            this.cxo.alk().clear();
        }
        this.cxo.a(axVar);
        if (axVar != null && axVar.alk() != null && axVar.alk().size() > 0) {
            this.cxn = axVar.alk().get(axVar.alk().size() - 1);
            if (this.cxo.getPage() != null) {
                this.aWP.bD(this.cxo.getPage().sq() == 1);
            } else {
                this.aWP.bD(true);
            }
            if (awVar != null) {
                awVar.toNextPage();
            }
            this.aWP.bE(true);
        } else {
            this.cxn = null;
            this.aWP.bD(false);
            this.aWP.bE(false);
        }
        this.aWP.bC(false);
        this.aWP.bB(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().zE();
        this.cxj.alt().p(1, true);
        this.cxj.alo().a(this.cxo);
        this.cxj.alo().d(this.aWP);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(ReadCacheRespMsg<List<ax>> readCacheRespMsg, ReadCacheMessage<ax> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cxW, readCacheRespMsg.getData().get(0));
        }
        this.cxn = null;
        this.cxW.reset();
        this.cxX.setNeedCache(true);
        this.cxX.FG();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<ax>> writeCacheRespMsg, WriteCacheMessage<ax> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ax> mvcHttpResponsedMessage, MvcHttpMessage<aw, ax> mvcHttpMessage, MvcNetMessage<aw, ax> mvcNetMessage) {
        ax axVar;
        this.cxj.alo().akY();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            axVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().setMsgReplyme(0);
            axVar = null;
        }
        if (r1 == null || axVar == null || !a(r1, axVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.cxj.a(errorData);
                this.cxj.alo().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ax, ?> mvcSocketResponsedMessage, MvcSocketMessage<aw, ax> mvcSocketMessage, MvcNetMessage<aw, ax> mvcNetMessage) {
        ax axVar;
        this.cxj.alo().akY();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            axVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().setMsgReplyme(0);
            axVar = null;
        }
        if (r1 == null || axVar == null || !a(r1, axVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.cxj.a(errorData);
                this.cxj.alo().a(errorData);
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

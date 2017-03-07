package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
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
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.mvc.model.NetModel;
import java.util.List;
/* loaded from: classes.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<f>, NetModel.b<e, f> {
    private com.baidu.tbadk.mvc.d.a bzQ;
    private AtMessageActivity dlG;
    private e dlH;
    private AtMeNetModel dlI;
    private AtMeCacheModel dlJ;
    private FeedData dlK;
    private ac dlL;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.aa(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.dlG = atMessageActivity;
    }

    public void e(Bundle bundle) {
        this.dlH = new e();
        this.dlI = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.aa(this.dlG.getPageContext().getPageActivity()), this.dlH);
        this.dlI.a(this);
        if (this.dlG != null) {
            this.dlI.setUniqueId(this.dlG.getUniqueId());
        }
        this.dlI.registerListener(this.mNetworkChangedMessageListener);
        this.dlJ = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.aa(this.dlG.getPageContext().getPageActivity()));
        this.dlJ.a(this);
        if (this.dlG != null) {
            this.dlJ.setUniqueId(this.dlG.getUniqueId());
        }
        this.dlL = new ac();
        this.bzQ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean TR() {
        if (!this.dlI.wN() && this.bzQ.Fp() && avl()) {
            this.bzQ.bP(true);
            this.bzQ.bR(true);
            this.dlH.g(this.dlK);
            this.dlI.setNeedCache(false);
            this.dlI.Fe();
            this.dlG.b(this.bzQ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avk() {
        if (this.dlI.wN() || !avl()) {
            return false;
        }
        this.dlK = null;
        this.dlH.reset();
        this.dlI.setNeedCache(true);
        this.dlI.Fe();
        return true;
    }

    protected boolean avl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dlL != null && this.dlL.dmr != null) {
            this.dlL.dmr.clear();
        }
        this.dlG.avm();
        this.dlG.a(this.dlL);
        return false;
    }

    public boolean TQ() {
        if (avl()) {
            if (this.dlG != null) {
                this.dlG.avn();
            }
            this.dlJ.a((com.baidu.tbadk.mvc.b.e) this.dlH);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.dlL.avv().clear();
        }
        this.dlL.a(fVar);
        if (fVar != null && fVar.avv() != null && fVar.avv().size() > 0) {
            this.dlK = fVar.avv().get(fVar.avv().size() - 1);
            if (this.dlL.getPage() != null) {
                this.bzQ.bQ(this.dlL.getPage().qQ() == 1);
            } else {
                this.bzQ.bQ(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bzQ.bR(true);
        } else {
            this.dlK = null;
            this.bzQ.bQ(false);
            this.bzQ.bR(false);
        }
        this.bzQ.bP(false);
        this.bzQ.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().za();
        if (!TbadkCoreApplication.isLogin()) {
            this.dlL.avv().clear();
        } else {
            this.dlG.b(this.bzQ);
        }
        this.dlG.a(this.dlL);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dlH, readCacheRespMsg.getData().get(0));
        }
        this.dlK = null;
        this.dlH.reset();
        this.dlI.setNeedCache(true);
        this.dlI.Fe();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dlG.avm();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            fVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
            fVar = null;
        }
        if (r1 == null || fVar == null || !a(r1, fVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.dlG.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dlG.avm();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            fVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
            fVar = null;
        }
        if (r1 == null || fVar == null || !a(r1, fVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.dlG.a(errorData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}

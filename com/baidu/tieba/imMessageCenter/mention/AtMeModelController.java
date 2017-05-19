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
/* loaded from: classes2.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<f>, NetModel.b<e, f> {
    private com.baidu.tbadk.mvc.d.a bCb;
    private AtMessageActivity dgA;
    private e dgB;
    private AtMeNetModel dgC;
    private AtMeCacheModel dgD;
    private FeedData dgE;
    private ac dgF;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.Z(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.dgA = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dgB = new e();
        this.dgC = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dgA.getPageContext().getPageActivity()), this.dgB);
        this.dgC.a(this);
        if (this.dgA != null) {
            this.dgC.setUniqueId(this.dgA.getUniqueId());
        }
        this.dgC.registerListener(this.mNetworkChangedMessageListener);
        this.dgD = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dgA.getPageContext().getPageActivity()));
        this.dgD.a(this);
        if (this.dgA != null) {
            this.dgD.setUniqueId(this.dgA.getUniqueId());
        }
        this.dgF = new ac();
        this.bCb = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean UJ() {
        if (!this.dgC.wu() && this.bCb.ER() && ata()) {
            this.bCb.bS(true);
            this.bCb.bU(true);
            this.dgB.g(this.dgE);
            this.dgC.setNeedCache(false);
            this.dgC.EG();
            this.dgA.b(this.bCb);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean asZ() {
        if (this.dgC.wu() || !ata()) {
            return false;
        }
        this.dgE = null;
        this.dgB.reset();
        this.dgC.setNeedCache(true);
        this.dgC.EG();
        return true;
    }

    protected boolean ata() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dgF != null && this.dgF.dhm != null) {
            this.dgF.dhm.clear();
        }
        this.dgA.atb();
        this.dgA.a(this.dgF);
        return false;
    }

    public boolean UI() {
        if (ata()) {
            if (this.dgA != null) {
                this.dgA.atc();
            }
            this.dgD.a((com.baidu.tbadk.mvc.b.e) this.dgB);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.dgF.atk().clear();
        }
        this.dgF.a(fVar);
        if (fVar != null && fVar.atk() != null && fVar.atk().size() > 0) {
            this.dgE = fVar.atk().get(fVar.atk().size() - 1);
            if (this.dgF.qB() != null) {
                this.bCb.bT(this.dgF.qB().qx() == 1);
            } else {
                this.bCb.bT(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bCb.bU(true);
        } else {
            this.dgE = null;
            this.bCb.bT(false);
            this.bCb.bU(false);
        }
        this.bCb.bS(false);
        this.bCb.bR(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yu().yK();
        if (!TbadkCoreApplication.isLogin()) {
            this.dgF.atk().clear();
        } else {
            this.dgA.b(this.bCb);
        }
        this.dgA.a(this.dgF);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dgB, readCacheRespMsg.getData().get(0));
        }
        this.dgE = null;
        this.dgB.reset();
        this.dgC.setNeedCache(true);
        this.dgC.EG();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dgA.atb();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            fVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgAtme(0);
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
            this.dgA.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dgA.atb();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            fVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgAtme(0);
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
            this.dgA.a(errorData);
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

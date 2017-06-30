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
    private com.baidu.tbadk.mvc.d.a bIK;
    private AtMessageActivity dtS;
    private e dtT;
    private AtMeNetModel dtU;
    private AtMeCacheModel dtV;
    private FeedData dtW;
    private ac dtX;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.Z(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.dtS = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dtT = new e();
        this.dtU = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dtS.getPageContext().getPageActivity()), this.dtT);
        this.dtU.a(this);
        if (this.dtS != null) {
            this.dtU.setUniqueId(this.dtS.getUniqueId());
        }
        this.dtU.registerListener(this.mNetworkChangedMessageListener);
        this.dtV = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dtS.getPageContext().getPageActivity()));
        this.dtV.a(this);
        if (this.dtS != null) {
            this.dtV.setUniqueId(this.dtS.getUniqueId());
        }
        this.dtX = new ac();
        this.bIK = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Xc() {
        if (!this.dtU.wI() && this.bIK.Fi() && axD()) {
            this.bIK.bR(true);
            this.bIK.bT(true);
            this.dtT.g(this.dtW);
            this.dtU.setNeedCache(false);
            this.dtU.EX();
            this.dtS.b(this.bIK);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean axC() {
        if (this.dtU.wI() || !axD()) {
            return false;
        }
        this.dtW = null;
        this.dtT.reset();
        this.dtU.setNeedCache(true);
        this.dtU.EX();
        return true;
    }

    protected boolean axD() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dtX != null && this.dtX.duE != null) {
            this.dtX.duE.clear();
        }
        this.dtS.axE();
        this.dtS.a(this.dtX);
        return false;
    }

    public boolean Xb() {
        if (axD()) {
            if (this.dtS != null) {
                this.dtS.axF();
            }
            this.dtV.a((com.baidu.tbadk.mvc.b.e) this.dtT);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.dtX.axM().clear();
        }
        this.dtX.a(fVar);
        if (fVar != null && fVar.axM() != null && fVar.axM().size() > 0) {
            this.dtW = fVar.axM().get(fVar.axM().size() - 1);
            if (this.dtX.qu() != null) {
                this.bIK.bS(this.dtX.qu().qq() == 1);
            } else {
                this.bIK.bS(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bIK.bT(true);
        } else {
            this.dtW = null;
            this.bIK.bS(false);
            this.bIK.bT(false);
        }
        this.bIK.bR(false);
        this.bIK.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().yW();
        if (!TbadkCoreApplication.isLogin()) {
            this.dtX.axM().clear();
        } else {
            this.dtS.b(this.bIK);
        }
        this.dtS.a(this.dtX);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dtT, readCacheRespMsg.getData().get(0));
        }
        this.dtW = null;
        this.dtT.reset();
        this.dtU.setNeedCache(true);
        this.dtU.EX();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dtS.axE();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            fVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgAtme(0);
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
            this.dtS.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dtS.axE();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            fVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgAtme(0);
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
            this.dtS.a(errorData);
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

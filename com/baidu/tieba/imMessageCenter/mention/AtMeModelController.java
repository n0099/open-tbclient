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
    private com.baidu.tbadk.mvc.d.a bHR;
    private AtMessageActivity dlW;
    private e dlX;
    private AtMeNetModel dlY;
    private AtMeCacheModel dlZ;
    private FeedData dma;
    private ac dmb;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.Z(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.dlW = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dlX = new e();
        this.dlY = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dlW.getPageContext().getPageActivity()), this.dlX);
        this.dlY.a(this);
        if (this.dlW != null) {
            this.dlY.setUniqueId(this.dlW.getUniqueId());
        }
        this.dlY.registerListener(this.mNetworkChangedMessageListener);
        this.dlZ = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dlW.getPageContext().getPageActivity()));
        this.dlZ.a(this);
        if (this.dlW != null) {
            this.dlZ.setUniqueId(this.dlW.getUniqueId());
        }
        this.dmb = new ac();
        this.bHR = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean VL() {
        if (!this.dlY.wq() && this.bHR.EL() && atV()) {
            this.bHR.bP(true);
            this.bHR.bR(true);
            this.dlX.g(this.dma);
            this.dlY.setNeedCache(false);
            this.dlY.EA();
            this.dlW.b(this.bHR);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean atU() {
        if (this.dlY.wq() || !atV()) {
            return false;
        }
        this.dma = null;
        this.dlX.reset();
        this.dlY.setNeedCache(true);
        this.dlY.EA();
        return true;
    }

    protected boolean atV() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dmb != null && this.dmb.dmI != null) {
            this.dmb.dmI.clear();
        }
        this.dlW.atW();
        this.dlW.a(this.dmb);
        return false;
    }

    public boolean VK() {
        if (atV()) {
            if (this.dlW != null) {
                this.dlW.atX();
            }
            this.dlZ.a((com.baidu.tbadk.mvc.b.e) this.dlX);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.dmb.auf().clear();
        }
        this.dmb.a(fVar);
        if (fVar != null && fVar.auf() != null && fVar.auf().size() > 0) {
            this.dma = fVar.auf().get(fVar.auf().size() - 1);
            if (this.dmb.qx() != null) {
                this.bHR.bQ(this.dmb.qx().qt() == 1);
            } else {
                this.bHR.bQ(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bHR.bR(true);
        } else {
            this.dma = null;
            this.bHR.bQ(false);
            this.bHR.bR(false);
        }
        this.bHR.bP(false);
        this.bHR.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().yD();
        if (!TbadkCoreApplication.isLogin()) {
            this.dmb.auf().clear();
        } else {
            this.dlW.b(this.bHR);
        }
        this.dlW.a(this.dmb);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dlX, readCacheRespMsg.getData().get(0));
        }
        this.dma = null;
        this.dlX.reset();
        this.dlY.setNeedCache(true);
        this.dlY.EA();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dlW.atW();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            fVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgAtme(0);
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
            this.dlW.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dlW.atW();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            fVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgAtme(0);
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
            this.dlW.a(errorData);
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

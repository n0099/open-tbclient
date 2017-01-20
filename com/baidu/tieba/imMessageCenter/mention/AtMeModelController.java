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
    private com.baidu.tbadk.mvc.d.a bsH;
    private AtMessageActivity djn;
    private e djo;
    private AtMeNetModel djp;
    private AtMeCacheModel djq;
    private FeedData djr;
    private ac djs;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.C(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.djn = atMessageActivity;
    }

    public void d(Bundle bundle) {
        this.djo = new e();
        this.djp = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.C(this.djn.getPageContext().getPageActivity()), this.djo);
        this.djp.a(this);
        if (this.djn != null) {
            this.djp.setUniqueId(this.djn.getUniqueId());
        }
        this.djp.registerListener(this.mNetworkChangedMessageListener);
        this.djq = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.C(this.djn.getPageContext().getPageActivity()));
        this.djq.a(this);
        if (this.djn != null) {
            this.djq.setUniqueId(this.djn.getUniqueId());
        }
        this.djs = new ac();
        this.bsH = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean SQ() {
        if (!this.djp.wq() && this.bsH.EQ() && avP()) {
            this.bsH.bP(true);
            this.bsH.bR(true);
            this.djo.f(this.djr);
            this.djp.setNeedCache(false);
            this.djp.EH();
            this.djn.d(this.bsH);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avO() {
        if (this.djp.wq() || !avP()) {
            return false;
        }
        this.djr = null;
        this.djo.reset();
        this.djp.setNeedCache(true);
        this.djp.EH();
        return true;
    }

    protected boolean avP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.djs != null && this.djs.djX != null) {
            this.djs.djX.clear();
        }
        this.djn.avQ();
        this.djn.a(this.djs);
        return false;
    }

    public boolean lN() {
        if (avP()) {
            if (this.djn != null) {
                this.djn.avR();
            }
            this.djq.a((com.baidu.tbadk.mvc.b.e) this.djo);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.djs.avZ().clear();
        }
        this.djs.a(fVar);
        if (fVar != null && fVar.avZ() != null && fVar.avZ().size() > 0) {
            this.djr = fVar.avZ().get(fVar.avZ().size() - 1);
            if (this.djs.getPage() != null) {
                this.bsH.bQ(this.djs.getPage().qx() == 1);
            } else {
                this.bsH.bQ(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bsH.bR(true);
        } else {
            this.djr = null;
            this.bsH.bQ(false);
            this.bsH.bR(false);
        }
        this.bsH.bP(false);
        this.bsH.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yt().yJ();
        if (!TbadkCoreApplication.isLogin()) {
            this.djs.avZ().clear();
        } else {
            this.djn.d(this.bsH);
        }
        this.djn.a(this.djs);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.djo, readCacheRespMsg.getData().get(0));
        }
        this.djr = null;
        this.djo.reset();
        this.djp.setNeedCache(true);
        this.djp.EH();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.djn.avQ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            fVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgAtme(0);
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
            this.djn.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.djn.avQ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            fVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgAtme(0);
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
            this.djn.a(errorData);
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

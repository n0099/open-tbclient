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
    private com.baidu.tbadk.mvc.d.a bCa;
    private FeedData dmA;
    private ac dmB;
    private AtMessageActivity dmw;
    private e dmx;
    private AtMeNetModel dmy;
    private AtMeCacheModel dmz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.Z(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.dmw = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dmx = new e();
        this.dmy = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dmw.getPageContext().getPageActivity()), this.dmx);
        this.dmy.a(this);
        if (this.dmw != null) {
            this.dmy.setUniqueId(this.dmw.getUniqueId());
        }
        this.dmy.registerListener(this.mNetworkChangedMessageListener);
        this.dmz = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dmw.getPageContext().getPageActivity()));
        this.dmz.a(this);
        if (this.dmw != null) {
            this.dmz.setUniqueId(this.dmw.getUniqueId());
        }
        this.dmB = new ac();
        this.bCa = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Vq() {
        if (!this.dmy.xj() && this.bCa.FN() && awf()) {
            this.bCa.bR(true);
            this.bCa.bT(true);
            this.dmx.g(this.dmA);
            this.dmy.setNeedCache(false);
            this.dmy.FC();
            this.dmw.b(this.bCa);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awe() {
        if (this.dmy.xj() || !awf()) {
            return false;
        }
        this.dmA = null;
        this.dmx.reset();
        this.dmy.setNeedCache(true);
        this.dmy.FC();
        return true;
    }

    protected boolean awf() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dmB != null && this.dmB.dnh != null) {
            this.dmB.dnh.clear();
        }
        this.dmw.awg();
        this.dmw.a(this.dmB);
        return false;
    }

    public boolean Vp() {
        if (awf()) {
            if (this.dmw != null) {
                this.dmw.awh();
            }
            this.dmz.a((com.baidu.tbadk.mvc.b.e) this.dmx);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.dmB.awp().clear();
        }
        this.dmB.a(fVar);
        if (fVar != null && fVar.awp() != null && fVar.awp().size() > 0) {
            this.dmA = fVar.awp().get(fVar.awp().size() - 1);
            if (this.dmB.rr() != null) {
                this.bCa.bS(this.dmB.rr().rn() == 1);
            } else {
                this.bCa.bS(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bCa.bT(true);
        } else {
            this.dmA = null;
            this.bCa.bS(false);
            this.bCa.bT(false);
        }
        this.bCa.bR(false);
        this.bCa.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().zz();
        if (!TbadkCoreApplication.isLogin()) {
            this.dmB.awp().clear();
        } else {
            this.dmw.b(this.bCa);
        }
        this.dmw.a(this.dmB);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dmx, readCacheRespMsg.getData().get(0));
        }
        this.dmA = null;
        this.dmx.reset();
        this.dmy.setNeedCache(true);
        this.dmy.FC();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dmw.awg();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            fVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgAtme(0);
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
            this.dmw.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dmw.awg();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            fVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgAtme(0);
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
            this.dmw.a(errorData);
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

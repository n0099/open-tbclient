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
    private com.baidu.tbadk.mvc.d.a bzJ;
    private AtMessageActivity dkf;
    private e dkg;
    private AtMeNetModel dkh;
    private AtMeCacheModel dki;
    private FeedData dkj;
    private ac dkk;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.k.Z(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new d(this, 2000994);
        this.dkf = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dkg = new e();
        this.dkh = new AtMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dkf.getPageContext().getPageActivity()), this.dkg);
        this.dkh.a(this);
        if (this.dkf != null) {
            this.dkh.setUniqueId(this.dkf.getUniqueId());
        }
        this.dkh.registerListener(this.mNetworkChangedMessageListener);
        this.dki = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dkf.getPageContext().getPageActivity()));
        this.dki.a(this);
        if (this.dkf != null) {
            this.dki.setUniqueId(this.dkf.getUniqueId());
        }
        this.dkk = new ac();
        this.bzJ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Up() {
        if (!this.dkh.xj() && this.bzJ.FN() && ave()) {
            this.bzJ.bR(true);
            this.bzJ.bT(true);
            this.dkg.g(this.dkj);
            this.dkh.setNeedCache(false);
            this.dkh.FC();
            this.dkf.b(this.bzJ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avd() {
        if (this.dkh.xj() || !ave()) {
            return false;
        }
        this.dkj = null;
        this.dkg.reset();
        this.dkh.setNeedCache(true);
        this.dkh.FC();
        return true;
    }

    protected boolean ave() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dkk != null && this.dkk.dkQ != null) {
            this.dkk.dkQ.clear();
        }
        this.dkf.avf();
        this.dkf.a(this.dkk);
        return false;
    }

    public boolean Uo() {
        if (ave()) {
            if (this.dkf != null) {
                this.dkf.avg();
            }
            this.dki.a((com.baidu.tbadk.mvc.b.e) this.dkg);
            return true;
        }
        return true;
    }

    protected boolean a(e eVar, f fVar) {
        if (eVar.getUpdateType() != 4) {
            this.dkk.avo().clear();
        }
        this.dkk.a(fVar);
        if (fVar != null && fVar.avo() != null && fVar.avo().size() > 0) {
            this.dkj = fVar.avo().get(fVar.avo().size() - 1);
            if (this.dkk.rr() != null) {
                this.bzJ.bS(this.dkk.rr().rn() == 1);
            } else {
                this.bzJ.bS(true);
            }
            if (eVar != null) {
                eVar.toNextPage();
            }
            this.bzJ.bT(true);
        } else {
            this.dkj = null;
            this.bzJ.bS(false);
            this.bzJ.bT(false);
        }
        this.bzJ.bR(false);
        this.bzJ.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().zz();
        if (!TbadkCoreApplication.isLogin()) {
            this.dkk.avo().clear();
        } else {
            this.dkf.b(this.bzJ);
        }
        this.dkf.a(this.dkk);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<f>> readCacheRespMsg, ReadCacheMessage<f> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dkg, readCacheRespMsg.getData().get(0));
        }
        this.dkj = null;
        this.dkg.reset();
        this.dkh.setNeedCache(true);
        this.dkh.FC();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<f>> writeCacheRespMsg, WriteCacheMessage<f> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<f> mvcHttpResponsedMessage, MvcHttpMessage<e, f> mvcHttpMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dkf.avf();
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
            this.dkf.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<f, ?> mvcSocketResponsedMessage, MvcSocketMessage<e, f> mvcSocketMessage, MvcNetMessage<e, f> mvcNetMessage) {
        f fVar;
        this.dkf.avf();
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
            this.dkf.a(errorData);
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

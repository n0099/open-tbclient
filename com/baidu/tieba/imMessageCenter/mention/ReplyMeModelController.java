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
public class ReplyMeModelController extends BdBaseModel<ReplyMessageActivity> implements CacheModel.a<au>, NetModel.b<at, au> {
    private com.baidu.tbadk.mvc.d.a bCb;
    private FeedData dgE;
    private ac dgF;
    private ReplyMeNetModel dhA;
    private ReplyMeCacheModel dhB;
    private ReplyMessageActivity dhy;
    private at dhz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new as(this, 2000994);
        this.dhy = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dhz = new at();
        this.dhA = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dhy.getPageContext().getPageActivity()), this.dhz);
        this.dhA.a(this);
        this.dhA.setUniqueId(getUniqueId());
        this.dhA.registerListener(this.mNetworkChangedMessageListener);
        this.dhB = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dhy.getPageContext().getPageActivity()));
        this.dhB.a(this);
        this.dhB.setUniqueId(getUniqueId());
        this.dgF = new ac();
        this.bCb = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean UJ() {
        if (!this.dhA.wu() && this.bCb.ER() && ata()) {
            this.bCb.bS(true);
            this.bCb.bU(true);
            this.dhz.g(this.dgE);
            this.dhA.setNeedCache(false);
            this.dhA.EG();
            this.dhy.b(this.bCb);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dl(boolean z) {
        if (this.dhA.wu() || !ata()) {
            return false;
        }
        this.dgE = null;
        this.dhz.reset();
        this.dhA.setNeedCache(true);
        this.dhA.EG();
        return true;
    }

    protected boolean ata() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dgF != null && this.dgF.dhm != null) {
            this.dgF.dhm.clear();
        }
        this.dhy.atb();
        this.dhy.a(this.dgF);
        return false;
    }

    public boolean UI() {
        if (ata()) {
            if (this.dhy != null) {
                this.dhy.atc();
            }
            this.dhB.a((com.baidu.tbadk.mvc.b.e) this.dhz);
            return true;
        }
        return true;
    }

    protected boolean a(at atVar, au auVar) {
        if (atVar.getUpdateType() != 4) {
            this.dgF.atk().clear();
        }
        this.dgF.a(auVar);
        if (auVar != null && auVar.atk() != null && auVar.atk().size() > 0) {
            this.dgE = auVar.atk().get(auVar.atk().size() - 1);
            if (this.dgF.qB() != null) {
                this.bCb.bT(this.dgF.qB().qx() == 1);
            } else {
                this.bCb.bT(true);
            }
            if (atVar != null) {
                atVar.toNextPage();
            }
            this.bCb.bU(true);
        } else {
            this.dgE = null;
            this.bCb.bT(false);
            this.bCb.bU(false);
        }
        this.bCb.bS(false);
        this.bCb.bR(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yu().yJ();
        this.dhy.a(this.dgF);
        this.dhy.b(this.bCb);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<au>> readCacheRespMsg, ReadCacheMessage<au> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dhz, readCacheRespMsg.getData().get(0));
        }
        this.dgE = null;
        this.dhz.reset();
        this.dhA.setNeedCache(true);
        this.dhA.EG();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<au>> writeCacheRespMsg, WriteCacheMessage<au> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<au> mvcHttpResponsedMessage, MvcHttpMessage<at, au> mvcHttpMessage, MvcNetMessage<at, au> mvcNetMessage) {
        au auVar;
        this.dhy.atb();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            auVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgReplyme(0);
            auVar = null;
        }
        if (r1 == null || auVar == null || !a(r1, auVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dhy.a(errorData);
                this.dhy.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<au, ?> mvcSocketResponsedMessage, MvcSocketMessage<at, au> mvcSocketMessage, MvcNetMessage<at, au> mvcNetMessage) {
        au auVar;
        this.dhy.atb();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            auVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgReplyme(0);
            auVar = null;
        }
        if (r1 == null || auVar == null || !a(r1, auVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dhy.a(errorData);
                this.dhy.a(errorData);
            }
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

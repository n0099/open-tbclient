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
    private com.baidu.tbadk.mvc.d.a bIK;
    private FeedData dtW;
    private ac dtX;
    private ReplyMessageActivity duQ;
    private at duR;
    private ReplyMeNetModel duS;
    private ReplyMeCacheModel duT;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new as(this, 2000994);
        this.duQ = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.duR = new at();
        this.duS = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.duQ.getPageContext().getPageActivity()), this.duR);
        this.duS.a(this);
        this.duS.setUniqueId(getUniqueId());
        this.duS.registerListener(this.mNetworkChangedMessageListener);
        this.duT = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.duQ.getPageContext().getPageActivity()));
        this.duT.a(this);
        this.duT.setUniqueId(getUniqueId());
        this.dtX = new ac();
        this.bIK = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Xc() {
        if (!this.duS.wI() && this.bIK.Fi() && axD()) {
            this.bIK.bR(true);
            this.bIK.bT(true);
            this.duR.g(this.dtW);
            this.duS.setNeedCache(false);
            this.duS.EX();
            this.duQ.b(this.bIK);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dE(boolean z) {
        if (this.duS.wI() || !axD()) {
            return false;
        }
        this.dtW = null;
        this.duR.reset();
        this.duS.setNeedCache(true);
        this.duS.EX();
        return true;
    }

    protected boolean axD() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dtX != null && this.dtX.duE != null) {
            this.dtX.duE.clear();
        }
        this.duQ.axE();
        this.duQ.a(this.dtX);
        return false;
    }

    public boolean Xb() {
        if (axD()) {
            if (this.duQ != null) {
                this.duQ.axF();
            }
            this.duT.a((com.baidu.tbadk.mvc.b.e) this.duR);
            return true;
        }
        return true;
    }

    protected boolean a(at atVar, au auVar) {
        if (atVar.getUpdateType() != 4) {
            this.dtX.axM().clear();
        }
        this.dtX.a(auVar);
        if (auVar != null && auVar.axM() != null && auVar.axM().size() > 0) {
            this.dtW = auVar.axM().get(auVar.axM().size() - 1);
            if (this.dtX.qu() != null) {
                this.bIK.bS(this.dtX.qu().qq() == 1);
            } else {
                this.bIK.bS(true);
            }
            if (atVar != null) {
                atVar.toNextPage();
            }
            this.bIK.bT(true);
        } else {
            this.dtW = null;
            this.bIK.bS(false);
            this.bIK.bT(false);
        }
        this.bIK.bR(false);
        this.bIK.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().yV();
        this.duQ.a(this.dtX);
        this.duQ.b(this.bIK);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<au>> readCacheRespMsg, ReadCacheMessage<au> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.duR, readCacheRespMsg.getData().get(0));
        }
        this.dtW = null;
        this.duR.reset();
        this.duS.setNeedCache(true);
        this.duS.EX();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<au>> writeCacheRespMsg, WriteCacheMessage<au> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<au> mvcHttpResponsedMessage, MvcHttpMessage<at, au> mvcHttpMessage, MvcNetMessage<at, au> mvcNetMessage) {
        au auVar;
        this.duQ.axE();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            auVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgReplyme(0);
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
                this.duQ.a(errorData);
                this.duQ.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<au, ?> mvcSocketResponsedMessage, MvcSocketMessage<at, au> mvcSocketMessage, MvcNetMessage<at, au> mvcNetMessage) {
        au auVar;
        this.duQ.axE();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            auVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgReplyme(0);
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
                this.duQ.a(errorData);
                this.duQ.a(errorData);
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

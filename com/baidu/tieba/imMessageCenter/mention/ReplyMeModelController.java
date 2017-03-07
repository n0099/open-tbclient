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
public class ReplyMeModelController extends BdBaseModel<ReplyMessageActivity> implements CacheModel.a<at>, NetModel.b<as, at> {
    private com.baidu.tbadk.mvc.d.a bzQ;
    private FeedData dlK;
    private ac dlL;
    private ReplyMessageActivity dmD;
    private as dmE;
    private ReplyMeNetModel dmF;
    private ReplyMeCacheModel dmG;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.aa(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new ar(this, 2000994);
        this.dmD = replyMessageActivity;
    }

    public void e(Bundle bundle) {
        this.dmE = new as();
        this.dmF = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.aa(this.dmD.getPageContext().getPageActivity()), this.dmE);
        this.dmF.a(this);
        this.dmF.setUniqueId(getUniqueId());
        this.dmF.registerListener(this.mNetworkChangedMessageListener);
        this.dmG = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.aa(this.dmD.getPageContext().getPageActivity()));
        this.dmG.a(this);
        this.dmG.setUniqueId(getUniqueId());
        this.dlL = new ac();
        this.bzQ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean TR() {
        if (!this.dmF.wN() && this.bzQ.Fp() && avl()) {
            this.bzQ.bP(true);
            this.bzQ.bR(true);
            this.dmE.g(this.dlK);
            this.dmF.setNeedCache(false);
            this.dmF.Fe();
            this.dmD.b(this.bzQ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cX(boolean z) {
        if (this.dmF.wN() || !avl()) {
            return false;
        }
        this.dlK = null;
        this.dmE.reset();
        this.dmF.setNeedCache(true);
        this.dmF.Fe();
        return true;
    }

    protected boolean avl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dlL != null && this.dlL.dmr != null) {
            this.dlL.dmr.clear();
        }
        this.dmD.avm();
        this.dmD.a(this.dlL);
        return false;
    }

    public boolean TQ() {
        if (avl()) {
            if (this.dmD != null) {
                this.dmD.avn();
            }
            this.dmG.a((com.baidu.tbadk.mvc.b.e) this.dmE);
            return true;
        }
        return true;
    }

    protected boolean a(as asVar, at atVar) {
        if (asVar.getUpdateType() != 4) {
            this.dlL.avv().clear();
        }
        this.dlL.a(atVar);
        if (atVar != null && atVar.avv() != null && atVar.avv().size() > 0) {
            this.dlK = atVar.avv().get(atVar.avv().size() - 1);
            if (this.dlL.getPage() != null) {
                this.bzQ.bQ(this.dlL.getPage().qQ() == 1);
            } else {
                this.bzQ.bQ(true);
            }
            if (asVar != null) {
                asVar.toNextPage();
            }
            this.bzQ.bR(true);
        } else {
            this.dlK = null;
            this.bzQ.bQ(false);
            this.bzQ.bR(false);
        }
        this.bzQ.bP(false);
        this.bzQ.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().yZ();
        this.dmD.a(this.dlL);
        this.dmD.b(this.bzQ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<at>> readCacheRespMsg, ReadCacheMessage<at> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dmE, readCacheRespMsg.getData().get(0));
        }
        this.dlK = null;
        this.dmE.reset();
        this.dmF.setNeedCache(true);
        this.dmF.Fe();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<at>> writeCacheRespMsg, WriteCacheMessage<at> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<at> mvcHttpResponsedMessage, MvcHttpMessage<as, at> mvcHttpMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dmD.avm();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            atVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
            atVar = null;
        }
        if (r1 == null || atVar == null || !a(r1, atVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dmD.a(errorData);
                this.dmD.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<at, ?> mvcSocketResponsedMessage, MvcSocketMessage<as, at> mvcSocketMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dmD.avm();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            atVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
            atVar = null;
        }
        if (r1 == null || atVar == null || !a(r1, atVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dmD.a(errorData);
                this.dmD.a(errorData);
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

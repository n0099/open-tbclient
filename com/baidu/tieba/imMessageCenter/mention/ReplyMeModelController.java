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
    private com.baidu.tbadk.mvc.d.a bsH;
    private FeedData djr;
    private ac djs;
    private ReplyMessageActivity dkj;
    private as dkk;
    private ReplyMeNetModel dkl;
    private ReplyMeCacheModel dkm;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.C(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new ar(this, 2000994);
        this.dkj = replyMessageActivity;
    }

    public void d(Bundle bundle) {
        this.dkk = new as();
        this.dkl = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.C(this.dkj.getPageContext().getPageActivity()), this.dkk);
        this.dkl.a(this);
        this.dkl.setUniqueId(getUniqueId());
        this.dkl.registerListener(this.mNetworkChangedMessageListener);
        this.dkm = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.C(this.dkj.getPageContext().getPageActivity()));
        this.dkm.a(this);
        this.dkm.setUniqueId(getUniqueId());
        this.djs = new ac();
        this.bsH = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean SQ() {
        if (!this.dkl.wq() && this.bsH.EQ() && avP()) {
            this.bsH.bP(true);
            this.bsH.bR(true);
            this.dkk.f(this.djr);
            this.dkl.setNeedCache(false);
            this.dkl.EH();
            this.dkj.d(this.bsH);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cX(boolean z) {
        if (this.dkl.wq() || !avP()) {
            return false;
        }
        this.djr = null;
        this.dkk.reset();
        this.dkl.setNeedCache(true);
        this.dkl.EH();
        return true;
    }

    protected boolean avP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.djs != null && this.djs.djX != null) {
            this.djs.djX.clear();
        }
        this.dkj.avQ();
        this.dkj.a(this.djs);
        return false;
    }

    public boolean lN() {
        if (avP()) {
            if (this.dkj != null) {
                this.dkj.avR();
            }
            this.dkm.a((com.baidu.tbadk.mvc.b.e) this.dkk);
            return true;
        }
        return true;
    }

    protected boolean a(as asVar, at atVar) {
        if (asVar.getUpdateType() != 4) {
            this.djs.avZ().clear();
        }
        this.djs.a(atVar);
        if (atVar != null && atVar.avZ() != null && atVar.avZ().size() > 0) {
            this.djr = atVar.avZ().get(atVar.avZ().size() - 1);
            if (this.djs.getPage() != null) {
                this.bsH.bQ(this.djs.getPage().qx() == 1);
            } else {
                this.bsH.bQ(true);
            }
            if (asVar != null) {
                asVar.toNextPage();
            }
            this.bsH.bR(true);
        } else {
            this.djr = null;
            this.bsH.bQ(false);
            this.bsH.bR(false);
        }
        this.bsH.bP(false);
        this.bsH.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yt().yI();
        this.dkj.a(this.djs);
        this.dkj.d(this.bsH);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<at>> readCacheRespMsg, ReadCacheMessage<at> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dkk, readCacheRespMsg.getData().get(0));
        }
        this.djr = null;
        this.dkk.reset();
        this.dkl.setNeedCache(true);
        this.dkl.EH();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<at>> writeCacheRespMsg, WriteCacheMessage<at> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<at> mvcHttpResponsedMessage, MvcHttpMessage<as, at> mvcHttpMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dkj.avQ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            atVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgReplyme(0);
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
                this.dkj.a(errorData);
                this.dkj.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<at, ?> mvcSocketResponsedMessage, MvcSocketMessage<as, at> mvcSocketMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dkj.avQ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            atVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgReplyme(0);
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
                this.dkj.a(errorData);
                this.dkj.a(errorData);
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

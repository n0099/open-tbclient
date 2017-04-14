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
    private com.baidu.tbadk.mvc.d.a bzJ;
    private FeedData dkj;
    private ac dkk;
    private ReplyMessageActivity dlc;
    private as dld;
    private ReplyMeNetModel dle;
    private ReplyMeCacheModel dlf;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new ar(this, 2000994);
        this.dlc = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dld = new as();
        this.dle = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dlc.getPageContext().getPageActivity()), this.dld);
        this.dle.a(this);
        this.dle.setUniqueId(getUniqueId());
        this.dle.registerListener(this.mNetworkChangedMessageListener);
        this.dlf = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dlc.getPageContext().getPageActivity()));
        this.dlf.a(this);
        this.dlf.setUniqueId(getUniqueId());
        this.dkk = new ac();
        this.bzJ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Up() {
        if (!this.dle.xj() && this.bzJ.FN() && ave()) {
            this.bzJ.bR(true);
            this.bzJ.bT(true);
            this.dld.g(this.dkj);
            this.dle.setNeedCache(false);
            this.dle.FC();
            this.dlc.b(this.bzJ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cZ(boolean z) {
        if (this.dle.xj() || !ave()) {
            return false;
        }
        this.dkj = null;
        this.dld.reset();
        this.dle.setNeedCache(true);
        this.dle.FC();
        return true;
    }

    protected boolean ave() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dkk != null && this.dkk.dkQ != null) {
            this.dkk.dkQ.clear();
        }
        this.dlc.avf();
        this.dlc.a(this.dkk);
        return false;
    }

    public boolean Uo() {
        if (ave()) {
            if (this.dlc != null) {
                this.dlc.avg();
            }
            this.dlf.a((com.baidu.tbadk.mvc.b.e) this.dld);
            return true;
        }
        return true;
    }

    protected boolean a(as asVar, at atVar) {
        if (asVar.getUpdateType() != 4) {
            this.dkk.avo().clear();
        }
        this.dkk.a(atVar);
        if (atVar != null && atVar.avo() != null && atVar.avo().size() > 0) {
            this.dkj = atVar.avo().get(atVar.avo().size() - 1);
            if (this.dkk.rr() != null) {
                this.bzJ.bS(this.dkk.rr().rn() == 1);
            } else {
                this.bzJ.bS(true);
            }
            if (asVar != null) {
                asVar.toNextPage();
            }
            this.bzJ.bT(true);
        } else {
            this.dkj = null;
            this.bzJ.bS(false);
            this.bzJ.bT(false);
        }
        this.bzJ.bR(false);
        this.bzJ.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().zy();
        this.dlc.a(this.dkk);
        this.dlc.b(this.bzJ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<at>> readCacheRespMsg, ReadCacheMessage<at> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dld, readCacheRespMsg.getData().get(0));
        }
        this.dkj = null;
        this.dld.reset();
        this.dle.setNeedCache(true);
        this.dle.FC();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<at>> writeCacheRespMsg, WriteCacheMessage<at> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<at> mvcHttpResponsedMessage, MvcHttpMessage<as, at> mvcHttpMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dlc.avf();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            atVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgReplyme(0);
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
                this.dlc.a(errorData);
                this.dlc.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<at, ?> mvcSocketResponsedMessage, MvcSocketMessage<as, at> mvcSocketMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dlc.avf();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            atVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgReplyme(0);
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
                this.dlc.a(errorData);
                this.dlc.a(errorData);
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

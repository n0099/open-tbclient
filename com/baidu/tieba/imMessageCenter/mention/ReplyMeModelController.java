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
    private com.baidu.tbadk.mvc.d.a bCa;
    private FeedData dmA;
    private ac dmB;
    private ReplyMessageActivity dnt;
    private as dnu;
    private ReplyMeNetModel dnv;
    private ReplyMeCacheModel dnw;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new ar(this, 2000994);
        this.dnt = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dnu = new as();
        this.dnv = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dnt.getPageContext().getPageActivity()), this.dnu);
        this.dnv.a(this);
        this.dnv.setUniqueId(getUniqueId());
        this.dnv.registerListener(this.mNetworkChangedMessageListener);
        this.dnw = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dnt.getPageContext().getPageActivity()));
        this.dnw.a(this);
        this.dnw.setUniqueId(getUniqueId());
        this.dmB = new ac();
        this.bCa = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Vq() {
        if (!this.dnv.xj() && this.bCa.FN() && awf()) {
            this.bCa.bR(true);
            this.bCa.bT(true);
            this.dnu.g(this.dmA);
            this.dnv.setNeedCache(false);
            this.dnv.FC();
            this.dnt.b(this.bCa);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dj(boolean z) {
        if (this.dnv.xj() || !awf()) {
            return false;
        }
        this.dmA = null;
        this.dnu.reset();
        this.dnv.setNeedCache(true);
        this.dnv.FC();
        return true;
    }

    protected boolean awf() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dmB != null && this.dmB.dnh != null) {
            this.dmB.dnh.clear();
        }
        this.dnt.awg();
        this.dnt.a(this.dmB);
        return false;
    }

    public boolean Vp() {
        if (awf()) {
            if (this.dnt != null) {
                this.dnt.awh();
            }
            this.dnw.a((com.baidu.tbadk.mvc.b.e) this.dnu);
            return true;
        }
        return true;
    }

    protected boolean a(as asVar, at atVar) {
        if (asVar.getUpdateType() != 4) {
            this.dmB.awp().clear();
        }
        this.dmB.a(atVar);
        if (atVar != null && atVar.awp() != null && atVar.awp().size() > 0) {
            this.dmA = atVar.awp().get(atVar.awp().size() - 1);
            if (this.dmB.rr() != null) {
                this.bCa.bS(this.dmB.rr().rn() == 1);
            } else {
                this.bCa.bS(true);
            }
            if (asVar != null) {
                asVar.toNextPage();
            }
            this.bCa.bT(true);
        } else {
            this.dmA = null;
            this.bCa.bS(false);
            this.bCa.bT(false);
        }
        this.bCa.bR(false);
        this.bCa.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().zy();
        this.dnt.a(this.dmB);
        this.dnt.b(this.bCa);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<at>> readCacheRespMsg, ReadCacheMessage<at> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dnu, readCacheRespMsg.getData().get(0));
        }
        this.dmA = null;
        this.dnu.reset();
        this.dnv.setNeedCache(true);
        this.dnv.FC();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<at>> writeCacheRespMsg, WriteCacheMessage<at> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<at> mvcHttpResponsedMessage, MvcHttpMessage<as, at> mvcHttpMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dnt.awg();
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
                this.dnt.a(errorData);
                this.dnt.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<at, ?> mvcSocketResponsedMessage, MvcSocketMessage<as, at> mvcSocketMessage, MvcNetMessage<as, at> mvcNetMessage) {
        at atVar;
        this.dnt.awg();
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
                this.dnt.a(errorData);
                this.dnt.a(errorData);
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

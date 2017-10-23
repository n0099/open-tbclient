package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
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
public class ReplyMeModelController extends BdBaseModel<ReplyMessageActivity> implements CacheModel.a<m>, NetModel.b<l, m> {
    private com.baidu.tbadk.mvc.d.a bRX;
    private FeedData dJo;
    private f dJp;
    private ReplyMessageActivity dKj;
    private l dKk;
    private ReplyMeNetModel dKl;
    private ReplyMeCacheModel dKm;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dKj.aAA();
                }
            }
        };
        this.dKj = replyMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dKk = new l();
        this.dKl = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dKj.getPageContext().getPageActivity()), this.dKk);
        this.dKl.a(this);
        this.dKl.setUniqueId(getUniqueId());
        this.dKl.registerListener(this.mNetworkChangedMessageListener);
        this.dKm = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dKj.getPageContext().getPageActivity()));
        this.dKm.a(this);
        this.dKm.setUniqueId(getUniqueId());
        this.dJp = new f();
        this.bRX = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zc() {
        if (!this.dKl.ws() && this.bRX.Fd() && aAz()) {
            this.bRX.bS(true);
            this.bRX.bU(true);
            this.dKk.g(this.dJo);
            this.dKl.setNeedCache(false);
            this.dKl.ET();
            this.dKj.b(this.bRX);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dK(boolean z) {
        if (this.dKl.ws() || !aAz()) {
            return false;
        }
        this.dJo = null;
        this.dKk.reset();
        this.dKl.setNeedCache(true);
        this.dKl.ET();
        return true;
    }

    protected boolean aAz() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dJp != null && this.dJp.dJX != null) {
            this.dJp.dJX.clear();
        }
        this.dKj.aAA();
        this.dKj.a(this.dJp);
        return false;
    }

    public boolean Zb() {
        if (aAz()) {
            if (this.dKj != null) {
                this.dKj.aAB();
            }
            this.dKm.a((com.baidu.tbadk.mvc.b.e) this.dKk);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dJp.aAI().clear();
        }
        this.dJp.a(mVar);
        if (mVar != null && mVar.aAI() != null && mVar.aAI().size() > 0) {
            this.dJo = mVar.aAI().get(mVar.aAI().size() - 1);
            if (this.dJp.qq() != null) {
                this.bRX.bT(this.dJp.qq().qm() == 1);
            } else {
                this.bRX.bT(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bRX.bU(true);
        } else {
            this.dJo = null;
            this.bRX.bT(false);
            this.bRX.bU(false);
        }
        this.bRX.bS(false);
        this.bRX.bR(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yv().yK();
        this.dKj.a(this.dJp);
        this.dKj.b(this.bRX);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dKk, readCacheRespMsg.getData().get(0));
        }
        this.dJo = null;
        this.dKk.reset();
        this.dKl.setNeedCache(true);
        this.dKl.ET();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dKj.aAA();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgReplyme(0);
            mVar = null;
        }
        if (r1 == null || mVar == null || !a(r1, mVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dKj.a(errorData);
                this.dKj.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dKj.aAA();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgReplyme(0);
            mVar = null;
        }
        if (r1 == null || mVar == null || !a(r1, mVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dKj.a(errorData);
                this.dKj.a(errorData);
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

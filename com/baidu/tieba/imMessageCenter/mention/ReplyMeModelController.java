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
    private com.baidu.tbadk.mvc.d.a bRH;
    private FeedData dMq;
    private f dMr;
    private ReplyMessageActivity dNl;
    private l dNm;
    private ReplyMeNetModel dNn;
    private ReplyMeCacheModel dNo;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.X(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dNl.aBJ();
                }
            }
        };
        this.dNl = replyMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dNm = new l();
        this.dNn = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.X(this.dNl.getPageContext().getPageActivity()), this.dNm);
        this.dNn.a(this);
        this.dNn.setUniqueId(getUniqueId());
        this.dNn.registerListener(this.mNetworkChangedMessageListener);
        this.dNo = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.X(this.dNl.getPageContext().getPageActivity()));
        this.dNo.a(this);
        this.dNo.setUniqueId(getUniqueId());
        this.dMr = new f();
        this.bRH = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zk() {
        if (!this.dNn.xa() && this.bRH.FE() && aBI()) {
            this.bRH.bU(true);
            this.bRH.bW(true);
            this.dNm.h(this.dMq);
            this.dNn.setNeedCache(false);
            this.dNn.Fu();
            this.dNl.b(this.bRH);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dR(boolean z) {
        if (this.dNn.xa() || !aBI()) {
            return false;
        }
        this.dMq = null;
        this.dNm.reset();
        this.dNn.setNeedCache(true);
        this.dNn.Fu();
        return true;
    }

    protected boolean aBI() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dMr != null && this.dMr.dMZ != null) {
            this.dMr.dMZ.clear();
        }
        this.dNl.aBJ();
        this.dNl.a(this.dMr);
        return false;
    }

    public boolean Zj() {
        if (aBI()) {
            if (this.dNl != null) {
                this.dNl.aBK();
            }
            this.dNo.a((com.baidu.tbadk.mvc.b.e) this.dNm);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dMr.aBR().clear();
        }
        this.dMr.a(mVar);
        if (mVar != null && mVar.aBR() != null && mVar.aBR().size() > 0) {
            this.dMq = mVar.aBR().get(mVar.aBR().size() - 1);
            if (this.dMr.qD() != null) {
                this.bRH.bV(this.dMr.qD().qz() == 1);
            } else {
                this.bRH.bV(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bRH.bW(true);
        } else {
            this.dMq = null;
            this.bRH.bV(false);
            this.bRH.bW(false);
        }
        this.bRH.bU(false);
        this.bRH.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zs();
        this.dNl.a(this.dMr);
        this.dNl.b(this.bRH);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dNm, readCacheRespMsg.getData().get(0));
        }
        this.dMq = null;
        this.dNm.reset();
        this.dNn.setNeedCache(true);
        this.dNn.Fu();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dNl.aBJ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgReplyme(0);
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
                this.dNl.a(errorData);
                this.dNl.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dNl.aBJ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgReplyme(0);
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
                this.dNl.a(errorData);
                this.dNl.a(errorData);
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

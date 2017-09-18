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
    private com.baidu.tbadk.mvc.d.a bSy;
    private FeedData dNk;
    private f dNl;
    private ReplyMessageActivity dOf;
    private l dOg;
    private ReplyMeNetModel dOh;
    private ReplyMeCacheModel dOi;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dOf.aBU();
                }
            }
        };
        this.dOf = replyMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dOg = new l();
        this.dOh = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dOf.getPageContext().getPageActivity()), this.dOg);
        this.dOh.a(this);
        this.dOh.setUniqueId(getUniqueId());
        this.dOh.registerListener(this.mNetworkChangedMessageListener);
        this.dOi = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dOf.getPageContext().getPageActivity()));
        this.dOi.a(this);
        this.dOi.setUniqueId(getUniqueId());
        this.dNl = new f();
        this.bSy = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zv() {
        if (!this.dOh.xa() && this.bSy.FE() && aBT()) {
            this.bSy.bU(true);
            this.bSy.bW(true);
            this.dOg.h(this.dNk);
            this.dOh.setNeedCache(false);
            this.dOh.Fu();
            this.dOf.b(this.bSy);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dS(boolean z) {
        if (this.dOh.xa() || !aBT()) {
            return false;
        }
        this.dNk = null;
        this.dOg.reset();
        this.dOh.setNeedCache(true);
        this.dOh.Fu();
        return true;
    }

    protected boolean aBT() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dNl != null && this.dNl.dNT != null) {
            this.dNl.dNT.clear();
        }
        this.dOf.aBU();
        this.dOf.a(this.dNl);
        return false;
    }

    public boolean Zu() {
        if (aBT()) {
            if (this.dOf != null) {
                this.dOf.aBV();
            }
            this.dOi.a((com.baidu.tbadk.mvc.b.e) this.dOg);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dNl.aCc().clear();
        }
        this.dNl.a(mVar);
        if (mVar != null && mVar.aCc() != null && mVar.aCc().size() > 0) {
            this.dNk = mVar.aCc().get(mVar.aCc().size() - 1);
            if (this.dNl.qD() != null) {
                this.bSy.bV(this.dNl.qD().qz() == 1);
            } else {
                this.bSy.bV(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bSy.bW(true);
        } else {
            this.dNk = null;
            this.bSy.bV(false);
            this.bSy.bW(false);
        }
        this.bSy.bU(false);
        this.bSy.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zs();
        this.dOf.a(this.dNl);
        this.dOf.b(this.bSy);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dOg, readCacheRespMsg.getData().get(0));
        }
        this.dNk = null;
        this.dOg.reset();
        this.dOh.setNeedCache(true);
        this.dOh.Fu();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dOf.aBU();
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
                this.dOf.a(errorData);
                this.dOf.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dOf.aBU();
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
                this.dOf.a(errorData);
                this.dOf.a(errorData);
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

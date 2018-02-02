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
    private com.baidu.tbadk.mvc.d.a dcg;
    private ReplyMessageActivity eOV;
    private l eOW;
    private ReplyMeNetModel eOX;
    private ReplyMeCacheModel eOY;
    private FeedData eOb;
    private f eOc;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.ak(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.eOV.aLT();
                }
            }
        };
        this.eOV = replyMessageActivity;
    }

    public void k(Bundle bundle) {
        this.eOW = new l();
        this.eOX = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eOV.getPageContext().getPageActivity()), this.eOW);
        this.eOX.a(this);
        this.eOX.setUniqueId(getUniqueId());
        this.eOX.registerListener(this.mNetworkChangedMessageListener);
        this.eOY = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eOV.getPageContext().getPageActivity()));
        this.eOY.a(this);
        this.eOY.setUniqueId(getUniqueId());
        this.eOc = new f();
        this.dcg = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ame() {
        if (!this.eOX.DR() && this.dcg.MY() && aLS()) {
            this.dcg.cq(true);
            this.dcg.cs(true);
            this.eOW.f(this.eOb);
            this.eOX.setNeedCache(false);
            this.eOX.MQ();
            this.eOV.b(this.dcg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eS(boolean z) {
        if (this.eOX.DR() || !aLS()) {
            return false;
        }
        this.eOb = null;
        this.eOW.reset();
        this.eOX.setNeedCache(true);
        this.eOX.MQ();
        return true;
    }

    protected boolean aLS() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eOc != null && this.eOc.eOH != null) {
            this.eOc.eOH.clear();
        }
        this.eOV.aLT();
        this.eOV.a(this.eOc);
        return false;
    }

    public boolean amd() {
        if (aLS()) {
            if (this.eOV != null) {
                this.eOV.aLU();
            }
            this.eOY.a((com.baidu.tbadk.mvc.b.e) this.eOW);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.eOc.aMb().clear();
        }
        this.eOc.a(mVar);
        if (mVar != null && mVar.aMb() != null && mVar.aMb().size() > 0) {
            this.eOb = mVar.aMb().get(mVar.aMb().size() - 1);
            if (this.eOc.xZ() != null) {
                this.dcg.cr(this.eOc.xZ().xV() == 1);
            } else {
                this.dcg.cr(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.dcg.cs(true);
        } else {
            this.eOb = null;
            this.dcg.cr(false);
            this.dcg.cs(false);
        }
        this.dcg.cq(false);
        this.dcg.cp(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().Gw();
        this.eOV.a(this.eOc);
        this.eOV.b(this.dcg);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eOW, readCacheRespMsg.getData().get(0));
        }
        this.eOb = null;
        this.eOW.reset();
        this.eOX.setNeedCache(true);
        this.eOX.MQ();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eOV.aLT();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgReplyme(0);
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
                this.eOV.a(errorData);
                this.eOV.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eOV.aLT();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgReplyme(0);
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
                this.eOV.a(errorData);
                this.eOV.a(errorData);
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

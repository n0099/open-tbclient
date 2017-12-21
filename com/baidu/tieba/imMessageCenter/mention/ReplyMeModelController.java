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
    private com.baidu.tbadk.mvc.d.a ciE;
    private ReplyMessageActivity eaY;
    private l eaZ;
    private FeedData ead;
    private f eae;
    private ReplyMeNetModel eba;
    private ReplyMeCacheModel ebb;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.eaY.aEI();
                }
            }
        };
        this.eaY = replyMessageActivity;
    }

    public void h(Bundle bundle) {
        this.eaZ = new l();
        this.eba = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.eaY.getPageContext().getPageActivity()), this.eaZ);
        this.eba.a(this);
        this.eba.setUniqueId(getUniqueId());
        this.eba.registerListener(this.mNetworkChangedMessageListener);
        this.ebb = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.eaY.getPageContext().getPageActivity()));
        this.ebb.a(this);
        this.ebb.setUniqueId(getUniqueId());
        this.eae = new f();
        this.ciE = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adq() {
        if (!this.eba.wA() && this.ciE.FJ() && aEH()) {
            this.ciE.bO(true);
            this.ciE.bQ(true);
            this.eaZ.g(this.ead);
            this.eba.setNeedCache(false);
            this.eba.Fz();
            this.eaY.b(this.ciE);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ee(boolean z) {
        if (this.eba.wA() || !aEH()) {
            return false;
        }
        this.ead = null;
        this.eaZ.reset();
        this.eba.setNeedCache(true);
        this.eba.Fz();
        return true;
    }

    protected boolean aEH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eae != null && this.eae.eaK != null) {
            this.eae.eaK.clear();
        }
        this.eaY.aEI();
        this.eaY.a(this.eae);
        return false;
    }

    public boolean adp() {
        if (aEH()) {
            if (this.eaY != null) {
                this.eaY.aEJ();
            }
            this.ebb.a((com.baidu.tbadk.mvc.b.e) this.eaZ);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.eae.aEQ().clear();
        }
        this.eae.a(mVar);
        if (mVar != null && mVar.aEQ() != null && mVar.aEQ().size() > 0) {
            this.ead = mVar.aEQ().get(mVar.aEQ().size() - 1);
            if (this.eae.qy() != null) {
                this.ciE.bP(this.eae.qy().qu() == 1);
            } else {
                this.ciE.bP(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.ciE.bQ(true);
        } else {
            this.ead = null;
            this.ciE.bP(false);
            this.ciE.bQ(false);
        }
        this.ciE.bO(false);
        this.ciE.bN(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zc();
        this.eaY.a(this.eae);
        this.eaY.b(this.ciE);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eaZ, readCacheRespMsg.getData().get(0));
        }
        this.ead = null;
        this.eaZ.reset();
        this.eba.setNeedCache(true);
        this.eba.Fz();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eaY.aEI();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(0);
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
                this.eaY.a(errorData);
                this.eaY.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eaY.aEI();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(0);
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
                this.eaY.a(errorData);
                this.eaY.a(errorData);
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

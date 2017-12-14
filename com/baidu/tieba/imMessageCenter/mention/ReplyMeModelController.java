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
    private com.baidu.tbadk.mvc.d.a ciA;
    private FeedData dZZ;
    private ReplyMessageActivity eaU;
    private l eaV;
    private ReplyMeNetModel eaW;
    private ReplyMeCacheModel eaX;
    private f eaa;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.eaU.aEI();
                }
            }
        };
        this.eaU = replyMessageActivity;
    }

    public void h(Bundle bundle) {
        this.eaV = new l();
        this.eaW = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.eaU.getPageContext().getPageActivity()), this.eaV);
        this.eaW.a(this);
        this.eaW.setUniqueId(getUniqueId());
        this.eaW.registerListener(this.mNetworkChangedMessageListener);
        this.eaX = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.eaU.getPageContext().getPageActivity()));
        this.eaX.a(this);
        this.eaX.setUniqueId(getUniqueId());
        this.eaa = new f();
        this.ciA = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adr() {
        if (!this.eaW.wA() && this.ciA.FJ() && aEH()) {
            this.ciA.bO(true);
            this.ciA.bQ(true);
            this.eaV.g(this.dZZ);
            this.eaW.setNeedCache(false);
            this.eaW.Fz();
            this.eaU.b(this.ciA);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ee(boolean z) {
        if (this.eaW.wA() || !aEH()) {
            return false;
        }
        this.dZZ = null;
        this.eaV.reset();
        this.eaW.setNeedCache(true);
        this.eaW.Fz();
        return true;
    }

    protected boolean aEH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eaa != null && this.eaa.eaG != null) {
            this.eaa.eaG.clear();
        }
        this.eaU.aEI();
        this.eaU.a(this.eaa);
        return false;
    }

    public boolean adq() {
        if (aEH()) {
            if (this.eaU != null) {
                this.eaU.aEJ();
            }
            this.eaX.a((com.baidu.tbadk.mvc.b.e) this.eaV);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.eaa.aEQ().clear();
        }
        this.eaa.a(mVar);
        if (mVar != null && mVar.aEQ() != null && mVar.aEQ().size() > 0) {
            this.dZZ = mVar.aEQ().get(mVar.aEQ().size() - 1);
            if (this.eaa.qy() != null) {
                this.ciA.bP(this.eaa.qy().qu() == 1);
            } else {
                this.ciA.bP(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.ciA.bQ(true);
        } else {
            this.dZZ = null;
            this.ciA.bP(false);
            this.ciA.bQ(false);
        }
        this.ciA.bO(false);
        this.ciA.bN(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zc();
        this.eaU.a(this.eaa);
        this.eaU.b(this.ciA);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eaV, readCacheRespMsg.getData().get(0));
        }
        this.dZZ = null;
        this.eaV.reset();
        this.eaW.setNeedCache(true);
        this.eaW.Fz();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eaU.aEI();
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
                this.eaU.a(errorData);
                this.eaU.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eaU.aEI();
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
                this.eaU.a(errorData);
                this.eaU.a(errorData);
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

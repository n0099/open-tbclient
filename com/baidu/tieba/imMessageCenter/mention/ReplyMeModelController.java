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
    private com.baidu.tbadk.mvc.d.a dbL;
    private FeedData eNG;
    private f eNH;
    private ReplyMessageActivity eOA;
    private l eOB;
    private ReplyMeNetModel eOC;
    private ReplyMeCacheModel eOD;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.ak(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.eOA.aLO();
                }
            }
        };
        this.eOA = replyMessageActivity;
    }

    public void k(Bundle bundle) {
        this.eOB = new l();
        this.eOC = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eOA.getPageContext().getPageActivity()), this.eOB);
        this.eOC.a(this);
        this.eOC.setUniqueId(getUniqueId());
        this.eOC.registerListener(this.mNetworkChangedMessageListener);
        this.eOD = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eOA.getPageContext().getPageActivity()));
        this.eOD.a(this);
        this.eOD.setUniqueId(getUniqueId());
        this.eNH = new f();
        this.dbL = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean alZ() {
        if (!this.eOC.DP() && this.dbL.MW() && aLN()) {
            this.dbL.cp(true);
            this.dbL.cr(true);
            this.eOB.f(this.eNG);
            this.eOC.setNeedCache(false);
            this.eOC.MO();
            this.eOA.b(this.dbL);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eP(boolean z) {
        if (this.eOC.DP() || !aLN()) {
            return false;
        }
        this.eNG = null;
        this.eOB.reset();
        this.eOC.setNeedCache(true);
        this.eOC.MO();
        return true;
    }

    protected boolean aLN() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eNH != null && this.eNH.eOm != null) {
            this.eNH.eOm.clear();
        }
        this.eOA.aLO();
        this.eOA.a(this.eNH);
        return false;
    }

    public boolean alY() {
        if (aLN()) {
            if (this.eOA != null) {
                this.eOA.aLP();
            }
            this.eOD.a((com.baidu.tbadk.mvc.b.e) this.eOB);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.eNH.aLW().clear();
        }
        this.eNH.a(mVar);
        if (mVar != null && mVar.aLW() != null && mVar.aLW().size() > 0) {
            this.eNG = mVar.aLW().get(mVar.aLW().size() - 1);
            if (this.eNH.xY() != null) {
                this.dbL.cq(this.eNH.xY().xU() == 1);
            } else {
                this.dbL.cq(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.dbL.cr(true);
        } else {
            this.eNG = null;
            this.dbL.cq(false);
            this.dbL.cr(false);
        }
        this.dbL.cp(false);
        this.dbL.co(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().Gu();
        this.eOA.a(this.eNH);
        this.eOA.b(this.dbL);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eOB, readCacheRespMsg.getData().get(0));
        }
        this.eNG = null;
        this.eOB.reset();
        this.eOC.setNeedCache(true);
        this.eOC.MO();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eOA.aLO();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgReplyme(0);
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
                this.eOA.a(errorData);
                this.eOA.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eOA.aLO();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgReplyme(0);
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
                this.eOA.a(errorData);
                this.eOA.a(errorData);
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

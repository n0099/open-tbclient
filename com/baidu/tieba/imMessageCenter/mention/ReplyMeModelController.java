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
    private com.baidu.tbadk.mvc.d.a bOO;
    private FeedData dFM;
    private f dFN;
    private ReplyMessageActivity dGF;
    private l dGG;
    private ReplyMeNetModel dGH;
    private ReplyMeCacheModel dGI;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.aa(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dGF.azU();
                }
            }
        };
        this.dGF = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dGG = new l();
        this.dGH = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.aa(this.dGF.getPageContext().getPageActivity()), this.dGG);
        this.dGH.a(this);
        this.dGH.setUniqueId(getUniqueId());
        this.dGH.registerListener(this.mNetworkChangedMessageListener);
        this.dGI = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.aa(this.dGF.getPageContext().getPageActivity()));
        this.dGI.a(this);
        this.dGI.setUniqueId(getUniqueId());
        this.dFN = new f();
        this.bOO = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Yh() {
        if (!this.dGH.xc() && this.bOO.FG() && azT()) {
            this.bOO.bU(true);
            this.bOO.bW(true);
            this.dGG.h(this.dFM);
            this.dGH.setNeedCache(false);
            this.dGH.Fw();
            this.dGF.b(this.bOO);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dO(boolean z) {
        if (this.dGH.xc() || !azT()) {
            return false;
        }
        this.dFM = null;
        this.dGG.reset();
        this.dGH.setNeedCache(true);
        this.dGH.Fw();
        return true;
    }

    protected boolean azT() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dFN != null && this.dFN.dGt != null) {
            this.dFN.dGt.clear();
        }
        this.dGF.azU();
        this.dGF.a(this.dFN);
        return false;
    }

    public boolean Yg() {
        if (azT()) {
            if (this.dGF != null) {
                this.dGF.azV();
            }
            this.dGI.a((com.baidu.tbadk.mvc.b.e) this.dGG);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dFN.aAc().clear();
        }
        this.dFN.a(mVar);
        if (mVar != null && mVar.aAc() != null && mVar.aAc().size() > 0) {
            this.dFM = mVar.aAc().get(mVar.aAc().size() - 1);
            if (this.dFN.qI() != null) {
                this.bOO.bV(this.dFN.qI().qE() == 1);
            } else {
                this.bOO.bV(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bOO.bW(true);
        } else {
            this.dFM = null;
            this.bOO.bV(false);
            this.bOO.bW(false);
        }
        this.bOO.bU(false);
        this.bOO.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zo();
        this.dGF.a(this.dFN);
        this.dGF.b(this.bOO);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dGG, readCacheRespMsg.getData().get(0));
        }
        this.dFM = null;
        this.dGG.reset();
        this.dGH.setNeedCache(true);
        this.dGH.Fw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dGF.azU();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgReplyme(0);
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
                this.dGF.a(errorData);
                this.dGF.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dGF.azU();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgReplyme(0);
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
                this.dGF.a(errorData);
                this.dGF.a(errorData);
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

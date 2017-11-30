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
    private com.baidu.tbadk.mvc.d.a cim;
    private FeedData dYU;
    private f dYV;
    private ReplyMessageActivity dZP;
    private l dZQ;
    private ReplyMeNetModel dZR;
    private ReplyMeCacheModel dZS;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dZP.aEz();
                }
            }
        };
        this.dZP = replyMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dZQ = new l();
        this.dZR = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dZP.getPageContext().getPageActivity()), this.dZQ);
        this.dZR.a(this);
        this.dZR.setUniqueId(getUniqueId());
        this.dZR.registerListener(this.mNetworkChangedMessageListener);
        this.dZS = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dZP.getPageContext().getPageActivity()));
        this.dZS.a(this);
        this.dZS.setUniqueId(getUniqueId());
        this.dYV = new f();
        this.cim = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adh() {
        if (!this.dZR.wC() && this.cim.FI() && aEy()) {
            this.cim.bN(true);
            this.cim.bP(true);
            this.dZQ.g(this.dYU);
            this.dZR.setNeedCache(false);
            this.dZR.Fy();
            this.dZP.b(this.cim);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ed(boolean z) {
        if (this.dZR.wC() || !aEy()) {
            return false;
        }
        this.dYU = null;
        this.dZQ.reset();
        this.dZR.setNeedCache(true);
        this.dZR.Fy();
        return true;
    }

    protected boolean aEy() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dYV != null && this.dYV.dZB != null) {
            this.dYV.dZB.clear();
        }
        this.dZP.aEz();
        this.dZP.a(this.dYV);
        return false;
    }

    public boolean adg() {
        if (aEy()) {
            if (this.dZP != null) {
                this.dZP.aEA();
            }
            this.dZS.a((com.baidu.tbadk.mvc.b.e) this.dZQ);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dYV.aEH().clear();
        }
        this.dYV.a(mVar);
        if (mVar != null && mVar.aEH() != null && mVar.aEH().size() > 0) {
            this.dYU = mVar.aEH().get(mVar.aEH().size() - 1);
            if (this.dYV.qA() != null) {
                this.cim.bO(this.dYV.qA().qw() == 1);
            } else {
                this.cim.bO(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.cim.bP(true);
        } else {
            this.dYU = null;
            this.cim.bO(false);
            this.cim.bP(false);
        }
        this.cim.bN(false);
        this.cim.bM(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yM().zb();
        this.dZP.a(this.dYV);
        this.dZP.b(this.cim);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dZQ, readCacheRespMsg.getData().get(0));
        }
        this.dYU = null;
        this.dZQ.reset();
        this.dZR.setNeedCache(true);
        this.dZR.Fy();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dZP.aEz();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgReplyme(0);
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
                this.dZP.a(errorData);
                this.dZP.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dZP.aEz();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgReplyme(0);
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
                this.dZP.a(errorData);
                this.dZP.a(errorData);
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

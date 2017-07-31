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
    private com.baidu.tbadk.mvc.d.a bOe;
    private FeedData dDP;
    private f dDQ;
    private ReplyMessageActivity dEI;
    private l dEJ;
    private ReplyMeNetModel dEK;
    private ReplyMeCacheModel dEL;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.aa(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dEI.azs();
                }
            }
        };
        this.dEI = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dEJ = new l();
        this.dEK = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.aa(this.dEI.getPageContext().getPageActivity()), this.dEJ);
        this.dEK.a(this);
        this.dEK.setUniqueId(getUniqueId());
        this.dEK.registerListener(this.mNetworkChangedMessageListener);
        this.dEL = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.aa(this.dEI.getPageContext().getPageActivity()));
        this.dEL.a(this);
        this.dEL.setUniqueId(getUniqueId());
        this.dDQ = new f();
        this.bOe = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean XP() {
        if (!this.dEK.xc() && this.bOe.FG() && azr()) {
            this.bOe.bU(true);
            this.bOe.bW(true);
            this.dEJ.h(this.dDP);
            this.dEK.setNeedCache(false);
            this.dEK.Fw();
            this.dEI.b(this.bOe);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dN(boolean z) {
        if (this.dEK.xc() || !azr()) {
            return false;
        }
        this.dDP = null;
        this.dEJ.reset();
        this.dEK.setNeedCache(true);
        this.dEK.Fw();
        return true;
    }

    protected boolean azr() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dDQ != null && this.dDQ.dEw != null) {
            this.dDQ.dEw.clear();
        }
        this.dEI.azs();
        this.dEI.a(this.dDQ);
        return false;
    }

    public boolean XO() {
        if (azr()) {
            if (this.dEI != null) {
                this.dEI.azt();
            }
            this.dEL.a((com.baidu.tbadk.mvc.b.e) this.dEJ);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dDQ.azA().clear();
        }
        this.dDQ.a(mVar);
        if (mVar != null && mVar.azA() != null && mVar.azA().size() > 0) {
            this.dDP = mVar.azA().get(mVar.azA().size() - 1);
            if (this.dDQ.qH() != null) {
                this.bOe.bV(this.dDQ.qH().qD() == 1);
            } else {
                this.bOe.bV(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bOe.bW(true);
        } else {
            this.dDP = null;
            this.bOe.bV(false);
            this.bOe.bW(false);
        }
        this.bOe.bU(false);
        this.bOe.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zo();
        this.dEI.a(this.dDQ);
        this.dEI.b(this.bOe);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dEJ, readCacheRespMsg.getData().get(0));
        }
        this.dDP = null;
        this.dEJ.reset();
        this.dEK.setNeedCache(true);
        this.dEK.Fw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dEI.azs();
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
                this.dEI.a(errorData);
                this.dEI.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dEI.azs();
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
                this.dEI.a(errorData);
                this.dEI.a(errorData);
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

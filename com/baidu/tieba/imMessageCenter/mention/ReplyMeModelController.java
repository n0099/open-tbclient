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
    private com.baidu.tbadk.mvc.d.a bMU;
    private FeedData dCy;
    private f dCz;
    private ReplyMessageActivity dDr;
    private l dDs;
    private ReplyMeNetModel dDt;
    private ReplyMeCacheModel dDu;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dDr.azh();
                }
            }
        };
        this.dDr = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dDs = new l();
        this.dDt = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Z(this.dDr.getPageContext().getPageActivity()), this.dDs);
        this.dDt.a(this);
        this.dDt.setUniqueId(getUniqueId());
        this.dDt.registerListener(this.mNetworkChangedMessageListener);
        this.dDu = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Z(this.dDr.getPageContext().getPageActivity()));
        this.dDu.a(this);
        this.dDu.setUniqueId(getUniqueId());
        this.dCz = new f();
        this.bMU = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean XK() {
        if (!this.dDt.wT() && this.bMU.Fy() && azg()) {
            this.bMU.bU(true);
            this.bMU.bW(true);
            this.dDs.h(this.dCy);
            this.dDt.setNeedCache(false);
            this.dDt.Fo();
            this.dDr.b(this.bMU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dN(boolean z) {
        if (this.dDt.wT() || !azg()) {
            return false;
        }
        this.dCy = null;
        this.dDs.reset();
        this.dDt.setNeedCache(true);
        this.dDt.Fo();
        return true;
    }

    protected boolean azg() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dCz != null && this.dCz.dDf != null) {
            this.dCz.dDf.clear();
        }
        this.dDr.azh();
        this.dDr.a(this.dCz);
        return false;
    }

    public boolean XJ() {
        if (azg()) {
            if (this.dDr != null) {
                this.dDr.azi();
            }
            this.dDu.a((com.baidu.tbadk.mvc.b.e) this.dDs);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dCz.azp().clear();
        }
        this.dCz.a(mVar);
        if (mVar != null && mVar.azp() != null && mVar.azp().size() > 0) {
            this.dCy = mVar.azp().get(mVar.azp().size() - 1);
            if (this.dCz.qx() != null) {
                this.bMU.bV(this.dCz.qx().qt() == 1);
            } else {
                this.bMU.bV(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bMU.bW(true);
        } else {
            this.dCy = null;
            this.bMU.bV(false);
            this.bMU.bW(false);
        }
        this.bMU.bU(false);
        this.bMU.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yR().zg();
        this.dDr.a(this.dCz);
        this.dDr.b(this.bMU);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dDs, readCacheRespMsg.getData().get(0));
        }
        this.dCy = null;
        this.dDs.reset();
        this.dDt.setNeedCache(true);
        this.dDt.Fo();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dDr.azh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgReplyme(0);
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
                this.dDr.a(errorData);
                this.dDr.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dDr.azh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgReplyme(0);
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
                this.dDr.a(errorData);
                this.dDr.a(errorData);
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

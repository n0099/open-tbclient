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
    private com.baidu.tbadk.mvc.d.a bSj;
    private FeedData dJC;
    private f dJD;
    private ReplyMeCacheModel dKA;
    private ReplyMessageActivity dKx;
    private l dKy;
    private ReplyMeNetModel dKz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dKx.aAF();
                }
            }
        };
        this.dKx = replyMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dKy = new l();
        this.dKz = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dKx.getPageContext().getPageActivity()), this.dKy);
        this.dKz.a(this);
        this.dKz.setUniqueId(getUniqueId());
        this.dKz.registerListener(this.mNetworkChangedMessageListener);
        this.dKA = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dKx.getPageContext().getPageActivity()));
        this.dKA.a(this);
        this.dKA.setUniqueId(getUniqueId());
        this.dJD = new f();
        this.bSj = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zg() {
        if (!this.dKz.wz() && this.bSj.Fj() && aAE()) {
            this.bSj.bT(true);
            this.bSj.bV(true);
            this.dKy.g(this.dJC);
            this.dKz.setNeedCache(false);
            this.dKz.EZ();
            this.dKx.b(this.bSj);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dL(boolean z) {
        if (this.dKz.wz() || !aAE()) {
            return false;
        }
        this.dJC = null;
        this.dKy.reset();
        this.dKz.setNeedCache(true);
        this.dKz.EZ();
        return true;
    }

    protected boolean aAE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dJD != null && this.dJD.dKl != null) {
            this.dJD.dKl.clear();
        }
        this.dKx.aAF();
        this.dKx.a(this.dJD);
        return false;
    }

    public boolean Zf() {
        if (aAE()) {
            if (this.dKx != null) {
                this.dKx.aAG();
            }
            this.dKA.a((com.baidu.tbadk.mvc.b.e) this.dKy);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dJD.aAN().clear();
        }
        this.dJD.a(mVar);
        if (mVar != null && mVar.aAN() != null && mVar.aAN().size() > 0) {
            this.dJC = mVar.aAN().get(mVar.aAN().size() - 1);
            if (this.dJD.qx() != null) {
                this.bSj.bU(this.dJD.qx().qt() == 1);
            } else {
                this.bSj.bU(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bSj.bV(true);
        } else {
            this.dJC = null;
            this.bSj.bU(false);
            this.bSj.bV(false);
        }
        this.bSj.bT(false);
        this.bSj.bS(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yB().yQ();
        this.dKx.a(this.dJD);
        this.dKx.b(this.bSj);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dKy, readCacheRespMsg.getData().get(0));
        }
        this.dJC = null;
        this.dKy.reset();
        this.dKz.setNeedCache(true);
        this.dKz.EZ();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dKx.aAF();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgReplyme(0);
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
                this.dKx.a(errorData);
                this.dKx.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dKx.aAF();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgReplyme(0);
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
                this.dKx.a(errorData);
                this.dKx.a(errorData);
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

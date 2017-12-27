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
    private com.baidu.tbadk.mvc.d.a cXh;
    private FeedData eMg;
    private f eMh;
    private ReplyMessageActivity eNb;
    private l eNc;
    private ReplyMeNetModel eNd;
    private ReplyMeCacheModel eNe;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.ak(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.eNb.aLJ();
                }
            }
        };
        this.eNb = replyMessageActivity;
    }

    public void k(Bundle bundle) {
        this.eNc = new l();
        this.eNd = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eNb.getPageContext().getPageActivity()), this.eNc);
        this.eNd.a(this);
        this.eNd.setUniqueId(getUniqueId());
        this.eNd.registerListener(this.mNetworkChangedMessageListener);
        this.eNe = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eNb.getPageContext().getPageActivity()));
        this.eNe.a(this);
        this.eNe.setUniqueId(getUniqueId());
        this.eMh = new f();
        this.cXh = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akW() {
        if (!this.eNd.DY() && this.cXh.Ni() && aLI()) {
            this.cXh.cr(true);
            this.cXh.ct(true);
            this.eNc.f(this.eMg);
            this.eNd.setNeedCache(false);
            this.eNd.Na();
            this.eNb.b(this.cXh);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eL(boolean z) {
        if (this.eNd.DY() || !aLI()) {
            return false;
        }
        this.eMg = null;
        this.eNc.reset();
        this.eNd.setNeedCache(true);
        this.eNd.Na();
        return true;
    }

    protected boolean aLI() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eMh != null && this.eMh.eMN != null) {
            this.eMh.eMN.clear();
        }
        this.eNb.aLJ();
        this.eNb.a(this.eMh);
        return false;
    }

    public boolean akV() {
        if (aLI()) {
            if (this.eNb != null) {
                this.eNb.aLK();
            }
            this.eNe.a((com.baidu.tbadk.mvc.b.e) this.eNc);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.eMh.aLR().clear();
        }
        this.eMh.a(mVar);
        if (mVar != null && mVar.aLR() != null && mVar.aLR().size() > 0) {
            this.eMg = mVar.aLR().get(mVar.aLR().size() - 1);
            if (this.eMh.yb() != null) {
                this.cXh.cs(this.eMh.yb().xX() == 1);
            } else {
                this.cXh.cs(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.cXh.ct(true);
        } else {
            this.eMg = null;
            this.cXh.cs(false);
            this.cXh.ct(false);
        }
        this.cXh.cr(false);
        this.cXh.cq(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GB();
        this.eNb.a(this.eMh);
        this.eNb.b(this.cXh);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eNc, readCacheRespMsg.getData().get(0));
        }
        this.eMg = null;
        this.eNc.reset();
        this.eNd.setNeedCache(true);
        this.eNd.Na();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eNb.aLJ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgReplyme(0);
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
                this.eNb.a(errorData);
                this.eNb.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.eNb.aLJ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgReplyme(0);
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
                this.eNb.a(errorData);
                this.eNb.a(errorData);
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

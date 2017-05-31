package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
public class ReplyMeModelController extends BdBaseModel<ReplyMessageActivity> implements CacheModel.a<au>, NetModel.b<at, au> {
    private com.baidu.tbadk.mvc.d.a bHR;
    private ReplyMessageActivity dmU;
    private at dmV;
    private ReplyMeNetModel dmW;
    private ReplyMeCacheModel dmX;
    private FeedData dma;
    private ac dmb;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new as(this, 2000994);
        this.dmU = replyMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dmV = new at();
        this.dmW = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.k.Z(this.dmU.getPageContext().getPageActivity()), this.dmV);
        this.dmW.a(this);
        this.dmW.setUniqueId(getUniqueId());
        this.dmW.registerListener(this.mNetworkChangedMessageListener);
        this.dmX = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.k.Z(this.dmU.getPageContext().getPageActivity()));
        this.dmX.a(this);
        this.dmX.setUniqueId(getUniqueId());
        this.dmb = new ac();
        this.bHR = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean VL() {
        if (!this.dmW.wq() && this.bHR.EL() && atV()) {
            this.bHR.bP(true);
            this.bHR.bR(true);
            this.dmV.g(this.dma);
            this.dmW.setNeedCache(false);
            this.dmW.EA();
            this.dmU.b(this.bHR);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dC(boolean z) {
        if (this.dmW.wq() || !atV()) {
            return false;
        }
        this.dma = null;
        this.dmV.reset();
        this.dmW.setNeedCache(true);
        this.dmW.EA();
        return true;
    }

    protected boolean atV() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dmb != null && this.dmb.dmI != null) {
            this.dmb.dmI.clear();
        }
        this.dmU.atW();
        this.dmU.a(this.dmb);
        return false;
    }

    public boolean VK() {
        if (atV()) {
            if (this.dmU != null) {
                this.dmU.atX();
            }
            this.dmX.a((com.baidu.tbadk.mvc.b.e) this.dmV);
            return true;
        }
        return true;
    }

    protected boolean a(at atVar, au auVar) {
        if (atVar.getUpdateType() != 4) {
            this.dmb.auf().clear();
        }
        this.dmb.a(auVar);
        if (auVar != null && auVar.auf() != null && auVar.auf().size() > 0) {
            this.dma = auVar.auf().get(auVar.auf().size() - 1);
            if (this.dmb.qx() != null) {
                this.bHR.bQ(this.dmb.qx().qt() == 1);
            } else {
                this.bHR.bQ(true);
            }
            if (atVar != null) {
                atVar.toNextPage();
            }
            this.bHR.bR(true);
        } else {
            this.dma = null;
            this.bHR.bQ(false);
            this.bHR.bR(false);
        }
        this.bHR.bP(false);
        this.bHR.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().yC();
        this.dmU.a(this.dmb);
        this.dmU.b(this.bHR);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<au>> readCacheRespMsg, ReadCacheMessage<au> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dmV, readCacheRespMsg.getData().get(0));
        }
        this.dma = null;
        this.dmV.reset();
        this.dmW.setNeedCache(true);
        this.dmW.EA();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<au>> writeCacheRespMsg, WriteCacheMessage<au> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<au> mvcHttpResponsedMessage, MvcHttpMessage<at, au> mvcHttpMessage, MvcNetMessage<at, au> mvcNetMessage) {
        au auVar;
        this.dmU.atW();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            auVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgReplyme(0);
            auVar = null;
        }
        if (r1 == null || auVar == null || !a(r1, auVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dmU.a(errorData);
                this.dmU.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<au, ?> mvcSocketResponsedMessage, MvcSocketMessage<at, au> mvcSocketMessage, MvcNetMessage<at, au> mvcNetMessage) {
        au auVar;
        this.dmU.atW();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            auVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgReplyme(0);
            auVar = null;
        }
        if (r1 == null || auVar == null || !a(r1, auVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dmU.a(errorData);
                this.dmU.a(errorData);
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

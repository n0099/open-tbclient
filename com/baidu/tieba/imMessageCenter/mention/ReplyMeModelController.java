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
    private com.baidu.tbadk.mvc.d.a bZB;
    private ReplyMessageActivity dRV;
    private l dRW;
    private ReplyMeNetModel dRX;
    private ReplyMeCacheModel dRY;
    private FeedData dRb;
    private f dRc;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dRV.aCV();
                }
            }
        };
        this.dRV = replyMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dRW = new l();
        this.dRX = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dRV.getPageContext().getPageActivity()), this.dRW);
        this.dRX.a(this);
        this.dRX.setUniqueId(getUniqueId());
        this.dRX.registerListener(this.mNetworkChangedMessageListener);
        this.dRY = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dRV.getPageContext().getPageActivity()));
        this.dRY.a(this);
        this.dRY.setUniqueId(getUniqueId());
        this.dRc = new f();
        this.bZB = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean abm() {
        if (!this.dRX.wz() && this.bZB.Fp() && aCU()) {
            this.bZB.bN(true);
            this.bZB.bP(true);
            this.dRW.g(this.dRb);
            this.dRX.setNeedCache(false);
            this.dRX.Ff();
            this.dRV.b(this.bZB);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dJ(boolean z) {
        if (this.dRX.wz() || !aCU()) {
            return false;
        }
        this.dRb = null;
        this.dRW.reset();
        this.dRX.setNeedCache(true);
        this.dRX.Ff();
        return true;
    }

    protected boolean aCU() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dRc != null && this.dRc.dRJ != null) {
            this.dRc.dRJ.clear();
        }
        this.dRV.aCV();
        this.dRV.a(this.dRc);
        return false;
    }

    public boolean abl() {
        if (aCU()) {
            if (this.dRV != null) {
                this.dRV.aCW();
            }
            this.dRY.a((com.baidu.tbadk.mvc.b.e) this.dRW);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dRc.aDd().clear();
        }
        this.dRc.a(mVar);
        if (mVar != null && mVar.aDd() != null && mVar.aDd().size() > 0) {
            this.dRb = mVar.aDd().get(mVar.aDd().size() - 1);
            if (this.dRc.qv() != null) {
                this.bZB.bO(this.dRc.qv().qr() == 1);
            } else {
                this.bZB.bO(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bZB.bP(true);
        } else {
            this.dRb = null;
            this.bZB.bO(false);
            this.bZB.bP(false);
        }
        this.bZB.bN(false);
        this.bZB.bM(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yC().yR();
        this.dRV.a(this.dRc);
        this.dRV.b(this.bZB);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dRW, readCacheRespMsg.getData().get(0));
        }
        this.dRb = null;
        this.dRW.reset();
        this.dRX.setNeedCache(true);
        this.dRX.Ff();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dRV.aCV();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgReplyme(0);
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
                this.dRV.a(errorData);
                this.dRV.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dRV.aCV();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgReplyme(0);
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
                this.dRV.a(errorData);
                this.dRV.a(errorData);
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

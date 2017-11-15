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
    private com.baidu.tbadk.mvc.d.a bZO;
    private ReplyMessageActivity dRZ;
    private FeedData dRg;
    private f dRh;
    private l dSa;
    private ReplyMeNetModel dSb;
    private ReplyMeCacheModel dSc;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ReplyMeModelController(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    ReplyMeModelController.this.dRZ.aCZ();
                }
            }
        };
        this.dRZ = replyMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dSa = new l();
        this.dSb = new ReplyMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dRZ.getPageContext().getPageActivity()), this.dSa);
        this.dSb.a(this);
        this.dSb.setUniqueId(getUniqueId());
        this.dSb.registerListener(this.mNetworkChangedMessageListener);
        this.dSc = new ReplyMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dRZ.getPageContext().getPageActivity()));
        this.dSc.a(this);
        this.dSc.setUniqueId(getUniqueId());
        this.dRh = new f();
        this.bZO = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aby() {
        if (!this.dSb.wz() && this.bZO.FB() && aCY()) {
            this.bZO.bO(true);
            this.bZO.bQ(true);
            this.dSa.g(this.dRg);
            this.dSb.setNeedCache(false);
            this.dSb.Fr();
            this.dRZ.b(this.bZO);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dO(boolean z) {
        if (this.dSb.wz() || !aCY()) {
            return false;
        }
        this.dRg = null;
        this.dSa.reset();
        this.dSb.setNeedCache(true);
        this.dSb.Fr();
        return true;
    }

    protected boolean aCY() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dRh != null && this.dRh.dRN != null) {
            this.dRh.dRN.clear();
        }
        this.dRZ.aCZ();
        this.dRZ.a(this.dRh);
        return false;
    }

    public boolean abx() {
        if (aCY()) {
            if (this.dRZ != null) {
                this.dRZ.aDa();
            }
            this.dSc.a((com.baidu.tbadk.mvc.b.e) this.dSa);
            return true;
        }
        return true;
    }

    protected boolean a(l lVar, m mVar) {
        if (lVar.getUpdateType() != 4) {
            this.dRh.aDh().clear();
        }
        this.dRh.a(mVar);
        if (mVar != null && mVar.aDh() != null && mVar.aDh().size() > 0) {
            this.dRg = mVar.aDh().get(mVar.aDh().size() - 1);
            if (this.dRh.qv() != null) {
                this.bZO.bP(this.dRh.qv().qr() == 1);
            } else {
                this.bZO.bP(true);
            }
            if (lVar != null) {
                lVar.toNextPage();
            }
            this.bZO.bQ(true);
        } else {
            this.dRg = null;
            this.bZO.bP(false);
            this.bZO.bQ(false);
        }
        this.bZO.bO(false);
        this.bZO.bN(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().yZ();
        this.dRZ.a(this.dRh);
        this.dRZ.b(this.bZO);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dSa, readCacheRespMsg.getData().get(0));
        }
        this.dRg = null;
        this.dSa.reset();
        this.dSb.setNeedCache(true);
        this.dSb.Fr();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dRZ.aCZ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
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
                this.dRZ.a(errorData);
                this.dRZ.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        this.dRZ.aCZ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
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
                this.dRZ.a(errorData);
                this.dRZ.a(errorData);
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

package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
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
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a iwp;
    private AtMessageActivity kIq;
    private b kIr;
    private AtMeNetModel kIs;
    private AtMeCacheModel kIt;
    private FeedData kIu;
    private f kIv;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.j.K(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kIq.cXd();
                }
            }
        };
        this.kIq = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kIr = new b();
        this.kIs = new AtMeNetModel((TbPageContext) com.baidu.adp.base.j.K(this.kIq.getPageContext().getPageActivity()), this.kIr);
        this.kIs.a(this);
        if (this.kIq != null) {
            this.kIs.setUniqueId(this.kIq.getUniqueId());
        }
        this.kIs.registerListener(this.mNetworkChangedMessageListener);
        this.kIt = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.j.K(this.kIq.getPageContext().getPageActivity()));
        this.kIt.a(this);
        if (this.kIq != null) {
            this.kIt.setUniqueId(this.kIq.getUniqueId());
        }
        this.kIv = new f();
        this.iwp = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crT() {
        if (!this.kIs.isLoading() && this.iwp.bDk() && cXc()) {
            this.iwp.lf(true);
            this.iwp.lh(true);
            this.kIr.e(this.kIu);
            this.kIs.setNeedCache(false);
            this.kIs.loadData();
            this.kIq.c(this.iwp);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cHN() {
        if (this.kIs.isLoading() || !cXc()) {
            return false;
        }
        this.kIu = null;
        this.kIr.reset();
        this.kIs.setNeedCache(true);
        this.kIs.loadData();
        return true;
    }

    protected boolean cXc() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kIv != null && this.kIv.kJR != null) {
            this.kIv.kJR.clear();
        }
        this.kIq.cXd();
        this.kIq.a(this.kIv);
        return false;
    }

    public boolean crS() {
        if (cXc()) {
            if (this.kIq != null) {
                this.kIq.cXe();
            }
            this.kIt.a((com.baidu.tbadk.mvc.b.e) this.kIr);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kIq.Vq();
        if (bVar.getUpdateType() != 4) {
            this.kIv.cXu().clear();
        }
        this.kIv.a(cVar);
        if (cVar != null && cVar.cXu() != null && cVar.cXu().size() > 0) {
            this.kIu = cVar.cXu().get(cVar.cXu().size() - 1);
            if (this.kIv.getPage() != null) {
                this.iwp.lg(this.kIv.getPage().bmm() == 1);
            } else {
                this.iwp.lg(true);
            }
            if (bVar != null) {
                bVar.cXx();
            }
            this.iwp.lh(true);
        } else {
            this.kIu = null;
            this.iwp.lg(false);
            this.iwp.lh(false);
        }
        this.iwp.lf(false);
        this.iwp.le(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxx();
        if (!TbadkCoreApplication.isLogin()) {
            this.kIv.cXu().clear();
        } else {
            this.kIq.c(this.iwp);
        }
        this.kIq.a(this.kIv);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kIr, readCacheRespMsg.getData().get(0));
        }
        this.kIu = null;
        this.kIr.reset();
        this.kIs.setNeedCache(true);
        this.kIs.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kIq.cXd();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kIq.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kIq.cXd();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kIq.a(errorData);
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

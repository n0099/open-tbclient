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
/* loaded from: classes9.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener cLK;
    private com.baidu.tbadk.mvc.d.a fPl;
    private AtMessageActivity hPQ;
    private b hPR;
    private AtMeNetModel hPS;
    private AtMeCacheModel hPT;
    private FeedData hPU;
    private f hPV;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.hPQ.bZK();
                }
            }
        };
        this.hPQ = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.hPR = new b();
        this.hPS = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.hPQ.getPageContext().getPageActivity()), this.hPR);
        this.hPS.a(this);
        if (this.hPQ != null) {
            this.hPS.setUniqueId(this.hPQ.getUniqueId());
        }
        this.hPS.registerListener(this.cLK);
        this.hPT = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.hPQ.getPageContext().getPageActivity()));
        this.hPT.a(this);
        if (this.hPQ != null) {
            this.hPT.setUniqueId(this.hPQ.getUniqueId());
        }
        this.hPV = new f();
        this.fPl = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bvV() {
        if (!this.hPS.isLoading() && this.fPl.aQO() && bZJ()) {
            this.fPl.gQ(true);
            this.fPl.gS(true);
            this.hPR.d(this.hPU);
            this.hPS.setNeedCache(false);
            this.hPS.loadData();
            this.hPQ.c(this.fPl);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bIY() {
        if (this.hPS.isLoading() || !bZJ()) {
            return false;
        }
        this.hPU = null;
        this.hPR.reset();
        this.hPS.setNeedCache(true);
        this.hPS.loadData();
        return true;
    }

    protected boolean bZJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hPV != null && this.hPV.hQR != null) {
            this.hPV.hQR.clear();
        }
        this.hPQ.bZK();
        this.hPQ.a(this.hPV);
        return false;
    }

    public boolean bvU() {
        if (bZJ()) {
            if (this.hPQ != null) {
                this.hPQ.bZL();
            }
            this.hPT.a((com.baidu.tbadk.mvc.b.e) this.hPR);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.hPV.cad().clear();
        }
        this.hPV.a(cVar);
        if (cVar != null && cVar.cad() != null && cVar.cad().size() > 0) {
            this.hPU = cVar.cad().get(cVar.cad().size() - 1);
            if (this.hPV.getPage() != null) {
                this.fPl.gR(this.hPV.getPage().aBn() == 1);
            } else {
                this.fPl.gR(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.fPl.gS(true);
        } else {
            this.hPU = null;
            this.fPl.gR(false);
            this.fPl.gS(false);
        }
        this.fPl.gQ(false);
        this.fPl.gP(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aKY();
        if (!TbadkCoreApplication.isLogin()) {
            this.hPV.cad().clear();
        } else {
            this.hPQ.c(this.fPl);
        }
        this.hPQ.a(this.hPV);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hPR, readCacheRespMsg.getData().get(0));
        }
        this.hPU = null;
        this.hPR.reset();
        this.hPS.setNeedCache(true);
        this.hPS.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hPQ.bZK();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgAtme(0);
            cVar = null;
        }
        if (r1 == null || cVar == null || !a(r1, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.hPQ.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hPQ.bZK();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgAtme(0);
            cVar = null;
        }
        if (r1 == null || cVar == null || !a(r1, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.hPQ.a(errorData);
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

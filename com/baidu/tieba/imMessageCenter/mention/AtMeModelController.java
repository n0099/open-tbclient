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
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a cVV;
    private AtMessageActivity eWP;
    private b eWQ;
    private AtMeNetModel eWR;
    private AtMeCacheModel eWS;
    private FeedData eWT;
    private f eWU;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eWP.aTK();
                }
            }
        };
        this.eWP = atMessageActivity;
    }

    public void m(Bundle bundle) {
        this.eWQ = new b();
        this.eWR = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.eWP.getPageContext().getPageActivity()), this.eWQ);
        this.eWR.a(this);
        if (this.eWP != null) {
            this.eWR.setUniqueId(this.eWP.getUniqueId());
        }
        this.eWR.registerListener(this.mNetworkChangedMessageListener);
        this.eWS = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.eWP.getPageContext().getPageActivity()));
        this.eWS.a(this);
        if (this.eWP != null) {
            this.eWS.setUniqueId(this.eWP.getUniqueId());
        }
        this.eWU = new f();
        this.cVV = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apa() {
        if (!this.eWR.Ee() && this.cVV.NA() && aTJ()) {
            this.cVV.cE(true);
            this.cVV.cG(true);
            this.eWQ.d(this.eWT);
            this.eWR.setNeedCache(false);
            this.eWR.Ns();
            this.eWP.b(this.cVV);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aDZ() {
        if (this.eWR.Ee() || !aTJ()) {
            return false;
        }
        this.eWT = null;
        this.eWQ.reset();
        this.eWR.setNeedCache(true);
        this.eWR.Ns();
        return true;
    }

    protected boolean aTJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eWU != null && this.eWU.eXS != null) {
            this.eWU.eXS.clear();
        }
        this.eWP.aTK();
        this.eWP.a(this.eWU);
        return false;
    }

    public boolean aoZ() {
        if (aTJ()) {
            if (this.eWP != null) {
                this.eWP.aTL();
            }
            this.eWS.a((com.baidu.tbadk.mvc.b.e) this.eWQ);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eWU.aUe().clear();
        }
        this.eWU.a(cVar);
        if (cVar != null && cVar.aUe() != null && cVar.aUe().size() > 0) {
            this.eWT = cVar.aUe().get(cVar.aUe().size() - 1);
            if (this.eWU.xO() != null) {
                this.cVV.cF(this.eWU.xO().xL() == 1);
            } else {
                this.cVV.cF(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cVV.cG(true);
        } else {
            this.eWT = null;
            this.cVV.cF(false);
            this.cVV.cG(false);
        }
        this.cVV.cE(false);
        this.cVV.cD(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.GL().Ha();
        if (!TbadkCoreApplication.isLogin()) {
            this.eWU.aUe().clear();
        } else {
            this.eWP.b(this.cVV);
        }
        this.eWP.a(this.eWU);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eWQ, readCacheRespMsg.getData().get(0));
        }
        this.eWT = null;
        this.eWQ.reset();
        this.eWR.setNeedCache(true);
        this.eWR.Ns();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eWP.aTK();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgAtme(0);
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
            this.eWP.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eWP.aTK();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgAtme(0);
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
            this.eWP.a(errorData);
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

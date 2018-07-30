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
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a cGJ;
    private AtMessageActivity eGD;
    private b eGE;
    private AtMeNetModel eGF;
    private AtMeCacheModel eGG;
    private FeedData eGH;
    private f eGI;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ad(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eGD.aON();
                }
            }
        };
        this.eGD = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.eGE = new b();
        this.eGF = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ad(this.eGD.getPageContext().getPageActivity()), this.eGE);
        this.eGF.a(this);
        if (this.eGD != null) {
            this.eGF.setUniqueId(this.eGD.getUniqueId());
        }
        this.eGF.registerListener(this.mNetworkChangedMessageListener);
        this.eGG = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ad(this.eGD.getPageContext().getPageActivity()));
        this.eGG.a(this);
        if (this.eGD != null) {
            this.eGG.setUniqueId(this.eGD.getUniqueId());
        }
        this.eGI = new f();
        this.cGJ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akm() {
        if (!this.eGF.AE() && this.cGJ.JZ() && aOM()) {
            this.cGJ.bR(true);
            this.cGJ.bT(true);
            this.eGE.d(this.eGH);
            this.eGF.setNeedCache(false);
            this.eGF.JR();
            this.eGD.b(this.cGJ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aww() {
        if (this.eGF.AE() || !aOM()) {
            return false;
        }
        this.eGH = null;
        this.eGE.reset();
        this.eGF.setNeedCache(true);
        this.eGF.JR();
        return true;
    }

    protected boolean aOM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eGI != null && this.eGI.eHG != null) {
            this.eGI.eHG.clear();
        }
        this.eGD.aON();
        this.eGD.a(this.eGI);
        return false;
    }

    public boolean akl() {
        if (aOM()) {
            if (this.eGD != null) {
                this.eGD.aOO();
            }
            this.eGG.a((com.baidu.tbadk.mvc.b.e) this.eGE);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eGI.aPh().clear();
        }
        this.eGI.a(cVar);
        if (cVar != null && cVar.aPh() != null && cVar.aPh().size() > 0) {
            this.eGH = cVar.aPh().get(cVar.aPh().size() - 1);
            if (this.eGI.uw() != null) {
                this.cGJ.bS(this.eGI.uw().us() == 1);
            } else {
                this.cGJ.bS(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cGJ.bT(true);
        } else {
            this.eGH = null;
            this.cGJ.bS(false);
            this.cGJ.bT(false);
        }
        this.cGJ.bR(false);
        this.cGJ.bQ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DA();
        if (!TbadkCoreApplication.isLogin()) {
            this.eGI.aPh().clear();
        } else {
            this.eGD.b(this.cGJ);
        }
        this.eGD.a(this.eGI);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eGE, readCacheRespMsg.getData().get(0));
        }
        this.eGH = null;
        this.eGE.reset();
        this.eGF.setNeedCache(true);
        this.eGF.JR();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eGD.aON();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgAtme(0);
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
            this.eGD.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eGD.aON();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgAtme(0);
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
            this.eGD.a(errorData);
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

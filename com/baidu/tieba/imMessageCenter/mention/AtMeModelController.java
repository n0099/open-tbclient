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
    private com.baidu.tbadk.mvc.d.a cGG;
    private AtMeNetModel eGA;
    private AtMeCacheModel eGB;
    private FeedData eGC;
    private f eGD;
    private AtMessageActivity eGy;
    private b eGz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ad(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eGy.aOK();
                }
            }
        };
        this.eGy = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.eGz = new b();
        this.eGA = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ad(this.eGy.getPageContext().getPageActivity()), this.eGz);
        this.eGA.a(this);
        if (this.eGy != null) {
            this.eGA.setUniqueId(this.eGy.getUniqueId());
        }
        this.eGA.registerListener(this.mNetworkChangedMessageListener);
        this.eGB = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ad(this.eGy.getPageContext().getPageActivity()));
        this.eGB.a(this);
        if (this.eGy != null) {
            this.eGB.setUniqueId(this.eGy.getUniqueId());
        }
        this.eGD = new f();
        this.cGG = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ako() {
        if (!this.eGA.AB() && this.cGG.Kd() && aOJ()) {
            this.cGG.bS(true);
            this.cGG.bU(true);
            this.eGz.d(this.eGC);
            this.eGA.setNeedCache(false);
            this.eGA.JV();
            this.eGy.b(this.cGG);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awv() {
        if (this.eGA.AB() || !aOJ()) {
            return false;
        }
        this.eGC = null;
        this.eGz.reset();
        this.eGA.setNeedCache(true);
        this.eGA.JV();
        return true;
    }

    protected boolean aOJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eGD != null && this.eGD.eHB != null) {
            this.eGD.eHB.clear();
        }
        this.eGy.aOK();
        this.eGy.a(this.eGD);
        return false;
    }

    public boolean akn() {
        if (aOJ()) {
            if (this.eGy != null) {
                this.eGy.aOL();
            }
            this.eGB.a((com.baidu.tbadk.mvc.b.e) this.eGz);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eGD.aPe().clear();
        }
        this.eGD.a(cVar);
        if (cVar != null && cVar.aPe() != null && cVar.aPe().size() > 0) {
            this.eGC = cVar.aPe().get(cVar.aPe().size() - 1);
            if (this.eGD.uv() != null) {
                this.cGG.bT(this.eGD.uv().ur() == 1);
            } else {
                this.cGG.bT(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cGG.bU(true);
        } else {
            this.eGC = null;
            this.cGG.bT(false);
            this.cGG.bU(false);
        }
        this.cGG.bS(false);
        this.cGG.bR(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DA();
        if (!TbadkCoreApplication.isLogin()) {
            this.eGD.aPe().clear();
        } else {
            this.eGy.b(this.cGG);
        }
        this.eGy.a(this.eGD);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eGz, readCacheRespMsg.getData().get(0));
        }
        this.eGC = null;
        this.eGz.reset();
        this.eGA.setNeedCache(true);
        this.eGA.JV();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eGy.aOK();
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
            this.eGy.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eGy.aOK();
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
            this.eGy.a(errorData);
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

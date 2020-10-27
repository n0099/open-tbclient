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
/* loaded from: classes22.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener eri;
    private com.baidu.tbadk.mvc.d.a hWQ;
    private AtMessageActivity knK;
    private b knL;
    private AtMeNetModel knM;
    private AtMeCacheModel knN;
    private FeedData knO;
    private f knP;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.knK.cTX();
                }
            }
        };
        this.knK = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.knL = new b();
        this.knM = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.knK.getPageContext().getPageActivity()), this.knL);
        this.knM.a(this);
        if (this.knK != null) {
            this.knM.setUniqueId(this.knK.getUniqueId());
        }
        this.knM.registerListener(this.eri);
        this.knN = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.knK.getPageContext().getPageActivity()));
        this.knN.a(this);
        if (this.knK != null) {
            this.knN.setUniqueId(this.knK.getUniqueId());
        }
        this.knP = new f();
        this.hWQ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cmB() {
        if (!this.knM.isLoading() && this.hWQ.bzr() && cTW()) {
            this.hWQ.kk(true);
            this.hWQ.km(true);
            this.knL.e(this.knO);
            this.knM.setNeedCache(false);
            this.knM.loadData();
            this.knK.c(this.hWQ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cBl() {
        if (this.knM.isLoading() || !cTW()) {
            return false;
        }
        this.knO = null;
        this.knL.reset();
        this.knM.setNeedCache(true);
        this.knM.loadData();
        return true;
    }

    protected boolean cTW() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.knP != null && this.knP.kpl != null) {
            this.knP.kpl.clear();
        }
        this.knK.cTX();
        this.knK.a(this.knP);
        return false;
    }

    public boolean cmA() {
        if (cTW()) {
            if (this.knK != null) {
                this.knK.cTY();
            }
            this.knN.a((com.baidu.tbadk.mvc.b.e) this.knL);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.knP.cUo().clear();
        }
        this.knP.a(cVar);
        if (cVar != null && cVar.cUo() != null && cVar.cUo().size() > 0) {
            this.knO = cVar.cUo().get(cVar.cUo().size() - 1);
            if (this.knP.getPage() != null) {
                this.hWQ.kl(this.knP.getPage().biQ() == 1);
            } else {
                this.hWQ.kl(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.hWQ.km(true);
        } else {
            this.knO = null;
            this.hWQ.kl(false);
            this.hWQ.km(false);
        }
        this.hWQ.kk(false);
        this.hWQ.kj(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bts().btG();
        if (!TbadkCoreApplication.isLogin()) {
            this.knP.cUo().clear();
        } else {
            this.knK.c(this.hWQ);
        }
        this.knK.a(this.knP);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.knL, readCacheRespMsg.getData().get(0));
        }
        this.knO = null;
        this.knL.reset();
        this.knM.setNeedCache(true);
        this.knM.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.knK.cTX();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgAtme(0);
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
            this.knK.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.knK.cTX();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgAtme(0);
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
            this.knK.a(errorData);
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

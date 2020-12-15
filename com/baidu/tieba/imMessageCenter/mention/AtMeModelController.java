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
    private com.baidu.tbadk.mvc.d.a ioC;
    private AtMessageActivity kHM;
    private b kHN;
    private AtMeNetModel kHO;
    private AtMeCacheModel kHP;
    private FeedData kHQ;
    private f kHR;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.J(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kHM.dbr();
                }
            }
        };
        this.kHM = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kHN = new b();
        this.kHO = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.J(this.kHM.getPageContext().getPageActivity()), this.kHN);
        this.kHO.a(this);
        if (this.kHM != null) {
            this.kHO.setUniqueId(this.kHM.getUniqueId());
        }
        this.kHO.registerListener(this.mNetworkChangedMessageListener);
        this.kHP = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.J(this.kHM.getPageContext().getPageActivity()));
        this.kHP.a(this);
        if (this.kHM != null) {
            this.kHP.setUniqueId(this.kHM.getUniqueId());
        }
        this.kHR = new f();
        this.ioC = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean csR() {
        if (!this.kHO.isLoading() && this.ioC.bEI() && dbq()) {
            this.ioC.kN(true);
            this.ioC.kP(true);
            this.kHN.e(this.kHQ);
            this.kHO.setNeedCache(false);
            this.kHO.loadData();
            this.kHM.c(this.ioC);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cIE() {
        if (this.kHO.isLoading() || !dbq()) {
            return false;
        }
        this.kHQ = null;
        this.kHN.reset();
        this.kHO.setNeedCache(true);
        this.kHO.loadData();
        return true;
    }

    protected boolean dbq() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kHR != null && this.kHR.kJn != null) {
            this.kHR.kJn.clear();
        }
        this.kHM.dbr();
        this.kHM.a(this.kHR);
        return false;
    }

    public boolean csQ() {
        if (dbq()) {
            if (this.kHM != null) {
                this.kHM.dbs();
            }
            this.kHP.a((com.baidu.tbadk.mvc.b.e) this.kHN);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kHM.Yb();
        if (bVar.getUpdateType() != 4) {
            this.kHR.dbI().clear();
        }
        this.kHR.a(cVar);
        if (cVar != null && cVar.dbI() != null && cVar.dbI().size() > 0) {
            this.kHQ = cVar.dbI().get(cVar.dbI().size() - 1);
            if (this.kHR.getPage() != null) {
                this.ioC.kO(this.kHR.getPage().bnF() == 1);
            } else {
                this.ioC.kO(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.ioC.kP(true);
        } else {
            this.kHQ = null;
            this.ioC.kO(false);
            this.ioC.kP(false);
        }
        this.ioC.kN(false);
        this.ioC.kM(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.byI().byW();
        if (!TbadkCoreApplication.isLogin()) {
            this.kHR.dbI().clear();
        } else {
            this.kHM.c(this.ioC);
        }
        this.kHM.a(this.kHR);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kHN, readCacheRespMsg.getData().get(0));
        }
        this.kHQ = null;
        this.kHN.reset();
        this.kHO.setNeedCache(true);
        this.kHO.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kHM.dbr();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgAtme(0);
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
            this.kHM.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kHM.dbr();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgAtme(0);
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
            this.kHM.a(errorData);
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

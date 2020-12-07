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
    private com.baidu.tbadk.mvc.d.a ioA;
    private AtMessageActivity kHK;
    private b kHL;
    private AtMeNetModel kHM;
    private AtMeCacheModel kHN;
    private FeedData kHO;
    private f kHP;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.J(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kHK.dbq();
                }
            }
        };
        this.kHK = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kHL = new b();
        this.kHM = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.J(this.kHK.getPageContext().getPageActivity()), this.kHL);
        this.kHM.a(this);
        if (this.kHK != null) {
            this.kHM.setUniqueId(this.kHK.getUniqueId());
        }
        this.kHM.registerListener(this.mNetworkChangedMessageListener);
        this.kHN = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.J(this.kHK.getPageContext().getPageActivity()));
        this.kHN.a(this);
        if (this.kHK != null) {
            this.kHN.setUniqueId(this.kHK.getUniqueId());
        }
        this.kHP = new f();
        this.ioA = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean csQ() {
        if (!this.kHM.isLoading() && this.ioA.bEI() && dbp()) {
            this.ioA.kN(true);
            this.ioA.kP(true);
            this.kHL.e(this.kHO);
            this.kHM.setNeedCache(false);
            this.kHM.loadData();
            this.kHK.c(this.ioA);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cID() {
        if (this.kHM.isLoading() || !dbp()) {
            return false;
        }
        this.kHO = null;
        this.kHL.reset();
        this.kHM.setNeedCache(true);
        this.kHM.loadData();
        return true;
    }

    protected boolean dbp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kHP != null && this.kHP.kJl != null) {
            this.kHP.kJl.clear();
        }
        this.kHK.dbq();
        this.kHK.a(this.kHP);
        return false;
    }

    public boolean csP() {
        if (dbp()) {
            if (this.kHK != null) {
                this.kHK.dbr();
            }
            this.kHN.a((com.baidu.tbadk.mvc.b.e) this.kHL);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kHK.Yb();
        if (bVar.getUpdateType() != 4) {
            this.kHP.dbH().clear();
        }
        this.kHP.a(cVar);
        if (cVar != null && cVar.dbH() != null && cVar.dbH().size() > 0) {
            this.kHO = cVar.dbH().get(cVar.dbH().size() - 1);
            if (this.kHP.getPage() != null) {
                this.ioA.kO(this.kHP.getPage().bnF() == 1);
            } else {
                this.ioA.kO(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.ioA.kP(true);
        } else {
            this.kHO = null;
            this.ioA.kO(false);
            this.ioA.kP(false);
        }
        this.ioA.kN(false);
        this.ioA.kM(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.byI().byW();
        if (!TbadkCoreApplication.isLogin()) {
            this.kHP.dbH().clear();
        } else {
            this.kHK.c(this.ioA);
        }
        this.kHK.a(this.kHP);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kHL, readCacheRespMsg.getData().get(0));
        }
        this.kHO = null;
        this.kHL.reset();
        this.kHM.setNeedCache(true);
        this.kHM.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kHK.dbq();
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
            this.kHK.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kHK.dbq();
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
            this.kHK.a(errorData);
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

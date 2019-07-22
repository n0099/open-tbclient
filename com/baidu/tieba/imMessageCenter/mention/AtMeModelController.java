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
    private com.baidu.tbadk.mvc.d.a eKw;
    private AtMessageActivity gUD;
    private b gUE;
    private AtMeNetModel gUF;
    private AtMeCacheModel gUG;
    private FeedData gUH;
    private f gUI;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gUD.bHJ();
                }
            }
        };
        this.gUD = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gUE = new b();
        this.gUF = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gUD.getPageContext().getPageActivity()), this.gUE);
        this.gUF.a(this);
        if (this.gUD != null) {
            this.gUF.setUniqueId(this.gUD.getUniqueId());
        }
        this.gUF.registerListener(this.mNetworkChangedMessageListener);
        this.gUG = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gUD.getPageContext().getPageActivity()));
        this.gUG.a(this);
        if (this.gUD != null) {
            this.gUG.setUniqueId(this.gUD.getUniqueId());
        }
        this.gUI = new f();
        this.eKw = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bba() {
        if (!this.gUF.pP() && this.eKw.auL() && bHI()) {
            this.eKw.fy(true);
            this.eKw.fA(true);
            this.gUE.d(this.gUH);
            this.gUF.setNeedCache(false);
            this.gUF.auD();
            this.gUD.c(this.eKw);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqJ() {
        if (this.gUF.pP() || !bHI()) {
            return false;
        }
        this.gUH = null;
        this.gUE.reset();
        this.gUF.setNeedCache(true);
        this.gUF.auD();
        return true;
    }

    protected boolean bHI() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gUI != null && this.gUI.gVD != null) {
            this.gUI.gVD.clear();
        }
        this.gUD.bHJ();
        this.gUD.a(this.gUI);
        return false;
    }

    public boolean baZ() {
        if (bHI()) {
            if (this.gUD != null) {
                this.gUD.bHK();
            }
            this.gUG.a((com.baidu.tbadk.mvc.b.e) this.gUE);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gUI.bIc().clear();
        }
        this.gUI.a(cVar);
        if (cVar != null && cVar.bIc() != null && cVar.bIc().size() > 0) {
            this.gUH = cVar.bIc().get(cVar.bIc().size() - 1);
            if (this.gUI.getPage() != null) {
                this.eKw.fz(this.gUI.getPage().adr() == 1);
            } else {
                this.eKw.fz(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eKw.fA(true);
        } else {
            this.gUH = null;
            this.eKw.fz(false);
            this.eKw.fA(false);
        }
        this.eKw.fy(false);
        this.eKw.fx(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.anD().anS();
        if (!TbadkCoreApplication.isLogin()) {
            this.gUI.bIc().clear();
        } else {
            this.gUD.c(this.eKw);
        }
        this.gUD.a(this.gUI);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gUE, readCacheRespMsg.getData().get(0));
        }
        this.gUH = null;
        this.gUE.reset();
        this.gUF.setNeedCache(true);
        this.gUF.auD();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gUD.bHJ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgAtme(0);
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
            this.gUD.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gUD.bHJ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgAtme(0);
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
            this.gUD.a(errorData);
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

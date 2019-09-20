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
    private com.baidu.tbadk.mvc.d.a eMm;
    private AtMessageActivity gXp;
    private b gXq;
    private AtMeNetModel gXr;
    private AtMeCacheModel gXs;
    private FeedData gXt;
    private f gXu;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gXp.bIL();
                }
            }
        };
        this.gXp = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gXq = new b();
        this.gXr = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gXp.getPageContext().getPageActivity()), this.gXq);
        this.gXr.a(this);
        if (this.gXp != null) {
            this.gXr.setUniqueId(this.gXp.getUniqueId());
        }
        this.gXr.registerListener(this.mNetworkChangedMessageListener);
        this.gXs = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gXp.getPageContext().getPageActivity()));
        this.gXs.a(this);
        if (this.gXp != null) {
            this.gXs.setUniqueId(this.gXp.getUniqueId());
        }
        this.gXu = new f();
        this.eMm = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bbG() {
        if (!this.gXr.pQ() && this.eMm.auZ() && bIK()) {
            this.eMm.fB(true);
            this.eMm.fD(true);
            this.gXq.d(this.gXt);
            this.gXr.setNeedCache(false);
            this.gXr.auR();
            this.gXp.c(this.eMm);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean brH() {
        if (this.gXr.pQ() || !bIK()) {
            return false;
        }
        this.gXt = null;
        this.gXq.reset();
        this.gXr.setNeedCache(true);
        this.gXr.auR();
        return true;
    }

    protected boolean bIK() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gXu != null && this.gXu.gYp != null) {
            this.gXu.gYp.clear();
        }
        this.gXp.bIL();
        this.gXp.a(this.gXu);
        return false;
    }

    public boolean bbF() {
        if (bIK()) {
            if (this.gXp != null) {
                this.gXp.bIM();
            }
            this.gXs.a((com.baidu.tbadk.mvc.b.e) this.gXq);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gXu.bJe().clear();
        }
        this.gXu.a(cVar);
        if (cVar != null && cVar.bJe() != null && cVar.bJe().size() > 0) {
            this.gXt = cVar.bJe().get(cVar.bJe().size() - 1);
            if (this.gXu.getPage() != null) {
                this.eMm.fC(this.gXu.getPage().adw() == 1);
            } else {
                this.eMm.fC(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eMm.fD(true);
        } else {
            this.gXt = null;
            this.eMm.fC(false);
            this.eMm.fD(false);
        }
        this.eMm.fB(false);
        this.eMm.fA(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.anR().aog();
        if (!TbadkCoreApplication.isLogin()) {
            this.gXu.bJe().clear();
        } else {
            this.gXp.c(this.eMm);
        }
        this.gXp.a(this.gXu);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gXq, readCacheRespMsg.getData().get(0));
        }
        this.gXt = null;
        this.gXq.reset();
        this.gXr.setNeedCache(true);
        this.gXr.auR();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gXp.bIL();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.anR().setMsgAtme(0);
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
            this.gXp.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gXp.bIL();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.anR().setMsgAtme(0);
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
            this.gXp.a(errorData);
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

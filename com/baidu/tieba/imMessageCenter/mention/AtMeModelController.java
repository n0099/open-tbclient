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
    final CustomMessageListener cLy;
    private com.baidu.tbadk.mvc.d.a fOq;
    private AtMessageActivity hOe;
    private b hOf;
    private AtMeNetModel hOg;
    private AtMeCacheModel hOh;
    private FeedData hOi;
    private f hOj;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.cLy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.hOe.bZr();
                }
            }
        };
        this.hOe = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.hOf = new b();
        this.hOg = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.hOe.getPageContext().getPageActivity()), this.hOf);
        this.hOg.a(this);
        if (this.hOe != null) {
            this.hOg.setUniqueId(this.hOe.getUniqueId());
        }
        this.hOg.registerListener(this.cLy);
        this.hOh = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.hOe.getPageContext().getPageActivity()));
        this.hOh.a(this);
        if (this.hOe != null) {
            this.hOh.setUniqueId(this.hOe.getUniqueId());
        }
        this.hOj = new f();
        this.fOq = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bvP() {
        if (!this.hOg.isLoading() && this.fOq.aQJ() && bZq()) {
            this.fOq.gP(true);
            this.fOq.gR(true);
            this.hOf.d(this.hOi);
            this.hOg.setNeedCache(false);
            this.hOg.loadData();
            this.hOe.c(this.fOq);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bIL() {
        if (this.hOg.isLoading() || !bZq()) {
            return false;
        }
        this.hOi = null;
        this.hOf.reset();
        this.hOg.setNeedCache(true);
        this.hOg.loadData();
        return true;
    }

    protected boolean bZq() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hOj != null && this.hOj.hPf != null) {
            this.hOj.hPf.clear();
        }
        this.hOe.bZr();
        this.hOe.a(this.hOj);
        return false;
    }

    public boolean bvO() {
        if (bZq()) {
            if (this.hOe != null) {
                this.hOe.bZs();
            }
            this.hOh.a((com.baidu.tbadk.mvc.b.e) this.hOf);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.hOj.bZK().clear();
        }
        this.hOj.a(cVar);
        if (cVar != null && cVar.bZK() != null && cVar.bZK().size() > 0) {
            this.hOi = cVar.bZK().get(cVar.bZK().size() - 1);
            if (this.hOj.getPage() != null) {
                this.fOq.gQ(this.hOj.getPage().aBk() == 1);
            } else {
                this.fOq.gQ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.fOq.gR(true);
        } else {
            this.hOi = null;
            this.fOq.gQ(false);
            this.fOq.gR(false);
        }
        this.fOq.gP(false);
        this.fOq.gO(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aKT();
        if (!TbadkCoreApplication.isLogin()) {
            this.hOj.bZK().clear();
        } else {
            this.hOe.c(this.fOq);
        }
        this.hOe.a(this.hOj);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hOf, readCacheRespMsg.getData().get(0));
        }
        this.hOi = null;
        this.hOf.reset();
        this.hOg.setNeedCache(true);
        this.hOg.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hOe.bZr();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKE().setMsgAtme(0);
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
            this.hOe.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hOe.bZr();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKE().setMsgAtme(0);
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
            this.hOe.a(errorData);
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

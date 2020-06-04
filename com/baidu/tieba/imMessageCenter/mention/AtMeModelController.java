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
    final CustomMessageListener dyW;
    private com.baidu.tbadk.mvc.d.a gIU;
    private AtMessageActivity iPh;
    private b iPi;
    private AtMeNetModel iPj;
    private AtMeCacheModel iPk;
    private FeedData iPl;
    private f iPm;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.G(atMessageActivity.getPageContext().getPageActivity()));
        this.dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.iPh.cqR();
                }
            }
        };
        this.iPh = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.iPi = new b();
        this.iPj = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.G(this.iPh.getPageContext().getPageActivity()), this.iPi);
        this.iPj.a(this);
        if (this.iPh != null) {
            this.iPj.setUniqueId(this.iPh.getUniqueId());
        }
        this.iPj.registerListener(this.dyW);
        this.iPk = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.G(this.iPh.getPageContext().getPageActivity()));
        this.iPk.a(this);
        if (this.iPh != null) {
            this.iPk.setUniqueId(this.iPh.getUniqueId());
        }
        this.iPm = new f();
        this.gIU = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bMa() {
        if (!this.iPj.isLoading() && this.gIU.bfh() && cqQ()) {
            this.gIU.ik(true);
            this.gIU.im(true);
            this.iPi.d(this.iPl);
            this.iPj.setNeedCache(false);
            this.iPj.loadData();
            this.iPh.c(this.gIU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bZY() {
        if (this.iPj.isLoading() || !cqQ()) {
            return false;
        }
        this.iPl = null;
        this.iPi.reset();
        this.iPj.setNeedCache(true);
        this.iPj.loadData();
        return true;
    }

    protected boolean cqQ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.iPm != null && this.iPm.iQi != null) {
            this.iPm.iQi.clear();
        }
        this.iPh.cqR();
        this.iPh.a(this.iPm);
        return false;
    }

    public boolean bLZ() {
        if (cqQ()) {
            if (this.iPh != null) {
                this.iPh.cqS();
            }
            this.iPk.a((com.baidu.tbadk.mvc.b.e) this.iPi);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.iPm.crk().clear();
        }
        this.iPm.a(cVar);
        if (cVar != null && cVar.crk() != null && cVar.crk().size() > 0) {
            this.iPl = cVar.crk().get(cVar.crk().size() - 1);
            if (this.iPm.getPage() != null) {
                this.gIU.il(this.iPm.getPage().aPt() == 1);
            } else {
                this.gIU.il(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.gIU.im(true);
        } else {
            this.iPl = null;
            this.gIU.il(false);
            this.gIU.im(false);
        }
        this.gIU.ik(false);
        this.gIU.ij(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().aZB();
        if (!TbadkCoreApplication.isLogin()) {
            this.iPm.crk().clear();
        } else {
            this.iPh.c(this.gIU);
        }
        this.iPh.a(this.iPm);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.iPi, readCacheRespMsg.getData().get(0));
        }
        this.iPl = null;
        this.iPi.reset();
        this.iPj.setNeedCache(true);
        this.iPj.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.iPh.cqR();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgAtme(0);
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
            this.iPh.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.iPh.cqR();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgAtme(0);
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
            this.iPh.a(errorData);
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

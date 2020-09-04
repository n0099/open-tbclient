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
/* loaded from: classes16.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener dUy;
    private com.baidu.tbadk.mvc.d.a hou;
    private AtMessageActivity jDL;
    private b jDM;
    private AtMeNetModel jDN;
    private AtMeCacheModel jDO;
    private FeedData jDP;
    private f jDQ;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.dUy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.jDL.cJC();
                }
            }
        };
        this.jDL = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.jDM = new b();
        this.jDN = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.jDL.getPageContext().getPageActivity()), this.jDM);
        this.jDN.a(this);
        if (this.jDL != null) {
            this.jDN.setUniqueId(this.jDL.getUniqueId());
        }
        this.jDN.registerListener(this.dUy);
        this.jDO = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.jDL.getPageContext().getPageActivity()));
        this.jDO.a(this);
        if (this.jDL != null) {
            this.jDO.setUniqueId(this.jDL.getUniqueId());
        }
        this.jDQ = new f();
        this.hou = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ccJ() {
        if (!this.jDN.isLoading() && this.hou.btK() && cJB()) {
            this.hou.jy(true);
            this.hou.jA(true);
            this.jDM.e(this.jDP);
            this.jDN.setNeedCache(false);
            this.jDN.loadData();
            this.jDL.c(this.hou);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crs() {
        if (this.jDN.isLoading() || !cJB()) {
            return false;
        }
        this.jDP = null;
        this.jDM.reset();
        this.jDN.setNeedCache(true);
        this.jDN.loadData();
        return true;
    }

    protected boolean cJB() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jDQ != null && this.jDQ.jFm != null) {
            this.jDQ.jFm.clear();
        }
        this.jDL.cJC();
        this.jDL.a(this.jDQ);
        return false;
    }

    public boolean ccI() {
        if (cJB()) {
            if (this.jDL != null) {
                this.jDL.cJD();
            }
            this.jDO.a((com.baidu.tbadk.mvc.b.e) this.jDM);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.jDQ.cJT().clear();
        }
        this.jDQ.a(cVar);
        if (cVar != null && cVar.cJT() != null && cVar.cJT().size() > 0) {
            this.jDP = cVar.cJT().get(cVar.cJT().size() - 1);
            if (this.jDQ.getPage() != null) {
                this.hou.jz(this.jDQ.getPage().bdu() == 1);
            } else {
                this.hou.jz(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.hou.jA(true);
        } else {
            this.jDP = null;
            this.hou.jz(false);
            this.hou.jA(false);
        }
        this.hou.jy(false);
        this.hou.jx(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boj();
        if (!TbadkCoreApplication.isLogin()) {
            this.jDQ.cJT().clear();
        } else {
            this.jDL.c(this.hou);
        }
        this.jDL.a(this.jDQ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jDM, readCacheRespMsg.getData().get(0));
        }
        this.jDP = null;
        this.jDM.reset();
        this.jDN.setNeedCache(true);
        this.jDN.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jDL.cJC();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgAtme(0);
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
            this.jDL.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jDL.cJC();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgAtme(0);
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
            this.jDL.a(errorData);
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

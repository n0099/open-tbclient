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
    final CustomMessageListener dkS;
    private com.baidu.tbadk.mvc.d.a gtS;
    private AtMessageActivity izH;
    private b izI;
    private AtMeNetModel izJ;
    private AtMeCacheModel izK;
    private FeedData izL;
    private f izM;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.T(atMessageActivity.getPageContext().getPageActivity()));
        this.dkS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.izH.ckl();
                }
            }
        };
        this.izH = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.izI = new b();
        this.izJ = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.T(this.izH.getPageContext().getPageActivity()), this.izI);
        this.izJ.a(this);
        if (this.izH != null) {
            this.izJ.setUniqueId(this.izH.getUniqueId());
        }
        this.izJ.registerListener(this.dkS);
        this.izK = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.T(this.izH.getPageContext().getPageActivity()));
        this.izK.a(this);
        if (this.izH != null) {
            this.izK.setUniqueId(this.izH.getUniqueId());
        }
        this.izM = new f();
        this.gtS = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bFG() {
        if (!this.izJ.isLoading() && this.gtS.aYY() && ckk()) {
            this.gtS.hO(true);
            this.gtS.hQ(true);
            this.izI.d(this.izL);
            this.izJ.setNeedCache(false);
            this.izJ.loadData();
            this.izH.c(this.gtS);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bTv() {
        if (this.izJ.isLoading() || !ckk()) {
            return false;
        }
        this.izL = null;
        this.izI.reset();
        this.izJ.setNeedCache(true);
        this.izJ.loadData();
        return true;
    }

    protected boolean ckk() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.izM != null && this.izM.iAI != null) {
            this.izM.iAI.clear();
        }
        this.izH.ckl();
        this.izH.a(this.izM);
        return false;
    }

    public boolean bFF() {
        if (ckk()) {
            if (this.izH != null) {
                this.izH.ckm();
            }
            this.izK.a((com.baidu.tbadk.mvc.b.e) this.izI);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.izM.ckE().clear();
        }
        this.izM.a(cVar);
        if (cVar != null && cVar.ckE() != null && cVar.ckE().size() > 0) {
            this.izL = cVar.ckE().get(cVar.ckE().size() - 1);
            if (this.izM.getPage() != null) {
                this.gtS.hP(this.izM.getPage().aJA() == 1);
            } else {
                this.gtS.hP(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.gtS.hQ(true);
        } else {
            this.izL = null;
            this.gtS.hP(false);
            this.gtS.hQ(false);
        }
        this.gtS.hO(false);
        this.gtS.hN(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aTg().aTv();
        if (!TbadkCoreApplication.isLogin()) {
            this.izM.ckE().clear();
        } else {
            this.izH.c(this.gtS);
        }
        this.izH.a(this.izM);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.izI, readCacheRespMsg.getData().get(0));
        }
        this.izL = null;
        this.izI.reset();
        this.izJ.setNeedCache(true);
        this.izJ.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.izH.ckl();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aTg().setMsgAtme(0);
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
            this.izH.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.izH.ckl();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aTg().setMsgAtme(0);
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
            this.izH.a(errorData);
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

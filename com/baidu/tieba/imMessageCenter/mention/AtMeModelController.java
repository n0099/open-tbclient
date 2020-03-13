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
    final CustomMessageListener cLz;
    private com.baidu.tbadk.mvc.d.a fOD;
    private AtMessageActivity hOq;
    private b hOr;
    private AtMeNetModel hOs;
    private AtMeCacheModel hOt;
    private FeedData hOu;
    private f hOv;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.cLz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.hOq.bZs();
                }
            }
        };
        this.hOq = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.hOr = new b();
        this.hOs = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.hOq.getPageContext().getPageActivity()), this.hOr);
        this.hOs.a(this);
        if (this.hOq != null) {
            this.hOs.setUniqueId(this.hOq.getUniqueId());
        }
        this.hOs.registerListener(this.cLz);
        this.hOt = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.hOq.getPageContext().getPageActivity()));
        this.hOt.a(this);
        if (this.hOq != null) {
            this.hOt.setUniqueId(this.hOq.getUniqueId());
        }
        this.hOv = new f();
        this.fOD = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bvQ() {
        if (!this.hOs.isLoading() && this.fOD.aQK() && bZr()) {
            this.fOD.gP(true);
            this.fOD.gR(true);
            this.hOr.d(this.hOu);
            this.hOs.setNeedCache(false);
            this.hOs.loadData();
            this.hOq.c(this.fOD);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bIM() {
        if (this.hOs.isLoading() || !bZr()) {
            return false;
        }
        this.hOu = null;
        this.hOr.reset();
        this.hOs.setNeedCache(true);
        this.hOs.loadData();
        return true;
    }

    protected boolean bZr() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hOv != null && this.hOv.hPr != null) {
            this.hOv.hPr.clear();
        }
        this.hOq.bZs();
        this.hOq.a(this.hOv);
        return false;
    }

    public boolean bvP() {
        if (bZr()) {
            if (this.hOq != null) {
                this.hOq.bZt();
            }
            this.hOt.a((com.baidu.tbadk.mvc.b.e) this.hOr);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.hOv.bZL().clear();
        }
        this.hOv.a(cVar);
        if (cVar != null && cVar.bZL() != null && cVar.bZL().size() > 0) {
            this.hOu = cVar.bZL().get(cVar.bZL().size() - 1);
            if (this.hOv.getPage() != null) {
                this.fOD.gQ(this.hOv.getPage().aBk() == 1);
            } else {
                this.fOD.gQ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.fOD.gR(true);
        } else {
            this.hOu = null;
            this.fOD.gQ(false);
            this.fOD.gR(false);
        }
        this.fOD.gP(false);
        this.fOD.gO(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aKU();
        if (!TbadkCoreApplication.isLogin()) {
            this.hOv.bZL().clear();
        } else {
            this.hOq.c(this.fOD);
        }
        this.hOq.a(this.hOv);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hOr, readCacheRespMsg.getData().get(0));
        }
        this.hOu = null;
        this.hOr.reset();
        this.hOs.setNeedCache(true);
        this.hOs.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hOq.bZs();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKF().setMsgAtme(0);
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
            this.hOq.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hOq.bZs();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKF().setMsgAtme(0);
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
            this.hOq.a(errorData);
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

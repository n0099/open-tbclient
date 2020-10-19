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
    final CustomMessageListener eiK;
    private com.baidu.tbadk.mvc.d.a hKt;
    private AtMessageActivity kbl;
    private b kbm;
    private AtMeNetModel kbn;
    private AtMeCacheModel kbo;
    private FeedData kbp;
    private f kbq;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kbl.cQQ();
                }
            }
        };
        this.kbl = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kbm = new b();
        this.kbn = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.kbl.getPageContext().getPageActivity()), this.kbm);
        this.kbn.a(this);
        if (this.kbl != null) {
            this.kbn.setUniqueId(this.kbl.getUniqueId());
        }
        this.kbn.registerListener(this.eiK);
        this.kbo = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.kbl.getPageContext().getPageActivity()));
        this.kbo.a(this);
        if (this.kbl != null) {
            this.kbo.setUniqueId(this.kbl.getUniqueId());
        }
        this.kbq = new f();
        this.hKt = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cju() {
        if (!this.kbn.isLoading() && this.hKt.bxy() && cQP()) {
            this.hKt.jX(true);
            this.hKt.jZ(true);
            this.kbm.e(this.kbp);
            this.kbn.setNeedCache(false);
            this.kbn.loadData();
            this.kbl.c(this.hKt);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cye() {
        if (this.kbn.isLoading() || !cQP()) {
            return false;
        }
        this.kbp = null;
        this.kbm.reset();
        this.kbn.setNeedCache(true);
        this.kbn.loadData();
        return true;
    }

    protected boolean cQP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kbq != null && this.kbq.kcM != null) {
            this.kbq.kcM.clear();
        }
        this.kbl.cQQ();
        this.kbl.a(this.kbq);
        return false;
    }

    public boolean cjt() {
        if (cQP()) {
            if (this.kbl != null) {
                this.kbl.cQR();
            }
            this.kbo.a((com.baidu.tbadk.mvc.b.e) this.kbm);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.kbq.cRh().clear();
        }
        this.kbq.a(cVar);
        if (cVar != null && cVar.cRh() != null && cVar.cRh().size() > 0) {
            this.kbp = cVar.cRh().get(cVar.cRh().size() - 1);
            if (this.kbq.getPage() != null) {
                this.hKt.jY(this.kbq.getPage().bgX() == 1);
            } else {
                this.hKt.jY(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.hKt.jZ(true);
        } else {
            this.kbp = null;
            this.hKt.jY(false);
            this.hKt.jZ(false);
        }
        this.hKt.jX(false);
        this.hKt.jW(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.brz().brN();
        if (!TbadkCoreApplication.isLogin()) {
            this.kbq.cRh().clear();
        } else {
            this.kbl.c(this.hKt);
        }
        this.kbl.a(this.kbq);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kbm, readCacheRespMsg.getData().get(0));
        }
        this.kbp = null;
        this.kbm.reset();
        this.kbn.setNeedCache(true);
        this.kbn.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kbl.cQQ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgAtme(0);
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
            this.kbl.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kbl.cQQ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgAtme(0);
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
            this.kbl.a(errorData);
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

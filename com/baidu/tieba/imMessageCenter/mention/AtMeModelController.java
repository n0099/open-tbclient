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
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener bVI;
    private com.baidu.tbadk.mvc.d.a eUS;
    private AtMessageActivity gVq;
    private b gVr;
    private AtMeNetModel gVs;
    private AtMeCacheModel gVt;
    private FeedData gVu;
    private f gVv;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gVq.bFv();
                }
            }
        };
        this.gVq = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gVr = new b();
        this.gVs = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gVq.getPageContext().getPageActivity()), this.gVr);
        this.gVs.a(this);
        if (this.gVq != null) {
            this.gVs.setUniqueId(this.gVq.getUniqueId());
        }
        this.gVs.registerListener(this.bVI);
        this.gVt = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gVq.getPageContext().getPageActivity()));
        this.gVt.a(this);
        if (this.gVq != null) {
            this.gVt.setUniqueId(this.gVq.getUniqueId());
        }
        this.gVv = new f();
        this.eUS = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bbL() {
        if (!this.gVs.isLoading() && this.eUS.awr() && bFu()) {
            this.eUS.fs(true);
            this.eUS.fu(true);
            this.gVr.d(this.gVu);
            this.gVs.setNeedCache(false);
            this.gVs.loadData();
            this.gVq.c(this.eUS);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boL() {
        if (this.gVs.isLoading() || !bFu()) {
            return false;
        }
        this.gVu = null;
        this.gVr.reset();
        this.gVs.setNeedCache(true);
        this.gVs.loadData();
        return true;
    }

    protected boolean bFu() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gVv != null && this.gVv.gWq != null) {
            this.gVv.gWq.clear();
        }
        this.gVq.bFv();
        this.gVq.a(this.gVv);
        return false;
    }

    public boolean bbK() {
        if (bFu()) {
            if (this.gVq != null) {
                this.gVq.bFw();
            }
            this.gVt.a((com.baidu.tbadk.mvc.b.e) this.gVr);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gVv.bFO().clear();
        }
        this.gVv.a(cVar);
        if (cVar != null && cVar.bFO() != null && cVar.bFO().size() > 0) {
            this.gVu = cVar.bFO().get(cVar.bFO().size() - 1);
            if (this.gVv.getPage() != null) {
                this.eUS.ft(this.gVv.getPage().ahA() == 1);
            } else {
                this.eUS.ft(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eUS.fu(true);
        } else {
            this.gVu = null;
            this.eUS.ft(false);
            this.eUS.fu(false);
        }
        this.eUS.fs(false);
        this.eUS.fr(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqI();
        if (!TbadkCoreApplication.isLogin()) {
            this.gVv.bFO().clear();
        } else {
            this.gVq.c(this.eUS);
        }
        this.gVq.a(this.gVv);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gVr, readCacheRespMsg.getData().get(0));
        }
        this.gVu = null;
        this.gVr.reset();
        this.gVs.setNeedCache(true);
        this.gVs.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gVq.bFv();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aqt().setMsgAtme(0);
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
            this.gVq.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gVq.bFv();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aqt().setMsgAtme(0);
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
            this.gVq.a(errorData);
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

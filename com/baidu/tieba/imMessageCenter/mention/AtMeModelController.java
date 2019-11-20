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
    final CustomMessageListener bUR;
    private com.baidu.tbadk.mvc.d.a eUb;
    private b gUA;
    private AtMeNetModel gUB;
    private AtMeCacheModel gUC;
    private FeedData gUD;
    private f gUE;
    private AtMessageActivity gUz;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gUz.bFt();
                }
            }
        };
        this.gUz = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gUA = new b();
        this.gUB = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gUz.getPageContext().getPageActivity()), this.gUA);
        this.gUB.a(this);
        if (this.gUz != null) {
            this.gUB.setUniqueId(this.gUz.getUniqueId());
        }
        this.gUB.registerListener(this.bUR);
        this.gUC = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gUz.getPageContext().getPageActivity()));
        this.gUC.a(this);
        if (this.gUz != null) {
            this.gUC.setUniqueId(this.gUz.getUniqueId());
        }
        this.gUE = new f();
        this.eUb = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bbJ() {
        if (!this.gUB.isLoading() && this.eUb.awp() && bFs()) {
            this.eUb.fs(true);
            this.eUb.fu(true);
            this.gUA.d(this.gUD);
            this.gUB.setNeedCache(false);
            this.gUB.loadData();
            this.gUz.c(this.eUb);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boJ() {
        if (this.gUB.isLoading() || !bFs()) {
            return false;
        }
        this.gUD = null;
        this.gUA.reset();
        this.gUB.setNeedCache(true);
        this.gUB.loadData();
        return true;
    }

    protected boolean bFs() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gUE != null && this.gUE.gVz != null) {
            this.gUE.gVz.clear();
        }
        this.gUz.bFt();
        this.gUz.a(this.gUE);
        return false;
    }

    public boolean bbI() {
        if (bFs()) {
            if (this.gUz != null) {
                this.gUz.bFu();
            }
            this.gUC.a((com.baidu.tbadk.mvc.b.e) this.gUA);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gUE.bFM().clear();
        }
        this.gUE.a(cVar);
        if (cVar != null && cVar.bFM() != null && cVar.bFM().size() > 0) {
            this.gUD = cVar.bFM().get(cVar.bFM().size() - 1);
            if (this.gUE.getPage() != null) {
                this.eUb.ft(this.gUE.getPage().ahy() == 1);
            } else {
                this.eUb.ft(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eUb.fu(true);
        } else {
            this.gUD = null;
            this.eUb.ft(false);
            this.eUb.fu(false);
        }
        this.eUb.fs(false);
        this.eUb.fr(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqG();
        if (!TbadkCoreApplication.isLogin()) {
            this.gUE.bFM().clear();
        } else {
            this.gUz.c(this.eUb);
        }
        this.gUz.a(this.gUE);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gUA, readCacheRespMsg.getData().get(0));
        }
        this.gUD = null;
        this.gUA.reset();
        this.gUB.setNeedCache(true);
        this.gUB.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gUz.bFt();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aqr().setMsgAtme(0);
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
            this.gUz.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gUz.bFt();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aqr().setMsgAtme(0);
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
            this.gUz.a(errorData);
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

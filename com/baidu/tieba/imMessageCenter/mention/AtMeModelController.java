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
/* loaded from: classes21.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener evs;
    private com.baidu.tbadk.mvc.d.a idG;
    private AtMessageActivity kuq;
    private b kur;
    private AtMeNetModel kus;
    private AtMeCacheModel kut;
    private FeedData kuu;
    private f kuv;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.evs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kuq.cWe();
                }
            }
        };
        this.kuq = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kur = new b();
        this.kus = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.kuq.getPageContext().getPageActivity()), this.kur);
        this.kus.a(this);
        if (this.kuq != null) {
            this.kus.setUniqueId(this.kuq.getUniqueId());
        }
        this.kus.registerListener(this.evs);
        this.kut = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.kuq.getPageContext().getPageActivity()));
        this.kut.a(this);
        if (this.kuq != null) {
            this.kut.setUniqueId(this.kuq.getUniqueId());
        }
        this.kuv = new f();
        this.idG = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean coD() {
        if (!this.kus.isLoading() && this.idG.bBg() && cWd()) {
            this.idG.ku(true);
            this.idG.kw(true);
            this.kur.e(this.kuu);
            this.kus.setNeedCache(false);
            this.kus.loadData();
            this.kuq.c(this.idG);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cDq() {
        if (this.kus.isLoading() || !cWd()) {
            return false;
        }
        this.kuu = null;
        this.kur.reset();
        this.kus.setNeedCache(true);
        this.kus.loadData();
        return true;
    }

    protected boolean cWd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kuv != null && this.kuv.kvR != null) {
            this.kuv.kvR.clear();
        }
        this.kuq.cWe();
        this.kuq.a(this.kuv);
        return false;
    }

    public boolean coC() {
        if (cWd()) {
            if (this.kuq != null) {
                this.kuq.cWf();
            }
            this.kut.a((com.baidu.tbadk.mvc.b.e) this.kur);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kuq.VB();
        if (bVar.getUpdateType() != 4) {
            this.kuv.cWv().clear();
        }
        this.kuv.a(cVar);
        if (cVar != null && cVar.cWv() != null && cVar.cWv().size() > 0) {
            this.kuu = cVar.cWv().get(cVar.cWv().size() - 1);
            if (this.kuv.getPage() != null) {
                this.idG.kv(this.kuv.getPage().bks() == 1);
            } else {
                this.idG.kv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.idG.kw(true);
        } else {
            this.kuu = null;
            this.idG.kv(false);
            this.idG.kw(false);
        }
        this.idG.ku(false);
        this.idG.kt(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvw();
        if (!TbadkCoreApplication.isLogin()) {
            this.kuv.cWv().clear();
        } else {
            this.kuq.c(this.idG);
        }
        this.kuq.a(this.kuv);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kur, readCacheRespMsg.getData().get(0));
        }
        this.kuu = null;
        this.kur.reset();
        this.kus.setNeedCache(true);
        this.kus.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kuq.cWe();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgAtme(0);
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
            this.kuq.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.kuq.cWe();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgAtme(0);
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
            this.kuq.a(errorData);
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

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
/* loaded from: classes7.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener cHu;
    private com.baidu.tbadk.mvc.d.a fLS;
    private AtMessageActivity hMe;
    private b hMf;
    private AtMeNetModel hMg;
    private AtMeCacheModel hMh;
    private FeedData hMi;
    private f hMj;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.cHu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.hMe.bXO();
                }
            }
        };
        this.hMe = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.hMf = new b();
        this.hMg = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.hMe.getPageContext().getPageActivity()), this.hMf);
        this.hMg.a(this);
        if (this.hMe != null) {
            this.hMg.setUniqueId(this.hMe.getUniqueId());
        }
        this.hMg.registerListener(this.cHu);
        this.hMh = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.hMe.getPageContext().getPageActivity()));
        this.hMh.a(this);
        if (this.hMe != null) {
            this.hMh.setUniqueId(this.hMe.getUniqueId());
        }
        this.hMj = new f();
        this.fLS = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean buj() {
        if (!this.hMg.isLoading() && this.fLS.aOs() && bXN()) {
            this.fLS.gI(true);
            this.fLS.gK(true);
            this.hMf.d(this.hMi);
            this.hMg.setNeedCache(false);
            this.hMg.loadData();
            this.hMe.c(this.fLS);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bHi() {
        if (this.hMg.isLoading() || !bXN()) {
            return false;
        }
        this.hMi = null;
        this.hMf.reset();
        this.hMg.setNeedCache(true);
        this.hMg.loadData();
        return true;
    }

    protected boolean bXN() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hMj != null && this.hMj.hNf != null) {
            this.hMj.hNf.clear();
        }
        this.hMe.bXO();
        this.hMe.a(this.hMj);
        return false;
    }

    public boolean bui() {
        if (bXN()) {
            if (this.hMe != null) {
                this.hMe.bXP();
            }
            this.hMh.a((com.baidu.tbadk.mvc.b.e) this.hMf);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.hMj.bYh().clear();
        }
        this.hMj.a(cVar);
        if (cVar != null && cVar.bYh() != null && cVar.bYh().size() > 0) {
            this.hMi = cVar.bYh().get(cVar.bYh().size() - 1);
            if (this.hMj.getPage() != null) {
                this.fLS.gJ(this.hMj.getPage().ayR() == 1);
            } else {
                this.fLS.gJ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.fLS.gK(true);
        } else {
            this.hMi = null;
            this.fLS.gJ(false);
            this.fLS.gK(false);
        }
        this.fLS.gI(false);
        this.fLS.gH(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIy();
        if (!TbadkCoreApplication.isLogin()) {
            this.hMj.bYh().clear();
        } else {
            this.hMe.c(this.fLS);
        }
        this.hMe.a(this.hMj);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hMf, readCacheRespMsg.getData().get(0));
        }
        this.hMi = null;
        this.hMf.reset();
        this.hMg.setNeedCache(true);
        this.hMg.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hMe.bXO();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgAtme(0);
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
            this.hMe.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hMe.bXO();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgAtme(0);
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
            this.hMe.a(errorData);
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

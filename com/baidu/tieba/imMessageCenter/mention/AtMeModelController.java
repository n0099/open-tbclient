package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
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
/* loaded from: classes2.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a deU;
    private AtMessageActivity eSg;
    private b eSh;
    private AtMeNetModel eSi;
    private AtMeCacheModel eSj;
    private FeedData eSk;
    private f eSl;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ak(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eSg.aNu();
                }
            }
        };
        this.eSg = atMessageActivity;
    }

    public void l(Bundle bundle) {
        this.eSh = new b();
        this.eSi = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eSg.getPageContext().getPageActivity()), this.eSh);
        this.eSi.a(this);
        if (this.eSg != null) {
            this.eSi.setUniqueId(this.eSg.getUniqueId());
        }
        this.eSi.registerListener(this.mNetworkChangedMessageListener);
        this.eSj = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eSg.getPageContext().getPageActivity()));
        this.eSj.a(this);
        if (this.eSg != null) {
            this.eSj.setUniqueId(this.eSg.getUniqueId());
        }
        this.eSl = new f();
        this.deU = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amN() {
        if (!this.eSi.El() && this.deU.NE() && aNt()) {
            this.deU.cu(true);
            this.deU.cw(true);
            this.eSh.d(this.eSk);
            this.eSi.setNeedCache(false);
            this.eSi.Nw();
            this.eSg.b(this.deU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNs() {
        if (this.eSi.El() || !aNt()) {
            return false;
        }
        this.eSk = null;
        this.eSh.reset();
        this.eSi.setNeedCache(true);
        this.eSi.Nw();
        return true;
    }

    protected boolean aNt() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eSl != null && this.eSl.eSV != null) {
            this.eSl.eSV.clear();
        }
        this.eSg.aNu();
        this.eSg.a(this.eSl);
        return false;
    }

    public boolean amM() {
        if (aNt()) {
            if (this.eSg != null) {
                this.eSg.aNv();
            }
            this.eSj.a((com.baidu.tbadk.mvc.b.e) this.eSh);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eSl.aNF().clear();
        }
        this.eSl.a(cVar);
        if (cVar != null && cVar.aNF() != null && cVar.aNF().size() > 0) {
            this.eSk = cVar.aNF().get(cVar.aNF().size() - 1);
            if (this.eSl.yA() != null) {
                this.deU.cv(this.eSl.yA().yw() == 1);
            } else {
                this.deU.cv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.deU.cw(true);
        } else {
            this.eSk = null;
            this.deU.cv(false);
            this.deU.cw(false);
        }
        this.deU.cu(false);
        this.deU.ct(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GY();
        if (!TbadkCoreApplication.isLogin()) {
            this.eSl.aNF().clear();
        } else {
            this.eSg.b(this.deU);
        }
        this.eSg.a(this.eSl);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eSh, readCacheRespMsg.getData().get(0));
        }
        this.eSk = null;
        this.eSh.reset();
        this.eSi.setNeedCache(true);
        this.eSi.Nw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eSg.aNu();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgAtme(0);
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
            this.eSg.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eSg.aNu();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgAtme(0);
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
            this.eSg.a(errorData);
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

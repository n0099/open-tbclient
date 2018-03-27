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
    private com.baidu.tbadk.mvc.d.a deL;
    private AtMessageActivity eSj;
    private b eSk;
    private AtMeNetModel eSl;
    private AtMeCacheModel eSm;
    private FeedData eSn;
    private f eSo;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ak(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eSj.aNu();
                }
            }
        };
        this.eSj = atMessageActivity;
    }

    public void l(Bundle bundle) {
        this.eSk = new b();
        this.eSl = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eSj.getPageContext().getPageActivity()), this.eSk);
        this.eSl.a(this);
        if (this.eSj != null) {
            this.eSl.setUniqueId(this.eSj.getUniqueId());
        }
        this.eSl.registerListener(this.mNetworkChangedMessageListener);
        this.eSm = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eSj.getPageContext().getPageActivity()));
        this.eSm.a(this);
        if (this.eSj != null) {
            this.eSm.setUniqueId(this.eSj.getUniqueId());
        }
        this.eSo = new f();
        this.deL = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amN() {
        if (!this.eSl.El() && this.deL.NE() && aNt()) {
            this.deL.cu(true);
            this.deL.cw(true);
            this.eSk.d(this.eSn);
            this.eSl.setNeedCache(false);
            this.eSl.Nw();
            this.eSj.b(this.deL);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNs() {
        if (this.eSl.El() || !aNt()) {
            return false;
        }
        this.eSn = null;
        this.eSk.reset();
        this.eSl.setNeedCache(true);
        this.eSl.Nw();
        return true;
    }

    protected boolean aNt() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eSo != null && this.eSo.eSY != null) {
            this.eSo.eSY.clear();
        }
        this.eSj.aNu();
        this.eSj.a(this.eSo);
        return false;
    }

    public boolean amM() {
        if (aNt()) {
            if (this.eSj != null) {
                this.eSj.aNv();
            }
            this.eSm.a((com.baidu.tbadk.mvc.b.e) this.eSk);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eSo.aNF().clear();
        }
        this.eSo.a(cVar);
        if (cVar != null && cVar.aNF() != null && cVar.aNF().size() > 0) {
            this.eSn = cVar.aNF().get(cVar.aNF().size() - 1);
            if (this.eSo.yA() != null) {
                this.deL.cv(this.eSo.yA().yw() == 1);
            } else {
                this.deL.cv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.deL.cw(true);
        } else {
            this.eSn = null;
            this.deL.cv(false);
            this.deL.cw(false);
        }
        this.deL.cu(false);
        this.deL.ct(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GY();
        if (!TbadkCoreApplication.isLogin()) {
            this.eSo.aNF().clear();
        } else {
            this.eSj.b(this.deL);
        }
        this.eSj.a(this.eSo);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eSk, readCacheRespMsg.getData().get(0));
        }
        this.eSn = null;
        this.eSk.reset();
        this.eSl.setNeedCache(true);
        this.eSl.Nw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eSj.aNu();
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
            this.eSj.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eSj.aNu();
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
            this.eSj.a(errorData);
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

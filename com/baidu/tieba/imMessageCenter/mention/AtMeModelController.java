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
    private com.baidu.tbadk.mvc.d.a bRX;
    private AtMessageActivity dJk;
    private b dJl;
    private AtMeNetModel dJm;
    private AtMeCacheModel dJn;
    private FeedData dJo;
    private f dJp;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dJk.aAA();
                }
            }
        };
        this.dJk = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dJl = new b();
        this.dJm = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dJk.getPageContext().getPageActivity()), this.dJl);
        this.dJm.a(this);
        if (this.dJk != null) {
            this.dJm.setUniqueId(this.dJk.getUniqueId());
        }
        this.dJm.registerListener(this.mNetworkChangedMessageListener);
        this.dJn = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dJk.getPageContext().getPageActivity()));
        this.dJn.a(this);
        if (this.dJk != null) {
            this.dJn.setUniqueId(this.dJk.getUniqueId());
        }
        this.dJp = new f();
        this.bRX = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zc() {
        if (!this.dJm.ws() && this.bRX.Fd() && aAz()) {
            this.bRX.bS(true);
            this.bRX.bU(true);
            this.dJl.g(this.dJo);
            this.dJm.setNeedCache(false);
            this.dJm.ET();
            this.dJk.b(this.bRX);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aAy() {
        if (this.dJm.ws() || !aAz()) {
            return false;
        }
        this.dJo = null;
        this.dJl.reset();
        this.dJm.setNeedCache(true);
        this.dJm.ET();
        return true;
    }

    protected boolean aAz() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dJp != null && this.dJp.dJX != null) {
            this.dJp.dJX.clear();
        }
        this.dJk.aAA();
        this.dJk.a(this.dJp);
        return false;
    }

    public boolean Zb() {
        if (aAz()) {
            if (this.dJk != null) {
                this.dJk.aAB();
            }
            this.dJn.a((com.baidu.tbadk.mvc.b.e) this.dJl);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dJp.aAI().clear();
        }
        this.dJp.a(cVar);
        if (cVar != null && cVar.aAI() != null && cVar.aAI().size() > 0) {
            this.dJo = cVar.aAI().get(cVar.aAI().size() - 1);
            if (this.dJp.qq() != null) {
                this.bRX.bT(this.dJp.qq().qm() == 1);
            } else {
                this.bRX.bT(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bRX.bU(true);
        } else {
            this.dJo = null;
            this.bRX.bT(false);
            this.bRX.bU(false);
        }
        this.bRX.bS(false);
        this.bRX.bR(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yv().yL();
        if (!TbadkCoreApplication.isLogin()) {
            this.dJp.aAI().clear();
        } else {
            this.dJk.b(this.bRX);
        }
        this.dJk.a(this.dJp);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dJl, readCacheRespMsg.getData().get(0));
        }
        this.dJo = null;
        this.dJl.reset();
        this.dJm.setNeedCache(true);
        this.dJm.ET();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dJk.aAA();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgAtme(0);
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
            this.dJk.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dJk.aAA();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgAtme(0);
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
            this.dJk.a(errorData);
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

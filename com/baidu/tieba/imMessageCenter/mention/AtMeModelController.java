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
    private com.baidu.tbadk.mvc.d.a bSy;
    private AtMessageActivity dNg;
    private b dNh;
    private AtMeNetModel dNi;
    private AtMeCacheModel dNj;
    private FeedData dNk;
    private f dNl;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dNg.aBU();
                }
            }
        };
        this.dNg = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dNh = new b();
        this.dNi = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dNg.getPageContext().getPageActivity()), this.dNh);
        this.dNi.a(this);
        if (this.dNg != null) {
            this.dNi.setUniqueId(this.dNg.getUniqueId());
        }
        this.dNi.registerListener(this.mNetworkChangedMessageListener);
        this.dNj = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dNg.getPageContext().getPageActivity()));
        this.dNj.a(this);
        if (this.dNg != null) {
            this.dNj.setUniqueId(this.dNg.getUniqueId());
        }
        this.dNl = new f();
        this.bSy = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zv() {
        if (!this.dNi.xa() && this.bSy.FE() && aBT()) {
            this.bSy.bU(true);
            this.bSy.bW(true);
            this.dNh.h(this.dNk);
            this.dNi.setNeedCache(false);
            this.dNi.Fu();
            this.dNg.b(this.bSy);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aBS() {
        if (this.dNi.xa() || !aBT()) {
            return false;
        }
        this.dNk = null;
        this.dNh.reset();
        this.dNi.setNeedCache(true);
        this.dNi.Fu();
        return true;
    }

    protected boolean aBT() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dNl != null && this.dNl.dNT != null) {
            this.dNl.dNT.clear();
        }
        this.dNg.aBU();
        this.dNg.a(this.dNl);
        return false;
    }

    public boolean Zu() {
        if (aBT()) {
            if (this.dNg != null) {
                this.dNg.aBV();
            }
            this.dNj.a((com.baidu.tbadk.mvc.b.e) this.dNh);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dNl.aCc().clear();
        }
        this.dNl.a(cVar);
        if (cVar != null && cVar.aCc() != null && cVar.aCc().size() > 0) {
            this.dNk = cVar.aCc().get(cVar.aCc().size() - 1);
            if (this.dNl.qD() != null) {
                this.bSy.bV(this.dNl.qD().qz() == 1);
            } else {
                this.bSy.bV(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bSy.bW(true);
        } else {
            this.dNk = null;
            this.bSy.bV(false);
            this.bSy.bW(false);
        }
        this.bSy.bU(false);
        this.bSy.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zt();
        if (!TbadkCoreApplication.isLogin()) {
            this.dNl.aCc().clear();
        } else {
            this.dNg.b(this.bSy);
        }
        this.dNg.a(this.dNl);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dNh, readCacheRespMsg.getData().get(0));
        }
        this.dNk = null;
        this.dNh.reset();
        this.dNi.setNeedCache(true);
        this.dNi.Fu();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dNg.aBU();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgAtme(0);
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
            this.dNg.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dNg.aBU();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgAtme(0);
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
            this.dNg.a(errorData);
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

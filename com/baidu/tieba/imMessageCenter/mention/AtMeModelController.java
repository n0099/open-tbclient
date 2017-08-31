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
    private com.baidu.tbadk.mvc.d.a bRH;
    private AtMessageActivity dMm;
    private b dMn;
    private AtMeNetModel dMo;
    private AtMeCacheModel dMp;
    private FeedData dMq;
    private f dMr;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.X(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dMm.aBJ();
                }
            }
        };
        this.dMm = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dMn = new b();
        this.dMo = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.X(this.dMm.getPageContext().getPageActivity()), this.dMn);
        this.dMo.a(this);
        if (this.dMm != null) {
            this.dMo.setUniqueId(this.dMm.getUniqueId());
        }
        this.dMo.registerListener(this.mNetworkChangedMessageListener);
        this.dMp = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.X(this.dMm.getPageContext().getPageActivity()));
        this.dMp.a(this);
        if (this.dMm != null) {
            this.dMp.setUniqueId(this.dMm.getUniqueId());
        }
        this.dMr = new f();
        this.bRH = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zk() {
        if (!this.dMo.xa() && this.bRH.FE() && aBI()) {
            this.bRH.bU(true);
            this.bRH.bW(true);
            this.dMn.h(this.dMq);
            this.dMo.setNeedCache(false);
            this.dMo.Fu();
            this.dMm.b(this.bRH);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aBH() {
        if (this.dMo.xa() || !aBI()) {
            return false;
        }
        this.dMq = null;
        this.dMn.reset();
        this.dMo.setNeedCache(true);
        this.dMo.Fu();
        return true;
    }

    protected boolean aBI() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dMr != null && this.dMr.dMZ != null) {
            this.dMr.dMZ.clear();
        }
        this.dMm.aBJ();
        this.dMm.a(this.dMr);
        return false;
    }

    public boolean Zj() {
        if (aBI()) {
            if (this.dMm != null) {
                this.dMm.aBK();
            }
            this.dMp.a((com.baidu.tbadk.mvc.b.e) this.dMn);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dMr.aBR().clear();
        }
        this.dMr.a(cVar);
        if (cVar != null && cVar.aBR() != null && cVar.aBR().size() > 0) {
            this.dMq = cVar.aBR().get(cVar.aBR().size() - 1);
            if (this.dMr.qD() != null) {
                this.bRH.bV(this.dMr.qD().qz() == 1);
            } else {
                this.bRH.bV(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bRH.bW(true);
        } else {
            this.dMq = null;
            this.bRH.bV(false);
            this.bRH.bW(false);
        }
        this.bRH.bU(false);
        this.bRH.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zt();
        if (!TbadkCoreApplication.isLogin()) {
            this.dMr.aBR().clear();
        } else {
            this.dMm.b(this.bRH);
        }
        this.dMm.a(this.dMr);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dMn, readCacheRespMsg.getData().get(0));
        }
        this.dMq = null;
        this.dMn.reset();
        this.dMo.setNeedCache(true);
        this.dMo.Fu();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dMm.aBJ();
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
            this.dMm.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dMm.aBJ();
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
            this.dMm.a(errorData);
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

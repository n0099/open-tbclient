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
    private com.baidu.tbadk.mvc.d.a bSj;
    private AtMeNetModel dJA;
    private AtMeCacheModel dJB;
    private FeedData dJC;
    private f dJD;
    private AtMessageActivity dJy;
    private b dJz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dJy.aAF();
                }
            }
        };
        this.dJy = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.dJz = new b();
        this.dJA = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dJy.getPageContext().getPageActivity()), this.dJz);
        this.dJA.a(this);
        if (this.dJy != null) {
            this.dJA.setUniqueId(this.dJy.getUniqueId());
        }
        this.dJA.registerListener(this.mNetworkChangedMessageListener);
        this.dJB = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dJy.getPageContext().getPageActivity()));
        this.dJB.a(this);
        if (this.dJy != null) {
            this.dJB.setUniqueId(this.dJy.getUniqueId());
        }
        this.dJD = new f();
        this.bSj = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zg() {
        if (!this.dJA.wz() && this.bSj.Fj() && aAE()) {
            this.bSj.bT(true);
            this.bSj.bV(true);
            this.dJz.g(this.dJC);
            this.dJA.setNeedCache(false);
            this.dJA.EZ();
            this.dJy.b(this.bSj);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aAD() {
        if (this.dJA.wz() || !aAE()) {
            return false;
        }
        this.dJC = null;
        this.dJz.reset();
        this.dJA.setNeedCache(true);
        this.dJA.EZ();
        return true;
    }

    protected boolean aAE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dJD != null && this.dJD.dKl != null) {
            this.dJD.dKl.clear();
        }
        this.dJy.aAF();
        this.dJy.a(this.dJD);
        return false;
    }

    public boolean Zf() {
        if (aAE()) {
            if (this.dJy != null) {
                this.dJy.aAG();
            }
            this.dJB.a((com.baidu.tbadk.mvc.b.e) this.dJz);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dJD.aAN().clear();
        }
        this.dJD.a(cVar);
        if (cVar != null && cVar.aAN() != null && cVar.aAN().size() > 0) {
            this.dJC = cVar.aAN().get(cVar.aAN().size() - 1);
            if (this.dJD.qx() != null) {
                this.bSj.bU(this.dJD.qx().qt() == 1);
            } else {
                this.bSj.bU(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bSj.bV(true);
        } else {
            this.dJC = null;
            this.bSj.bU(false);
            this.bSj.bV(false);
        }
        this.bSj.bT(false);
        this.bSj.bS(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yB().yR();
        if (!TbadkCoreApplication.isLogin()) {
            this.dJD.aAN().clear();
        } else {
            this.dJy.b(this.bSj);
        }
        this.dJy.a(this.dJD);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dJz, readCacheRespMsg.getData().get(0));
        }
        this.dJC = null;
        this.dJz.reset();
        this.dJA.setNeedCache(true);
        this.dJA.EZ();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dJy.aAF();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgAtme(0);
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
            this.dJy.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dJy.aAF();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgAtme(0);
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
            this.dJy.a(errorData);
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

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
    private com.baidu.tbadk.mvc.d.a bZB;
    private AtMessageActivity dQX;
    private b dQY;
    private AtMeNetModel dQZ;
    private AtMeCacheModel dRa;
    private FeedData dRb;
    private f dRc;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dQX.aCV();
                }
            }
        };
        this.dQX = atMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dQY = new b();
        this.dQZ = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dQX.getPageContext().getPageActivity()), this.dQY);
        this.dQZ.a(this);
        if (this.dQX != null) {
            this.dQZ.setUniqueId(this.dQX.getUniqueId());
        }
        this.dQZ.registerListener(this.mNetworkChangedMessageListener);
        this.dRa = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dQX.getPageContext().getPageActivity()));
        this.dRa.a(this);
        if (this.dQX != null) {
            this.dRa.setUniqueId(this.dQX.getUniqueId());
        }
        this.dRc = new f();
        this.bZB = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean abm() {
        if (!this.dQZ.wz() && this.bZB.Fp() && aCU()) {
            this.bZB.bN(true);
            this.bZB.bP(true);
            this.dQY.g(this.dRb);
            this.dQZ.setNeedCache(false);
            this.dQZ.Ff();
            this.dQX.b(this.bZB);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aCT() {
        if (this.dQZ.wz() || !aCU()) {
            return false;
        }
        this.dRb = null;
        this.dQY.reset();
        this.dQZ.setNeedCache(true);
        this.dQZ.Ff();
        return true;
    }

    protected boolean aCU() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dRc != null && this.dRc.dRJ != null) {
            this.dRc.dRJ.clear();
        }
        this.dQX.aCV();
        this.dQX.a(this.dRc);
        return false;
    }

    public boolean abl() {
        if (aCU()) {
            if (this.dQX != null) {
                this.dQX.aCW();
            }
            this.dRa.a((com.baidu.tbadk.mvc.b.e) this.dQY);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dRc.aDd().clear();
        }
        this.dRc.a(cVar);
        if (cVar != null && cVar.aDd() != null && cVar.aDd().size() > 0) {
            this.dRb = cVar.aDd().get(cVar.aDd().size() - 1);
            if (this.dRc.qv() != null) {
                this.bZB.bO(this.dRc.qv().qr() == 1);
            } else {
                this.bZB.bO(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bZB.bP(true);
        } else {
            this.dRb = null;
            this.bZB.bO(false);
            this.bZB.bP(false);
        }
        this.bZB.bN(false);
        this.bZB.bM(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yC().yS();
        if (!TbadkCoreApplication.isLogin()) {
            this.dRc.aDd().clear();
        } else {
            this.dQX.b(this.bZB);
        }
        this.dQX.a(this.dRc);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dQY, readCacheRespMsg.getData().get(0));
        }
        this.dRb = null;
        this.dQY.reset();
        this.dQZ.setNeedCache(true);
        this.dQZ.Ff();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dQX.aCV();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgAtme(0);
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
            this.dQX.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dQX.aCV();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgAtme(0);
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
            this.dQX.a(errorData);
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

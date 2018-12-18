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
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a dcF;
    private AtMessageActivity fdE;
    private b fdF;
    private AtMeNetModel fdG;
    private AtMeCacheModel fdH;
    private FeedData fdI;
    private f fdJ;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.fdE.aVB();
                }
            }
        };
        this.fdE = atMessageActivity;
    }

    public void p(Bundle bundle) {
        this.fdF = new b();
        this.fdG = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.fdE.getPageContext().getPageActivity()), this.fdF);
        this.fdG.a(this);
        if (this.fdE != null) {
            this.fdG.setUniqueId(this.fdE.getUniqueId());
        }
        this.fdG.registerListener(this.mNetworkChangedMessageListener);
        this.fdH = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.fdE.getPageContext().getPageActivity()));
        this.fdH.a(this);
        if (this.fdE != null) {
            this.fdH.setUniqueId(this.fdE.getUniqueId());
        }
        this.fdJ = new f();
        this.dcF = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aqN() {
        if (!this.fdG.Fi() && this.dcF.OE() && aVA()) {
            this.dcF.cF(true);
            this.dcF.cH(true);
            this.fdF.d(this.fdI);
            this.fdG.setNeedCache(false);
            this.fdG.Ow();
            this.fdE.b(this.dcF);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aFL() {
        if (this.fdG.Fi() || !aVA()) {
            return false;
        }
        this.fdI = null;
        this.fdF.reset();
        this.fdG.setNeedCache(true);
        this.fdG.Ow();
        return true;
    }

    protected boolean aVA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.fdJ != null && this.fdJ.feH != null) {
            this.fdJ.feH.clear();
        }
        this.fdE.aVB();
        this.fdE.a(this.fdJ);
        return false;
    }

    public boolean aqM() {
        if (aVA()) {
            if (this.fdE != null) {
                this.fdE.aVC();
            }
            this.fdH.a((com.baidu.tbadk.mvc.b.e) this.fdF);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.fdJ.aVV().clear();
        }
        this.fdJ.a(cVar);
        if (cVar != null && cVar.aVV() != null && cVar.aVV().size() > 0) {
            this.fdI = cVar.aVV().get(cVar.aVV().size() - 1);
            if (this.fdJ.yS() != null) {
                this.dcF.cG(this.fdJ.yS().yP() == 1);
            } else {
                this.dcF.cG(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.dcF.cH(true);
        } else {
            this.fdI = null;
            this.dcF.cG(false);
            this.dcF.cH(false);
        }
        this.dcF.cF(false);
        this.dcF.cE(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.HP().Ie();
        if (!TbadkCoreApplication.isLogin()) {
            this.fdJ.aVV().clear();
        } else {
            this.fdE.b(this.dcF);
        }
        this.fdE.a(this.fdJ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.fdF, readCacheRespMsg.getData().get(0));
        }
        this.fdI = null;
        this.fdF.reset();
        this.fdG.setNeedCache(true);
        this.fdG.Ow();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fdE.aVB();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgAtme(0);
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
            this.fdE.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fdE.aVB();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgAtme(0);
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
            this.fdE.a(errorData);
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

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
    private com.baidu.tbadk.mvc.d.a eKD;
    private f gVA;
    private AtMessageActivity gVv;
    private b gVw;
    private AtMeNetModel gVx;
    private AtMeCacheModel gVy;
    private FeedData gVz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gVv.bHX();
                }
            }
        };
        this.gVv = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gVw = new b();
        this.gVx = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gVv.getPageContext().getPageActivity()), this.gVw);
        this.gVx.a(this);
        if (this.gVv != null) {
            this.gVx.setUniqueId(this.gVv.getUniqueId());
        }
        this.gVx.registerListener(this.mNetworkChangedMessageListener);
        this.gVy = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gVv.getPageContext().getPageActivity()));
        this.gVy.a(this);
        if (this.gVv != null) {
            this.gVy.setUniqueId(this.gVv.getUniqueId());
        }
        this.gVA = new f();
        this.eKD = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bbc() {
        if (!this.gVx.pP() && this.eKD.auN() && bHW()) {
            this.eKD.fy(true);
            this.eKD.fA(true);
            this.gVw.d(this.gVz);
            this.gVx.setNeedCache(false);
            this.gVx.auF();
            this.gVv.c(this.eKD);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqW() {
        if (this.gVx.pP() || !bHW()) {
            return false;
        }
        this.gVz = null;
        this.gVw.reset();
        this.gVx.setNeedCache(true);
        this.gVx.auF();
        return true;
    }

    protected boolean bHW() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gVA != null && this.gVA.gWv != null) {
            this.gVA.gWv.clear();
        }
        this.gVv.bHX();
        this.gVv.a(this.gVA);
        return false;
    }

    public boolean bbb() {
        if (bHW()) {
            if (this.gVv != null) {
                this.gVv.bHY();
            }
            this.gVy.a((com.baidu.tbadk.mvc.b.e) this.gVw);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gVA.bIq().clear();
        }
        this.gVA.a(cVar);
        if (cVar != null && cVar.bIq() != null && cVar.bIq().size() > 0) {
            this.gVz = cVar.bIq().get(cVar.bIq().size() - 1);
            if (this.gVA.getPage() != null) {
                this.eKD.fz(this.gVA.getPage().ads() == 1);
            } else {
                this.eKD.fz(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eKD.fA(true);
        } else {
            this.gVz = null;
            this.eKD.fz(false);
            this.eKD.fA(false);
        }
        this.eKD.fy(false);
        this.eKD.fx(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.anF().anU();
        if (!TbadkCoreApplication.isLogin()) {
            this.gVA.bIq().clear();
        } else {
            this.gVv.c(this.eKD);
        }
        this.gVv.a(this.gVA);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gVw, readCacheRespMsg.getData().get(0));
        }
        this.gVz = null;
        this.gVw.reset();
        this.gVx.setNeedCache(true);
        this.gVx.auF();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gVv.bHX();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgAtme(0);
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
            this.gVv.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gVv.bHX();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgAtme(0);
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
            this.gVv.a(errorData);
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

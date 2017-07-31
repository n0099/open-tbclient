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
    private com.baidu.tbadk.mvc.d.a bOe;
    private AtMessageActivity dDL;
    private b dDM;
    private AtMeNetModel dDN;
    private AtMeCacheModel dDO;
    private FeedData dDP;
    private f dDQ;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aa(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dDL.azs();
                }
            }
        };
        this.dDL = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dDM = new b();
        this.dDN = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aa(this.dDL.getPageContext().getPageActivity()), this.dDM);
        this.dDN.a(this);
        if (this.dDL != null) {
            this.dDN.setUniqueId(this.dDL.getUniqueId());
        }
        this.dDN.registerListener(this.mNetworkChangedMessageListener);
        this.dDO = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aa(this.dDL.getPageContext().getPageActivity()));
        this.dDO.a(this);
        if (this.dDL != null) {
            this.dDO.setUniqueId(this.dDL.getUniqueId());
        }
        this.dDQ = new f();
        this.bOe = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean XP() {
        if (!this.dDN.xc() && this.bOe.FG() && azr()) {
            this.bOe.bU(true);
            this.bOe.bW(true);
            this.dDM.h(this.dDP);
            this.dDN.setNeedCache(false);
            this.dDN.Fw();
            this.dDL.b(this.bOe);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean azq() {
        if (this.dDN.xc() || !azr()) {
            return false;
        }
        this.dDP = null;
        this.dDM.reset();
        this.dDN.setNeedCache(true);
        this.dDN.Fw();
        return true;
    }

    protected boolean azr() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dDQ != null && this.dDQ.dEw != null) {
            this.dDQ.dEw.clear();
        }
        this.dDL.azs();
        this.dDL.a(this.dDQ);
        return false;
    }

    public boolean XO() {
        if (azr()) {
            if (this.dDL != null) {
                this.dDL.azt();
            }
            this.dDO.a((com.baidu.tbadk.mvc.b.e) this.dDM);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dDQ.azA().clear();
        }
        this.dDQ.a(cVar);
        if (cVar != null && cVar.azA() != null && cVar.azA().size() > 0) {
            this.dDP = cVar.azA().get(cVar.azA().size() - 1);
            if (this.dDQ.qH() != null) {
                this.bOe.bV(this.dDQ.qH().qD() == 1);
            } else {
                this.bOe.bV(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bOe.bW(true);
        } else {
            this.dDP = null;
            this.bOe.bV(false);
            this.bOe.bW(false);
        }
        this.bOe.bU(false);
        this.bOe.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zp();
        if (!TbadkCoreApplication.isLogin()) {
            this.dDQ.azA().clear();
        } else {
            this.dDL.b(this.bOe);
        }
        this.dDL.a(this.dDQ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dDM, readCacheRespMsg.getData().get(0));
        }
        this.dDP = null;
        this.dDM.reset();
        this.dDN.setNeedCache(true);
        this.dDN.Fw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dDL.azs();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgAtme(0);
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
            this.dDL.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dDL.azs();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgAtme(0);
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
            this.dDL.a(errorData);
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

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
    private com.baidu.tbadk.mvc.d.a bOO;
    private AtMessageActivity dFI;
    private b dFJ;
    private AtMeNetModel dFK;
    private AtMeCacheModel dFL;
    private FeedData dFM;
    private f dFN;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aa(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dFI.azU();
                }
            }
        };
        this.dFI = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dFJ = new b();
        this.dFK = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aa(this.dFI.getPageContext().getPageActivity()), this.dFJ);
        this.dFK.a(this);
        if (this.dFI != null) {
            this.dFK.setUniqueId(this.dFI.getUniqueId());
        }
        this.dFK.registerListener(this.mNetworkChangedMessageListener);
        this.dFL = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aa(this.dFI.getPageContext().getPageActivity()));
        this.dFL.a(this);
        if (this.dFI != null) {
            this.dFL.setUniqueId(this.dFI.getUniqueId());
        }
        this.dFN = new f();
        this.bOO = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Yh() {
        if (!this.dFK.xc() && this.bOO.FG() && azT()) {
            this.bOO.bU(true);
            this.bOO.bW(true);
            this.dFJ.h(this.dFM);
            this.dFK.setNeedCache(false);
            this.dFK.Fw();
            this.dFI.b(this.bOO);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean azS() {
        if (this.dFK.xc() || !azT()) {
            return false;
        }
        this.dFM = null;
        this.dFJ.reset();
        this.dFK.setNeedCache(true);
        this.dFK.Fw();
        return true;
    }

    protected boolean azT() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dFN != null && this.dFN.dGt != null) {
            this.dFN.dGt.clear();
        }
        this.dFI.azU();
        this.dFI.a(this.dFN);
        return false;
    }

    public boolean Yg() {
        if (azT()) {
            if (this.dFI != null) {
                this.dFI.azV();
            }
            this.dFL.a((com.baidu.tbadk.mvc.b.e) this.dFJ);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dFN.aAc().clear();
        }
        this.dFN.a(cVar);
        if (cVar != null && cVar.aAc() != null && cVar.aAc().size() > 0) {
            this.dFM = cVar.aAc().get(cVar.aAc().size() - 1);
            if (this.dFN.qI() != null) {
                this.bOO.bV(this.dFN.qI().qE() == 1);
            } else {
                this.bOO.bV(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bOO.bW(true);
        } else {
            this.dFM = null;
            this.bOO.bV(false);
            this.bOO.bW(false);
        }
        this.bOO.bU(false);
        this.bOO.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zp();
        if (!TbadkCoreApplication.isLogin()) {
            this.dFN.aAc().clear();
        } else {
            this.dFI.b(this.bOO);
        }
        this.dFI.a(this.dFN);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dFJ, readCacheRespMsg.getData().get(0));
        }
        this.dFM = null;
        this.dFJ.reset();
        this.dFK.setNeedCache(true);
        this.dFK.Fw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dFI.azU();
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
            this.dFI.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dFI.azU();
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
            this.dFI.a(errorData);
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

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
    private com.baidu.tbadk.mvc.d.a cim;
    private AtMessageActivity dYQ;
    private b dYR;
    private AtMeNetModel dYS;
    private AtMeCacheModel dYT;
    private FeedData dYU;
    private f dYV;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dYQ.aEz();
                }
            }
        };
        this.dYQ = atMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dYR = new b();
        this.dYS = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dYQ.getPageContext().getPageActivity()), this.dYR);
        this.dYS.a(this);
        if (this.dYQ != null) {
            this.dYS.setUniqueId(this.dYQ.getUniqueId());
        }
        this.dYS.registerListener(this.mNetworkChangedMessageListener);
        this.dYT = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dYQ.getPageContext().getPageActivity()));
        this.dYT.a(this);
        if (this.dYQ != null) {
            this.dYT.setUniqueId(this.dYQ.getUniqueId());
        }
        this.dYV = new f();
        this.cim = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adh() {
        if (!this.dYS.wC() && this.cim.FI() && aEy()) {
            this.cim.bN(true);
            this.cim.bP(true);
            this.dYR.g(this.dYU);
            this.dYS.setNeedCache(false);
            this.dYS.Fy();
            this.dYQ.b(this.cim);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aEx() {
        if (this.dYS.wC() || !aEy()) {
            return false;
        }
        this.dYU = null;
        this.dYR.reset();
        this.dYS.setNeedCache(true);
        this.dYS.Fy();
        return true;
    }

    protected boolean aEy() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dYV != null && this.dYV.dZB != null) {
            this.dYV.dZB.clear();
        }
        this.dYQ.aEz();
        this.dYQ.a(this.dYV);
        return false;
    }

    public boolean adg() {
        if (aEy()) {
            if (this.dYQ != null) {
                this.dYQ.aEA();
            }
            this.dYT.a((com.baidu.tbadk.mvc.b.e) this.dYR);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dYV.aEH().clear();
        }
        this.dYV.a(cVar);
        if (cVar != null && cVar.aEH() != null && cVar.aEH().size() > 0) {
            this.dYU = cVar.aEH().get(cVar.aEH().size() - 1);
            if (this.dYV.qA() != null) {
                this.cim.bO(this.dYV.qA().qw() == 1);
            } else {
                this.cim.bO(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cim.bP(true);
        } else {
            this.dYU = null;
            this.cim.bO(false);
            this.cim.bP(false);
        }
        this.cim.bN(false);
        this.cim.bM(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yM().zc();
        if (!TbadkCoreApplication.isLogin()) {
            this.dYV.aEH().clear();
        } else {
            this.dYQ.b(this.cim);
        }
        this.dYQ.a(this.dYV);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dYR, readCacheRespMsg.getData().get(0));
        }
        this.dYU = null;
        this.dYR.reset();
        this.dYS.setNeedCache(true);
        this.dYS.Fy();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dYQ.aEz();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgAtme(0);
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
            this.dYQ.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dYQ.aEz();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgAtme(0);
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
            this.dYQ.a(errorData);
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

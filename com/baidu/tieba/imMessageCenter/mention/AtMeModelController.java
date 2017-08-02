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
    private com.baidu.tbadk.mvc.d.a bMU;
    private AtMessageActivity dCu;
    private b dCv;
    private AtMeNetModel dCw;
    private AtMeCacheModel dCx;
    private FeedData dCy;
    private f dCz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Z(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dCu.azh();
                }
            }
        };
        this.dCu = atMessageActivity;
    }

    public void f(Bundle bundle) {
        this.dCv = new b();
        this.dCw = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Z(this.dCu.getPageContext().getPageActivity()), this.dCv);
        this.dCw.a(this);
        if (this.dCu != null) {
            this.dCw.setUniqueId(this.dCu.getUniqueId());
        }
        this.dCw.registerListener(this.mNetworkChangedMessageListener);
        this.dCx = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Z(this.dCu.getPageContext().getPageActivity()));
        this.dCx.a(this);
        if (this.dCu != null) {
            this.dCx.setUniqueId(this.dCu.getUniqueId());
        }
        this.dCz = new f();
        this.bMU = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean XK() {
        if (!this.dCw.wT() && this.bMU.Fy() && azg()) {
            this.bMU.bU(true);
            this.bMU.bW(true);
            this.dCv.h(this.dCy);
            this.dCw.setNeedCache(false);
            this.dCw.Fo();
            this.dCu.b(this.bMU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean azf() {
        if (this.dCw.wT() || !azg()) {
            return false;
        }
        this.dCy = null;
        this.dCv.reset();
        this.dCw.setNeedCache(true);
        this.dCw.Fo();
        return true;
    }

    protected boolean azg() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dCz != null && this.dCz.dDf != null) {
            this.dCz.dDf.clear();
        }
        this.dCu.azh();
        this.dCu.a(this.dCz);
        return false;
    }

    public boolean XJ() {
        if (azg()) {
            if (this.dCu != null) {
                this.dCu.azi();
            }
            this.dCx.a((com.baidu.tbadk.mvc.b.e) this.dCv);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dCz.azp().clear();
        }
        this.dCz.a(cVar);
        if (cVar != null && cVar.azp() != null && cVar.azp().size() > 0) {
            this.dCy = cVar.azp().get(cVar.azp().size() - 1);
            if (this.dCz.qx() != null) {
                this.bMU.bV(this.dCz.qx().qt() == 1);
            } else {
                this.bMU.bV(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bMU.bW(true);
        } else {
            this.dCy = null;
            this.bMU.bV(false);
            this.bMU.bW(false);
        }
        this.bMU.bU(false);
        this.bMU.bT(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yR().zh();
        if (!TbadkCoreApplication.isLogin()) {
            this.dCz.azp().clear();
        } else {
            this.dCu.b(this.bMU);
        }
        this.dCu.a(this.dCz);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dCv, readCacheRespMsg.getData().get(0));
        }
        this.dCy = null;
        this.dCv.reset();
        this.dCw.setNeedCache(true);
        this.dCw.Fo();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dCu.azh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgAtme(0);
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
            this.dCu.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dCu.azh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgAtme(0);
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
            this.dCu.a(errorData);
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

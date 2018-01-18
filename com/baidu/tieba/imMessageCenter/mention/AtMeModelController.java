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
    private com.baidu.tbadk.mvc.d.a dbL;
    private AtMessageActivity eNC;
    private b eND;
    private AtMeNetModel eNE;
    private AtMeCacheModel eNF;
    private FeedData eNG;
    private f eNH;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ak(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eNC.aLO();
                }
            }
        };
        this.eNC = atMessageActivity;
    }

    public void k(Bundle bundle) {
        this.eND = new b();
        this.eNE = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eNC.getPageContext().getPageActivity()), this.eND);
        this.eNE.a(this);
        if (this.eNC != null) {
            this.eNE.setUniqueId(this.eNC.getUniqueId());
        }
        this.eNE.registerListener(this.mNetworkChangedMessageListener);
        this.eNF = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eNC.getPageContext().getPageActivity()));
        this.eNF.a(this);
        if (this.eNC != null) {
            this.eNF.setUniqueId(this.eNC.getUniqueId());
        }
        this.eNH = new f();
        this.dbL = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean alZ() {
        if (!this.eNE.DP() && this.dbL.MW() && aLN()) {
            this.dbL.cp(true);
            this.dbL.cr(true);
            this.eND.f(this.eNG);
            this.eNE.setNeedCache(false);
            this.eNE.MO();
            this.eNC.b(this.dbL);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aLM() {
        if (this.eNE.DP() || !aLN()) {
            return false;
        }
        this.eNG = null;
        this.eND.reset();
        this.eNE.setNeedCache(true);
        this.eNE.MO();
        return true;
    }

    protected boolean aLN() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eNH != null && this.eNH.eOm != null) {
            this.eNH.eOm.clear();
        }
        this.eNC.aLO();
        this.eNC.a(this.eNH);
        return false;
    }

    public boolean alY() {
        if (aLN()) {
            if (this.eNC != null) {
                this.eNC.aLP();
            }
            this.eNF.a((com.baidu.tbadk.mvc.b.e) this.eND);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eNH.aLW().clear();
        }
        this.eNH.a(cVar);
        if (cVar != null && cVar.aLW() != null && cVar.aLW().size() > 0) {
            this.eNG = cVar.aLW().get(cVar.aLW().size() - 1);
            if (this.eNH.xY() != null) {
                this.dbL.cq(this.eNH.xY().xU() == 1);
            } else {
                this.dbL.cq(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.dbL.cr(true);
        } else {
            this.eNG = null;
            this.dbL.cq(false);
            this.dbL.cr(false);
        }
        this.dbL.cp(false);
        this.dbL.co(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().Gv();
        if (!TbadkCoreApplication.isLogin()) {
            this.eNH.aLW().clear();
        } else {
            this.eNC.b(this.dbL);
        }
        this.eNC.a(this.eNH);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eND, readCacheRespMsg.getData().get(0));
        }
        this.eNG = null;
        this.eND.reset();
        this.eNE.setNeedCache(true);
        this.eNE.MO();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eNC.aLO();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgAtme(0);
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
            this.eNC.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eNC.aLO();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgAtme(0);
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
            this.eNC.a(errorData);
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

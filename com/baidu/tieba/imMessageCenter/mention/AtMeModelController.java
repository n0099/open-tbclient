package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
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
/* loaded from: classes22.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener exb;
    private com.baidu.tbadk.mvc.d.a icN;
    private AtMessageActivity ktG;
    private b ktH;
    private AtMeNetModel ktI;
    private AtMeCacheModel ktJ;
    private FeedData ktK;
    private f ktL;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.ktG.cWy();
                }
            }
        };
        this.ktG = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.ktH = new b();
        this.ktI = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.ktG.getPageContext().getPageActivity()), this.ktH);
        this.ktI.a(this);
        if (this.ktG != null) {
            this.ktI.setUniqueId(this.ktG.getUniqueId());
        }
        this.ktI.registerListener(this.exb);
        this.ktJ = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.ktG.getPageContext().getPageActivity()));
        this.ktJ.a(this);
        if (this.ktG != null) {
            this.ktJ.setUniqueId(this.ktG.getUniqueId());
        }
        this.ktL = new f();
        this.icN = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cpc() {
        if (!this.ktI.isLoading() && this.icN.bBQ() && cWx()) {
            this.icN.kt(true);
            this.icN.kv(true);
            this.ktH.e(this.ktK);
            this.ktI.setNeedCache(false);
            this.ktI.loadData();
            this.ktG.c(this.icN);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cDM() {
        if (this.ktI.isLoading() || !cWx()) {
            return false;
        }
        this.ktK = null;
        this.ktH.reset();
        this.ktI.setNeedCache(true);
        this.ktI.loadData();
        return true;
    }

    protected boolean cWx() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.ktL != null && this.ktL.kvh != null) {
            this.ktL.kvh.clear();
        }
        this.ktG.cWy();
        this.ktG.a(this.ktL);
        return false;
    }

    public boolean cpb() {
        if (cWx()) {
            if (this.ktG != null) {
                this.ktG.cWz();
            }
            this.ktJ.a((com.baidu.tbadk.mvc.b.e) this.ktH);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.ktL.cWP().clear();
        }
        this.ktL.a(cVar);
        if (cVar != null && cVar.cWP() != null && cVar.cWP().size() > 0) {
            this.ktK = cVar.cWP().get(cVar.cWP().size() - 1);
            if (this.ktL.getPage() != null) {
                this.icN.ku(this.ktL.getPage().blq() == 1);
            } else {
                this.icN.ku(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.icN.kv(true);
        } else {
            this.ktK = null;
            this.icN.ku(false);
            this.icN.kv(false);
        }
        this.icN.kt(false);
        this.icN.ks(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().bwg();
        if (!TbadkCoreApplication.isLogin()) {
            this.ktL.cWP().clear();
        } else {
            this.ktG.c(this.icN);
        }
        this.ktG.a(this.ktL);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.ktH, readCacheRespMsg.getData().get(0));
        }
        this.ktK = null;
        this.ktH.reset();
        this.ktI.setNeedCache(true);
        this.ktI.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.ktG.cWy();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgAtme(0);
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
            this.ktG.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.ktG.cWy();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgAtme(0);
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
            this.ktG.a(errorData);
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

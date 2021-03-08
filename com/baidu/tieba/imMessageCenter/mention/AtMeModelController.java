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
/* loaded from: classes2.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a iDW;
    private AtMessageActivity kSJ;
    private b kSK;
    private AtMeNetModel kSL;
    private AtMeCacheModel kSM;
    private FeedData kSN;
    private f kSO;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.j.J(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kSJ.cZp();
                }
            }
        };
        this.kSJ = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kSK = new b();
        this.kSL = new AtMeNetModel((TbPageContext) com.baidu.adp.base.j.J(this.kSJ.getPageContext().getPageActivity()), this.kSK);
        this.kSL.a(this);
        if (this.kSJ != null) {
            this.kSL.setUniqueId(this.kSJ.getUniqueId());
        }
        this.kSL.registerListener(this.mNetworkChangedMessageListener);
        this.kSM = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.j.J(this.kSJ.getPageContext().getPageActivity()));
        this.kSM.a(this);
        if (this.kSJ != null) {
            this.kSM.setUniqueId(this.kSJ.getUniqueId());
        }
        this.kSO = new f();
        this.iDW = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cts() {
        if (!this.kSL.isLoading() && this.iDW.bDF() && cZo()) {
            this.iDW.li(true);
            this.iDW.lk(true);
            this.kSK.e(this.kSN);
            this.kSL.setNeedCache(false);
            this.kSL.loadData();
            this.kSJ.c(this.iDW);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cJn() {
        if (this.kSL.isLoading() || !cZo()) {
            return false;
        }
        this.kSN = null;
        this.kSK.reset();
        this.kSL.setNeedCache(true);
        this.kSL.loadData();
        return true;
    }

    protected boolean cZo() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kSO != null && this.kSO.kUk != null) {
            this.kSO.kUk.clear();
        }
        this.kSJ.cZp();
        this.kSJ.a(this.kSO);
        return false;
    }

    public boolean ctr() {
        if (cZo()) {
            if (this.kSJ != null) {
                this.kSJ.cZq();
            }
            this.kSM.a((com.baidu.tbadk.mvc.b.e) this.kSK);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kSJ.Xc();
        if (bVar.getUpdateType() != 4) {
            this.kSO.cZG().clear();
        }
        this.kSO.a(cVar);
        if (cVar != null && cVar.cZG() != null && cVar.cZG().size() > 0) {
            this.kSN = cVar.cZG().get(cVar.cZG().size() - 1);
            if (this.kSO.getPage() != null) {
                this.iDW.lj(this.kSO.getPage().bmH() == 1);
            } else {
                this.iDW.lj(true);
            }
            if (bVar != null) {
                bVar.cZJ();
            }
            this.iDW.lk(true);
        } else {
            this.kSN = null;
            this.iDW.lj(false);
            this.iDW.lk(false);
        }
        this.iDW.li(false);
        this.iDW.lh(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bxS();
        if (!TbadkCoreApplication.isLogin()) {
            this.kSO.cZG().clear();
        } else {
            this.kSJ.c(this.iDW);
        }
        this.kSJ.a(this.kSO);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kSK, readCacheRespMsg.getData().get(0));
        }
        this.kSN = null;
        this.kSK.reset();
        this.kSL.setNeedCache(true);
        this.kSL.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kSJ.cZp();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kSJ.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kSJ.cZp();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kSJ.a(errorData);
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

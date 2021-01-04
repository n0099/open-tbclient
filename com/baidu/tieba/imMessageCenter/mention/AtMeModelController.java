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
    private com.baidu.tbadk.mvc.d.a iAW;
    private AtMessageActivity kMV;
    private b kMW;
    private AtMeNetModel kMX;
    private AtMeCacheModel kMY;
    private FeedData kMZ;
    private f kNa;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.j.K(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kMV.daU();
                }
            }
        };
        this.kMV = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kMW = new b();
        this.kMX = new AtMeNetModel((TbPageContext) com.baidu.adp.base.j.K(this.kMV.getPageContext().getPageActivity()), this.kMW);
        this.kMX.a(this);
        if (this.kMV != null) {
            this.kMX.setUniqueId(this.kMV.getUniqueId());
        }
        this.kMX.registerListener(this.mNetworkChangedMessageListener);
        this.kMY = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.j.K(this.kMV.getPageContext().getPageActivity()));
        this.kMY.a(this);
        if (this.kMV != null) {
            this.kMY.setUniqueId(this.kMV.getUniqueId());
        }
        this.kNa = new f();
        this.iAW = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cvK() {
        if (!this.kMX.isLoading() && this.iAW.bHc() && daT()) {
            this.iAW.lj(true);
            this.iAW.ll(true);
            this.kMW.e(this.kMZ);
            this.kMX.setNeedCache(false);
            this.kMX.loadData();
            this.kMV.c(this.iAW);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cLE() {
        if (this.kMX.isLoading() || !daT()) {
            return false;
        }
        this.kMZ = null;
        this.kMW.reset();
        this.kMX.setNeedCache(true);
        this.kMX.loadData();
        return true;
    }

    protected boolean daT() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kNa != null && this.kNa.kOw != null) {
            this.kNa.kOw.clear();
        }
        this.kMV.daU();
        this.kMV.a(this.kNa);
        return false;
    }

    public boolean cvJ() {
        if (daT()) {
            if (this.kMV != null) {
                this.kMV.daV();
            }
            this.kMY.a((com.baidu.tbadk.mvc.b.e) this.kMW);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kMV.Zi();
        if (bVar.getUpdateType() != 4) {
            this.kNa.dbl().clear();
        }
        this.kNa.a(cVar);
        if (cVar != null && cVar.dbl() != null && cVar.dbl().size() > 0) {
            this.kMZ = cVar.dbl().get(cVar.dbl().size() - 1);
            if (this.kNa.getPage() != null) {
                this.iAW.lk(this.kNa.getPage().bqf() == 1);
            } else {
                this.iAW.lk(true);
            }
            if (bVar != null) {
                bVar.dbo();
            }
            this.iAW.ll(true);
        } else {
            this.kMZ = null;
            this.iAW.lk(false);
            this.iAW.ll(false);
        }
        this.iAW.lj(false);
        this.iAW.li(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bBc().bBq();
        if (!TbadkCoreApplication.isLogin()) {
            this.kNa.dbl().clear();
        } else {
            this.kMV.c(this.iAW);
        }
        this.kMV.a(this.kNa);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kMW, readCacheRespMsg.getData().get(0));
        }
        this.kMZ = null;
        this.kMW.reset();
        this.kMX.setNeedCache(true);
        this.kMX.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kMV.daU();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bBc().setMsgAtme(0);
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
            this.kMV.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kMV.daU();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bBc().setMsgAtme(0);
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
            this.kMV.a(errorData);
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

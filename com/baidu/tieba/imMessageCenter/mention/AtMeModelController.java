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
    private com.baidu.tbadk.mvc.d.a deI;
    private AtMessageActivity eRU;
    private b eRV;
    private AtMeNetModel eRW;
    private AtMeCacheModel eRX;
    private FeedData eRY;
    private f eRZ;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ak(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eRU.aNt();
                }
            }
        };
        this.eRU = atMessageActivity;
    }

    public void l(Bundle bundle) {
        this.eRV = new b();
        this.eRW = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eRU.getPageContext().getPageActivity()), this.eRV);
        this.eRW.a(this);
        if (this.eRU != null) {
            this.eRW.setUniqueId(this.eRU.getUniqueId());
        }
        this.eRW.registerListener(this.mNetworkChangedMessageListener);
        this.eRX = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eRU.getPageContext().getPageActivity()));
        this.eRX.a(this);
        if (this.eRU != null) {
            this.eRX.setUniqueId(this.eRU.getUniqueId());
        }
        this.eRZ = new f();
        this.deI = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amM() {
        if (!this.eRW.Ek() && this.deI.ND() && aNs()) {
            this.deI.cu(true);
            this.deI.cw(true);
            this.eRV.d(this.eRY);
            this.eRW.setNeedCache(false);
            this.eRW.Nv();
            this.eRU.b(this.deI);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNr() {
        if (this.eRW.Ek() || !aNs()) {
            return false;
        }
        this.eRY = null;
        this.eRV.reset();
        this.eRW.setNeedCache(true);
        this.eRW.Nv();
        return true;
    }

    protected boolean aNs() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eRZ != null && this.eRZ.eSJ != null) {
            this.eRZ.eSJ.clear();
        }
        this.eRU.aNt();
        this.eRU.a(this.eRZ);
        return false;
    }

    public boolean amL() {
        if (aNs()) {
            if (this.eRU != null) {
                this.eRU.aNu();
            }
            this.eRX.a((com.baidu.tbadk.mvc.b.e) this.eRV);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eRZ.aNE().clear();
        }
        this.eRZ.a(cVar);
        if (cVar != null && cVar.aNE() != null && cVar.aNE().size() > 0) {
            this.eRY = cVar.aNE().get(cVar.aNE().size() - 1);
            if (this.eRZ.yA() != null) {
                this.deI.cv(this.eRZ.yA().yw() == 1);
            } else {
                this.deI.cv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.deI.cw(true);
        } else {
            this.eRY = null;
            this.deI.cv(false);
            this.deI.cw(false);
        }
        this.deI.cu(false);
        this.deI.ct(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.GI().GX();
        if (!TbadkCoreApplication.isLogin()) {
            this.eRZ.aNE().clear();
        } else {
            this.eRU.b(this.deI);
        }
        this.eRU.a(this.eRZ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eRV, readCacheRespMsg.getData().get(0));
        }
        this.eRY = null;
        this.eRV.reset();
        this.eRW.setNeedCache(true);
        this.eRW.Nv();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eRU.aNt();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgAtme(0);
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
            this.eRU.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eRU.aNt();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgAtme(0);
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
            this.eRU.a(errorData);
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

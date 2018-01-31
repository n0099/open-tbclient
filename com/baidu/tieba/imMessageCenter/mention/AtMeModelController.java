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
    private com.baidu.tbadk.mvc.d.a dcg;
    private AtMessageActivity eNX;
    private b eNY;
    private AtMeNetModel eNZ;
    private AtMeCacheModel eOa;
    private FeedData eOb;
    private f eOc;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ak(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eNX.aLT();
                }
            }
        };
        this.eNX = atMessageActivity;
    }

    public void k(Bundle bundle) {
        this.eNY = new b();
        this.eNZ = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eNX.getPageContext().getPageActivity()), this.eNY);
        this.eNZ.a(this);
        if (this.eNX != null) {
            this.eNZ.setUniqueId(this.eNX.getUniqueId());
        }
        this.eNZ.registerListener(this.mNetworkChangedMessageListener);
        this.eOa = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eNX.getPageContext().getPageActivity()));
        this.eOa.a(this);
        if (this.eNX != null) {
            this.eOa.setUniqueId(this.eNX.getUniqueId());
        }
        this.eOc = new f();
        this.dcg = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ame() {
        if (!this.eNZ.DR() && this.dcg.MY() && aLS()) {
            this.dcg.cq(true);
            this.dcg.cs(true);
            this.eNY.f(this.eOb);
            this.eNZ.setNeedCache(false);
            this.eNZ.MQ();
            this.eNX.b(this.dcg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aLR() {
        if (this.eNZ.DR() || !aLS()) {
            return false;
        }
        this.eOb = null;
        this.eNY.reset();
        this.eNZ.setNeedCache(true);
        this.eNZ.MQ();
        return true;
    }

    protected boolean aLS() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eOc != null && this.eOc.eOH != null) {
            this.eOc.eOH.clear();
        }
        this.eNX.aLT();
        this.eNX.a(this.eOc);
        return false;
    }

    public boolean amd() {
        if (aLS()) {
            if (this.eNX != null) {
                this.eNX.aLU();
            }
            this.eOa.a((com.baidu.tbadk.mvc.b.e) this.eNY);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eOc.aMb().clear();
        }
        this.eOc.a(cVar);
        if (cVar != null && cVar.aMb() != null && cVar.aMb().size() > 0) {
            this.eOb = cVar.aMb().get(cVar.aMb().size() - 1);
            if (this.eOc.xZ() != null) {
                this.dcg.cr(this.eOc.xZ().xV() == 1);
            } else {
                this.dcg.cr(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.dcg.cs(true);
        } else {
            this.eOb = null;
            this.dcg.cr(false);
            this.dcg.cs(false);
        }
        this.dcg.cq(false);
        this.dcg.cp(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().Gx();
        if (!TbadkCoreApplication.isLogin()) {
            this.eOc.aMb().clear();
        } else {
            this.eNX.b(this.dcg);
        }
        this.eNX.a(this.eOc);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eNY, readCacheRespMsg.getData().get(0));
        }
        this.eOb = null;
        this.eNY.reset();
        this.eNZ.setNeedCache(true);
        this.eNZ.MQ();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eNX.aLT();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgAtme(0);
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
            this.eNX.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eNX.aLT();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgAtme(0);
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
            this.eNX.a(errorData);
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

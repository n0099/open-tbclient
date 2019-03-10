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
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a eqj;
    private AtMessageActivity gxq;
    private b gxr;
    private AtMeNetModel gxs;
    private AtMeCacheModel gxt;
    private FeedData gxu;
    private f gxv;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gxq.bxu();
                }
            }
        };
        this.gxq = atMessageActivity;
    }

    public void J(Bundle bundle) {
        this.gxr = new b();
        this.gxs = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxq.getPageContext().getPageActivity()), this.gxr);
        this.gxs.a(this);
        if (this.gxq != null) {
            this.gxs.setUniqueId(this.gxq.getUniqueId());
        }
        this.gxs.registerListener(this.mNetworkChangedMessageListener);
        this.gxt = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxq.getPageContext().getPageActivity()));
        this.gxt.a(this);
        if (this.gxq != null) {
            this.gxt.setUniqueId(this.gxq.getUniqueId());
        }
        this.gxv = new f();
        this.eqj = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aRS() {
        if (!this.gxs.qz() && this.eqj.aoD() && bxt()) {
            this.eqj.eY(true);
            this.eqj.fa(true);
            this.gxr.d(this.gxu);
            this.gxs.setNeedCache(false);
            this.gxs.aov();
            this.gxq.b(this.eqj);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bho() {
        if (this.gxs.qz() || !bxt()) {
            return false;
        }
        this.gxu = null;
        this.gxr.reset();
        this.gxs.setNeedCache(true);
        this.gxs.aov();
        return true;
    }

    protected boolean bxt() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gxv != null && this.gxv.gyq != null) {
            this.gxv.gyq.clear();
        }
        this.gxq.bxu();
        this.gxq.a(this.gxv);
        return false;
    }

    public boolean aRR() {
        if (bxt()) {
            if (this.gxq != null) {
                this.gxq.bxv();
            }
            this.gxt.a((com.baidu.tbadk.mvc.b.e) this.gxr);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gxv.bxN().clear();
        }
        this.gxv.a(cVar);
        if (cVar != null && cVar.bxN() != null && cVar.bxN().size() > 0) {
            this.gxu = cVar.bxN().get(cVar.bxN().size() - 1);
            if (this.gxv.getPage() != null) {
                this.eqj.eZ(this.gxv.getPage().XK() == 1);
            } else {
                this.eqj.eZ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eqj.fa(true);
        } else {
            this.gxu = null;
            this.eqj.eZ(false);
            this.eqj.fa(false);
        }
        this.eqj.eY(false);
        this.eqj.eX(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahP();
        if (!TbadkCoreApplication.isLogin()) {
            this.gxv.bxN().clear();
        } else {
            this.gxq.b(this.eqj);
        }
        this.gxq.a(this.gxv);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gxr, readCacheRespMsg.getData().get(0));
        }
        this.gxu = null;
        this.gxr.reset();
        this.gxs.setNeedCache(true);
        this.gxs.aov();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxq.bxu();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgAtme(0);
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
            this.gxq.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxq.bxu();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgAtme(0);
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
            this.gxq.a(errorData);
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

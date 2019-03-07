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
    private AtMessageActivity gxp;
    private b gxq;
    private AtMeNetModel gxr;
    private AtMeCacheModel gxs;
    private FeedData gxt;
    private f gxu;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gxp.bxt();
                }
            }
        };
        this.gxp = atMessageActivity;
    }

    public void J(Bundle bundle) {
        this.gxq = new b();
        this.gxr = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxp.getPageContext().getPageActivity()), this.gxq);
        this.gxr.a(this);
        if (this.gxp != null) {
            this.gxr.setUniqueId(this.gxp.getUniqueId());
        }
        this.gxr.registerListener(this.mNetworkChangedMessageListener);
        this.gxs = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxp.getPageContext().getPageActivity()));
        this.gxs.a(this);
        if (this.gxp != null) {
            this.gxs.setUniqueId(this.gxp.getUniqueId());
        }
        this.gxu = new f();
        this.eqj = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aRR() {
        if (!this.gxr.qz() && this.eqj.aoD() && bxs()) {
            this.eqj.eY(true);
            this.eqj.fa(true);
            this.gxq.d(this.gxt);
            this.gxr.setNeedCache(false);
            this.gxr.aov();
            this.gxp.b(this.eqj);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bhn() {
        if (this.gxr.qz() || !bxs()) {
            return false;
        }
        this.gxt = null;
        this.gxq.reset();
        this.gxr.setNeedCache(true);
        this.gxr.aov();
        return true;
    }

    protected boolean bxs() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gxu != null && this.gxu.gyp != null) {
            this.gxu.gyp.clear();
        }
        this.gxp.bxt();
        this.gxp.a(this.gxu);
        return false;
    }

    public boolean aRQ() {
        if (bxs()) {
            if (this.gxp != null) {
                this.gxp.bxu();
            }
            this.gxs.a((com.baidu.tbadk.mvc.b.e) this.gxq);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gxu.bxM().clear();
        }
        this.gxu.a(cVar);
        if (cVar != null && cVar.bxM() != null && cVar.bxM().size() > 0) {
            this.gxt = cVar.bxM().get(cVar.bxM().size() - 1);
            if (this.gxu.getPage() != null) {
                this.eqj.eZ(this.gxu.getPage().XK() == 1);
            } else {
                this.eqj.eZ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eqj.fa(true);
        } else {
            this.gxt = null;
            this.eqj.eZ(false);
            this.eqj.fa(false);
        }
        this.eqj.eY(false);
        this.eqj.eX(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahP();
        if (!TbadkCoreApplication.isLogin()) {
            this.gxu.bxM().clear();
        } else {
            this.gxp.b(this.eqj);
        }
        this.gxp.a(this.gxu);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gxq, readCacheRespMsg.getData().get(0));
        }
        this.gxt = null;
        this.gxq.reset();
        this.gxr.setNeedCache(true);
        this.gxr.aov();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxp.bxt();
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
            this.gxp.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxp.bxt();
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
            this.gxp.a(errorData);
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

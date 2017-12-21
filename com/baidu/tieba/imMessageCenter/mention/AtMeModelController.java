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
    private com.baidu.tbadk.mvc.d.a ciE;
    private AtMessageActivity dZZ;
    private b eaa;
    private AtMeNetModel eab;
    private AtMeCacheModel eac;
    private FeedData ead;
    private f eae;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dZZ.aEI();
                }
            }
        };
        this.dZZ = atMessageActivity;
    }

    public void h(Bundle bundle) {
        this.eaa = new b();
        this.eab = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dZZ.getPageContext().getPageActivity()), this.eaa);
        this.eab.a(this);
        if (this.dZZ != null) {
            this.eab.setUniqueId(this.dZZ.getUniqueId());
        }
        this.eab.registerListener(this.mNetworkChangedMessageListener);
        this.eac = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dZZ.getPageContext().getPageActivity()));
        this.eac.a(this);
        if (this.dZZ != null) {
            this.eac.setUniqueId(this.dZZ.getUniqueId());
        }
        this.eae = new f();
        this.ciE = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adq() {
        if (!this.eab.wA() && this.ciE.FJ() && aEH()) {
            this.ciE.bO(true);
            this.ciE.bQ(true);
            this.eaa.g(this.ead);
            this.eab.setNeedCache(false);
            this.eab.Fz();
            this.dZZ.b(this.ciE);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aEG() {
        if (this.eab.wA() || !aEH()) {
            return false;
        }
        this.ead = null;
        this.eaa.reset();
        this.eab.setNeedCache(true);
        this.eab.Fz();
        return true;
    }

    protected boolean aEH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eae != null && this.eae.eaK != null) {
            this.eae.eaK.clear();
        }
        this.dZZ.aEI();
        this.dZZ.a(this.eae);
        return false;
    }

    public boolean adp() {
        if (aEH()) {
            if (this.dZZ != null) {
                this.dZZ.aEJ();
            }
            this.eac.a((com.baidu.tbadk.mvc.b.e) this.eaa);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eae.aEQ().clear();
        }
        this.eae.a(cVar);
        if (cVar != null && cVar.aEQ() != null && cVar.aEQ().size() > 0) {
            this.ead = cVar.aEQ().get(cVar.aEQ().size() - 1);
            if (this.eae.qy() != null) {
                this.ciE.bP(this.eae.qy().qu() == 1);
            } else {
                this.ciE.bP(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.ciE.bQ(true);
        } else {
            this.ead = null;
            this.ciE.bP(false);
            this.ciE.bQ(false);
        }
        this.ciE.bO(false);
        this.ciE.bN(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zd();
        if (!TbadkCoreApplication.isLogin()) {
            this.eae.aEQ().clear();
        } else {
            this.dZZ.b(this.ciE);
        }
        this.dZZ.a(this.eae);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eaa, readCacheRespMsg.getData().get(0));
        }
        this.ead = null;
        this.eaa.reset();
        this.eab.setNeedCache(true);
        this.eab.Fz();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dZZ.aEI();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(0);
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
            this.dZZ.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dZZ.aEI();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(0);
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
            this.dZZ.a(errorData);
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

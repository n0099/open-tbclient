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
    private com.baidu.tbadk.mvc.d.a eFA;
    private AtMessageActivity gOr;
    private b gOs;
    private AtMeNetModel gOt;
    private AtMeCacheModel gOu;
    private FeedData gOv;
    private f gOw;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gOr.bFb();
                }
            }
        };
        this.gOr = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gOs = new b();
        this.gOt = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gOr.getPageContext().getPageActivity()), this.gOs);
        this.gOt.a(this);
        if (this.gOr != null) {
            this.gOt.setUniqueId(this.gOr.getUniqueId());
        }
        this.gOt.registerListener(this.mNetworkChangedMessageListener);
        this.gOu = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gOr.getPageContext().getPageActivity()));
        this.gOu.a(this);
        if (this.gOr != null) {
            this.gOu.setUniqueId(this.gOr.getUniqueId());
        }
        this.gOw = new f();
        this.eFA = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aZb() {
        if (!this.gOt.pu() && this.eFA.atD() && bFa()) {
            this.eFA.fu(true);
            this.eFA.fw(true);
            this.gOs.d(this.gOv);
            this.gOt.setNeedCache(false);
            this.gOt.atv();
            this.gOr.c(this.eFA);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boH() {
        if (this.gOt.pu() || !bFa()) {
            return false;
        }
        this.gOv = null;
        this.gOs.reset();
        this.gOt.setNeedCache(true);
        this.gOt.atv();
        return true;
    }

    protected boolean bFa() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gOw != null && this.gOw.gPr != null) {
            this.gOw.gPr.clear();
        }
        this.gOr.bFb();
        this.gOr.a(this.gOw);
        return false;
    }

    public boolean aZa() {
        if (bFa()) {
            if (this.gOr != null) {
                this.gOr.bFc();
            }
            this.gOu.a((com.baidu.tbadk.mvc.b.e) this.gOs);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gOw.bFu().clear();
        }
        this.gOw.a(cVar);
        if (cVar != null && cVar.bFu() != null && cVar.bFu().size() > 0) {
            this.gOv = cVar.bFu().get(cVar.bFu().size() - 1);
            if (this.gOw.getPage() != null) {
                this.eFA.fv(this.gOw.getPage().acp() == 1);
            } else {
                this.eFA.fv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eFA.fw(true);
        } else {
            this.gOv = null;
            this.eFA.fv(false);
            this.eFA.fw(false);
        }
        this.eFA.fu(false);
        this.eFA.ft(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amN();
        if (!TbadkCoreApplication.isLogin()) {
            this.gOw.bFu().clear();
        } else {
            this.gOr.c(this.eFA);
        }
        this.gOr.a(this.gOw);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gOs, readCacheRespMsg.getData().get(0));
        }
        this.gOv = null;
        this.gOs.reset();
        this.gOt.setNeedCache(true);
        this.gOt.atv();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gOr.bFb();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgAtme(0);
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
            this.gOr.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gOr.bFb();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgAtme(0);
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
            this.gOr.a(errorData);
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

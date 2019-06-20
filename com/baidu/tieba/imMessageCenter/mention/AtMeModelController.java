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
    private AtMessageActivity gOt;
    private b gOu;
    private AtMeNetModel gOv;
    private AtMeCacheModel gOw;
    private FeedData gOx;
    private f gOy;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gOt.bFc();
                }
            }
        };
        this.gOt = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gOu = new b();
        this.gOv = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gOt.getPageContext().getPageActivity()), this.gOu);
        this.gOv.a(this);
        if (this.gOt != null) {
            this.gOv.setUniqueId(this.gOt.getUniqueId());
        }
        this.gOv.registerListener(this.mNetworkChangedMessageListener);
        this.gOw = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gOt.getPageContext().getPageActivity()));
        this.gOw.a(this);
        if (this.gOt != null) {
            this.gOw.setUniqueId(this.gOt.getUniqueId());
        }
        this.gOy = new f();
        this.eFA = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aZb() {
        if (!this.gOv.pu() && this.eFA.atD() && bFb()) {
            this.eFA.fu(true);
            this.eFA.fw(true);
            this.gOu.d(this.gOx);
            this.gOv.setNeedCache(false);
            this.gOv.atv();
            this.gOt.c(this.eFA);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boI() {
        if (this.gOv.pu() || !bFb()) {
            return false;
        }
        this.gOx = null;
        this.gOu.reset();
        this.gOv.setNeedCache(true);
        this.gOv.atv();
        return true;
    }

    protected boolean bFb() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gOy != null && this.gOy.gPt != null) {
            this.gOy.gPt.clear();
        }
        this.gOt.bFc();
        this.gOt.a(this.gOy);
        return false;
    }

    public boolean aZa() {
        if (bFb()) {
            if (this.gOt != null) {
                this.gOt.bFd();
            }
            this.gOw.a((com.baidu.tbadk.mvc.b.e) this.gOu);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gOy.bFv().clear();
        }
        this.gOy.a(cVar);
        if (cVar != null && cVar.bFv() != null && cVar.bFv().size() > 0) {
            this.gOx = cVar.bFv().get(cVar.bFv().size() - 1);
            if (this.gOy.getPage() != null) {
                this.eFA.fv(this.gOy.getPage().acp() == 1);
            } else {
                this.eFA.fv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eFA.fw(true);
        } else {
            this.gOx = null;
            this.eFA.fv(false);
            this.eFA.fw(false);
        }
        this.eFA.fu(false);
        this.eFA.ft(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amN();
        if (!TbadkCoreApplication.isLogin()) {
            this.gOy.bFv().clear();
        } else {
            this.gOt.c(this.eFA);
        }
        this.gOt.a(this.gOy);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gOu, readCacheRespMsg.getData().get(0));
        }
        this.gOx = null;
        this.gOu.reset();
        this.gOv.setNeedCache(true);
        this.gOv.atv();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gOt.bFc();
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
            this.gOt.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gOt.bFc();
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
            this.gOt.a(errorData);
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

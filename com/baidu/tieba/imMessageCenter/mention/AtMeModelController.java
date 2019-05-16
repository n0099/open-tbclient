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
    private com.baidu.tbadk.mvc.d.a eFz;
    private AtMessageActivity gOq;
    private b gOr;
    private AtMeNetModel gOs;
    private AtMeCacheModel gOt;
    private FeedData gOu;
    private f gOv;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gOq.bEY();
                }
            }
        };
        this.gOq = atMessageActivity;
    }

    public void K(Bundle bundle) {
        this.gOr = new b();
        this.gOs = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.gOq.getPageContext().getPageActivity()), this.gOr);
        this.gOs.a(this);
        if (this.gOq != null) {
            this.gOs.setUniqueId(this.gOq.getUniqueId());
        }
        this.gOs.registerListener(this.mNetworkChangedMessageListener);
        this.gOt = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.gOq.getPageContext().getPageActivity()));
        this.gOt.a(this);
        if (this.gOq != null) {
            this.gOt.setUniqueId(this.gOq.getUniqueId());
        }
        this.gOv = new f();
        this.eFz = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aYY() {
        if (!this.gOs.pu() && this.eFz.atD() && bEX()) {
            this.eFz.fu(true);
            this.eFz.fw(true);
            this.gOr.d(this.gOu);
            this.gOs.setNeedCache(false);
            this.gOs.atv();
            this.gOq.c(this.eFz);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boE() {
        if (this.gOs.pu() || !bEX()) {
            return false;
        }
        this.gOu = null;
        this.gOr.reset();
        this.gOs.setNeedCache(true);
        this.gOs.atv();
        return true;
    }

    protected boolean bEX() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gOv != null && this.gOv.gPp != null) {
            this.gOv.gPp.clear();
        }
        this.gOq.bEY();
        this.gOq.a(this.gOv);
        return false;
    }

    public boolean aYX() {
        if (bEX()) {
            if (this.gOq != null) {
                this.gOq.bEZ();
            }
            this.gOt.a((com.baidu.tbadk.mvc.b.e) this.gOr);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gOv.bFr().clear();
        }
        this.gOv.a(cVar);
        if (cVar != null && cVar.bFr() != null && cVar.bFr().size() > 0) {
            this.gOu = cVar.bFr().get(cVar.bFr().size() - 1);
            if (this.gOv.getPage() != null) {
                this.eFz.fv(this.gOv.getPage().acp() == 1);
            } else {
                this.eFz.fv(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.eFz.fw(true);
        } else {
            this.gOu = null;
            this.eFz.fv(false);
            this.eFz.fw(false);
        }
        this.eFz.fu(false);
        this.eFz.ft(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amN();
        if (!TbadkCoreApplication.isLogin()) {
            this.gOv.bFr().clear();
        } else {
            this.gOq.c(this.eFz);
        }
        this.gOq.a(this.gOv);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gOr, readCacheRespMsg.getData().get(0));
        }
        this.gOu = null;
        this.gOr.reset();
        this.gOs.setNeedCache(true);
        this.gOs.atv();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gOq.bEY();
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
            this.gOq.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gOq.bEY();
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
            this.gOq.a(errorData);
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

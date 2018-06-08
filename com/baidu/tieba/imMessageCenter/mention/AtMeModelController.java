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
    private com.baidu.tbadk.mvc.d.a cGk;
    private AtMessageActivity eyU;
    private b eyV;
    private AtMeNetModel eyW;
    private AtMeCacheModel eyX;
    private FeedData eyY;
    private f eyZ;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ad(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eyU.aNh();
                }
            }
        };
        this.eyU = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.eyV = new b();
        this.eyW = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ad(this.eyU.getPageContext().getPageActivity()), this.eyV);
        this.eyW.a(this);
        if (this.eyU != null) {
            this.eyW.setUniqueId(this.eyU.getUniqueId());
        }
        this.eyW.registerListener(this.mNetworkChangedMessageListener);
        this.eyX = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ad(this.eyU.getPageContext().getPageActivity()));
        this.eyX.a(this);
        if (this.eyU != null) {
            this.eyX.setUniqueId(this.eyU.getUniqueId());
        }
        this.eyZ = new f();
        this.cGk = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akt() {
        if (!this.eyW.Ax() && this.cGk.JM() && aNg()) {
            this.cGk.bQ(true);
            this.cGk.bS(true);
            this.eyV.d(this.eyY);
            this.eyW.setNeedCache(false);
            this.eyW.JE();
            this.eyU.b(this.cGk);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avn() {
        if (this.eyW.Ax() || !aNg()) {
            return false;
        }
        this.eyY = null;
        this.eyV.reset();
        this.eyW.setNeedCache(true);
        this.eyW.JE();
        return true;
    }

    protected boolean aNg() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eyZ != null && this.eyZ.ezW != null) {
            this.eyZ.ezW.clear();
        }
        this.eyU.aNh();
        this.eyU.a(this.eyZ);
        return false;
    }

    public boolean aks() {
        if (aNg()) {
            if (this.eyU != null) {
                this.eyU.aNi();
            }
            this.eyX.a((com.baidu.tbadk.mvc.b.e) this.eyV);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eyZ.aNB().clear();
        }
        this.eyZ.a(cVar);
        if (cVar != null && cVar.aNB() != null && cVar.aNB().size() > 0) {
            this.eyY = cVar.aNB().get(cVar.aNB().size() - 1);
            if (this.eyZ.uB() != null) {
                this.cGk.bR(this.eyZ.uB().ux() == 1);
            } else {
                this.cGk.bR(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cGk.bS(true);
        } else {
            this.eyY = null;
            this.cGk.bR(false);
            this.cGk.bS(false);
        }
        this.cGk.bQ(false);
        this.cGk.bP(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dm();
        if (!TbadkCoreApplication.isLogin()) {
            this.eyZ.aNB().clear();
        } else {
            this.eyU.b(this.cGk);
        }
        this.eyU.a(this.eyZ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eyV, readCacheRespMsg.getData().get(0));
        }
        this.eyY = null;
        this.eyV.reset();
        this.eyW.setNeedCache(true);
        this.eyW.JE();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eyU.aNh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgAtme(0);
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
            this.eyU.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eyU.aNh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgAtme(0);
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
            this.eyU.a(errorData);
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

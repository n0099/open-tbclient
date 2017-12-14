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
    private com.baidu.tbadk.mvc.d.a ciA;
    private AtMessageActivity dZV;
    private b dZW;
    private AtMeNetModel dZX;
    private AtMeCacheModel dZY;
    private FeedData dZZ;
    private f eaa;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dZV.aEI();
                }
            }
        };
        this.dZV = atMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dZW = new b();
        this.dZX = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dZV.getPageContext().getPageActivity()), this.dZW);
        this.dZX.a(this);
        if (this.dZV != null) {
            this.dZX.setUniqueId(this.dZV.getUniqueId());
        }
        this.dZX.registerListener(this.mNetworkChangedMessageListener);
        this.dZY = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dZV.getPageContext().getPageActivity()));
        this.dZY.a(this);
        if (this.dZV != null) {
            this.dZY.setUniqueId(this.dZV.getUniqueId());
        }
        this.eaa = new f();
        this.ciA = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adr() {
        if (!this.dZX.wA() && this.ciA.FJ() && aEH()) {
            this.ciA.bO(true);
            this.ciA.bQ(true);
            this.dZW.g(this.dZZ);
            this.dZX.setNeedCache(false);
            this.dZX.Fz();
            this.dZV.b(this.ciA);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aEG() {
        if (this.dZX.wA() || !aEH()) {
            return false;
        }
        this.dZZ = null;
        this.dZW.reset();
        this.dZX.setNeedCache(true);
        this.dZX.Fz();
        return true;
    }

    protected boolean aEH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eaa != null && this.eaa.eaG != null) {
            this.eaa.eaG.clear();
        }
        this.dZV.aEI();
        this.dZV.a(this.eaa);
        return false;
    }

    public boolean adq() {
        if (aEH()) {
            if (this.dZV != null) {
                this.dZV.aEJ();
            }
            this.dZY.a((com.baidu.tbadk.mvc.b.e) this.dZW);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eaa.aEQ().clear();
        }
        this.eaa.a(cVar);
        if (cVar != null && cVar.aEQ() != null && cVar.aEQ().size() > 0) {
            this.dZZ = cVar.aEQ().get(cVar.aEQ().size() - 1);
            if (this.eaa.qy() != null) {
                this.ciA.bP(this.eaa.qy().qu() == 1);
            } else {
                this.ciA.bP(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.ciA.bQ(true);
        } else {
            this.dZZ = null;
            this.ciA.bP(false);
            this.ciA.bQ(false);
        }
        this.ciA.bO(false);
        this.ciA.bN(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zd();
        if (!TbadkCoreApplication.isLogin()) {
            this.eaa.aEQ().clear();
        } else {
            this.dZV.b(this.ciA);
        }
        this.dZV.a(this.eaa);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dZW, readCacheRespMsg.getData().get(0));
        }
        this.dZZ = null;
        this.dZW.reset();
        this.dZX.setNeedCache(true);
        this.dZX.Fz();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dZV.aEI();
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
            this.dZV.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dZV.aEI();
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
            this.dZV.a(errorData);
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

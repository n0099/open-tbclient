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
    private com.baidu.tbadk.mvc.d.a cEd;
    private AtMessageActivity eCJ;
    private b eCK;
    private AtMeNetModel eCL;
    private AtMeCacheModel eCM;
    private FeedData eCN;
    private f eCO;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ad(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eCJ.aNN();
                }
            }
        };
        this.eCJ = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.eCK = new b();
        this.eCL = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ad(this.eCJ.getPageContext().getPageActivity()), this.eCK);
        this.eCL.a(this);
        if (this.eCJ != null) {
            this.eCL.setUniqueId(this.eCJ.getUniqueId());
        }
        this.eCL.registerListener(this.mNetworkChangedMessageListener);
        this.eCM = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ad(this.eCJ.getPageContext().getPageActivity()));
        this.eCM.a(this);
        if (this.eCJ != null) {
            this.eCM.setUniqueId(this.eCJ.getUniqueId());
        }
        this.eCO = new f();
        this.cEd = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ajN() {
        if (!this.eCL.AO() && this.cEd.Ke() && aNM()) {
            this.cEd.bT(true);
            this.cEd.bV(true);
            this.eCK.d(this.eCN);
            this.eCL.setNeedCache(false);
            this.eCL.JW();
            this.eCJ.b(this.cEd);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avR() {
        if (this.eCL.AO() || !aNM()) {
            return false;
        }
        this.eCN = null;
        this.eCK.reset();
        this.eCL.setNeedCache(true);
        this.eCL.JW();
        return true;
    }

    protected boolean aNM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eCO != null && this.eCO.eDM != null) {
            this.eCO.eDM.clear();
        }
        this.eCJ.aNN();
        this.eCJ.a(this.eCO);
        return false;
    }

    public boolean ajM() {
        if (aNM()) {
            if (this.eCJ != null) {
                this.eCJ.aNO();
            }
            this.eCM.a((com.baidu.tbadk.mvc.b.e) this.eCK);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eCO.aOh().clear();
        }
        this.eCO.a(cVar);
        if (cVar != null && cVar.aOh() != null && cVar.aOh().size() > 0) {
            this.eCN = cVar.aOh().get(cVar.aOh().size() - 1);
            if (this.eCO.uJ() != null) {
                this.cEd.bU(this.eCO.uJ().uF() == 1);
            } else {
                this.cEd.bU(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cEd.bV(true);
        } else {
            this.eCN = null;
            this.cEd.bU(false);
            this.cEd.bV(false);
        }
        this.cEd.bT(false);
        this.cEd.bS(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DE();
        if (!TbadkCoreApplication.isLogin()) {
            this.eCO.aOh().clear();
        } else {
            this.eCJ.b(this.cEd);
        }
        this.eCJ.a(this.eCO);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eCK, readCacheRespMsg.getData().get(0));
        }
        this.eCN = null;
        this.eCK.reset();
        this.eCL.setNeedCache(true);
        this.eCL.JW();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eCJ.aNN();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgAtme(0);
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
            this.eCJ.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eCJ.aNN();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgAtme(0);
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
            this.eCJ.a(errorData);
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

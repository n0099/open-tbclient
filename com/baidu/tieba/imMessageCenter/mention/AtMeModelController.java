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
    private com.baidu.tbadk.mvc.d.a cwB;
    private AtMeCacheModel emA;
    private FeedData emB;
    private f emC;
    private AtMessageActivity emx;
    private b emy;
    private AtMeNetModel emz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.emx.aIo();
                }
            }
        };
        this.emx = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.emy = new b();
        this.emz = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.emx.getPageContext().getPageActivity()), this.emy);
        this.emz.a(this);
        if (this.emx != null) {
            this.emz.setUniqueId(this.emx.getUniqueId());
        }
        this.emz.registerListener(this.mNetworkChangedMessageListener);
        this.emA = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.emx.getPageContext().getPageActivity()));
        this.emA.a(this);
        if (this.emx != null) {
            this.emA.setUniqueId(this.emx.getUniqueId());
        }
        this.emC = new f();
        this.cwB = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agL() {
        if (!this.emz.wX() && this.cwB.Gg() && aIn()) {
            this.cwB.bM(true);
            this.cwB.bO(true);
            this.emy.d(this.emB);
            this.emz.setNeedCache(false);
            this.emz.FY();
            this.emx.b(this.cwB);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arj() {
        if (this.emz.wX() || !aIn()) {
            return false;
        }
        this.emB = null;
        this.emy.reset();
        this.emz.setNeedCache(true);
        this.emz.FY();
        return true;
    }

    protected boolean aIn() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.emC != null && this.emC.enz != null) {
            this.emC.enz.clear();
        }
        this.emx.aIo();
        this.emx.a(this.emC);
        return false;
    }

    public boolean agK() {
        if (aIn()) {
            if (this.emx != null) {
                this.emx.aIp();
            }
            this.emA.a((com.baidu.tbadk.mvc.b.e) this.emy);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.emC.aIH().clear();
        }
        this.emC.a(cVar);
        if (cVar != null && cVar.aIH() != null && cVar.aIH().size() > 0) {
            this.emB = cVar.aIH().get(cVar.aIH().size() - 1);
            if (this.emC.rg() != null) {
                this.cwB.bN(this.emC.rg().rc() == 1);
            } else {
                this.cwB.bN(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cwB.bO(true);
        } else {
            this.emB = null;
            this.cwB.bN(false);
            this.cwB.bO(false);
        }
        this.cwB.bM(false);
        this.cwB.bL(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zM();
        if (!TbadkCoreApplication.isLogin()) {
            this.emC.aIH().clear();
        } else {
            this.emx.b(this.cwB);
        }
        this.emx.a(this.emC);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.emy, readCacheRespMsg.getData().get(0));
        }
        this.emB = null;
        this.emy.reset();
        this.emz.setNeedCache(true);
        this.emz.FY();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.emx.aIo();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
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
            this.emx.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.emx.aIo();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
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
            this.emx.a(errorData);
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

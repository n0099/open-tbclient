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
    private com.baidu.tbadk.mvc.d.a cUP;
    private FeedData eVA;
    private f eVB;
    private AtMessageActivity eVw;
    private b eVx;
    private AtMeNetModel eVy;
    private AtMeCacheModel eVz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eVw.aUn();
                }
            }
        };
        this.eVw = atMessageActivity;
    }

    public void j(Bundle bundle) {
        this.eVx = new b();
        this.eVy = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.eVw.getPageContext().getPageActivity()), this.eVx);
        this.eVy.a(this);
        if (this.eVw != null) {
            this.eVy.setUniqueId(this.eVw.getUniqueId());
        }
        this.eVy.registerListener(this.mNetworkChangedMessageListener);
        this.eVz = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.eVw.getPageContext().getPageActivity()));
        this.eVz.a(this);
        if (this.eVw != null) {
            this.eVz.setUniqueId(this.eVw.getUniqueId());
        }
        this.eVB = new f();
        this.cUP = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apz() {
        if (!this.eVy.DU() && this.cUP.Nr() && aUm()) {
            this.cUP.cn(true);
            this.cUP.cp(true);
            this.eVx.d(this.eVA);
            this.eVy.setNeedCache(false);
            this.eVy.Nj();
            this.eVw.b(this.cUP);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aCc() {
        if (this.eVy.DU() || !aUm()) {
            return false;
        }
        this.eVA = null;
        this.eVx.reset();
        this.eVy.setNeedCache(true);
        this.eVy.Nj();
        return true;
    }

    protected boolean aUm() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eVB != null && this.eVB.eWz != null) {
            this.eVB.eWz.clear();
        }
        this.eVw.aUn();
        this.eVw.a(this.eVB);
        return false;
    }

    public boolean apy() {
        if (aUm()) {
            if (this.eVw != null) {
                this.eVw.aUo();
            }
            this.eVz.a((com.baidu.tbadk.mvc.b.e) this.eVx);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eVB.aUH().clear();
        }
        this.eVB.a(cVar);
        if (cVar != null && cVar.aUH() != null && cVar.aUH().size() > 0) {
            this.eVA = cVar.aUH().get(cVar.aUH().size() - 1);
            if (this.eVB.xH() != null) {
                this.cUP.co(this.eVB.xH().xD() == 1);
            } else {
                this.cUP.co(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cUP.cp(true);
        } else {
            this.eVA = null;
            this.cUP.co(false);
            this.cUP.cp(false);
        }
        this.cUP.cn(false);
        this.cUP.cm(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GO();
        if (!TbadkCoreApplication.isLogin()) {
            this.eVB.aUH().clear();
        } else {
            this.eVw.b(this.cUP);
        }
        this.eVw.a(this.eVB);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eVx, readCacheRespMsg.getData().get(0));
        }
        this.eVA = null;
        this.eVx.reset();
        this.eVy.setNeedCache(true);
        this.eVy.Nj();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eVw.aUn();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgAtme(0);
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
            this.eVw.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eVw.aUn();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgAtme(0);
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
            this.eVw.a(errorData);
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

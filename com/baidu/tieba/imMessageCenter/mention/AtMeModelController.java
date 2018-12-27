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
    private com.baidu.tbadk.mvc.d.a dfx;
    private f fgA;
    private AtMessageActivity fgv;
    private b fgw;
    private AtMeNetModel fgx;
    private AtMeCacheModel fgy;
    private FeedData fgz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.fgv.aWp();
                }
            }
        };
        this.fgv = atMessageActivity;
    }

    public void p(Bundle bundle) {
        this.fgw = new b();
        this.fgx = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.fgv.getPageContext().getPageActivity()), this.fgw);
        this.fgx.a(this);
        if (this.fgv != null) {
            this.fgx.setUniqueId(this.fgv.getUniqueId());
        }
        this.fgx.registerListener(this.mNetworkChangedMessageListener);
        this.fgy = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.fgv.getPageContext().getPageActivity()));
        this.fgy.a(this);
        if (this.fgv != null) {
            this.fgy.setUniqueId(this.fgv.getUniqueId());
        }
        this.fgA = new f();
        this.dfx = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arC() {
        if (!this.fgx.Fi() && this.dfx.OF() && aWo()) {
            this.dfx.cF(true);
            this.dfx.cH(true);
            this.fgw.d(this.fgz);
            this.fgx.setNeedCache(false);
            this.fgx.Ox();
            this.fgv.b(this.dfx);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGA() {
        if (this.fgx.Fi() || !aWo()) {
            return false;
        }
        this.fgz = null;
        this.fgw.reset();
        this.fgx.setNeedCache(true);
        this.fgx.Ox();
        return true;
    }

    protected boolean aWo() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.fgA != null && this.fgA.fhy != null) {
            this.fgA.fhy.clear();
        }
        this.fgv.aWp();
        this.fgv.a(this.fgA);
        return false;
    }

    public boolean arB() {
        if (aWo()) {
            if (this.fgv != null) {
                this.fgv.aWq();
            }
            this.fgy.a((com.baidu.tbadk.mvc.b.e) this.fgw);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.fgA.aWJ().clear();
        }
        this.fgA.a(cVar);
        if (cVar != null && cVar.aWJ() != null && cVar.aWJ().size() > 0) {
            this.fgz = cVar.aWJ().get(cVar.aWJ().size() - 1);
            if (this.fgA.yS() != null) {
                this.dfx.cG(this.fgA.yS().yP() == 1);
            } else {
                this.dfx.cG(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.dfx.cH(true);
        } else {
            this.fgz = null;
            this.dfx.cG(false);
            this.dfx.cH(false);
        }
        this.dfx.cF(false);
        this.dfx.cE(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.HQ().If();
        if (!TbadkCoreApplication.isLogin()) {
            this.fgA.aWJ().clear();
        } else {
            this.fgv.b(this.dfx);
        }
        this.fgv.a(this.fgA);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.fgw, readCacheRespMsg.getData().get(0));
        }
        this.fgz = null;
        this.fgw.reset();
        this.fgx.setNeedCache(true);
        this.fgx.Ox();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fgv.aWp();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgAtme(0);
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
            this.fgv.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fgv.aWp();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgAtme(0);
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
            this.fgv.a(errorData);
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

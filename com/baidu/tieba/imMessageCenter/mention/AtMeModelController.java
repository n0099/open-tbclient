package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
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
/* loaded from: classes21.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener dWI;
    private com.baidu.tbadk.mvc.d.a hvy;
    private AtMessageActivity jMn;
    private b jMo;
    private AtMeNetModel jMp;
    private AtMeCacheModel jMq;
    private FeedData jMr;
    private f jMs;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.dWI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.jMn.cNi();
                }
            }
        };
        this.jMn = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.jMo = new b();
        this.jMp = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.jMn.getPageContext().getPageActivity()), this.jMo);
        this.jMp.a(this);
        if (this.jMn != null) {
            this.jMp.setUniqueId(this.jMn.getUniqueId());
        }
        this.jMp.registerListener(this.dWI);
        this.jMq = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.jMn.getPageContext().getPageActivity()));
        this.jMq.a(this);
        if (this.jMn != null) {
            this.jMq.setUniqueId(this.jMn.getUniqueId());
        }
        this.jMs = new f();
        this.hvy = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cfY() {
        if (!this.jMp.isLoading() && this.hvy.buO() && cNh()) {
            this.hvy.jz(true);
            this.hvy.jB(true);
            this.jMo.e(this.jMr);
            this.jMp.setNeedCache(false);
            this.jMp.loadData();
            this.jMn.c(this.hvy);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cuH() {
        if (this.jMp.isLoading() || !cNh()) {
            return false;
        }
        this.jMr = null;
        this.jMo.reset();
        this.jMp.setNeedCache(true);
        this.jMp.loadData();
        return true;
    }

    protected boolean cNh() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jMs != null && this.jMs.jNO != null) {
            this.jMs.jNO.clear();
        }
        this.jMn.cNi();
        this.jMn.a(this.jMs);
        return false;
    }

    public boolean cfX() {
        if (cNh()) {
            if (this.jMn != null) {
                this.jMn.cNj();
            }
            this.jMq.a((com.baidu.tbadk.mvc.b.e) this.jMo);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.jMs.cNz().clear();
        }
        this.jMs.a(cVar);
        if (cVar != null && cVar.cNz() != null && cVar.cNz().size() > 0) {
            this.jMr = cVar.cNz().get(cVar.cNz().size() - 1);
            if (this.jMs.getPage() != null) {
                this.hvy.jA(this.jMs.getPage().beo() == 1);
            } else {
                this.hvy.jA(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.hvy.jB(true);
        } else {
            this.jMr = null;
            this.hvy.jA(false);
            this.hvy.jB(false);
        }
        this.hvy.jz(false);
        this.hvy.jy(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpd();
        if (!TbadkCoreApplication.isLogin()) {
            this.jMs.cNz().clear();
        } else {
            this.jMn.c(this.hvy);
        }
        this.jMn.a(this.jMs);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jMo, readCacheRespMsg.getData().get(0));
        }
        this.jMr = null;
        this.jMo.reset();
        this.jMp.setNeedCache(true);
        this.jMp.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jMn.cNi();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgAtme(0);
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
            this.jMn.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jMn.cNi();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgAtme(0);
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
            this.jMn.a(errorData);
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

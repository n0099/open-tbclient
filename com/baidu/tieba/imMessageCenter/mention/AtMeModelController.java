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
/* loaded from: classes16.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener dUu;
    private com.baidu.tbadk.mvc.d.a hoq;
    private AtMessageActivity jDF;
    private b jDG;
    private AtMeNetModel jDH;
    private AtMeCacheModel jDI;
    private FeedData jDJ;
    private f jDK;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.I(atMessageActivity.getPageContext().getPageActivity()));
        this.dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.jDF.cJB();
                }
            }
        };
        this.jDF = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.jDG = new b();
        this.jDH = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.I(this.jDF.getPageContext().getPageActivity()), this.jDG);
        this.jDH.a(this);
        if (this.jDF != null) {
            this.jDH.setUniqueId(this.jDF.getUniqueId());
        }
        this.jDH.registerListener(this.dUu);
        this.jDI = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.I(this.jDF.getPageContext().getPageActivity()));
        this.jDI.a(this);
        if (this.jDF != null) {
            this.jDI.setUniqueId(this.jDF.getUniqueId());
        }
        this.jDK = new f();
        this.hoq = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ccI() {
        if (!this.jDH.isLoading() && this.hoq.btJ() && cJA()) {
            this.hoq.jw(true);
            this.hoq.jy(true);
            this.jDG.e(this.jDJ);
            this.jDH.setNeedCache(false);
            this.jDH.loadData();
            this.jDF.c(this.hoq);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crr() {
        if (this.jDH.isLoading() || !cJA()) {
            return false;
        }
        this.jDJ = null;
        this.jDG.reset();
        this.jDH.setNeedCache(true);
        this.jDH.loadData();
        return true;
    }

    protected boolean cJA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jDK != null && this.jDK.jFg != null) {
            this.jDK.jFg.clear();
        }
        this.jDF.cJB();
        this.jDF.a(this.jDK);
        return false;
    }

    public boolean ccH() {
        if (cJA()) {
            if (this.jDF != null) {
                this.jDF.cJC();
            }
            this.jDI.a((com.baidu.tbadk.mvc.b.e) this.jDG);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.jDK.cJS().clear();
        }
        this.jDK.a(cVar);
        if (cVar != null && cVar.cJS() != null && cVar.cJS().size() > 0) {
            this.jDJ = cVar.cJS().get(cVar.cJS().size() - 1);
            if (this.jDK.getPage() != null) {
                this.hoq.jx(this.jDK.getPage().bdu() == 1);
            } else {
                this.hoq.jx(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.hoq.jy(true);
        } else {
            this.jDJ = null;
            this.hoq.jx(false);
            this.hoq.jy(false);
        }
        this.hoq.jw(false);
        this.hoq.jv(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boj();
        if (!TbadkCoreApplication.isLogin()) {
            this.jDK.cJS().clear();
        } else {
            this.jDF.c(this.hoq);
        }
        this.jDF.a(this.jDK);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jDG, readCacheRespMsg.getData().get(0));
        }
        this.jDJ = null;
        this.jDG.reset();
        this.jDH.setNeedCache(true);
        this.jDH.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jDF.cJB();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgAtme(0);
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
            this.jDF.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jDF.cJB();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgAtme(0);
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
            this.jDF.a(errorData);
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

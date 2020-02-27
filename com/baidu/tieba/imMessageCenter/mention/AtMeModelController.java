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
/* loaded from: classes9.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener cLx;
    private com.baidu.tbadk.mvc.d.a fOo;
    private AtMessageActivity hOc;
    private b hOd;
    private AtMeNetModel hOe;
    private AtMeCacheModel hOf;
    private FeedData hOg;
    private f hOh;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.cLx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.hOc.bZp();
                }
            }
        };
        this.hOc = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.hOd = new b();
        this.hOe = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.hOc.getPageContext().getPageActivity()), this.hOd);
        this.hOe.a(this);
        if (this.hOc != null) {
            this.hOe.setUniqueId(this.hOc.getUniqueId());
        }
        this.hOe.registerListener(this.cLx);
        this.hOf = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.hOc.getPageContext().getPageActivity()));
        this.hOf.a(this);
        if (this.hOc != null) {
            this.hOf.setUniqueId(this.hOc.getUniqueId());
        }
        this.hOh = new f();
        this.fOo = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bvN() {
        if (!this.hOe.isLoading() && this.fOo.aQH() && bZo()) {
            this.fOo.gP(true);
            this.fOo.gR(true);
            this.hOd.d(this.hOg);
            this.hOe.setNeedCache(false);
            this.hOe.loadData();
            this.hOc.c(this.fOo);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bIJ() {
        if (this.hOe.isLoading() || !bZo()) {
            return false;
        }
        this.hOg = null;
        this.hOd.reset();
        this.hOe.setNeedCache(true);
        this.hOe.loadData();
        return true;
    }

    protected boolean bZo() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hOh != null && this.hOh.hPd != null) {
            this.hOh.hPd.clear();
        }
        this.hOc.bZp();
        this.hOc.a(this.hOh);
        return false;
    }

    public boolean bvM() {
        if (bZo()) {
            if (this.hOc != null) {
                this.hOc.bZq();
            }
            this.hOf.a((com.baidu.tbadk.mvc.b.e) this.hOd);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.hOh.bZI().clear();
        }
        this.hOh.a(cVar);
        if (cVar != null && cVar.bZI() != null && cVar.bZI().size() > 0) {
            this.hOg = cVar.bZI().get(cVar.bZI().size() - 1);
            if (this.hOh.getPage() != null) {
                this.fOo.gQ(this.hOh.getPage().aBi() == 1);
            } else {
                this.fOo.gQ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.fOo.gR(true);
        } else {
            this.hOg = null;
            this.fOo.gQ(false);
            this.fOo.gR(false);
        }
        this.fOo.gP(false);
        this.fOo.gO(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKR();
        if (!TbadkCoreApplication.isLogin()) {
            this.hOh.bZI().clear();
        } else {
            this.hOc.c(this.fOo);
        }
        this.hOc.a(this.hOh);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hOd, readCacheRespMsg.getData().get(0));
        }
        this.hOg = null;
        this.hOd.reset();
        this.hOe.setNeedCache(true);
        this.hOe.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hOc.bZp();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgAtme(0);
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
            this.hOc.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hOc.bZp();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgAtme(0);
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
            this.hOc.a(errorData);
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

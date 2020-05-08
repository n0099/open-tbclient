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
    final CustomMessageListener dkW;
    private com.baidu.tbadk.mvc.d.a gtY;
    private AtMessageActivity izN;
    private b izO;
    private AtMeNetModel izP;
    private AtMeCacheModel izQ;
    private FeedData izR;
    private f izS;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.G(atMessageActivity.getPageContext().getPageActivity()));
        this.dkW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.izN.ckj();
                }
            }
        };
        this.izN = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.izO = new b();
        this.izP = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.G(this.izN.getPageContext().getPageActivity()), this.izO);
        this.izP.a(this);
        if (this.izN != null) {
            this.izP.setUniqueId(this.izN.getUniqueId());
        }
        this.izP.registerListener(this.dkW);
        this.izQ = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.G(this.izN.getPageContext().getPageActivity()));
        this.izQ.a(this);
        if (this.izN != null) {
            this.izQ.setUniqueId(this.izN.getUniqueId());
        }
        this.izS = new f();
        this.gtY = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bFE() {
        if (!this.izP.isLoading() && this.gtY.aYW() && cki()) {
            this.gtY.hO(true);
            this.gtY.hQ(true);
            this.izO.d(this.izR);
            this.izP.setNeedCache(false);
            this.izP.loadData();
            this.izN.c(this.gtY);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bTt() {
        if (this.izP.isLoading() || !cki()) {
            return false;
        }
        this.izR = null;
        this.izO.reset();
        this.izP.setNeedCache(true);
        this.izP.loadData();
        return true;
    }

    protected boolean cki() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.izS != null && this.izS.iAO != null) {
            this.izS.iAO.clear();
        }
        this.izN.ckj();
        this.izN.a(this.izS);
        return false;
    }

    public boolean bFD() {
        if (cki()) {
            if (this.izN != null) {
                this.izN.ckk();
            }
            this.izQ.a((com.baidu.tbadk.mvc.b.e) this.izO);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.izS.ckC().clear();
        }
        this.izS.a(cVar);
        if (cVar != null && cVar.ckC() != null && cVar.ckC().size() > 0) {
            this.izR = cVar.ckC().get(cVar.ckC().size() - 1);
            if (this.izS.getPage() != null) {
                this.gtY.hP(this.izS.getPage().aJy() == 1);
            } else {
                this.gtY.hP(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.gtY.hQ(true);
        } else {
            this.izR = null;
            this.gtY.hP(false);
            this.gtY.hQ(false);
        }
        this.gtY.hO(false);
        this.gtY.hN(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTt();
        if (!TbadkCoreApplication.isLogin()) {
            this.izS.ckC().clear();
        } else {
            this.izN.c(this.gtY);
        }
        this.izN.a(this.izS);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.izO, readCacheRespMsg.getData().get(0));
        }
        this.izR = null;
        this.izO.reset();
        this.izP.setNeedCache(true);
        this.izP.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.izN.ckj();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgAtme(0);
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
            this.izN.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.izN.ckj();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgAtme(0);
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
            this.izN.a(errorData);
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

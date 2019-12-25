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
/* loaded from: classes6.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    final CustomMessageListener cHi;
    private com.baidu.tbadk.mvc.d.a fII;
    private AtMessageActivity hIB;
    private b hIC;
    private AtMeNetModel hID;
    private AtMeCacheModel hIE;
    private FeedData hIF;
    private f hIG;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.cHi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.hIB.bWF();
                }
            }
        };
        this.hIB = atMessageActivity;
    }

    public void ad(Bundle bundle) {
        this.hIC = new b();
        this.hID = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.hIB.getPageContext().getPageActivity()), this.hIC);
        this.hID.a(this);
        if (this.hIB != null) {
            this.hID.setUniqueId(this.hIB.getUniqueId());
        }
        this.hID.registerListener(this.cHi);
        this.hIE = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.hIB.getPageContext().getPageActivity()));
        this.hIE.a(this);
        if (this.hIB != null) {
            this.hIE.setUniqueId(this.hIB.getUniqueId());
        }
        this.hIG = new f();
        this.fII = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bth() {
        if (!this.hID.isLoading() && this.fII.aNZ() && bWE()) {
            this.fII.gD(true);
            this.fII.gF(true);
            this.hIC.d(this.hIF);
            this.hID.setNeedCache(false);
            this.hID.loadData();
            this.hIB.c(this.fII);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bGg() {
        if (this.hID.isLoading() || !bWE()) {
            return false;
        }
        this.hIF = null;
        this.hIC.reset();
        this.hID.setNeedCache(true);
        this.hID.loadData();
        return true;
    }

    protected boolean bWE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hIG != null && this.hIG.hJC != null) {
            this.hIG.hJC.clear();
        }
        this.hIB.bWF();
        this.hIB.a(this.hIG);
        return false;
    }

    public boolean btg() {
        if (bWE()) {
            if (this.hIB != null) {
                this.hIB.bWG();
            }
            this.hIE.a((com.baidu.tbadk.mvc.b.e) this.hIC);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.hIG.bWY().clear();
        }
        this.hIG.a(cVar);
        if (cVar != null && cVar.bWY() != null && cVar.bWY().size() > 0) {
            this.hIF = cVar.bWY().get(cVar.bWY().size() - 1);
            if (this.hIG.getPage() != null) {
                this.fII.gE(this.hIG.getPage().ayy() == 1);
            } else {
                this.fII.gE(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.fII.gF(true);
        } else {
            this.hIF = null;
            this.fII.gE(false);
            this.fII.gF(false);
        }
        this.fII.gD(false);
        this.fII.gC(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIe();
        if (!TbadkCoreApplication.isLogin()) {
            this.hIG.bWY().clear();
        } else {
            this.hIB.c(this.fII);
        }
        this.hIB.a(this.hIG);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hIC, readCacheRespMsg.getData().get(0));
        }
        this.hIF = null;
        this.hIC.reset();
        this.hID.setNeedCache(true);
        this.hID.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hIB.bWF();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aHP().setMsgAtme(0);
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
            this.hIB.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.hIB.bWF();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aHP().setMsgAtme(0);
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
            this.hIB.a(errorData);
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

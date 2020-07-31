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
    final CustomMessageListener dLm;
    private com.baidu.tbadk.mvc.d.a hbz;
    private AtMessageActivity joF;
    private b joG;
    private AtMeNetModel joH;
    private AtMeCacheModel joI;
    private FeedData joJ;
    private f joK;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.G(atMessageActivity.getPageContext().getPageActivity()));
        this.dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.joF.cyK();
                }
            }
        };
        this.joF = atMessageActivity;
    }

    public void ak(Bundle bundle) {
        this.joG = new b();
        this.joH = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.G(this.joF.getPageContext().getPageActivity()), this.joG);
        this.joH.a(this);
        if (this.joF != null) {
            this.joH.setUniqueId(this.joF.getUniqueId());
        }
        this.joH.registerListener(this.dLm);
        this.joI = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.G(this.joF.getPageContext().getPageActivity()));
        this.joI.a(this);
        if (this.joF != null) {
            this.joI.setUniqueId(this.joF.getUniqueId());
        }
        this.joK = new f();
        this.hbz = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bSw() {
        if (!this.joH.isLoading() && this.hbz.bkX() && cyJ()) {
            this.hbz.iY(true);
            this.hbz.ja(true);
            this.joG.e(this.joJ);
            this.joH.setNeedCache(false);
            this.joH.loadData();
            this.joF.c(this.hbz);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cgM() {
        if (this.joH.isLoading() || !cyJ()) {
            return false;
        }
        this.joJ = null;
        this.joG.reset();
        this.joH.setNeedCache(true);
        this.joH.loadData();
        return true;
    }

    protected boolean cyJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.joK != null && this.joK.jqg != null) {
            this.joK.jqg.clear();
        }
        this.joF.cyK();
        this.joF.a(this.joK);
        return false;
    }

    public boolean bSv() {
        if (cyJ()) {
            if (this.joF != null) {
                this.joF.cyL();
            }
            this.joI.a((com.baidu.tbadk.mvc.b.e) this.joG);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.joK.czb().clear();
        }
        this.joK.a(cVar);
        if (cVar != null && cVar.czb() != null && cVar.czb().size() > 0) {
            this.joJ = cVar.czb().get(cVar.czb().size() - 1);
            if (this.joK.getPage() != null) {
                this.hbz.iZ(this.joK.getPage().aVb() == 1);
            } else {
                this.hbz.iZ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.hbz.ja(true);
        } else {
            this.joJ = null;
            this.hbz.iZ(false);
            this.hbz.ja(false);
        }
        this.hbz.iY(false);
        this.hbz.iX(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfz();
        if (!TbadkCoreApplication.isLogin()) {
            this.joK.czb().clear();
        } else {
            this.joF.c(this.hbz);
        }
        this.joF.a(this.joK);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.joG, readCacheRespMsg.getData().get(0));
        }
        this.joJ = null;
        this.joG.reset();
        this.joH.setNeedCache(true);
        this.joH.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.joF.cyK();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgAtme(0);
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
            this.joF.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.joF.cyK();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgAtme(0);
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
            this.joF.a(errorData);
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

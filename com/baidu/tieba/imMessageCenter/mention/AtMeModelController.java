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
    final CustomMessageListener dyW;
    private com.baidu.tbadk.mvc.d.a gIJ;
    private AtMessageActivity iOu;
    private b iOv;
    private AtMeNetModel iOw;
    private AtMeCacheModel iOx;
    private FeedData iOy;
    private f iOz;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.G(atMessageActivity.getPageContext().getPageActivity()));
        this.dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.iOu.cqI();
                }
            }
        };
        this.iOu = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.iOv = new b();
        this.iOw = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.G(this.iOu.getPageContext().getPageActivity()), this.iOv);
        this.iOw.a(this);
        if (this.iOu != null) {
            this.iOw.setUniqueId(this.iOu.getUniqueId());
        }
        this.iOw.registerListener(this.dyW);
        this.iOx = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.G(this.iOu.getPageContext().getPageActivity()));
        this.iOx.a(this);
        if (this.iOu != null) {
            this.iOx.setUniqueId(this.iOu.getUniqueId());
        }
        this.iOz = new f();
        this.gIJ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bLY() {
        if (!this.iOw.isLoading() && this.gIJ.bfg() && cqH()) {
            this.gIJ.ik(true);
            this.gIJ.im(true);
            this.iOv.d(this.iOy);
            this.iOw.setNeedCache(false);
            this.iOw.loadData();
            this.iOu.c(this.gIJ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bZQ() {
        if (this.iOw.isLoading() || !cqH()) {
            return false;
        }
        this.iOy = null;
        this.iOv.reset();
        this.iOw.setNeedCache(true);
        this.iOw.loadData();
        return true;
    }

    protected boolean cqH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.iOz != null && this.iOz.iPv != null) {
            this.iOz.iPv.clear();
        }
        this.iOu.cqI();
        this.iOu.a(this.iOz);
        return false;
    }

    public boolean bLX() {
        if (cqH()) {
            if (this.iOu != null) {
                this.iOu.cqJ();
            }
            this.iOx.a((com.baidu.tbadk.mvc.b.e) this.iOv);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.iOz.crb().clear();
        }
        this.iOz.a(cVar);
        if (cVar != null && cVar.crb() != null && cVar.crb().size() > 0) {
            this.iOy = cVar.crb().get(cVar.crb().size() - 1);
            if (this.iOz.getPage() != null) {
                this.gIJ.il(this.iOz.getPage().aPt() == 1);
            } else {
                this.gIJ.il(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.gIJ.im(true);
        } else {
            this.iOy = null;
            this.gIJ.il(false);
            this.gIJ.im(false);
        }
        this.gIJ.ik(false);
        this.gIJ.ij(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZA();
        if (!TbadkCoreApplication.isLogin()) {
            this.iOz.crb().clear();
        } else {
            this.iOu.c(this.gIJ);
        }
        this.iOu.a(this.iOz);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.iOv, readCacheRespMsg.getData().get(0));
        }
        this.iOy = null;
        this.iOv.reset();
        this.iOw.setNeedCache(true);
        this.iOw.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.iOu.cqI();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgAtme(0);
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
            this.iOu.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.iOu.cqI();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgAtme(0);
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
            this.iOu.a(errorData);
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

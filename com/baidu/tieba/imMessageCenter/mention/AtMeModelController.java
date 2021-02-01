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
/* loaded from: classes2.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a iBZ;
    private AtMessageActivity kQt;
    private b kQu;
    private AtMeNetModel kQv;
    private AtMeCacheModel kQw;
    private FeedData kQx;
    private f kQy;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.j.K(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kQt.cZb();
                }
            }
        };
        this.kQt = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kQu = new b();
        this.kQv = new AtMeNetModel((TbPageContext) com.baidu.adp.base.j.K(this.kQt.getPageContext().getPageActivity()), this.kQu);
        this.kQv.a(this);
        if (this.kQt != null) {
            this.kQv.setUniqueId(this.kQt.getUniqueId());
        }
        this.kQv.registerListener(this.mNetworkChangedMessageListener);
        this.kQw = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.j.K(this.kQt.getPageContext().getPageActivity()));
        this.kQw.a(this);
        if (this.kQt != null) {
            this.kQw.setUniqueId(this.kQt.getUniqueId());
        }
        this.kQy = new f();
        this.iBZ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ctf() {
        if (!this.kQv.isLoading() && this.iBZ.bDC() && cZa()) {
            this.iBZ.li(true);
            this.iBZ.lk(true);
            this.kQu.e(this.kQx);
            this.kQv.setNeedCache(false);
            this.kQv.loadData();
            this.kQt.c(this.iBZ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cJa() {
        if (this.kQv.isLoading() || !cZa()) {
            return false;
        }
        this.kQx = null;
        this.kQu.reset();
        this.kQv.setNeedCache(true);
        this.kQv.loadData();
        return true;
    }

    protected boolean cZa() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kQy != null && this.kQy.kRU != null) {
            this.kQy.kRU.clear();
        }
        this.kQt.cZb();
        this.kQt.a(this.kQy);
        return false;
    }

    public boolean cte() {
        if (cZa()) {
            if (this.kQt != null) {
                this.kQt.cZc();
            }
            this.kQw.a((com.baidu.tbadk.mvc.b.e) this.kQu);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kQt.WZ();
        if (bVar.getUpdateType() != 4) {
            this.kQy.cZs().clear();
        }
        this.kQy.a(cVar);
        if (cVar != null && cVar.cZs() != null && cVar.cZs().size() > 0) {
            this.kQx = cVar.cZs().get(cVar.cZs().size() - 1);
            if (this.kQy.getPage() != null) {
                this.iBZ.lj(this.kQy.getPage().bmF() == 1);
            } else {
                this.iBZ.lj(true);
            }
            if (bVar != null) {
                bVar.cZv();
            }
            this.iBZ.lk(true);
        } else {
            this.kQx = null;
            this.iBZ.lj(false);
            this.iBZ.lk(false);
        }
        this.iBZ.li(false);
        this.iBZ.lh(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxP();
        if (!TbadkCoreApplication.isLogin()) {
            this.kQy.cZs().clear();
        } else {
            this.kQt.c(this.iBZ);
        }
        this.kQt.a(this.kQy);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kQu, readCacheRespMsg.getData().get(0));
        }
        this.kQx = null;
        this.kQu.reset();
        this.kQv.setNeedCache(true);
        this.kQv.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kQt.cZb();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kQt.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kQt.cZb();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kQt.a(errorData);
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

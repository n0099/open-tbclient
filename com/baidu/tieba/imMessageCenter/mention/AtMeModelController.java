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
/* loaded from: classes2.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a cXh;
    private AtMessageActivity eMc;
    private b eMd;
    private AtMeNetModel eMe;
    private AtMeCacheModel eMf;
    private FeedData eMg;
    private f eMh;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ak(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eMc.aLJ();
                }
            }
        };
        this.eMc = atMessageActivity;
    }

    public void k(Bundle bundle) {
        this.eMd = new b();
        this.eMe = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ak(this.eMc.getPageContext().getPageActivity()), this.eMd);
        this.eMe.a(this);
        if (this.eMc != null) {
            this.eMe.setUniqueId(this.eMc.getUniqueId());
        }
        this.eMe.registerListener(this.mNetworkChangedMessageListener);
        this.eMf = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ak(this.eMc.getPageContext().getPageActivity()));
        this.eMf.a(this);
        if (this.eMc != null) {
            this.eMf.setUniqueId(this.eMc.getUniqueId());
        }
        this.eMh = new f();
        this.cXh = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akW() {
        if (!this.eMe.DY() && this.cXh.Ni() && aLI()) {
            this.cXh.cr(true);
            this.cXh.ct(true);
            this.eMd.f(this.eMg);
            this.eMe.setNeedCache(false);
            this.eMe.Na();
            this.eMc.b(this.cXh);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aLH() {
        if (this.eMe.DY() || !aLI()) {
            return false;
        }
        this.eMg = null;
        this.eMd.reset();
        this.eMe.setNeedCache(true);
        this.eMe.Na();
        return true;
    }

    protected boolean aLI() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eMh != null && this.eMh.eMN != null) {
            this.eMh.eMN.clear();
        }
        this.eMc.aLJ();
        this.eMc.a(this.eMh);
        return false;
    }

    public boolean akV() {
        if (aLI()) {
            if (this.eMc != null) {
                this.eMc.aLK();
            }
            this.eMf.a((com.baidu.tbadk.mvc.b.e) this.eMd);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eMh.aLR().clear();
        }
        this.eMh.a(cVar);
        if (cVar != null && cVar.aLR() != null && cVar.aLR().size() > 0) {
            this.eMg = cVar.aLR().get(cVar.aLR().size() - 1);
            if (this.eMh.yb() != null) {
                this.cXh.cs(this.eMh.yb().xX() == 1);
            } else {
                this.cXh.cs(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cXh.ct(true);
        } else {
            this.eMg = null;
            this.cXh.cs(false);
            this.cXh.ct(false);
        }
        this.cXh.cr(false);
        this.cXh.cq(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GC();
        if (!TbadkCoreApplication.isLogin()) {
            this.eMh.aLR().clear();
        } else {
            this.eMc.b(this.cXh);
        }
        this.eMc.a(this.eMh);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eMd, readCacheRespMsg.getData().get(0));
        }
        this.eMg = null;
        this.eMd.reset();
        this.eMe.setNeedCache(true);
        this.eMe.Na();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eMc.aLJ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgAtme(0);
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
            this.eMc.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eMc.aLJ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgAtme(0);
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
            this.eMc.a(errorData);
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

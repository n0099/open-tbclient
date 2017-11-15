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
    private com.baidu.tbadk.mvc.d.a bZO;
    private AtMessageActivity dRc;
    private b dRd;
    private AtMeNetModel dRe;
    private AtMeCacheModel dRf;
    private FeedData dRg;
    private f dRh;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.Y(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.dRc.aCZ();
                }
            }
        };
        this.dRc = atMessageActivity;
    }

    public void h(Bundle bundle) {
        this.dRd = new b();
        this.dRe = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.Y(this.dRc.getPageContext().getPageActivity()), this.dRd);
        this.dRe.a(this);
        if (this.dRc != null) {
            this.dRe.setUniqueId(this.dRc.getUniqueId());
        }
        this.dRe.registerListener(this.mNetworkChangedMessageListener);
        this.dRf = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.Y(this.dRc.getPageContext().getPageActivity()));
        this.dRf.a(this);
        if (this.dRc != null) {
            this.dRf.setUniqueId(this.dRc.getUniqueId());
        }
        this.dRh = new f();
        this.bZO = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aby() {
        if (!this.dRe.wz() && this.bZO.FB() && aCY()) {
            this.bZO.bO(true);
            this.bZO.bQ(true);
            this.dRd.g(this.dRg);
            this.dRe.setNeedCache(false);
            this.dRe.Fr();
            this.dRc.b(this.bZO);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aCX() {
        if (this.dRe.wz() || !aCY()) {
            return false;
        }
        this.dRg = null;
        this.dRd.reset();
        this.dRe.setNeedCache(true);
        this.dRe.Fr();
        return true;
    }

    protected boolean aCY() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dRh != null && this.dRh.dRN != null) {
            this.dRh.dRN.clear();
        }
        this.dRc.aCZ();
        this.dRc.a(this.dRh);
        return false;
    }

    public boolean abx() {
        if (aCY()) {
            if (this.dRc != null) {
                this.dRc.aDa();
            }
            this.dRf.a((com.baidu.tbadk.mvc.b.e) this.dRd);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.dRh.aDh().clear();
        }
        this.dRh.a(cVar);
        if (cVar != null && cVar.aDh() != null && cVar.aDh().size() > 0) {
            this.dRg = cVar.aDh().get(cVar.aDh().size() - 1);
            if (this.dRh.qv() != null) {
                this.bZO.bP(this.dRh.qv().qr() == 1);
            } else {
                this.bZO.bP(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.bZO.bQ(true);
        } else {
            this.dRg = null;
            this.bZO.bP(false);
            this.bZO.bQ(false);
        }
        this.bZO.bO(false);
        this.bZO.bN(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().za();
        if (!TbadkCoreApplication.isLogin()) {
            this.dRh.aDh().clear();
        } else {
            this.dRc.b(this.bZO);
        }
        this.dRc.a(this.dRh);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dRd, readCacheRespMsg.getData().get(0));
        }
        this.dRg = null;
        this.dRd.reset();
        this.dRe.setNeedCache(true);
        this.dRe.Fr();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dRc.aCZ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
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
            this.dRc.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.dRc.aCZ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
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
            this.dRc.a(errorData);
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

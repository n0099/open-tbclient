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
    private com.baidu.tbadk.mvc.d.a cMx;
    private AtMessageActivity eNO;
    private b eNP;
    private AtMeNetModel eNQ;
    private AtMeCacheModel eNR;
    private FeedData eNS;
    private f eNT;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.eNO.aQZ();
                }
            }
        };
        this.eNO = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.eNP = new b();
        this.eNQ = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.eNO.getPageContext().getPageActivity()), this.eNP);
        this.eNQ.a(this);
        if (this.eNO != null) {
            this.eNQ.setUniqueId(this.eNO.getUniqueId());
        }
        this.eNQ.registerListener(this.mNetworkChangedMessageListener);
        this.eNR = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.eNO.getPageContext().getPageActivity()));
        this.eNR.a(this);
        if (this.eNO != null) {
            this.eNR.setUniqueId(this.eNO.getUniqueId());
        }
        this.eNT = new f();
        this.cMx = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean alZ() {
        if (!this.eNQ.BO() && this.cMx.Lt() && aQY()) {
            this.cMx.ce(true);
            this.cMx.cg(true);
            this.eNP.d(this.eNS);
            this.eNQ.setNeedCache(false);
            this.eNQ.Ll();
            this.eNO.b(this.cMx);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ayJ() {
        if (this.eNQ.BO() || !aQY()) {
            return false;
        }
        this.eNS = null;
        this.eNP.reset();
        this.eNQ.setNeedCache(true);
        this.eNQ.Ll();
        return true;
    }

    protected boolean aQY() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eNT != null && this.eNT.eOR != null) {
            this.eNT.eOR.clear();
        }
        this.eNO.aQZ();
        this.eNO.a(this.eNT);
        return false;
    }

    public boolean alY() {
        if (aQY()) {
            if (this.eNO != null) {
                this.eNO.aRa();
            }
            this.eNR.a((com.baidu.tbadk.mvc.b.e) this.eNP);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.eNT.aRt().clear();
        }
        this.eNT.a(cVar);
        if (cVar != null && cVar.aRt() != null && cVar.aRt().size() > 0) {
            this.eNS = cVar.aRt().get(cVar.aRt().size() - 1);
            if (this.eNT.vy() != null) {
                this.cMx.cf(this.eNT.vy().vu() == 1);
            } else {
                this.cMx.cf(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cMx.cg(true);
        } else {
            this.eNS = null;
            this.cMx.cf(false);
            this.cMx.cg(false);
        }
        this.cMx.ce(false);
        this.cMx.cd(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EN();
        if (!TbadkCoreApplication.isLogin()) {
            this.eNT.aRt().clear();
        } else {
            this.eNO.b(this.cMx);
        }
        this.eNO.a(this.eNT);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eNP, readCacheRespMsg.getData().get(0));
        }
        this.eNS = null;
        this.eNP.reset();
        this.eNQ.setNeedCache(true);
        this.eNQ.Ll();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eNO.aQZ();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgAtme(0);
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
            this.eNO.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.eNO.aQZ();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgAtme(0);
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
            this.eNO.a(errorData);
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

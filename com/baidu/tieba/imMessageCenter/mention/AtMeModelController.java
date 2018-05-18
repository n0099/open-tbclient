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
    private com.baidu.tbadk.mvc.d.a cxH;
    private AtMessageActivity enC;
    private b enD;
    private AtMeNetModel enE;
    private AtMeCacheModel enF;
    private FeedData enG;
    private f enH;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.enC.aIm();
                }
            }
        };
        this.enC = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.enD = new b();
        this.enE = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.enC.getPageContext().getPageActivity()), this.enD);
        this.enE.a(this);
        if (this.enC != null) {
            this.enE.setUniqueId(this.enC.getUniqueId());
        }
        this.enE.registerListener(this.mNetworkChangedMessageListener);
        this.enF = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.enC.getPageContext().getPageActivity()));
        this.enF.a(this);
        if (this.enC != null) {
            this.enF.setUniqueId(this.enC.getUniqueId());
        }
        this.enH = new f();
        this.cxH = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agL() {
        if (!this.enE.wW() && this.cxH.Ge() && aIl()) {
            this.cxH.bM(true);
            this.cxH.bO(true);
            this.enD.d(this.enG);
            this.enE.setNeedCache(false);
            this.enE.FW();
            this.enC.b(this.cxH);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ari() {
        if (this.enE.wW() || !aIl()) {
            return false;
        }
        this.enG = null;
        this.enD.reset();
        this.enE.setNeedCache(true);
        this.enE.FW();
        return true;
    }

    protected boolean aIl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.enH != null && this.enH.eoF != null) {
            this.enH.eoF.clear();
        }
        this.enC.aIm();
        this.enC.a(this.enH);
        return false;
    }

    public boolean agK() {
        if (aIl()) {
            if (this.enC != null) {
                this.enC.aIn();
            }
            this.enF.a((com.baidu.tbadk.mvc.b.e) this.enD);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.enH.aIG().clear();
        }
        this.enH.a(cVar);
        if (cVar != null && cVar.aIG() != null && cVar.aIG().size() > 0) {
            this.enG = cVar.aIG().get(cVar.aIG().size() - 1);
            if (this.enH.rf() != null) {
                this.cxH.bN(this.enH.rf().rb() == 1);
            } else {
                this.cxH.bN(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cxH.bO(true);
        } else {
            this.enG = null;
            this.cxH.bN(false);
            this.cxH.bO(false);
        }
        this.cxH.bM(false);
        this.cxH.bL(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zw().zL();
        if (!TbadkCoreApplication.isLogin()) {
            this.enH.aIG().clear();
        } else {
            this.enC.b(this.cxH);
        }
        this.enC.a(this.enH);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.enD, readCacheRespMsg.getData().get(0));
        }
        this.enG = null;
        this.enD.reset();
        this.enE.setNeedCache(true);
        this.enE.FW();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.enC.aIm();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgAtme(0);
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
            this.enC.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.enC.aIm();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgAtme(0);
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
            this.enC.a(errorData);
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

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
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a dgj;
    private AtMessageActivity fhi;
    private b fhj;
    private AtMeNetModel fhk;
    private AtMeCacheModel fhl;
    private FeedData fhm;
    private f fhn;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.fhi.aWP();
                }
            }
        };
        this.fhi = atMessageActivity;
    }

    public void p(Bundle bundle) {
        this.fhj = new b();
        this.fhk = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.fhi.getPageContext().getPageActivity()), this.fhj);
        this.fhk.a(this);
        if (this.fhi != null) {
            this.fhk.setUniqueId(this.fhi.getUniqueId());
        }
        this.fhk.registerListener(this.mNetworkChangedMessageListener);
        this.fhl = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.fhi.getPageContext().getPageActivity()));
        this.fhl.a(this);
        if (this.fhi != null) {
            this.fhl.setUniqueId(this.fhi.getUniqueId());
        }
        this.fhn = new f();
        this.dgj = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean asa() {
        if (!this.fhk.Fv() && this.dgj.OX() && aWO()) {
            this.dgj.cI(true);
            this.dgj.cK(true);
            this.fhj.d(this.fhm);
            this.fhk.setNeedCache(false);
            this.fhk.OP();
            this.fhi.b(this.dgj);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGX() {
        if (this.fhk.Fv() || !aWO()) {
            return false;
        }
        this.fhm = null;
        this.fhj.reset();
        this.fhk.setNeedCache(true);
        this.fhk.OP();
        return true;
    }

    protected boolean aWO() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.fhn != null && this.fhn.fin != null) {
            this.fhn.fin.clear();
        }
        this.fhi.aWP();
        this.fhi.a(this.fhn);
        return false;
    }

    public boolean arZ() {
        if (aWO()) {
            if (this.fhi != null) {
                this.fhi.aWQ();
            }
            this.fhl.a((com.baidu.tbadk.mvc.b.e) this.fhj);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.fhn.aXj().clear();
        }
        this.fhn.a(cVar);
        if (cVar != null && cVar.aXj() != null && cVar.aXj().size() > 0) {
            this.fhm = cVar.aXj().get(cVar.aXj().size() - 1);
            if (this.fhn.zf() != null) {
                this.dgj.cJ(this.fhn.zf().zc() == 1);
            } else {
                this.dgj.cJ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.dgj.cK(true);
        } else {
            this.fhm = null;
            this.dgj.cJ(false);
            this.dgj.cK(false);
        }
        this.dgj.cI(false);
        this.dgj.cH(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.If().Iu();
        if (!TbadkCoreApplication.isLogin()) {
            this.fhn.aXj().clear();
        } else {
            this.fhi.b(this.dgj);
        }
        this.fhi.a(this.fhn);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.fhj, readCacheRespMsg.getData().get(0));
        }
        this.fhm = null;
        this.fhj.reset();
        this.fhk.setNeedCache(true);
        this.fhk.OP();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fhi.aWP();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgAtme(0);
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
            this.fhi.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fhi.aWP();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgAtme(0);
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
            this.fhi.a(errorData);
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

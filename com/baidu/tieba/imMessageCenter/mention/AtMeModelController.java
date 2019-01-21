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
    private com.baidu.tbadk.mvc.d.a dgk;
    private AtMessageActivity fhj;
    private b fhk;
    private AtMeNetModel fhl;
    private AtMeCacheModel fhm;
    private FeedData fhn;
    private f fho;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.fhj.aWP();
                }
            }
        };
        this.fhj = atMessageActivity;
    }

    public void p(Bundle bundle) {
        this.fhk = new b();
        this.fhl = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.fhj.getPageContext().getPageActivity()), this.fhk);
        this.fhl.a(this);
        if (this.fhj != null) {
            this.fhl.setUniqueId(this.fhj.getUniqueId());
        }
        this.fhl.registerListener(this.mNetworkChangedMessageListener);
        this.fhm = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.fhj.getPageContext().getPageActivity()));
        this.fhm.a(this);
        if (this.fhj != null) {
            this.fhm.setUniqueId(this.fhj.getUniqueId());
        }
        this.fho = new f();
        this.dgk = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean asa() {
        if (!this.fhl.Fv() && this.dgk.OX() && aWO()) {
            this.dgk.cI(true);
            this.dgk.cK(true);
            this.fhk.d(this.fhn);
            this.fhl.setNeedCache(false);
            this.fhl.OP();
            this.fhj.b(this.dgk);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGX() {
        if (this.fhl.Fv() || !aWO()) {
            return false;
        }
        this.fhn = null;
        this.fhk.reset();
        this.fhl.setNeedCache(true);
        this.fhl.OP();
        return true;
    }

    protected boolean aWO() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.fho != null && this.fho.fio != null) {
            this.fho.fio.clear();
        }
        this.fhj.aWP();
        this.fhj.a(this.fho);
        return false;
    }

    public boolean arZ() {
        if (aWO()) {
            if (this.fhj != null) {
                this.fhj.aWQ();
            }
            this.fhm.a((com.baidu.tbadk.mvc.b.e) this.fhk);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.fho.aXj().clear();
        }
        this.fho.a(cVar);
        if (cVar != null && cVar.aXj() != null && cVar.aXj().size() > 0) {
            this.fhn = cVar.aXj().get(cVar.aXj().size() - 1);
            if (this.fho.zf() != null) {
                this.dgk.cJ(this.fho.zf().zc() == 1);
            } else {
                this.dgk.cJ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.dgk.cK(true);
        } else {
            this.fhn = null;
            this.dgk.cJ(false);
            this.dgk.cK(false);
        }
        this.dgk.cI(false);
        this.dgk.cH(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.If().Iu();
        if (!TbadkCoreApplication.isLogin()) {
            this.fho.aXj().clear();
        } else {
            this.fhj.b(this.dgk);
        }
        this.fhj.a(this.fho);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.fhk, readCacheRespMsg.getData().get(0));
        }
        this.fhn = null;
        this.fhk.reset();
        this.fhl.setNeedCache(true);
        this.fhl.OP();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fhj.aWP();
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
            this.fhj.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.fhj.aWP();
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
            this.fhj.a(errorData);
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

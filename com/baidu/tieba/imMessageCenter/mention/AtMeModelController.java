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
    final CustomMessageListener dFp;
    private com.baidu.tbadk.mvc.d.a gVU;
    private AtMessageActivity jgj;
    private b jgk;
    private AtMeNetModel jgl;
    private AtMeCacheModel jgm;
    private FeedData jgn;
    private f jgo;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.G(atMessageActivity.getPageContext().getPageActivity()));
        this.dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.jgj.cuH();
                }
            }
        };
        this.jgj = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.jgk = new b();
        this.jgl = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.G(this.jgj.getPageContext().getPageActivity()), this.jgk);
        this.jgl.a(this);
        if (this.jgj != null) {
            this.jgl.setUniqueId(this.jgj.getUniqueId());
        }
        this.jgl.registerListener(this.dFp);
        this.jgm = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.G(this.jgj.getPageContext().getPageActivity()));
        this.jgm.a(this);
        if (this.jgj != null) {
            this.jgm.setUniqueId(this.jgj.getUniqueId());
        }
        this.jgo = new f();
        this.gVU = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bPl() {
        if (!this.jgl.isLoading() && this.gVU.bhm() && cuG()) {
            this.gVU.it(true);
            this.gVU.iv(true);
            this.jgk.e(this.jgn);
            this.jgl.setNeedCache(false);
            this.jgl.loadData();
            this.jgj.c(this.gVU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cdn() {
        if (this.jgl.isLoading() || !cuG()) {
            return false;
        }
        this.jgn = null;
        this.jgk.reset();
        this.jgl.setNeedCache(true);
        this.jgl.loadData();
        return true;
    }

    protected boolean cuG() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jgo != null && this.jgo.jhr != null) {
            this.jgo.jhr.clear();
        }
        this.jgj.cuH();
        this.jgj.a(this.jgo);
        return false;
    }

    public boolean bPk() {
        if (cuG()) {
            if (this.jgj != null) {
                this.jgj.cuI();
            }
            this.jgm.a((com.baidu.tbadk.mvc.b.e) this.jgk);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.jgo.cvc().clear();
        }
        this.jgo.a(cVar);
        if (cVar != null && cVar.cvc() != null && cVar.cvc().size() > 0) {
            this.jgn = cVar.cvc().get(cVar.cvc().size() - 1);
            if (this.jgo.getPage() != null) {
                this.gVU.iu(this.jgo.getPage().aRf() == 1);
            } else {
                this.gVU.iu(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.gVU.iv(true);
        } else {
            this.jgn = null;
            this.gVU.iu(false);
            this.gVU.iv(false);
        }
        this.gVU.it(false);
        this.gVU.is(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbD();
        if (!TbadkCoreApplication.isLogin()) {
            this.jgo.cvc().clear();
        } else {
            this.jgj.c(this.gVU);
        }
        this.jgj.a(this.jgo);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jgk, readCacheRespMsg.getData().get(0));
        }
        this.jgn = null;
        this.jgk.reset();
        this.jgl.setNeedCache(true);
        this.jgl.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jgj.cuH();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgAtme(0);
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
            this.jgj.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.jgj.cuH();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgAtme(0);
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
            this.jgj.a(errorData);
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

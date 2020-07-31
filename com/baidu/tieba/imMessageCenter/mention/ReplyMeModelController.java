package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.q;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData joJ;
    private f joK;
    private ReplyMessageFragment jqp;
    private k jqq;
    private ReplyMeNetModel jqr;
    private ReplyMeCacheModel jqs;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jqp = replyMessageFragment;
    }

    public void ak(Bundle bundle) {
        this.jqq = new k();
        this.jqr = new ReplyMeNetModel(this.jqp.getPageContext(), this.jqq);
        this.jqr.a(this);
        this.jqr.setUniqueId(this.jqp.getUniqueId());
        this.jqs = new ReplyMeCacheModel(this.jqp.getPageContext());
        this.jqs.a(this);
        this.jqs.setUniqueId(this.jqp.getUniqueId());
        this.joK = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bSw() {
        if (this.jqr.isLoading() || !cyJ()) {
            return false;
        }
        this.jqq.e(this.joJ);
        this.jqr.setNeedCache(false);
        this.jqr.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cgM() {
        if (this.jqr.isLoading() || !cyJ()) {
            return false;
        }
        this.joJ = null;
        this.jqq.reset();
        this.jqr.setNeedCache(true);
        this.jqr.loadData();
        return true;
    }

    protected boolean cyJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.joK != null && this.joK.jqg != null) {
            this.joK.jqg.clear();
        }
        this.jqp.czg();
        this.jqp.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean bSv() {
        if (cyJ()) {
            this.jqs.a((com.baidu.tbadk.mvc.b.e) this.jqq);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.joK.czb().clear();
        }
        this.joK.a(lVar);
        if (lVar != null && lVar.czb() != null && lVar.czb().size() > 0) {
            this.joJ = lVar.czb().get(lVar.czb().size() - 1);
            if (this.joK.getPage() != null) {
                z4 = this.joK.getPage().aVb() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgReplyme(0);
            }
            if (kVar != null) {
                kVar.toNextPage();
                z3 = true;
                z2 = z4;
            } else {
                z3 = true;
                z2 = z4;
            }
        } else {
            this.joJ = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfy();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.joK.jqg.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.qH(false);
            }
            arrayList.add(aVar);
        }
        this.jqp.b(z2, arrayList);
        return z3;
    }

    public void zE(int i) {
        if (this.joK != null && this.joK.czb() != null && i < this.joK.czb().size()) {
            this.joK.czb().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jqq, readCacheRespMsg.getData().get(0), true);
        }
        this.joJ = null;
        this.jqq.reset();
        this.jqr.setNeedCache(true);
        this.jqr.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<l>> writeCacheRespMsg, WriteCacheMessage<l> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<k, l> mvcHttpMessage, MvcNetMessage<k, l> mvcNetMessage) {
        l lVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            lVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgReplyme(0);
            lVar = null;
        }
        if (r1 == null || lVar == null || !a(r1, lVar, false)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.jqp.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<l, ?> mvcSocketResponsedMessage, MvcSocketMessage<k, l> mvcSocketMessage, MvcNetMessage<k, l> mvcNetMessage) {
        l lVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            lVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgReplyme(0);
            lVar = null;
        }
        if (r1 == null || lVar == null || !a(r1, lVar, false)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.jqp.a(errorData);
            }
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

    public void onDestroy() {
        if (this.jqr != null) {
            this.jqr.a((NetModel.b) null);
        }
        if (this.jqs != null) {
            this.jqs.a((CacheModel.a) null);
        }
    }
}

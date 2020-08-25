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
    private FeedData jDJ;
    private f jDK;
    private ReplyMessageFragment jFp;
    private k jFq;
    private ReplyMeNetModel jFr;
    private ReplyMeCacheModel jFs;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jFp = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.jFq = new k();
        this.jFr = new ReplyMeNetModel(this.jFp.getPageContext(), this.jFq);
        this.jFr.a(this);
        this.jFr.setUniqueId(this.jFp.getUniqueId());
        this.jFs = new ReplyMeCacheModel(this.jFp.getPageContext());
        this.jFs.a(this);
        this.jFs.setUniqueId(this.jFp.getUniqueId());
        this.jDK = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ccI() {
        if (this.jFr.isLoading() || !cJA()) {
            return false;
        }
        this.jFq.e(this.jDJ);
        this.jFr.setNeedCache(false);
        this.jFr.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crr() {
        if (this.jFr.isLoading() || !cJA()) {
            return false;
        }
        this.jDJ = null;
        this.jFq.reset();
        this.jFr.setNeedCache(true);
        this.jFr.loadData();
        return true;
    }

    protected boolean cJA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jDK != null && this.jDK.jFg != null) {
            this.jDK.jFg.clear();
        }
        this.jFp.cJX();
        this.jFp.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean ccH() {
        if (cJA()) {
            this.jFs.a((com.baidu.tbadk.mvc.b.e) this.jFq);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.jDK.cJS().clear();
        }
        this.jDK.a(lVar);
        if (lVar != null && lVar.cJS() != null && lVar.cJS().size() > 0) {
            this.jDJ = lVar.cJS().get(lVar.cJS().size() - 1);
            if (this.jDK.getPage() != null) {
                z4 = this.jDK.getPage().bdu() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgReplyme(0);
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
            this.jDJ = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boi();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.jDK.jFg.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.rn(false);
            }
            arrayList.add(aVar);
        }
        this.jFp.b(z2, arrayList);
        return z3;
    }

    public void BX(int i) {
        if (this.jDK != null && this.jDK.cJS() != null && i < this.jDK.cJS().size()) {
            this.jDK.cJS().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jFq, readCacheRespMsg.getData().get(0), true);
        }
        this.jDJ = null;
        this.jFq.reset();
        this.jFr.setNeedCache(true);
        this.jFr.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgReplyme(0);
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
                this.jFp.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgReplyme(0);
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
                this.jFp.a(errorData);
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
        if (this.jFr != null) {
            this.jFr.a((NetModel.b) null);
        }
        if (this.jFs != null) {
            this.jFs.a((CacheModel.a) null);
        }
    }
}

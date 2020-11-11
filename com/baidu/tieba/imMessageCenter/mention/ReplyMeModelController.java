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
/* loaded from: classes22.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData ktK;
    private f ktL;
    private ReplyMessageFragment kvq;
    private k kvr;
    private ReplyMeNetModel kvs;
    private ReplyMeCacheModel kvt;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kvq = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kvr = new k();
        this.kvs = new ReplyMeNetModel(this.kvq.getPageContext(), this.kvr);
        this.kvs.a(this);
        this.kvs.setUniqueId(this.kvq.getUniqueId());
        this.kvt = new ReplyMeCacheModel(this.kvq.getPageContext());
        this.kvt.a(this);
        this.kvt.setUniqueId(this.kvq.getUniqueId());
        this.ktL = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cpc() {
        if (this.kvs.isLoading() || !cWx()) {
            return false;
        }
        this.kvr.e(this.ktK);
        this.kvs.setNeedCache(false);
        this.kvs.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cDM() {
        if (this.kvs.isLoading() || !cWx()) {
            return false;
        }
        this.ktK = null;
        this.kvr.reset();
        this.kvs.setNeedCache(true);
        this.kvs.loadData();
        return true;
    }

    protected boolean cWx() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.ktL != null && this.ktL.kvh != null) {
            this.ktL.kvh.clear();
        }
        this.kvq.cWU();
        this.kvq.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean cpb() {
        if (cWx()) {
            this.kvt.a((com.baidu.tbadk.mvc.b.e) this.kvr);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.ktL.cWP().clear();
        }
        this.ktL.a(lVar);
        if (lVar != null && lVar.cWP() != null && lVar.cWP().size() > 0) {
            this.ktK = lVar.cWP().get(lVar.cWP().size() - 1);
            if (this.ktL.getPage() != null) {
                z4 = this.ktL.getPage().blq() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgReplyme(0);
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
            this.ktK = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().bwf();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.ktL.kvh.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.sE(false);
            }
            arrayList.add(aVar);
        }
        this.kvq.b(z2, arrayList);
        return z3;
    }

    public void DK(int i) {
        if (this.ktL != null && this.ktL.cWP() != null && i < this.ktL.cWP().size()) {
            this.ktL.cWP().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kvr, readCacheRespMsg.getData().get(0), true);
        }
        this.ktK = null;
        this.kvr.reset();
        this.kvs.setNeedCache(true);
        this.kvs.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgReplyme(0);
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
                this.kvq.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgReplyme(0);
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
                this.kvq.a(errorData);
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
        if (this.kvs != null) {
            this.kvs.a((NetModel.b) null);
        }
        if (this.kvt != null) {
            this.kvt.a((CacheModel.a) null);
        }
    }
}

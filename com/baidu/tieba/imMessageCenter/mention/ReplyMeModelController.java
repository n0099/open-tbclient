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
    private FeedData jDP;
    private f jDQ;
    private ReplyMessageFragment jFv;
    private k jFw;
    private ReplyMeNetModel jFx;
    private ReplyMeCacheModel jFy;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jFv = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.jFw = new k();
        this.jFx = new ReplyMeNetModel(this.jFv.getPageContext(), this.jFw);
        this.jFx.a(this);
        this.jFx.setUniqueId(this.jFv.getUniqueId());
        this.jFy = new ReplyMeCacheModel(this.jFv.getPageContext());
        this.jFy.a(this);
        this.jFy.setUniqueId(this.jFv.getUniqueId());
        this.jDQ = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ccJ() {
        if (this.jFx.isLoading() || !cJB()) {
            return false;
        }
        this.jFw.e(this.jDP);
        this.jFx.setNeedCache(false);
        this.jFx.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crs() {
        if (this.jFx.isLoading() || !cJB()) {
            return false;
        }
        this.jDP = null;
        this.jFw.reset();
        this.jFx.setNeedCache(true);
        this.jFx.loadData();
        return true;
    }

    protected boolean cJB() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jDQ != null && this.jDQ.jFm != null) {
            this.jDQ.jFm.clear();
        }
        this.jFv.cJY();
        this.jFv.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean ccI() {
        if (cJB()) {
            this.jFy.a((com.baidu.tbadk.mvc.b.e) this.jFw);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.jDQ.cJT().clear();
        }
        this.jDQ.a(lVar);
        if (lVar != null && lVar.cJT() != null && lVar.cJT().size() > 0) {
            this.jDP = lVar.cJT().get(lVar.cJT().size() - 1);
            if (this.jDQ.getPage() != null) {
                z4 = this.jDQ.getPage().bdu() == 1;
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
            this.jDP = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boi();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.jDQ.jFm.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.rp(false);
            }
            arrayList.add(aVar);
        }
        this.jFv.b(z2, arrayList);
        return z3;
    }

    public void BX(int i) {
        if (this.jDQ != null && this.jDQ.cJT() != null && i < this.jDQ.cJT().size()) {
            this.jDQ.cJT().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jFw, readCacheRespMsg.getData().get(0), true);
        }
        this.jDP = null;
        this.jFw.reset();
        this.jFx.setNeedCache(true);
        this.jFx.loadData();
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
                this.jFv.a(errorData);
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
                this.jFv.a(errorData);
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
        if (this.jFx != null) {
            this.jFx.a((NetModel.b) null);
        }
        if (this.jFy != null) {
            this.jFy.a((CacheModel.a) null);
        }
    }
}

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
/* loaded from: classes9.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData jgn;
    private f jgo;
    private ReplyMessageFragment jhA;
    private k jhB;
    private ReplyMeNetModel jhC;
    private ReplyMeCacheModel jhD;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jhA = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.jhB = new k();
        this.jhC = new ReplyMeNetModel(this.jhA.getPageContext(), this.jhB);
        this.jhC.a(this);
        this.jhC.setUniqueId(this.jhA.getUniqueId());
        this.jhD = new ReplyMeCacheModel(this.jhA.getPageContext());
        this.jhD.a(this);
        this.jhD.setUniqueId(this.jhA.getUniqueId());
        this.jgo = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bPl() {
        if (this.jhC.isLoading() || !cuG()) {
            return false;
        }
        this.jhB.e(this.jgn);
        this.jhC.setNeedCache(false);
        this.jhC.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cdn() {
        if (this.jhC.isLoading() || !cuG()) {
            return false;
        }
        this.jgn = null;
        this.jhB.reset();
        this.jhC.setNeedCache(true);
        this.jhC.loadData();
        return true;
    }

    protected boolean cuG() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jgo != null && this.jgo.jhr != null) {
            this.jgo.jhr.clear();
        }
        this.jhA.cvj();
        this.jhA.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean bPk() {
        if (cuG()) {
            this.jhD.a((com.baidu.tbadk.mvc.b.e) this.jhB);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.jgo.cvc().clear();
        }
        this.jgo.a(lVar);
        if (lVar != null && lVar.cvc() != null && lVar.cvc().size() > 0) {
            this.jgn = lVar.cvc().get(lVar.cvc().size() - 1);
            if (this.jgo.getPage() != null) {
                z4 = this.jgo.getPage().aRf() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgReplyme(0);
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
            this.jgn = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbC();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.jgo.jhr.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.qa(false);
            }
            arrayList.add(aVar);
        }
        this.jhA.b(z2, arrayList);
        return z3;
    }

    public void zd(int i) {
        if (this.jgo != null && this.jgo.cvc() != null && i < this.jgo.cvc().size()) {
            this.jgo.cvc().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jhB, readCacheRespMsg.getData().get(0), true);
        }
        this.jgn = null;
        this.jhB.reset();
        this.jhC.setNeedCache(true);
        this.jhC.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgReplyme(0);
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
                this.jhA.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgReplyme(0);
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
                this.jhA.a(errorData);
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
        if (this.jhC != null) {
            this.jhC.a((NetModel.b) null);
        }
        if (this.jhD != null) {
            this.jhD.a((CacheModel.a) null);
        }
    }
}

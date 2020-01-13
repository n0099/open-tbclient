package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
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
/* loaded from: classes7.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData hMi;
    private f hMj;
    private ReplyMessageFragment hNo;
    private k hNp;
    private ReplyMeNetModel hNq;
    private ReplyMeCacheModel hNr;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hNo = replyMessageFragment;
    }

    public void ad(Bundle bundle) {
        this.hNp = new k();
        this.hNq = new ReplyMeNetModel(this.hNo.getPageContext(), this.hNp);
        this.hNq.a(this);
        this.hNq.setUniqueId(this.hNo.getUniqueId());
        this.hNr = new ReplyMeCacheModel(this.hNo.getPageContext());
        this.hNr.a(this);
        this.hNr.setUniqueId(this.hNo.getUniqueId());
        this.hMj = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean buj() {
        if (this.hNq.isLoading() || !bXN()) {
            return false;
        }
        this.hNp.d(this.hMi);
        this.hNq.setNeedCache(false);
        this.hNq.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bHi() {
        if (this.hNq.isLoading() || !bXN()) {
            return false;
        }
        this.hMi = null;
        this.hNp.reset();
        this.hNq.setNeedCache(true);
        this.hNq.loadData();
        return true;
    }

    protected boolean bXN() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hMj != null && this.hMj.hNf != null) {
            this.hMj.hNf.clear();
        }
        this.hNo.bYn();
        this.hNo.b(false, (ArrayList<com.baidu.adp.widget.ListView.m>) null);
        return false;
    }

    public boolean bui() {
        if (bXN()) {
            this.hNr.a((com.baidu.tbadk.mvc.b.e) this.hNp);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.hMj.bYh().clear();
        }
        this.hMj.a(lVar);
        if (lVar != null && lVar.bYh() != null && lVar.bYh().size() > 0) {
            this.hMi = lVar.bYh().get(lVar.bYh().size() - 1);
            if (this.hMj.getPage() != null) {
                z4 = this.hMj.getPage().ayR() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgReplyme(0);
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
            this.hMi = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIx();
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.hMj.hNf.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.oi(false);
            }
            arrayList.add(aVar);
        }
        this.hNo.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hNp, readCacheRespMsg.getData().get(0), true);
        }
        this.hMi = null;
        this.hNp.reset();
        this.hNq.setNeedCache(true);
        this.hNq.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgReplyme(0);
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
                this.hNo.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgReplyme(0);
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
                this.hNo.a(errorData);
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
        if (this.hNq != null) {
            this.hNq.a((NetModel.b) null);
        }
        if (this.hNr != null) {
            this.hNr.a((CacheModel.a) null);
        }
    }
}

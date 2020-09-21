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
/* loaded from: classes21.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData jMr;
    private f jMs;
    private ReplyMessageFragment jNX;
    private k jNY;
    private ReplyMeNetModel jNZ;
    private ReplyMeCacheModel jOa;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jNX = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.jNY = new k();
        this.jNZ = new ReplyMeNetModel(this.jNX.getPageContext(), this.jNY);
        this.jNZ.a(this);
        this.jNZ.setUniqueId(this.jNX.getUniqueId());
        this.jOa = new ReplyMeCacheModel(this.jNX.getPageContext());
        this.jOa.a(this);
        this.jOa.setUniqueId(this.jNX.getUniqueId());
        this.jMs = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cfY() {
        if (this.jNZ.isLoading() || !cNh()) {
            return false;
        }
        this.jNY.e(this.jMr);
        this.jNZ.setNeedCache(false);
        this.jNZ.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cuH() {
        if (this.jNZ.isLoading() || !cNh()) {
            return false;
        }
        this.jMr = null;
        this.jNY.reset();
        this.jNZ.setNeedCache(true);
        this.jNZ.loadData();
        return true;
    }

    protected boolean cNh() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.jMs != null && this.jMs.jNO != null) {
            this.jMs.jNO.clear();
        }
        this.jNX.cNE();
        this.jNX.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean cfX() {
        if (cNh()) {
            this.jOa.a((com.baidu.tbadk.mvc.b.e) this.jNY);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.jMs.cNz().clear();
        }
        this.jMs.a(lVar);
        if (lVar != null && lVar.cNz() != null && lVar.cNz().size() > 0) {
            this.jMr = lVar.cNz().get(lVar.cNz().size() - 1);
            if (this.jMs.getPage() != null) {
                z4 = this.jMs.getPage().beo() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgReplyme(0);
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
            this.jMr = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpc();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.jMs.jNO.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.rx(false);
            }
            arrayList.add(aVar);
        }
        this.jNX.b(z2, arrayList);
        return z3;
    }

    public void Cy(int i) {
        if (this.jMs != null && this.jMs.cNz() != null && i < this.jMs.cNz().size()) {
            this.jMs.cNz().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.jNY, readCacheRespMsg.getData().get(0), true);
        }
        this.jMr = null;
        this.jNY.reset();
        this.jNZ.setNeedCache(true);
        this.jNZ.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgReplyme(0);
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
                this.jNX.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgReplyme(0);
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
                this.jNX.a(errorData);
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
        if (this.jNZ != null) {
            this.jNZ.a((NetModel.b) null);
        }
        if (this.jOa != null) {
            this.jOa.a((CacheModel.a) null);
        }
    }
}

package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes2.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData kQL;
    private f kQM;
    private ReplyMessageFragment kSr;
    private k kSs;
    private ReplyMeNetModel kSt;
    private ReplyMeCacheModel kSu;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kSr = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kSs = new k();
        this.kSt = new ReplyMeNetModel(this.kSr.getPageContext(), this.kSs);
        this.kSt.a(this);
        this.kSt.setUniqueId(this.kSr.getUniqueId());
        this.kSu = new ReplyMeCacheModel(this.kSr.getPageContext());
        this.kSu.a(this);
        this.kSu.setUniqueId(this.kSr.getUniqueId());
        this.kQM = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ctm() {
        if (this.kSt.isLoading() || !cZh()) {
            return false;
        }
        this.kSs.e(this.kQL);
        this.kSt.setNeedCache(false);
        this.kSt.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cJh() {
        if (this.kSt.isLoading() || !cZh()) {
            return false;
        }
        this.kQL = null;
        this.kSs.reset();
        this.kSt.setNeedCache(true);
        this.kSt.loadData();
        return true;
    }

    protected boolean cZh() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kQM != null && this.kQM.kSi != null) {
            this.kQM.kSi.clear();
        }
        this.kSr.cZG();
        this.kSr.b(false, (ArrayList<n>) null);
        return false;
    }

    public boolean ctl() {
        if (cZh()) {
            this.kSu.a((com.baidu.tbadk.mvc.b.e) this.kSs);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (kVar.getUpdateType() != 4) {
            this.kQM.cZz().clear();
        }
        this.kQM.a(lVar);
        if (lVar != null && lVar.cZz() != null && lVar.cZz().size() > 0) {
            this.kQL = lVar.cZz().get(lVar.cZz().size() - 1);
            if (this.kQM.getPage() != null) {
                z3 = this.kQM.getPage().bmF() == 1;
            } else {
                z3 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgReplyme(0);
            }
            if (kVar != null) {
                kVar.cZC();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.kQL = null;
            z2 = false;
            z4 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxO();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kQM.kSi.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tt(false);
            }
            arrayList.add(aVar);
        }
        this.kSr.b(z2, arrayList);
        return z4;
    }

    public void DA(int i) {
        if (this.kQM != null && this.kQM.cZz() != null && i < this.kQM.cZz().size()) {
            this.kQM.cZz().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kSs, readCacheRespMsg.getData().get(0), true);
        }
        this.kQL = null;
        this.kSs.reset();
        this.kSt.setNeedCache(true);
        this.kSt.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<l>> writeCacheRespMsg, WriteCacheMessage<l> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<k, l> mvcHttpMessage, MvcNetMessage<k, l> mvcNetMessage) {
        l lVar;
        k kVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            lVar = mvcHttpResponsedMessage.getData();
            kVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgReplyme(0);
            lVar = null;
            kVar = null;
        }
        if (kVar == null || lVar == null || !a(kVar, lVar, false)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.kSr.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<l, ?> mvcSocketResponsedMessage, MvcSocketMessage<k, l> mvcSocketMessage, MvcNetMessage<k, l> mvcNetMessage) {
        l lVar;
        k kVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            lVar = mvcSocketResponsedMessage.getData();
            kVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgReplyme(0);
            lVar = null;
            kVar = null;
        }
        if (kVar == null || lVar == null || !a(kVar, lVar, false)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.kSr.a(errorData);
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
        if (this.kSt != null) {
            this.kSt.a((NetModel.b) null);
        }
        if (this.kSu != null) {
            this.kSu.a((CacheModel.a) null);
        }
    }
}

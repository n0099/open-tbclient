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
    private FeedData kSN;
    private f kSO;
    private ReplyMessageFragment kUt;
    private k kUu;
    private ReplyMeNetModel kUv;
    private ReplyMeCacheModel kUw;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kUt = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kUu = new k();
        this.kUv = new ReplyMeNetModel(this.kUt.getPageContext(), this.kUu);
        this.kUv.a(this);
        this.kUv.setUniqueId(this.kUt.getUniqueId());
        this.kUw = new ReplyMeCacheModel(this.kUt.getPageContext());
        this.kUw.a(this);
        this.kUw.setUniqueId(this.kUt.getUniqueId());
        this.kSO = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cts() {
        if (this.kUv.isLoading() || !cZo()) {
            return false;
        }
        this.kUu.e(this.kSN);
        this.kUv.setNeedCache(false);
        this.kUv.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cJn() {
        if (this.kUv.isLoading() || !cZo()) {
            return false;
        }
        this.kSN = null;
        this.kUu.reset();
        this.kUv.setNeedCache(true);
        this.kUv.loadData();
        return true;
    }

    protected boolean cZo() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kSO != null && this.kSO.kUk != null) {
            this.kSO.kUk.clear();
        }
        this.kUt.cZN();
        this.kUt.b(false, (ArrayList<n>) null);
        return false;
    }

    public boolean ctr() {
        if (cZo()) {
            this.kUw.a((com.baidu.tbadk.mvc.b.e) this.kUu);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (kVar.getUpdateType() != 4) {
            this.kSO.cZG().clear();
        }
        this.kSO.a(lVar);
        if (lVar != null && lVar.cZG() != null && lVar.cZG().size() > 0) {
            this.kSN = lVar.cZG().get(lVar.cZG().size() - 1);
            if (this.kSO.getPage() != null) {
                z3 = this.kSO.getPage().bmH() == 1;
            } else {
                z3 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgReplyme(0);
            }
            if (kVar != null) {
                kVar.cZJ();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.kSN = null;
            z2 = false;
            z4 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bxR();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kSO.kUk.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tt(false);
            }
            arrayList.add(aVar);
        }
        this.kUt.b(z2, arrayList);
        return z4;
    }

    public void DD(int i) {
        if (this.kSO != null && this.kSO.cZG() != null && i < this.kSO.cZG().size()) {
            this.kSO.cZG().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kUu, readCacheRespMsg.getData().get(0), true);
        }
        this.kSN = null;
        this.kUu.reset();
        this.kUv.setNeedCache(true);
        this.kUv.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgReplyme(0);
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
                this.kUt.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgReplyme(0);
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
                this.kUt.a(errorData);
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
        if (this.kUv != null) {
            this.kUv.a((NetModel.b) null);
        }
        if (this.kUw != null) {
            this.kUw.a((CacheModel.a) null);
        }
    }
}

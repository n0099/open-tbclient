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
    private FeedData kQx;
    private f kQy;
    private ReplyMessageFragment kSd;
    private k kSe;
    private ReplyMeNetModel kSf;
    private ReplyMeCacheModel kSg;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kSd = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kSe = new k();
        this.kSf = new ReplyMeNetModel(this.kSd.getPageContext(), this.kSe);
        this.kSf.a(this);
        this.kSf.setUniqueId(this.kSd.getUniqueId());
        this.kSg = new ReplyMeCacheModel(this.kSd.getPageContext());
        this.kSg.a(this);
        this.kSg.setUniqueId(this.kSd.getUniqueId());
        this.kQy = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ctf() {
        if (this.kSf.isLoading() || !cZa()) {
            return false;
        }
        this.kSe.e(this.kQx);
        this.kSf.setNeedCache(false);
        this.kSf.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cJa() {
        if (this.kSf.isLoading() || !cZa()) {
            return false;
        }
        this.kQx = null;
        this.kSe.reset();
        this.kSf.setNeedCache(true);
        this.kSf.loadData();
        return true;
    }

    protected boolean cZa() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kQy != null && this.kQy.kRU != null) {
            this.kQy.kRU.clear();
        }
        this.kSd.cZz();
        this.kSd.b(false, (ArrayList<n>) null);
        return false;
    }

    public boolean cte() {
        if (cZa()) {
            this.kSg.a((com.baidu.tbadk.mvc.b.e) this.kSe);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (kVar.getUpdateType() != 4) {
            this.kQy.cZs().clear();
        }
        this.kQy.a(lVar);
        if (lVar != null && lVar.cZs() != null && lVar.cZs().size() > 0) {
            this.kQx = lVar.cZs().get(lVar.cZs().size() - 1);
            if (this.kQy.getPage() != null) {
                z3 = this.kQy.getPage().bmF() == 1;
            } else {
                z3 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgReplyme(0);
            }
            if (kVar != null) {
                kVar.cZv();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.kQx = null;
            z2 = false;
            z4 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxO();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kQy.kRU.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tt(false);
            }
            arrayList.add(aVar);
        }
        this.kSd.b(z2, arrayList);
        return z4;
    }

    public void DA(int i) {
        if (this.kQy != null && this.kQy.cZs() != null && i < this.kQy.cZs().size()) {
            this.kQy.cZs().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kSe, readCacheRespMsg.getData().get(0), true);
        }
        this.kQx = null;
        this.kSe.reset();
        this.kSf.setNeedCache(true);
        this.kSf.loadData();
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
                this.kSd.a(errorData);
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
                this.kSd.a(errorData);
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
        if (this.kSf != null) {
            this.kSf.a((NetModel.b) null);
        }
        if (this.kSg != null) {
            this.kSg.a((CacheModel.a) null);
        }
    }
}

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
    private FeedData kHO;
    private f kHP;
    private ReplyMessageFragment kJu;
    private k kJv;
    private ReplyMeNetModel kJw;
    private ReplyMeCacheModel kJx;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kJu = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kJv = new k();
        this.kJw = new ReplyMeNetModel(this.kJu.getPageContext(), this.kJv);
        this.kJw.a(this);
        this.kJw.setUniqueId(this.kJu.getUniqueId());
        this.kJx = new ReplyMeCacheModel(this.kJu.getPageContext());
        this.kJx.a(this);
        this.kJx.setUniqueId(this.kJu.getUniqueId());
        this.kHP = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean csQ() {
        if (this.kJw.isLoading() || !dbp()) {
            return false;
        }
        this.kJv.e(this.kHO);
        this.kJw.setNeedCache(false);
        this.kJw.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cID() {
        if (this.kJw.isLoading() || !dbp()) {
            return false;
        }
        this.kHO = null;
        this.kJv.reset();
        this.kJw.setNeedCache(true);
        this.kJw.loadData();
        return true;
    }

    protected boolean dbp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kHP != null && this.kHP.kJl != null) {
            this.kHP.kJl.clear();
        }
        this.kJu.dbN();
        this.kJu.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean csP() {
        if (dbp()) {
            this.kJx.a((com.baidu.tbadk.mvc.b.e) this.kJv);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.kHP.dbH().clear();
        }
        this.kHP.a(lVar);
        if (lVar != null && lVar.dbH() != null && lVar.dbH().size() > 0) {
            this.kHO = lVar.dbH().get(lVar.dbH().size() - 1);
            if (this.kHP.getPage() != null) {
                z4 = this.kHP.getPage().bnF() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgReplyme(0);
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
            this.kHO = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.byI().byV();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kHP.kJl.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tj(false);
            }
            arrayList.add(aVar);
        }
        this.kJu.b(z2, arrayList);
        return z3;
    }

    public void EX(int i) {
        if (this.kHP != null && this.kHP.dbH() != null && i < this.kHP.dbH().size()) {
            this.kHP.dbH().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kJv, readCacheRespMsg.getData().get(0), true);
        }
        this.kHO = null;
        this.kJv.reset();
        this.kJw.setNeedCache(true);
        this.kJw.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<l>> writeCacheRespMsg, WriteCacheMessage<l> writeCacheMessage) {
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
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgReplyme(0);
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
                this.kJu.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgReplyme(0);
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
                this.kJu.a(errorData);
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
        if (this.kJw != null) {
            this.kJw.a((NetModel.b) null);
        }
        if (this.kJx != null) {
            this.kJx.a((CacheModel.a) null);
        }
    }
}

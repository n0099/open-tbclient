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
    private FeedData kHQ;
    private f kHR;
    private ReplyMessageFragment kJw;
    private k kJx;
    private ReplyMeNetModel kJy;
    private ReplyMeCacheModel kJz;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kJw = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kJx = new k();
        this.kJy = new ReplyMeNetModel(this.kJw.getPageContext(), this.kJx);
        this.kJy.a(this);
        this.kJy.setUniqueId(this.kJw.getUniqueId());
        this.kJz = new ReplyMeCacheModel(this.kJw.getPageContext());
        this.kJz.a(this);
        this.kJz.setUniqueId(this.kJw.getUniqueId());
        this.kHR = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean csR() {
        if (this.kJy.isLoading() || !dbq()) {
            return false;
        }
        this.kJx.e(this.kHQ);
        this.kJy.setNeedCache(false);
        this.kJy.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cIE() {
        if (this.kJy.isLoading() || !dbq()) {
            return false;
        }
        this.kHQ = null;
        this.kJx.reset();
        this.kJy.setNeedCache(true);
        this.kJy.loadData();
        return true;
    }

    protected boolean dbq() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kHR != null && this.kHR.kJn != null) {
            this.kHR.kJn.clear();
        }
        this.kJw.dbO();
        this.kJw.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean csQ() {
        if (dbq()) {
            this.kJz.a((com.baidu.tbadk.mvc.b.e) this.kJx);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.kHR.dbI().clear();
        }
        this.kHR.a(lVar);
        if (lVar != null && lVar.dbI() != null && lVar.dbI().size() > 0) {
            this.kHQ = lVar.dbI().get(lVar.dbI().size() - 1);
            if (this.kHR.getPage() != null) {
                z4 = this.kHR.getPage().bnF() == 1;
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
            this.kHQ = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.byI().byV();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kHR.kJn.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tj(false);
            }
            arrayList.add(aVar);
        }
        this.kJw.b(z2, arrayList);
        return z3;
    }

    public void EX(int i) {
        if (this.kHR != null && this.kHR.dbI() != null && i < this.kHR.dbI().size()) {
            this.kHR.dbI().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kJx, readCacheRespMsg.getData().get(0), true);
        }
        this.kHQ = null;
        this.kJx.reset();
        this.kJy.setNeedCache(true);
        this.kJy.loadData();
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
                this.kJw.a(errorData);
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
                this.kJw.a(errorData);
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
        if (this.kJy != null) {
            this.kJy.a((NetModel.b) null);
        }
        if (this.kJz != null) {
            this.kJz.a((CacheModel.a) null);
        }
    }
}

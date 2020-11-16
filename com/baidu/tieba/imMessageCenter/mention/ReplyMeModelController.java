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
    private FeedData kuu;
    private f kuv;
    private ReplyMessageFragment kwa;
    private k kwb;
    private ReplyMeNetModel kwc;
    private ReplyMeCacheModel kwd;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kwa = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kwb = new k();
        this.kwc = new ReplyMeNetModel(this.kwa.getPageContext(), this.kwb);
        this.kwc.a(this);
        this.kwc.setUniqueId(this.kwa.getUniqueId());
        this.kwd = new ReplyMeCacheModel(this.kwa.getPageContext());
        this.kwd.a(this);
        this.kwd.setUniqueId(this.kwa.getUniqueId());
        this.kuv = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean coD() {
        if (this.kwc.isLoading() || !cWd()) {
            return false;
        }
        this.kwb.e(this.kuu);
        this.kwc.setNeedCache(false);
        this.kwc.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cDq() {
        if (this.kwc.isLoading() || !cWd()) {
            return false;
        }
        this.kuu = null;
        this.kwb.reset();
        this.kwc.setNeedCache(true);
        this.kwc.loadData();
        return true;
    }

    protected boolean cWd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kuv != null && this.kuv.kvR != null) {
            this.kuv.kvR.clear();
        }
        this.kwa.cWB();
        this.kwa.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean coC() {
        if (cWd()) {
            this.kwd.a((com.baidu.tbadk.mvc.b.e) this.kwb);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.kuv.cWv().clear();
        }
        this.kuv.a(lVar);
        if (lVar != null && lVar.cWv() != null && lVar.cWv().size() > 0) {
            this.kuu = lVar.cWv().get(lVar.cWv().size() - 1);
            if (this.kuv.getPage() != null) {
                z4 = this.kuv.getPage().bks() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgReplyme(0);
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
            this.kuu = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvv();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kuv.kvR.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.sH(false);
            }
            arrayList.add(aVar);
        }
        this.kwa.b(z2, arrayList);
        return z3;
    }

    public void Ei(int i) {
        if (this.kuv != null && this.kuv.cWv() != null && i < this.kuv.cWv().size()) {
            this.kuv.cWv().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kwb, readCacheRespMsg.getData().get(0), true);
        }
        this.kuu = null;
        this.kwb.reset();
        this.kwc.setNeedCache(true);
        this.kwc.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgReplyme(0);
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
                this.kwa.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgReplyme(0);
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
                this.kwa.a(errorData);
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
        if (this.kwc != null) {
            this.kwc.a((NetModel.b) null);
        }
        if (this.kwd != null) {
            this.kwd.a((CacheModel.a) null);
        }
    }
}

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
    private FeedData knO;
    private f knP;
    private ReplyMessageFragment kpu;
    private k kpv;
    private ReplyMeNetModel kpw;
    private ReplyMeCacheModel kpx;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kpu = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kpv = new k();
        this.kpw = new ReplyMeNetModel(this.kpu.getPageContext(), this.kpv);
        this.kpw.a(this);
        this.kpw.setUniqueId(this.kpu.getUniqueId());
        this.kpx = new ReplyMeCacheModel(this.kpu.getPageContext());
        this.kpx.a(this);
        this.kpx.setUniqueId(this.kpu.getUniqueId());
        this.knP = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cmB() {
        if (this.kpw.isLoading() || !cTW()) {
            return false;
        }
        this.kpv.e(this.knO);
        this.kpw.setNeedCache(false);
        this.kpw.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cBl() {
        if (this.kpw.isLoading() || !cTW()) {
            return false;
        }
        this.knO = null;
        this.kpv.reset();
        this.kpw.setNeedCache(true);
        this.kpw.loadData();
        return true;
    }

    protected boolean cTW() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.knP != null && this.knP.kpl != null) {
            this.knP.kpl.clear();
        }
        this.kpu.cUt();
        this.kpu.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean cmA() {
        if (cTW()) {
            this.kpx.a((com.baidu.tbadk.mvc.b.e) this.kpv);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.knP.cUo().clear();
        }
        this.knP.a(lVar);
        if (lVar != null && lVar.cUo() != null && lVar.cUo().size() > 0) {
            this.knO = lVar.cUo().get(lVar.cUo().size() - 1);
            if (this.knP.getPage() != null) {
                z4 = this.knP.getPage().biQ() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgReplyme(0);
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
            this.knO = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bts().btF();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.knP.kpl.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.sv(false);
            }
            arrayList.add(aVar);
        }
        this.kpu.b(z2, arrayList);
        return z3;
    }

    public void Dx(int i) {
        if (this.knP != null && this.knP.cUo() != null && i < this.knP.cUo().size()) {
            this.knP.cUo().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kpv, readCacheRespMsg.getData().get(0), true);
        }
        this.knO = null;
        this.kpv.reset();
        this.kpw.setNeedCache(true);
        this.kpw.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgReplyme(0);
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
                this.kpu.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgReplyme(0);
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
                this.kpu.a(errorData);
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
        if (this.kpw != null) {
            this.kpw.a((NetModel.b) null);
        }
        if (this.kpx != null) {
            this.kpx.a((CacheModel.a) null);
        }
    }
}

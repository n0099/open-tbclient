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
    private FeedData kbp;
    private f kbq;
    private ReplyMessageFragment kcV;
    private k kcW;
    private ReplyMeNetModel kcX;
    private ReplyMeCacheModel kcY;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kcV = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kcW = new k();
        this.kcX = new ReplyMeNetModel(this.kcV.getPageContext(), this.kcW);
        this.kcX.a(this);
        this.kcX.setUniqueId(this.kcV.getUniqueId());
        this.kcY = new ReplyMeCacheModel(this.kcV.getPageContext());
        this.kcY.a(this);
        this.kcY.setUniqueId(this.kcV.getUniqueId());
        this.kbq = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cju() {
        if (this.kcX.isLoading() || !cQP()) {
            return false;
        }
        this.kcW.e(this.kbp);
        this.kcX.setNeedCache(false);
        this.kcX.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cye() {
        if (this.kcX.isLoading() || !cQP()) {
            return false;
        }
        this.kbp = null;
        this.kcW.reset();
        this.kcX.setNeedCache(true);
        this.kcX.loadData();
        return true;
    }

    protected boolean cQP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kbq != null && this.kbq.kcM != null) {
            this.kbq.kcM.clear();
        }
        this.kcV.cRm();
        this.kcV.b(false, (ArrayList<q>) null);
        return false;
    }

    public boolean cjt() {
        if (cQP()) {
            this.kcY.a((com.baidu.tbadk.mvc.b.e) this.kcW);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.kbq.cRh().clear();
        }
        this.kbq.a(lVar);
        if (lVar != null && lVar.cRh() != null && lVar.cRh().size() > 0) {
            this.kbp = lVar.cRh().get(lVar.cRh().size() - 1);
            if (this.kbq.getPage() != null) {
                z4 = this.kbq.getPage().bgX() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgReplyme(0);
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
            this.kbp = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.brz().brM();
        ArrayList<q> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kbq.kcM.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.sd(false);
            }
            arrayList.add(aVar);
        }
        this.kcV.b(z2, arrayList);
        return z3;
    }

    public void De(int i) {
        if (this.kbq != null && this.kbq.cRh() != null && i < this.kbq.cRh().size()) {
            this.kbq.cRh().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kcW, readCacheRespMsg.getData().get(0), true);
        }
        this.kbp = null;
        this.kcW.reset();
        this.kcX.setNeedCache(true);
        this.kcX.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgReplyme(0);
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
                this.kcV.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgReplyme(0);
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
                this.kcV.a(errorData);
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
        if (this.kcX != null) {
            this.kcX.a((NetModel.b) null);
        }
        if (this.kcY != null) {
            this.kcY.a((CacheModel.a) null);
        }
    }
}

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
/* loaded from: classes4.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData gOx;
    private f gOy;
    private ReplyMessageFragment gPD;
    private k gPE;
    private ReplyMeNetModel gPF;
    private ReplyMeCacheModel gPG;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gPD = replyMessageFragment;
    }

    public void K(Bundle bundle) {
        this.gPE = new k();
        this.gPF = new ReplyMeNetModel(this.gPD.getPageContext(), this.gPE);
        this.gPF.a(this);
        this.gPF.setUniqueId(this.gPD.getUniqueId());
        this.gPG = new ReplyMeCacheModel(this.gPD.getPageContext());
        this.gPG.a(this);
        this.gPG.setUniqueId(this.gPD.getUniqueId());
        this.gOy = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aZb() {
        if (this.gPF.pu() || !bFb()) {
            return false;
        }
        this.gPE.d(this.gOx);
        this.gPF.setNeedCache(false);
        this.gPF.atv();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boI() {
        if (this.gPF.pu() || !bFb()) {
            return false;
        }
        this.gOx = null;
        this.gPE.reset();
        this.gPF.setNeedCache(true);
        this.gPF.atv();
        return true;
    }

    protected boolean bFb() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gOy != null && this.gOy.gPt != null) {
            this.gOy.gPt.clear();
        }
        this.gPD.bFA();
        this.gPD.b(false, (ArrayList<com.baidu.adp.widget.ListView.m>) null);
        return false;
    }

    public boolean aZa() {
        if (bFb()) {
            this.gPG.a((com.baidu.tbadk.mvc.b.e) this.gPE);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.gOy.bFv().clear();
        }
        this.gOy.a(lVar);
        if (lVar != null && lVar.bFv() != null && lVar.bFv().size() > 0) {
            this.gOx = lVar.bFv().get(lVar.bFv().size() - 1);
            if (this.gOy.getPage() != null) {
                z4 = this.gOy.getPage().acp() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgReplyme(0);
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
            this.gOx = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amM();
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.gOy.gPt.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.mD(false);
            }
            arrayList.add(aVar);
        }
        this.gPD.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gPE, readCacheRespMsg.getData().get(0), true);
        }
        this.gOx = null;
        this.gPE.reset();
        this.gPF.setNeedCache(true);
        this.gPF.atv();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgReplyme(0);
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
                this.gPD.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgReplyme(0);
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
                this.gPD.a(errorData);
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
        if (this.gPF != null) {
            this.gPF.a((NetModel.b) null);
        }
        if (this.gPG != null) {
            this.gPG.a((CacheModel.a) null);
        }
    }
}

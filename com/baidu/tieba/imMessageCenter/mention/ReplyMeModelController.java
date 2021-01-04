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
    private FeedData kMZ;
    private f kNa;
    private ReplyMessageFragment kOF;
    private k kOG;
    private ReplyMeNetModel kOH;
    private ReplyMeCacheModel kOI;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kOF = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kOG = new k();
        this.kOH = new ReplyMeNetModel(this.kOF.getPageContext(), this.kOG);
        this.kOH.a(this);
        this.kOH.setUniqueId(this.kOF.getUniqueId());
        this.kOI = new ReplyMeCacheModel(this.kOF.getPageContext());
        this.kOI.a(this);
        this.kOI.setUniqueId(this.kOF.getUniqueId());
        this.kNa = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cvK() {
        if (this.kOH.isLoading() || !daT()) {
            return false;
        }
        this.kOG.e(this.kMZ);
        this.kOH.setNeedCache(false);
        this.kOH.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cLE() {
        if (this.kOH.isLoading() || !daT()) {
            return false;
        }
        this.kMZ = null;
        this.kOG.reset();
        this.kOH.setNeedCache(true);
        this.kOH.loadData();
        return true;
    }

    protected boolean daT() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kNa != null && this.kNa.kOw != null) {
            this.kNa.kOw.clear();
        }
        this.kOF.dbs();
        this.kOF.b(false, (ArrayList<n>) null);
        return false;
    }

    public boolean cvJ() {
        if (daT()) {
            this.kOI.a((com.baidu.tbadk.mvc.b.e) this.kOG);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (kVar.getUpdateType() != 4) {
            this.kNa.dbl().clear();
        }
        this.kNa.a(lVar);
        if (lVar != null && lVar.dbl() != null && lVar.dbl().size() > 0) {
            this.kMZ = lVar.dbl().get(lVar.dbl().size() - 1);
            if (this.kNa.getPage() != null) {
                z3 = this.kNa.getPage().bqf() == 1;
            } else {
                z3 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBc().setMsgReplyme(0);
            }
            if (kVar != null) {
                kVar.dbo();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.kMZ = null;
            z2 = false;
            z4 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bBc().bBp();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kNa.kOw.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tk(false);
            }
            arrayList.add(aVar);
        }
        this.kOF.b(z2, arrayList);
        return z4;
    }

    public void EP(int i) {
        if (this.kNa != null && this.kNa.dbl() != null && i < this.kNa.dbl().size()) {
            this.kNa.dbl().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kOG, readCacheRespMsg.getData().get(0), true);
        }
        this.kMZ = null;
        this.kOG.reset();
        this.kOH.setNeedCache(true);
        this.kOH.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bBc().setMsgReplyme(0);
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
                this.kOF.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bBc().setMsgReplyme(0);
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
                this.kOF.a(errorData);
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
        if (this.kOH != null) {
            this.kOH.a((NetModel.b) null);
        }
        if (this.kOI != null) {
            this.kOI.a((CacheModel.a) null);
        }
    }
}

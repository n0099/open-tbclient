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
/* loaded from: classes2.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData emy;
    private f emz;
    private ReplyMessageFragment enH;
    private k enI;
    private ReplyMeNetModel enJ;
    private ReplyMeCacheModel enK;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.enH = replyMessageFragment;
    }

    public void i(Bundle bundle) {
        this.enI = new k();
        this.enJ = new ReplyMeNetModel(this.enH.getPageContext(), this.enI);
        this.enJ.a(this);
        this.enJ.setUniqueId(this.enH.getUniqueId());
        this.enK = new ReplyMeCacheModel(this.enH.getPageContext());
        this.enK.a(this);
        this.enK.setUniqueId(this.enH.getUniqueId());
        this.emz = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agL() {
        if (this.enJ.wX() || !aIn()) {
            return false;
        }
        this.enI.d(this.emy);
        this.enJ.setNeedCache(false);
        this.enJ.FY();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arj() {
        if (this.enJ.wX() || !aIn()) {
            return false;
        }
        this.emy = null;
        this.enI.reset();
        this.enJ.setNeedCache(true);
        this.enJ.FY();
        return true;
    }

    protected boolean aIn() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.emz != null && this.emz.enw != null) {
            this.emz.enw.clear();
        }
        this.enH.aIO();
        this.enH.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean agK() {
        if (aIn()) {
            this.enK.a((com.baidu.tbadk.mvc.b.e) this.enI);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        if (kVar.getUpdateType() != 4) {
            this.emz.aIH().clear();
        }
        this.emz.a(lVar);
        if (lVar != null && lVar.aIH() != null && lVar.aIH().size() > 0) {
            this.emy = lVar.aIH().get(lVar.aIH().size() - 1);
            if (this.emz.rg() != null) {
                z3 = this.emz.rg().rc() == 1;
            } else {
                z3 = true;
            }
            if (kVar != null) {
                kVar.toNextPage();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.emy = null;
            z2 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zL();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.emz.enw.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.hO(false);
            }
            arrayList.add(aVar);
        }
        this.enH.b(z2, arrayList);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.enI, readCacheRespMsg.getData().get(0), true);
        }
        this.emy = null;
        this.enI.reset();
        this.enJ.setNeedCache(true);
        this.enJ.FY();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgReplyme(0);
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
                this.enH.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgReplyme(0);
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
                this.enH.a(errorData);
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
        if (this.enJ != null) {
            this.enJ.a((NetModel.b) null);
        }
        if (this.enK != null) {
            this.enK.a((CacheModel.a) null);
        }
    }
}

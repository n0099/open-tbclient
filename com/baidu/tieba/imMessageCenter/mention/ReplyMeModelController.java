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
    private FeedData emB;
    private f emC;
    private ReplyMessageFragment enK;
    private k enL;
    private ReplyMeNetModel enM;
    private ReplyMeCacheModel enN;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.enK = replyMessageFragment;
    }

    public void i(Bundle bundle) {
        this.enL = new k();
        this.enM = new ReplyMeNetModel(this.enK.getPageContext(), this.enL);
        this.enM.a(this);
        this.enM.setUniqueId(this.enK.getUniqueId());
        this.enN = new ReplyMeCacheModel(this.enK.getPageContext());
        this.enN.a(this);
        this.enN.setUniqueId(this.enK.getUniqueId());
        this.emC = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agL() {
        if (this.enM.wX() || !aIn()) {
            return false;
        }
        this.enL.d(this.emB);
        this.enM.setNeedCache(false);
        this.enM.FY();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arj() {
        if (this.enM.wX() || !aIn()) {
            return false;
        }
        this.emB = null;
        this.enL.reset();
        this.enM.setNeedCache(true);
        this.enM.FY();
        return true;
    }

    protected boolean aIn() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.emC != null && this.emC.enz != null) {
            this.emC.enz.clear();
        }
        this.enK.aIO();
        this.enK.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean agK() {
        if (aIn()) {
            this.enN.a((com.baidu.tbadk.mvc.b.e) this.enL);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        if (kVar.getUpdateType() != 4) {
            this.emC.aIH().clear();
        }
        this.emC.a(lVar);
        if (lVar != null && lVar.aIH() != null && lVar.aIH().size() > 0) {
            this.emB = lVar.aIH().get(lVar.aIH().size() - 1);
            if (this.emC.rg() != null) {
                z3 = this.emC.rg().rc() == 1;
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
            this.emB = null;
            z2 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zL();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.emC.enz.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.hO(false);
            }
            arrayList.add(aVar);
        }
        this.enK.b(z2, arrayList);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.enL, readCacheRespMsg.getData().get(0), true);
        }
        this.emB = null;
        this.enL.reset();
        this.enM.setNeedCache(true);
        this.enM.FY();
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
                this.enK.a(errorData);
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
                this.enK.a(errorData);
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
        if (this.enM != null) {
            this.enM.a((NetModel.b) null);
        }
        if (this.enN != null) {
            this.enN.a((CacheModel.a) null);
        }
    }
}

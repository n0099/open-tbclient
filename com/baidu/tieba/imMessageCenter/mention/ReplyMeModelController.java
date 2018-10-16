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
    private FeedData eVA;
    private f eVB;
    private ReplyMessageFragment eWK;
    private k eWL;
    private ReplyMeNetModel eWM;
    private ReplyMeCacheModel eWN;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eWK = replyMessageFragment;
    }

    public void j(Bundle bundle) {
        this.eWL = new k();
        this.eWM = new ReplyMeNetModel(this.eWK.getPageContext(), this.eWL);
        this.eWM.a(this);
        this.eWM.setUniqueId(this.eWK.getUniqueId());
        this.eWN = new ReplyMeCacheModel(this.eWK.getPageContext());
        this.eWN.a(this);
        this.eWN.setUniqueId(this.eWK.getUniqueId());
        this.eVB = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apz() {
        if (this.eWM.DU() || !aUm()) {
            return false;
        }
        this.eWL.d(this.eVA);
        this.eWM.setNeedCache(false);
        this.eWM.Nj();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aCc() {
        if (this.eWM.DU() || !aUm()) {
            return false;
        }
        this.eVA = null;
        this.eWL.reset();
        this.eWM.setNeedCache(true);
        this.eWM.Nj();
        return true;
    }

    protected boolean aUm() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eVB != null && this.eVB.eWz != null) {
            this.eVB.eWz.clear();
        }
        this.eWK.aUM();
        this.eWK.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean apy() {
        if (aUm()) {
            this.eWN.a((com.baidu.tbadk.mvc.b.e) this.eWL);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.eVB.aUH().clear();
        }
        this.eVB.a(lVar);
        if (lVar != null && lVar.aUH() != null && lVar.aUH().size() > 0) {
            this.eVA = lVar.aUH().get(lVar.aUH().size() - 1);
            if (this.eVB.xH() != null) {
                z4 = this.eVB.xH().xD() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgReplyme(0);
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
            this.eVA = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GN();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eVB.eWz.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.iY(false);
            }
            arrayList.add(aVar);
        }
        this.eWK.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eWL, readCacheRespMsg.getData().get(0), true);
        }
        this.eVA = null;
        this.eWL.reset();
        this.eWM.setNeedCache(true);
        this.eWM.Nj();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgReplyme(0);
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
                this.eWK.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgReplyme(0);
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
                this.eWK.a(errorData);
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
        if (this.eWM != null) {
            this.eWM.a((NetModel.b) null);
        }
        if (this.eWN != null) {
            this.eWN.a((CacheModel.a) null);
        }
    }
}

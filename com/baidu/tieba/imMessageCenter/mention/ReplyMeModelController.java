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
    private f fgA;
    private FeedData fgz;
    private ReplyMessageFragment fhJ;
    private k fhK;
    private ReplyMeNetModel fhL;
    private ReplyMeCacheModel fhM;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.fhJ = replyMessageFragment;
    }

    public void p(Bundle bundle) {
        this.fhK = new k();
        this.fhL = new ReplyMeNetModel(this.fhJ.getPageContext(), this.fhK);
        this.fhL.a(this);
        this.fhL.setUniqueId(this.fhJ.getUniqueId());
        this.fhM = new ReplyMeCacheModel(this.fhJ.getPageContext());
        this.fhM.a(this);
        this.fhM.setUniqueId(this.fhJ.getUniqueId());
        this.fgA = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arC() {
        if (this.fhL.Fi() || !aWo()) {
            return false;
        }
        this.fhK.d(this.fgz);
        this.fhL.setNeedCache(false);
        this.fhL.Ox();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGA() {
        if (this.fhL.Fi() || !aWo()) {
            return false;
        }
        this.fgz = null;
        this.fhK.reset();
        this.fhL.setNeedCache(true);
        this.fhL.Ox();
        return true;
    }

    protected boolean aWo() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.fgA != null && this.fgA.fhy != null) {
            this.fgA.fhy.clear();
        }
        this.fhJ.aWO();
        this.fhJ.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean arB() {
        if (aWo()) {
            this.fhM.a((com.baidu.tbadk.mvc.b.e) this.fhK);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.fgA.aWJ().clear();
        }
        this.fgA.a(lVar);
        if (lVar != null && lVar.aWJ() != null && lVar.aWJ().size() > 0) {
            this.fgz = lVar.aWJ().get(lVar.aWJ().size() - 1);
            if (this.fgA.yS() != null) {
                z4 = this.fgA.yS().yP() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgReplyme(0);
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
            this.fgz = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Ie();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.fgA.fhy.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.jn(false);
            }
            arrayList.add(aVar);
        }
        this.fhJ.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.fhK, readCacheRespMsg.getData().get(0), true);
        }
        this.fgz = null;
        this.fhK.reset();
        this.fhL.setNeedCache(true);
        this.fhL.Ox();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgReplyme(0);
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
                this.fhJ.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgReplyme(0);
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
                this.fhJ.a(errorData);
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
        if (this.fhL != null) {
            this.fhL.a((NetModel.b) null);
        }
        if (this.fhM != null) {
            this.fhM.a((CacheModel.a) null);
        }
    }
}

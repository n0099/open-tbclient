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
    private FeedData gxt;
    private f gxu;
    private k gyA;
    private ReplyMeNetModel gyB;
    private ReplyMeCacheModel gyC;
    private ReplyMessageFragment gyz;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gyz = replyMessageFragment;
    }

    public void J(Bundle bundle) {
        this.gyA = new k();
        this.gyB = new ReplyMeNetModel(this.gyz.getPageContext(), this.gyA);
        this.gyB.a(this);
        this.gyB.setUniqueId(this.gyz.getUniqueId());
        this.gyC = new ReplyMeCacheModel(this.gyz.getPageContext());
        this.gyC.a(this);
        this.gyC.setUniqueId(this.gyz.getUniqueId());
        this.gxu = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aRR() {
        if (this.gyB.qz() || !bxs()) {
            return false;
        }
        this.gyA.d(this.gxt);
        this.gyB.setNeedCache(false);
        this.gyB.aou();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bhn() {
        if (this.gyB.qz() || !bxs()) {
            return false;
        }
        this.gxt = null;
        this.gyA.reset();
        this.gyB.setNeedCache(true);
        this.gyB.aou();
        return true;
    }

    protected boolean bxs() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gxu != null && this.gxu.gyp != null) {
            this.gxu.gyp.clear();
        }
        this.gyz.bxR();
        this.gyz.b(false, (ArrayList<com.baidu.adp.widget.ListView.m>) null);
        return false;
    }

    public boolean aRQ() {
        if (bxs()) {
            this.gyC.a((com.baidu.tbadk.mvc.b.e) this.gyA);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.gxu.bxM().clear();
        }
        this.gxu.a(lVar);
        if (lVar != null && lVar.bxM() != null && lVar.bxM().size() > 0) {
            this.gxt = lVar.bxM().get(lVar.bxM().size() - 1);
            if (this.gxu.getPage() != null) {
                z4 = this.gxu.getPage().XK() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgReplyme(0);
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
            this.gxt = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahO();
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.gxu.gyp.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.lN(false);
            }
            arrayList.add(aVar);
        }
        this.gyz.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gyA, readCacheRespMsg.getData().get(0), true);
        }
        this.gxt = null;
        this.gyA.reset();
        this.gyB.setNeedCache(true);
        this.gyB.aou();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgReplyme(0);
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
                this.gyz.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgReplyme(0);
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
                this.gyz.a(errorData);
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
        if (this.gyB != null) {
            this.gyB.a((NetModel.b) null);
        }
        if (this.gyC != null) {
            this.gyC.a((CacheModel.a) null);
        }
    }
}

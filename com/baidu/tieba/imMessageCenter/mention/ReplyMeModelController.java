package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.o;
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
/* loaded from: classes9.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData iPl;
    private f iPm;
    private ReplyMessageFragment iQr;
    private k iQs;
    private ReplyMeNetModel iQt;
    private ReplyMeCacheModel iQu;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.iQr = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.iQs = new k();
        this.iQt = new ReplyMeNetModel(this.iQr.getPageContext(), this.iQs);
        this.iQt.a(this);
        this.iQt.setUniqueId(this.iQr.getUniqueId());
        this.iQu = new ReplyMeCacheModel(this.iQr.getPageContext());
        this.iQu.a(this);
        this.iQu.setUniqueId(this.iQr.getUniqueId());
        this.iPm = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bMa() {
        if (this.iQt.isLoading() || !cqQ()) {
            return false;
        }
        this.iQs.d(this.iPl);
        this.iQt.setNeedCache(false);
        this.iQt.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bZY() {
        if (this.iQt.isLoading() || !cqQ()) {
            return false;
        }
        this.iPl = null;
        this.iQs.reset();
        this.iQt.setNeedCache(true);
        this.iQt.loadData();
        return true;
    }

    protected boolean cqQ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.iPm != null && this.iPm.iQi != null) {
            this.iPm.iQi.clear();
        }
        this.iQr.crr();
        this.iQr.b(false, (ArrayList<o>) null);
        return false;
    }

    public boolean bLZ() {
        if (cqQ()) {
            this.iQu.a((com.baidu.tbadk.mvc.b.e) this.iQs);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.iPm.crk().clear();
        }
        this.iPm.a(lVar);
        if (lVar != null && lVar.crk() != null && lVar.crk().size() > 0) {
            this.iPl = lVar.crk().get(lVar.crk().size() - 1);
            if (this.iPm.getPage() != null) {
                z4 = this.iPm.getPage().aPt() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgReplyme(0);
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
            this.iPl = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().aZA();
        ArrayList<o> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.iPm.iQi.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.pQ(false);
            }
            arrayList.add(aVar);
        }
        this.iQr.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.iQs, readCacheRespMsg.getData().get(0), true);
        }
        this.iPl = null;
        this.iQs.reset();
        this.iQt.setNeedCache(true);
        this.iQt.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgReplyme(0);
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
                this.iQr.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgReplyme(0);
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
                this.iQr.a(errorData);
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
        if (this.iQt != null) {
            this.iQt.a((NetModel.b) null);
        }
        if (this.iQu != null) {
            this.iQu.a((CacheModel.a) null);
        }
    }
}

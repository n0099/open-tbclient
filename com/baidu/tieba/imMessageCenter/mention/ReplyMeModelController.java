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
    private FeedData iOy;
    private f iOz;
    private ReplyMessageFragment iPE;
    private k iPF;
    private ReplyMeNetModel iPG;
    private ReplyMeCacheModel iPH;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.iPE = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.iPF = new k();
        this.iPG = new ReplyMeNetModel(this.iPE.getPageContext(), this.iPF);
        this.iPG.a(this);
        this.iPG.setUniqueId(this.iPE.getUniqueId());
        this.iPH = new ReplyMeCacheModel(this.iPE.getPageContext());
        this.iPH.a(this);
        this.iPH.setUniqueId(this.iPE.getUniqueId());
        this.iOz = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bLY() {
        if (this.iPG.isLoading() || !cqH()) {
            return false;
        }
        this.iPF.d(this.iOy);
        this.iPG.setNeedCache(false);
        this.iPG.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bZQ() {
        if (this.iPG.isLoading() || !cqH()) {
            return false;
        }
        this.iOy = null;
        this.iPF.reset();
        this.iPG.setNeedCache(true);
        this.iPG.loadData();
        return true;
    }

    protected boolean cqH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.iOz != null && this.iOz.iPv != null) {
            this.iOz.iPv.clear();
        }
        this.iPE.cri();
        this.iPE.b(false, (ArrayList<o>) null);
        return false;
    }

    public boolean bLX() {
        if (cqH()) {
            this.iPH.a((com.baidu.tbadk.mvc.b.e) this.iPF);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.iOz.crb().clear();
        }
        this.iOz.a(lVar);
        if (lVar != null && lVar.crb() != null && lVar.crb().size() > 0) {
            this.iOy = lVar.crb().get(lVar.crb().size() - 1);
            if (this.iOz.getPage() != null) {
                z4 = this.iOz.getPage().aPt() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgReplyme(0);
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
            this.iOy = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZz();
        ArrayList<o> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.iOz.iPv.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.pQ(false);
            }
            arrayList.add(aVar);
        }
        this.iPE.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.iPF, readCacheRespMsg.getData().get(0), true);
        }
        this.iOy = null;
        this.iPF.reset();
        this.iPG.setNeedCache(true);
        this.iPG.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgReplyme(0);
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
                this.iPE.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgReplyme(0);
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
                this.iPE.a(errorData);
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
        if (this.iPG != null) {
            this.iPG.a((NetModel.b) null);
        }
        if (this.iPH != null) {
            this.iPH.a((CacheModel.a) null);
        }
    }
}

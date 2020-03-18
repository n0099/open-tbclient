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
/* loaded from: classes9.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private FeedData hPU;
    private f hPV;
    private ReplyMessageFragment hRa;
    private k hRb;
    private ReplyMeNetModel hRc;
    private ReplyMeCacheModel hRd;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hRa = replyMessageFragment;
    }

    public void ad(Bundle bundle) {
        this.hRb = new k();
        this.hRc = new ReplyMeNetModel(this.hRa.getPageContext(), this.hRb);
        this.hRc.a(this);
        this.hRc.setUniqueId(this.hRa.getUniqueId());
        this.hRd = new ReplyMeCacheModel(this.hRa.getPageContext());
        this.hRd.a(this);
        this.hRd.setUniqueId(this.hRa.getUniqueId());
        this.hPV = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bvV() {
        if (this.hRc.isLoading() || !bZJ()) {
            return false;
        }
        this.hRb.d(this.hPU);
        this.hRc.setNeedCache(false);
        this.hRc.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bIY() {
        if (this.hRc.isLoading() || !bZJ()) {
            return false;
        }
        this.hPU = null;
        this.hRb.reset();
        this.hRc.setNeedCache(true);
        this.hRc.loadData();
        return true;
    }

    protected boolean bZJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hPV != null && this.hPV.hQR != null) {
            this.hPV.hQR.clear();
        }
        this.hRa.caj();
        this.hRa.b(false, (ArrayList<com.baidu.adp.widget.ListView.m>) null);
        return false;
    }

    public boolean bvU() {
        if (bZJ()) {
            this.hRd.a((com.baidu.tbadk.mvc.b.e) this.hRb);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.hPV.cad().clear();
        }
        this.hPV.a(lVar);
        if (lVar != null && lVar.cad() != null && lVar.cad().size() > 0) {
            this.hPU = lVar.cad().get(lVar.cad().size() - 1);
            if (this.hPV.getPage() != null) {
                z4 = this.hPV.getPage().aBn() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgReplyme(0);
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
            this.hPU = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aKX();
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.hPV.hQR.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.oq(false);
            }
            arrayList.add(aVar);
        }
        this.hRa.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hRb, readCacheRespMsg.getData().get(0), true);
        }
        this.hPU = null;
        this.hRb.reset();
        this.hRc.setNeedCache(true);
        this.hRc.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgReplyme(0);
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
                this.hRa.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgReplyme(0);
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
                this.hRa.a(errorData);
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
        if (this.hRc != null) {
            this.hRc.a((NetModel.b) null);
        }
        if (this.hRd != null) {
            this.hRd.a((CacheModel.a) null);
        }
    }
}

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
    private FeedData kIu;
    private f kIv;
    private ReplyMessageFragment kKa;
    private k kKb;
    private ReplyMeNetModel kKc;
    private ReplyMeCacheModel kKd;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kKa = replyMessageFragment;
    }

    public void aj(Bundle bundle) {
        this.kKb = new k();
        this.kKc = new ReplyMeNetModel(this.kKa.getPageContext(), this.kKb);
        this.kKc.a(this);
        this.kKc.setUniqueId(this.kKa.getUniqueId());
        this.kKd = new ReplyMeCacheModel(this.kKa.getPageContext());
        this.kKd.a(this);
        this.kKd.setUniqueId(this.kKa.getUniqueId());
        this.kIv = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crT() {
        if (this.kKc.isLoading() || !cXc()) {
            return false;
        }
        this.kKb.e(this.kIu);
        this.kKc.setNeedCache(false);
        this.kKc.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cHN() {
        if (this.kKc.isLoading() || !cXc()) {
            return false;
        }
        this.kIu = null;
        this.kKb.reset();
        this.kKc.setNeedCache(true);
        this.kKc.loadData();
        return true;
    }

    protected boolean cXc() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kIv != null && this.kIv.kJR != null) {
            this.kIv.kJR.clear();
        }
        this.kKa.cXB();
        this.kKa.b(false, (ArrayList<n>) null);
        return false;
    }

    public boolean crS() {
        if (cXc()) {
            this.kKd.a((com.baidu.tbadk.mvc.b.e) this.kKb);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (kVar.getUpdateType() != 4) {
            this.kIv.cXu().clear();
        }
        this.kIv.a(lVar);
        if (lVar != null && lVar.cXu() != null && lVar.cXu().size() > 0) {
            this.kIu = lVar.cXu().get(lVar.cXu().size() - 1);
            if (this.kIv.getPage() != null) {
                z3 = this.kIv.getPage().bmm() == 1;
            } else {
                z3 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgReplyme(0);
            }
            if (kVar != null) {
                kVar.cXx();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.kIu = null;
            z2 = false;
            z4 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxw();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.kIv.kJR.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.f(it.next());
            if (z) {
                aVar.tg(false);
            }
            arrayList.add(aVar);
        }
        this.kKa.b(z2, arrayList);
        return z4;
    }

    public void Di(int i) {
        if (this.kIv != null && this.kIv.cXu() != null && i < this.kIv.cXu().size()) {
            this.kIv.cXu().remove(i);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kKb, readCacheRespMsg.getData().get(0), true);
        }
        this.kIu = null;
        this.kKb.reset();
        this.kKc.setNeedCache(true);
        this.kKc.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgReplyme(0);
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
                this.kKa.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgReplyme(0);
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
                this.kKa.a(errorData);
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
        if (this.kKc != null) {
            this.kKc.a((NetModel.b) null);
        }
        if (this.kKd != null) {
            this.kKd.a((CacheModel.a) null);
        }
    }
}

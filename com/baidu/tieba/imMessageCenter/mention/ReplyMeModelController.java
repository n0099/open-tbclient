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
    private FeedData hOg;
    private f hOh;
    private ReplyMessageFragment hPm;
    private k hPn;
    private ReplyMeNetModel hPo;
    private ReplyMeCacheModel hPp;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hPm = replyMessageFragment;
    }

    public void ad(Bundle bundle) {
        this.hPn = new k();
        this.hPo = new ReplyMeNetModel(this.hPm.getPageContext(), this.hPn);
        this.hPo.a(this);
        this.hPo.setUniqueId(this.hPm.getUniqueId());
        this.hPp = new ReplyMeCacheModel(this.hPm.getPageContext());
        this.hPp.a(this);
        this.hPp.setUniqueId(this.hPm.getUniqueId());
        this.hOh = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bvN() {
        if (this.hPo.isLoading() || !bZo()) {
            return false;
        }
        this.hPn.d(this.hOg);
        this.hPo.setNeedCache(false);
        this.hPo.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bIJ() {
        if (this.hPo.isLoading() || !bZo()) {
            return false;
        }
        this.hOg = null;
        this.hPn.reset();
        this.hPo.setNeedCache(true);
        this.hPo.loadData();
        return true;
    }

    protected boolean bZo() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.hOh != null && this.hOh.hPd != null) {
            this.hOh.hPd.clear();
        }
        this.hPm.bZO();
        this.hPm.b(false, (ArrayList<com.baidu.adp.widget.ListView.m>) null);
        return false;
    }

    public boolean bvM() {
        if (bZo()) {
            this.hPp.a((com.baidu.tbadk.mvc.b.e) this.hPn);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.hOh.bZI().clear();
        }
        this.hOh.a(lVar);
        if (lVar != null && lVar.bZI() != null && lVar.bZI().size() > 0) {
            this.hOg = lVar.bZI().get(lVar.bZI().size() - 1);
            if (this.hOh.getPage() != null) {
                z4 = this.hOh.getPage().aBi() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgReplyme(0);
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
            this.hOg = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKQ();
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.hOh.hPd.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.ok(false);
            }
            arrayList.add(aVar);
        }
        this.hPm.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.hPn, readCacheRespMsg.getData().get(0), true);
        }
        this.hOg = null;
        this.hPn.reset();
        this.hPo.setNeedCache(true);
        this.hPo.loadData();
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgReplyme(0);
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
                this.hPm.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgReplyme(0);
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
                this.hPm.a(errorData);
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
        if (this.hPo != null) {
            this.hPo.a((NetModel.b) null);
        }
        if (this.hPp != null) {
            this.hPp.a((CacheModel.a) null);
        }
    }
}

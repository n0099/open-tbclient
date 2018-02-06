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
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<n>, NetModel.b<m, n> {
    private FeedData eSk;
    private f eSl;
    private p eTe;
    private m eTf;
    private ReplyMeNetModel eTg;
    private ReplyMeCacheModel eTh;

    public ReplyMeModelController(p pVar) {
        super(pVar.getPageContext());
        this.eTe = pVar;
    }

    public void l(Bundle bundle) {
        this.eTf = new m();
        this.eTg = new ReplyMeNetModel(this.eTe.getPageContext(), this.eTf);
        this.eTg.a(this);
        this.eTg.setUniqueId(this.eTe.getUniqueId());
        this.eTh = new ReplyMeCacheModel(this.eTe.getPageContext());
        this.eTh.a(this);
        this.eTh.setUniqueId(this.eTe.getUniqueId());
        this.eSl = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amN() {
        if (this.eTg.El() || !aNt()) {
            return false;
        }
        this.eTf.d(this.eSk);
        this.eTg.setNeedCache(false);
        this.eTg.Nw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNs() {
        if (this.eTg.El() || !aNt()) {
            return false;
        }
        this.eSk = null;
        this.eTf.reset();
        this.eTg.setNeedCache(true);
        this.eTg.Nw();
        return true;
    }

    protected boolean aNt() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eSl != null && this.eSl.eSV != null) {
            this.eSl.eSV.clear();
        }
        this.eTe.aNM();
        this.eTe.b(false, (ArrayList<com.baidu.adp.widget.ListView.i>) null);
        return false;
    }

    public boolean amM() {
        if (aNt()) {
            this.eTh.a((com.baidu.tbadk.mvc.b.e) this.eTf);
            return true;
        }
        return true;
    }

    protected boolean a(m mVar, n nVar, boolean z) {
        boolean z2;
        boolean z3;
        if (mVar.getUpdateType() != 4) {
            this.eSl.aNF().clear();
        }
        this.eSl.a(nVar);
        if (nVar != null && nVar.aNF() != null && nVar.aNF().size() > 0) {
            this.eSk = nVar.aNF().get(nVar.aNF().size() - 1);
            if (this.eSl.yA() != null) {
                z3 = this.eSl.yA().yw() == 1;
            } else {
                z3 = true;
            }
            if (mVar != null) {
                mVar.toNextPage();
                z2 = z3;
            } else {
                z2 = z3;
            }
        } else {
            this.eSk = null;
            z2 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GX();
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eSl.eSV.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.il(false);
            }
            arrayList.add(aVar);
        }
        this.eTe.b(z2, arrayList);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<n>> readCacheRespMsg, ReadCacheMessage<n> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eTf, readCacheRespMsg.getData().get(0), true);
        }
        this.eSk = null;
        this.eTf.reset();
        this.eTg.setNeedCache(true);
        this.eTg.Nw();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<n>> writeCacheRespMsg, WriteCacheMessage<n> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<m, n> mvcHttpMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            nVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgReplyme(0);
            nVar = null;
        }
        if (r1 == null || nVar == null || !a(r1, nVar, false)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.eTe.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            nVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgReplyme(0);
            nVar = null;
        }
        if (r1 == null || nVar == null || !a(r1, nVar, false)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.eTe.a(errorData);
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
}

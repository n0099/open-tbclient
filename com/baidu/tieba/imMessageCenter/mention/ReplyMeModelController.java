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
    private FeedData eSn;
    private f eSo;
    private p eTh;
    private m eTi;
    private ReplyMeNetModel eTj;
    private ReplyMeCacheModel eTk;

    public ReplyMeModelController(p pVar) {
        super(pVar.getPageContext());
        this.eTh = pVar;
    }

    public void l(Bundle bundle) {
        this.eTi = new m();
        this.eTj = new ReplyMeNetModel(this.eTh.getPageContext(), this.eTi);
        this.eTj.a(this);
        this.eTj.setUniqueId(this.eTh.getUniqueId());
        this.eTk = new ReplyMeCacheModel(this.eTh.getPageContext());
        this.eTk.a(this);
        this.eTk.setUniqueId(this.eTh.getUniqueId());
        this.eSo = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amN() {
        if (this.eTj.El() || !aNt()) {
            return false;
        }
        this.eTi.d(this.eSn);
        this.eTj.setNeedCache(false);
        this.eTj.Nw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNs() {
        if (this.eTj.El() || !aNt()) {
            return false;
        }
        this.eSn = null;
        this.eTi.reset();
        this.eTj.setNeedCache(true);
        this.eTj.Nw();
        return true;
    }

    protected boolean aNt() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eSo != null && this.eSo.eSY != null) {
            this.eSo.eSY.clear();
        }
        this.eTh.aNM();
        this.eTh.b(false, (ArrayList<com.baidu.adp.widget.ListView.i>) null);
        return false;
    }

    public boolean amM() {
        if (aNt()) {
            this.eTk.a((com.baidu.tbadk.mvc.b.e) this.eTi);
            return true;
        }
        return true;
    }

    protected boolean a(m mVar, n nVar, boolean z) {
        boolean z2;
        boolean z3;
        if (mVar.getUpdateType() != 4) {
            this.eSo.aNF().clear();
        }
        this.eSo.a(nVar);
        if (nVar != null && nVar.aNF() != null && nVar.aNF().size() > 0) {
            this.eSn = nVar.aNF().get(nVar.aNF().size() - 1);
            if (this.eSo.yA() != null) {
                z3 = this.eSo.yA().yw() == 1;
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
            this.eSn = null;
            z2 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GX();
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eSo.eSY.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.iq(false);
            }
            arrayList.add(aVar);
        }
        this.eTh.b(z2, arrayList);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<n>> readCacheRespMsg, ReadCacheMessage<n> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eTi, readCacheRespMsg.getData().get(0), true);
        }
        this.eSn = null;
        this.eTi.reset();
        this.eTj.setNeedCache(true);
        this.eTj.Nw();
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
                this.eTh.a(errorData);
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
                this.eTh.a(errorData);
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

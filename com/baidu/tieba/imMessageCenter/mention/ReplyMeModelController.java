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
    private FeedData eRY;
    private f eRZ;
    private p eSS;
    private m eST;
    private ReplyMeNetModel eSU;
    private ReplyMeCacheModel eSV;

    public ReplyMeModelController(p pVar) {
        super(pVar.getPageContext());
        this.eSS = pVar;
    }

    public void l(Bundle bundle) {
        this.eST = new m();
        this.eSU = new ReplyMeNetModel(this.eSS.getPageContext(), this.eST);
        this.eSU.a(this);
        this.eSU.setUniqueId(this.eSS.getUniqueId());
        this.eSV = new ReplyMeCacheModel(this.eSS.getPageContext());
        this.eSV.a(this);
        this.eSV.setUniqueId(this.eSS.getUniqueId());
        this.eRZ = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amM() {
        if (this.eSU.Ek() || !aNs()) {
            return false;
        }
        this.eST.d(this.eRY);
        this.eSU.setNeedCache(false);
        this.eSU.Nv();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNr() {
        if (this.eSU.Ek() || !aNs()) {
            return false;
        }
        this.eRY = null;
        this.eST.reset();
        this.eSU.setNeedCache(true);
        this.eSU.Nv();
        return true;
    }

    protected boolean aNs() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eRZ != null && this.eRZ.eSJ != null) {
            this.eRZ.eSJ.clear();
        }
        this.eSS.aNL();
        this.eSS.b(false, (ArrayList<com.baidu.adp.widget.ListView.i>) null);
        return false;
    }

    public boolean amL() {
        if (aNs()) {
            this.eSV.a((com.baidu.tbadk.mvc.b.e) this.eST);
            return true;
        }
        return true;
    }

    protected boolean a(m mVar, n nVar, boolean z) {
        boolean z2;
        boolean z3;
        if (mVar.getUpdateType() != 4) {
            this.eRZ.aNE().clear();
        }
        this.eRZ.a(nVar);
        if (nVar != null && nVar.aNE() != null && nVar.aNE().size() > 0) {
            this.eRY = nVar.aNE().get(nVar.aNE().size() - 1);
            if (this.eRZ.yA() != null) {
                z3 = this.eRZ.yA().yw() == 1;
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
            this.eRY = null;
            z2 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.GI().GW();
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eRZ.eSJ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.il(false);
            }
            arrayList.add(aVar);
        }
        this.eSS.b(z2, arrayList);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<n>> readCacheRespMsg, ReadCacheMessage<n> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eST, readCacheRespMsg.getData().get(0), true);
        }
        this.eRY = null;
        this.eST.reset();
        this.eSU.setNeedCache(true);
        this.eSU.Nv();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgReplyme(0);
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
                this.eSS.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgReplyme(0);
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
                this.eSS.a(errorData);
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

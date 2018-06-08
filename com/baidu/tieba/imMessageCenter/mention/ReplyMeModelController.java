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
public class ReplyMeModelController extends BdBaseModel implements CacheModel.a<l>, NetModel.b<k, l> {
    private ReplyMessageFragment eAh;
    private k eAi;
    private ReplyMeNetModel eAj;
    private ReplyMeCacheModel eAk;
    private FeedData eyY;
    private f eyZ;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eAh = replyMessageFragment;
    }

    public void i(Bundle bundle) {
        this.eAi = new k();
        this.eAj = new ReplyMeNetModel(this.eAh.getPageContext(), this.eAi);
        this.eAj.a(this);
        this.eAj.setUniqueId(this.eAh.getUniqueId());
        this.eAk = new ReplyMeCacheModel(this.eAh.getPageContext());
        this.eAk.a(this);
        this.eAk.setUniqueId(this.eAh.getUniqueId());
        this.eyZ = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akt() {
        if (this.eAj.Ax() || !aNg()) {
            return false;
        }
        this.eAi.d(this.eyY);
        this.eAj.setNeedCache(false);
        this.eAj.JE();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avn() {
        if (this.eAj.Ax() || !aNg()) {
            return false;
        }
        this.eyY = null;
        this.eAi.reset();
        this.eAj.setNeedCache(true);
        this.eAj.JE();
        return true;
    }

    protected boolean aNg() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eyZ != null && this.eyZ.ezW != null) {
            this.eyZ.ezW.clear();
        }
        this.eAh.aNI();
        this.eAh.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean aks() {
        if (aNg()) {
            this.eAk.a((com.baidu.tbadk.mvc.b.e) this.eAi);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.eyZ.aNB().clear();
        }
        this.eyZ.a(lVar);
        if (lVar != null && lVar.aNB() != null && lVar.aNB().size() > 0) {
            this.eyY = lVar.aNB().get(lVar.aNB().size() - 1);
            if (this.eyZ.uB() != null) {
                z4 = this.eyZ.uB().ux() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgReplyme(0);
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
            this.eyY = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dl();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eyZ.ezW.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.hV(false);
            }
            arrayList.add(aVar);
        }
        this.eAh.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eAi, readCacheRespMsg.getData().get(0), true);
        }
        this.eyY = null;
        this.eAi.reset();
        this.eAj.setNeedCache(true);
        this.eAj.JE();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgReplyme(0);
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
                this.eAh.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgReplyme(0);
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
                this.eAh.a(errorData);
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
        if (this.eAj != null) {
            this.eAj.a((NetModel.b) null);
        }
        if (this.eAk != null) {
            this.eAk.a((CacheModel.a) null);
        }
    }
}

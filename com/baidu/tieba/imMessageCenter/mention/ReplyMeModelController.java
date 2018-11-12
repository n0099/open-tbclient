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
    private FeedData eWT;
    private f eWU;
    private ReplyMessageFragment eYd;
    private k eYe;
    private ReplyMeNetModel eYf;
    private ReplyMeCacheModel eYg;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eYd = replyMessageFragment;
    }

    public void m(Bundle bundle) {
        this.eYe = new k();
        this.eYf = new ReplyMeNetModel(this.eYd.getPageContext(), this.eYe);
        this.eYf.a(this);
        this.eYf.setUniqueId(this.eYd.getUniqueId());
        this.eYg = new ReplyMeCacheModel(this.eYd.getPageContext());
        this.eYg.a(this);
        this.eYg.setUniqueId(this.eYd.getUniqueId());
        this.eWU = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apa() {
        if (this.eYf.Ee() || !aTJ()) {
            return false;
        }
        this.eYe.d(this.eWT);
        this.eYf.setNeedCache(false);
        this.eYf.Ns();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aDZ() {
        if (this.eYf.Ee() || !aTJ()) {
            return false;
        }
        this.eWT = null;
        this.eYe.reset();
        this.eYf.setNeedCache(true);
        this.eYf.Ns();
        return true;
    }

    protected boolean aTJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eWU != null && this.eWU.eXS != null) {
            this.eWU.eXS.clear();
        }
        this.eYd.aUj();
        this.eYd.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean aoZ() {
        if (aTJ()) {
            this.eYg.a((com.baidu.tbadk.mvc.b.e) this.eYe);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.eWU.aUe().clear();
        }
        this.eWU.a(lVar);
        if (lVar != null && lVar.aUe() != null && lVar.aUe().size() > 0) {
            this.eWT = lVar.aUe().get(lVar.aUe().size() - 1);
            if (this.eWU.xO() != null) {
                z4 = this.eWU.xO().xL() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgReplyme(0);
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
            this.eWT = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.GL().GZ();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eWU.eXS.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.jh(false);
            }
            arrayList.add(aVar);
        }
        this.eYd.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eYe, readCacheRespMsg.getData().get(0), true);
        }
        this.eWT = null;
        this.eYe.reset();
        this.eYf.setNeedCache(true);
        this.eYf.Ns();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgReplyme(0);
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
                this.eYd.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgReplyme(0);
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
                this.eYd.a(errorData);
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
        if (this.eYf != null) {
            this.eYf.a((NetModel.b) null);
        }
        if (this.eYg != null) {
            this.eYg.a((CacheModel.a) null);
        }
    }
}

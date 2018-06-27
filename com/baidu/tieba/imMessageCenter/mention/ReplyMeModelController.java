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
    private FeedData eCN;
    private f eCO;
    private ReplyMessageFragment eDX;
    private k eDY;
    private ReplyMeNetModel eDZ;
    private ReplyMeCacheModel eEa;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eDX = replyMessageFragment;
    }

    public void i(Bundle bundle) {
        this.eDY = new k();
        this.eDZ = new ReplyMeNetModel(this.eDX.getPageContext(), this.eDY);
        this.eDZ.a(this);
        this.eDZ.setUniqueId(this.eDX.getUniqueId());
        this.eEa = new ReplyMeCacheModel(this.eDX.getPageContext());
        this.eEa.a(this);
        this.eEa.setUniqueId(this.eDX.getUniqueId());
        this.eCO = new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ajN() {
        if (this.eDZ.AO() || !aNM()) {
            return false;
        }
        this.eDY.d(this.eCN);
        this.eDZ.setNeedCache(false);
        this.eDZ.JW();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avR() {
        if (this.eDZ.AO() || !aNM()) {
            return false;
        }
        this.eCN = null;
        this.eDY.reset();
        this.eDZ.setNeedCache(true);
        this.eDZ.JW();
        return true;
    }

    protected boolean aNM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.eCO != null && this.eCO.eDM != null) {
            this.eCO.eDM.clear();
        }
        this.eDX.aOo();
        this.eDX.b(false, (ArrayList<com.baidu.adp.widget.ListView.h>) null);
        return false;
    }

    public boolean ajM() {
        if (aNM()) {
            this.eEa.a((com.baidu.tbadk.mvc.b.e) this.eDY);
            return true;
        }
        return true;
    }

    protected boolean a(k kVar, l lVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (kVar.getUpdateType() != 4) {
            this.eCO.aOh().clear();
        }
        this.eCO.a(lVar);
        if (lVar != null && lVar.aOh() != null && lVar.aOh().size() > 0) {
            this.eCN = lVar.aOh().get(lVar.aOh().size() - 1);
            if (this.eCO.uJ() != null) {
                z4 = this.eCO.uJ().uF() == 1;
            } else {
                z4 = true;
            }
            if (kVar.getUpdateType() == 1) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgReplyme(0);
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
            this.eCN = null;
            z2 = false;
            z3 = false;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DD();
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.eCO.eDM.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
            aVar.e(it.next());
            if (z) {
                aVar.m16if(false);
            }
            arrayList.add(aVar);
        }
        this.eDX.b(z2, arrayList);
        return z3;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<l>> readCacheRespMsg, ReadCacheMessage<l> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.eDY, readCacheRespMsg.getData().get(0), true);
        }
        this.eCN = null;
        this.eDY.reset();
        this.eDZ.setNeedCache(true);
        this.eDZ.JW();
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
            com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgReplyme(0);
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
                this.eDX.a(errorData);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgReplyme(0);
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
                this.eDX.a(errorData);
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
        if (this.eDZ != null) {
            this.eDZ.a((NetModel.b) null);
        }
        if (this.eEa != null) {
            this.eEa.a((CacheModel.a) null);
        }
    }
}

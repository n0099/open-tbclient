package com.baidu.tieba.mention;

import android.os.Bundle;
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
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.mvc.model.a;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e<SingleMentionActivity> implements NetModel.b<h, i>, a.InterfaceC0052a<i> {
    private com.baidu.tbadk.mvc.d.a aJI;
    private SingleMentionActivity caj;
    private h cak;
    private g cal;
    private a cam;
    private FeedData can;
    private t cao;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.caj = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.cak = new h();
        this.cal = new g(this.caj.getPageContext(), this.cak);
        this.cal.a(this);
        this.cal.setUniqueId(getUniqueId());
        this.cam = new a(this.caj.getPageContext());
        this.cam.a(this);
        this.cam.setUniqueId(getUniqueId());
        this.cao = new t();
        this.aJI = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hn() {
        if (this.cal.isLoading() || !this.aJI.Dc()) {
            return false;
        }
        this.aJI.bk(true);
        this.aJI.bm(true);
        this.cak.b(this.can);
        this.cal.setNeedCache(false);
        this.cal.CS();
        this.caj.adf().d(this.aJI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bB(boolean z) {
        if (this.cal.isLoading()) {
            return false;
        }
        this.can = null;
        this.cak.reset();
        this.cal.setNeedCache(true);
        this.cal.CS();
        return true;
    }

    public boolean oR() {
        this.cam.a((com.baidu.tbadk.mvc.b.e) this.cak);
        return true;
    }

    protected boolean a(h hVar, i iVar) {
        if (hVar.getUpdateType() != 4) {
            this.cao.adc().clear();
        }
        this.cao.a(iVar);
        if (iVar != null && iVar.adc() != null && iVar.adc().size() > 0) {
            this.can = iVar.adc().get(iVar.adc().size() - 1);
            if (this.cao.getPage() != null) {
                this.aJI.bl(this.cao.getPage().rL() == 1);
            } else {
                this.aJI.bl(true);
            }
            if (hVar != null) {
                hVar.toNextPage();
            }
            this.aJI.bm(true);
        } else {
            this.can = null;
            this.aJI.bl(false);
            this.aJI.bm(false);
        }
        this.aJI.bk(false);
        this.aJI.bj(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().xa();
        this.caj.adi().o(2, true);
        this.caj.adf().a(this.cao);
        this.caj.adf().d(this.aJI);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cak, readCacheRespMsg.getData().get(0));
        }
        this.can = null;
        this.cak.reset();
        this.cal.setNeedCache(true);
        this.cal.CS();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<h, i> mvcHttpMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            iVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgAtme(0);
            iVar = null;
        }
        if (r1 == null || iVar == null || !a(r1, iVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.caj.a(errorData);
            this.caj.adf().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, i> mvcSocketMessage, MvcNetMessage<h, i> mvcNetMessage) {
        i iVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            iVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgAtme(0);
            iVar = null;
        }
        if (r1 == null || iVar == null || !a(r1, iVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.caj.a(errorData);
            this.caj.adf().a(errorData);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}

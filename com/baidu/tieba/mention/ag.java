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
public class ag extends com.baidu.adp.base.e<SingleMentionActivity> implements NetModel.b<ai, aj>, a.InterfaceC0052a<aj> {
    private com.baidu.tbadk.mvc.d.a aKr;
    private SingleMentionActivity bVG;
    private FeedData bVK;
    private t bVL;
    private ai bWj;
    private ah bWk;
    private y bWl;

    public ag(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bVG = singleMentionActivity;
    }

    public void f(Bundle bundle) {
        this.bWj = new ai();
        this.bWk = new ah(this.bVG.getPageContext(), this.bWj);
        this.bWk.a(this);
        this.bWk.setUniqueId(getUniqueId());
        this.bWl = new y(this.bVG.getPageContext());
        this.bWl.a(this);
        this.bWl.setUniqueId(getUniqueId());
        this.bVL = new t();
        this.aKr = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HF() {
        if (this.bWk.isLoading() || !this.aKr.Df()) {
            return false;
        }
        this.aKr.bf(true);
        this.aKr.bh(true);
        this.bWj.b(this.bVK);
        this.bWk.setNeedCache(false);
        this.bWk.CV();
        this.bVG.abH().d(this.aKr);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bz(boolean z) {
        if (this.bWk.isLoading()) {
            return false;
        }
        this.bVK = null;
        this.bWj.reset();
        this.bWk.setNeedCache(true);
        this.bWk.CV();
        return true;
    }

    public boolean oT() {
        this.bWl.a((com.baidu.tbadk.mvc.b.e) this.bWj);
        return true;
    }

    protected boolean a(ai aiVar, aj ajVar) {
        if (aiVar.getUpdateType() != 4) {
            this.bVL.abF().clear();
        }
        this.bVL.a(ajVar);
        if (ajVar != null && ajVar.abF() != null && ajVar.abF().size() > 0) {
            this.bVK = ajVar.abF().get(ajVar.abF().size() - 1);
            if (this.bVL.getPage() != null) {
                this.aKr.bg(this.bVL.getPage().rT() == 1);
            } else {
                this.aKr.bg(true);
            }
            if (aiVar != null) {
                aiVar.toNextPage();
            }
            this.aKr.bh(true);
        } else {
            this.bVK = null;
            this.aKr.bg(false);
            this.aKr.bh(false);
        }
        this.aKr.bf(false);
        this.aKr.be(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.wT().xi();
        this.bVG.abL().m(1, true);
        this.bVG.abH().a(this.bVL);
        this.bVG.abH().d(this.aKr);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<aj>> readCacheRespMsg, ReadCacheMessage<aj> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bWj, readCacheRespMsg.getData().get(0));
        }
        this.bVK = null;
        this.bWj.reset();
        this.bWk.setNeedCache(true);
        this.bWk.CV();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<aj>> writeCacheRespMsg, WriteCacheMessage<aj> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<aj> mvcHttpResponsedMessage, MvcHttpMessage<ai, aj> mvcHttpMessage, MvcNetMessage<ai, aj> mvcNetMessage) {
        aj ajVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ajVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgReplyme(0);
            ajVar = null;
        }
        if (r1 == null || ajVar == null || !a(r1, ajVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bVG.a(errorData);
            this.bVG.abH().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<aj, ?> mvcSocketResponsedMessage, MvcSocketMessage<ai, aj> mvcSocketMessage, MvcNetMessage<ai, aj> mvcNetMessage) {
        aj ajVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ajVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgReplyme(0);
            ajVar = null;
        }
        if (r1 == null || ajVar == null || !a(r1, ajVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.bVG.a(errorData);
            this.bVG.abH().a(errorData);
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

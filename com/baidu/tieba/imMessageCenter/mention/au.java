package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.mvc.model.a;
import java.util.List;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e<bf> implements NetModel.b<ax, ay>, a.InterfaceC0046a<ay> {
    final CustomMessageListener Dc;
    private com.baidu.tbadk.mvc.d.a aSJ;
    private ax cyV;
    private aw cyW;
    private am cyX;
    private bf cyh;
    private FeedData cyl;
    private ag cym;

    public au(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.Dc = new av(this, 2000994);
        this.cyh = bfVar;
    }

    public void c(Bundle bundle) {
        this.cyV = new ax();
        this.cyW = new aw((TbPageContext) com.baidu.adp.base.l.s(this.cyh.getPageContext().getPageActivity()), this.cyV);
        this.cyW.a(this);
        this.cyW.setUniqueId(getUniqueId());
        this.cyW.registerListener(this.Dc);
        this.cyX = new am((TbPageContext) com.baidu.adp.base.l.s(this.cyh.getPageContext().getPageActivity()));
        this.cyX.a(this);
        this.cyX.setUniqueId(getUniqueId());
        this.cym = new ag();
        this.aSJ = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KM() {
        if (!this.cyW.isLoading() && this.aSJ.DH() && alc()) {
            this.aSJ.bI(true);
            this.aSJ.bK(true);
            this.cyV.d(this.cyl);
            this.cyW.setNeedCache(false);
            this.cyW.Dy();
            this.cyh.alw().d(this.aSJ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ck(boolean z) {
        if (this.cyW.isLoading() || !alc()) {
            return false;
        }
        this.cyl = null;
        this.cyV.reset();
        this.cyW.setNeedCache(true);
        this.cyW.Dy();
        return true;
    }

    protected boolean alc() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cym != null && this.cym.cyK != null) {
            this.cym.cyK.clear();
        }
        this.cyh.alw().ale();
        this.cyh.alw().a(this.cym);
        return false;
    }

    public boolean kX() {
        if (alc()) {
            if (this.cyh != null && this.cyh.alw() != null) {
                this.cyh.alw().ald();
            }
            this.cyX.a((com.baidu.tbadk.mvc.b.e) this.cyV);
            return true;
        }
        return true;
    }

    protected boolean a(ax axVar, ay ayVar) {
        if (axVar.getUpdateType() != 4) {
            this.cym.alr().clear();
        }
        this.cym.a(ayVar);
        if (ayVar != null && ayVar.alr() != null && ayVar.alr().size() > 0) {
            this.cyl = ayVar.alr().get(ayVar.alr().size() - 1);
            if (this.cym.getPage() != null) {
                this.aSJ.bJ(this.cym.getPage().pK() == 1);
            } else {
                this.aSJ.bJ(true);
            }
            if (axVar != null) {
                axVar.toNextPage();
            }
            this.aSJ.bK(true);
        } else {
            this.cyl = null;
            this.aSJ.bJ(false);
            this.aSJ.bK(false);
        }
        this.aSJ.bI(false);
        this.aSJ.bH(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xi().xx();
        this.cyh.alB().s(1, true);
        this.cyh.alw().a(this.cym);
        this.cyh.alw().d(this.aSJ);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(ReadCacheRespMsg<List<ay>> readCacheRespMsg, ReadCacheMessage<ay> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cyV, readCacheRespMsg.getData().get(0));
        }
        this.cyl = null;
        this.cyV.reset();
        this.cyW.setNeedCache(true);
        this.cyW.Dy();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0046a
    public void a(WriteCacheRespMsg<List<ay>> writeCacheRespMsg, WriteCacheMessage<ay> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ay> mvcHttpResponsedMessage, MvcHttpMessage<ax, ay> mvcHttpMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.cyh.alw().ale();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ayVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgReplyme(0);
            ayVar = null;
        }
        if (r1 == null || ayVar == null || !a(r1, ayVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.cyh.a(errorData);
                this.cyh.alw().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ay, ?> mvcSocketResponsedMessage, MvcSocketMessage<ax, ay> mvcSocketMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.cyh.alw().ale();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ayVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgReplyme(0);
            ayVar = null;
        }
        if (r1 == null || ayVar == null || !a(r1, ayVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.cyh.a(errorData);
                this.cyh.alw().a(errorData);
            }
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

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
public class au extends com.baidu.adp.base.e<bf> implements NetModel.b<ax, ay>, a.InterfaceC0047a<ay> {
    final CustomMessageListener DE;
    private com.baidu.tbadk.mvc.d.a aXc;
    private FeedData dgD;
    private ag dgE;
    private bf dgz;
    private ax dho;
    private aw dhp;
    private am dhq;

    public au(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.DE = new av(this, 2000994);
        this.dgz = bfVar;
    }

    public void d(Bundle bundle) {
        this.dho = new ax();
        this.dhp = new aw((TbPageContext) com.baidu.adp.base.l.s(this.dgz.getPageContext().getPageActivity()), this.dho);
        this.dhp.a(this);
        this.dhp.setUniqueId(getUniqueId());
        this.dhp.registerListener(this.DE);
        this.dhq = new am((TbPageContext) com.baidu.adp.base.l.s(this.dgz.getPageContext().getPageActivity()));
        this.dhq.a(this);
        this.dhq.setUniqueId(getUniqueId());
        this.dgE = new ag();
        this.aXc = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean LK() {
        if (!this.dhp.DJ() && this.aXc.DQ() && aud()) {
            this.aXc.bK(true);
            this.aXc.bM(true);
            this.dho.d(this.dgD);
            this.dhp.setNeedCache(false);
            this.dhp.DG();
            this.dgz.aux().d(this.aXc);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean co(boolean z) {
        if (this.dhp.DJ() || !aud()) {
            return false;
        }
        this.dgD = null;
        this.dho.reset();
        this.dhp.setNeedCache(true);
        this.dhp.DG();
        return true;
    }

    protected boolean aud() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dgE != null && this.dgE.dhd != null) {
            this.dgE.dhd.clear();
        }
        this.dgz.aux().auf();
        this.dgz.aux().a(this.dgE);
        return false;
    }

    public boolean kX() {
        if (aud()) {
            if (this.dgz != null && this.dgz.aux() != null) {
                this.dgz.aux().aue();
            }
            this.dhq.a((com.baidu.tbadk.mvc.b.e) this.dho);
            return true;
        }
        return true;
    }

    protected boolean a(ax axVar, ay ayVar) {
        if (axVar.getUpdateType() != 4) {
            this.dgE.aus().clear();
        }
        this.dgE.a(ayVar);
        if (ayVar != null && ayVar.aus() != null && ayVar.aus().size() > 0) {
            this.dgD = ayVar.aus().get(ayVar.aus().size() - 1);
            if (this.dgE.getPage() != null) {
                this.aXc.bL(this.dgE.getPage().pn() == 1);
            } else {
                this.aXc.bL(true);
            }
            if (axVar != null) {
                axVar.toNextPage();
            }
            this.aXc.bM(true);
        } else {
            this.dgD = null;
            this.aXc.bL(false);
            this.aXc.bM(false);
        }
        this.aXc.bK(false);
        this.aXc.bJ(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().xC();
        this.dgz.auC().H(1, true);
        this.dgz.aux().a(this.dgE);
        this.dgz.aux().d(this.aXc);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<ay>> readCacheRespMsg, ReadCacheMessage<ay> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dho, readCacheRespMsg.getData().get(0));
        }
        this.dgD = null;
        this.dho.reset();
        this.dhp.setNeedCache(true);
        this.dhp.DG();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<ay>> writeCacheRespMsg, WriteCacheMessage<ay> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ay> mvcHttpResponsedMessage, MvcHttpMessage<ax, ay> mvcHttpMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dgz.aux().auf();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ayVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgReplyme(0);
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
                this.dgz.a(errorData);
                this.dgz.aux().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ay, ?> mvcSocketResponsedMessage, MvcSocketMessage<ax, ay> mvcSocketMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dgz.aux().auf();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ayVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgReplyme(0);
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
                this.dgz.a(errorData);
                this.dgz.aux().a(errorData);
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

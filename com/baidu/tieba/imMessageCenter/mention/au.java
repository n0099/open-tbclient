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
    final CustomMessageListener FQ;
    private com.baidu.tbadk.mvc.d.a bdp;
    private bf dtC;
    private FeedData dtG;
    private ag dtH;
    private ax dur;
    private aw dus;
    private am dut;

    public au(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.FQ = new av(this, 2000994);
        this.dtC = bfVar;
    }

    public void d(Bundle bundle) {
        this.dur = new ax();
        this.dus = new aw((TbPageContext) com.baidu.adp.base.l.C(this.dtC.getPageContext().getPageActivity()), this.dur);
        this.dus.a(this);
        this.dus.setUniqueId(getUniqueId());
        this.dus.registerListener(this.FQ);
        this.dut = new am((TbPageContext) com.baidu.adp.base.l.C(this.dtC.getPageContext().getPageActivity()));
        this.dut.a(this);
        this.dut.setUniqueId(getUniqueId());
        this.dtH = new ag();
        this.bdp = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean OR() {
        if (!this.dus.wG() && this.bdp.Fj() && azp()) {
            this.bdp.bL(true);
            this.bdp.bN(true);
            this.dur.d(this.dtG);
            this.dus.setNeedCache(false);
            this.dus.Fa();
            this.dtC.azI().d(this.bdp);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cv(boolean z) {
        if (this.dus.wG() || !azp()) {
            return false;
        }
        this.dtG = null;
        this.dur.reset();
        this.dus.setNeedCache(true);
        this.dus.Fa();
        return true;
    }

    protected boolean azp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dtH != null && this.dtH.dug != null) {
            this.dtH.dug.clear();
        }
        this.dtC.azI().azr();
        this.dtC.azI().a(this.dtH);
        return false;
    }

    public boolean lS() {
        if (azp()) {
            if (this.dtC != null && this.dtC.azI() != null) {
                this.dtC.azI().azq();
            }
            this.dut.a((com.baidu.tbadk.mvc.b.e) this.dur);
            return true;
        }
        return true;
    }

    protected boolean a(ax axVar, ay ayVar) {
        if (axVar.getUpdateType() != 4) {
            this.dtH.azD().clear();
        }
        this.dtH.a(ayVar);
        if (ayVar != null && ayVar.azD() != null && ayVar.azD().size() > 0) {
            this.dtG = ayVar.azD().get(ayVar.azD().size() - 1);
            if (this.dtH.getPage() != null) {
                this.bdp.bM(this.dtH.getPage().qB() == 1);
            } else {
                this.bdp.bM(true);
            }
            if (axVar != null) {
                axVar.toNextPage();
            }
            this.bdp.bN(true);
        } else {
            this.dtG = null;
            this.bdp.bM(false);
            this.bdp.bN(false);
        }
        this.bdp.bL(false);
        this.bdp.bK(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yD().yS();
        this.dtC.azN().H(1, true);
        this.dtC.azI().a(this.dtH);
        this.dtC.azI().d(this.bdp);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<ay>> readCacheRespMsg, ReadCacheMessage<ay> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dur, readCacheRespMsg.getData().get(0));
        }
        this.dtG = null;
        this.dur.reset();
        this.dus.setNeedCache(true);
        this.dus.Fa();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<ay>> writeCacheRespMsg, WriteCacheMessage<ay> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ay> mvcHttpResponsedMessage, MvcHttpMessage<ax, ay> mvcHttpMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dtC.azI().azr();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            ayVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgReplyme(0);
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
                this.dtC.a(errorData);
                this.dtC.azI().a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ay, ?> mvcSocketResponsedMessage, MvcSocketMessage<ax, ay> mvcSocketMessage, MvcNetMessage<ax, ay> mvcNetMessage) {
        ay ayVar;
        this.dtC.azI().azr();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            ayVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgReplyme(0);
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
                this.dtC.a(errorData);
                this.dtC.azI().a(errorData);
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

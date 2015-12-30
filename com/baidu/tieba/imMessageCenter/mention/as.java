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
public class as extends com.baidu.adp.base.e<bd> implements NetModel.b<av, aw>, a.InterfaceC0054a<aw> {
    private com.baidu.tbadk.mvc.d.a aQW;
    private av ciU;
    private au ciV;
    private ak ciW;
    private bd cih;
    private FeedData cil;
    private ae cim;
    final CustomMessageListener mNetworkChangedMessageListener;

    public as(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new at(this, 2000994);
        this.cih = bdVar;
    }

    public void b(Bundle bundle) {
        this.ciU = new av();
        this.ciV = new au((TbPageContext) com.baidu.adp.base.l.C(this.cih.getPageContext().getPageActivity()), this.ciU);
        this.ciV.a(this);
        this.ciV.setUniqueId(getUniqueId());
        this.ciV.registerListener(this.mNetworkChangedMessageListener);
        this.ciW = new ak((TbPageContext) com.baidu.adp.base.l.C(this.cih.getPageContext().getPageActivity()));
        this.ciW.a(this);
        this.ciW.setUniqueId(getUniqueId());
        this.cim = new ae();
        this.aQW = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IR() {
        if (!this.ciV.isLoading() && this.aQW.DI() && aes()) {
            this.aQW.bv(true);
            this.aQW.bx(true);
            this.ciU.b(this.cil);
            this.ciV.setNeedCache(false);
            this.ciV.Dy();
            this.cih.aeL().d(this.aQW);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bP(boolean z) {
        if (this.ciV.isLoading() || !aes()) {
            return false;
        }
        this.cil = null;
        this.ciU.reset();
        this.ciV.setNeedCache(true);
        this.ciV.Dy();
        return true;
    }

    protected boolean aes() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cim != null && this.cim.ciJ != null) {
            this.cim.ciJ.clear();
        }
        this.cih.aeL().aeu();
        this.cih.aeL().a(this.cim);
        return false;
    }

    public boolean ow() {
        if (aes()) {
            if (this.cih != null && this.cih.aeL() != null) {
                this.cih.aeL().aet();
            }
            this.ciW.a((com.baidu.tbadk.mvc.b.e) this.ciU);
            return true;
        }
        return true;
    }

    protected boolean a(av avVar, aw awVar) {
        if (avVar.getUpdateType() != 4) {
            this.cim.aeH().clear();
        }
        this.cim.a(awVar);
        if (awVar != null && awVar.aeH() != null && awVar.aeH().size() > 0) {
            this.cil = awVar.aeH().get(awVar.aeH().size() - 1);
            if (this.cim.getPage() != null) {
                this.aQW.bw(this.cim.getPage().rO() == 1);
            } else {
                this.aQW.bw(true);
            }
            if (avVar != null) {
                avVar.toNextPage();
            }
            this.aQW.bx(true);
        } else {
            this.cil = null;
            this.aQW.bw(false);
            this.aQW.bx(false);
        }
        this.aQW.bv(false);
        this.aQW.bu(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xv().xK();
        this.cih.aeQ().o(1, true);
        this.cih.aeL().a(this.cim);
        this.cih.aeL().d(this.aQW);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<aw>> readCacheRespMsg, ReadCacheMessage<aw> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.ciU, readCacheRespMsg.getData().get(0));
        }
        this.cil = null;
        this.ciU.reset();
        this.ciV.setNeedCache(true);
        this.ciV.Dy();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<aw>> writeCacheRespMsg, WriteCacheMessage<aw> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<aw> mvcHttpResponsedMessage, MvcHttpMessage<av, aw> mvcHttpMessage, MvcNetMessage<av, aw> mvcNetMessage) {
        aw awVar;
        this.cih.aeL().aeu();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            awVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgReplyme(0);
            awVar = null;
        }
        if (r1 == null || awVar == null || !a(r1, awVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.cih.a(errorData);
            this.cih.aeL().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<aw, ?> mvcSocketResponsedMessage, MvcSocketMessage<av, aw> mvcSocketMessage, MvcNetMessage<av, aw> mvcNetMessage) {
        aw awVar;
        this.cih.aeL().aeu();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            awVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgReplyme(0);
            awVar = null;
        }
        if (r1 == null || awVar == null || !a(r1, awVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.cih.a(errorData);
            this.cih.aeL().a(errorData);
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

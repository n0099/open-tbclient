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
public class as extends com.baidu.adp.base.e<bd> implements NetModel.b<av, aw>, a.InterfaceC0055a<aw> {
    final CustomMessageListener MF;
    private com.baidu.tbadk.mvc.d.a aTd;
    private bd cmH;
    private FeedData cmL;
    private ae cmM;
    private av cnu;
    private au cnv;
    private ak cnw;

    public as(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.MF = new at(this, 2000994);
        this.cmH = bdVar;
    }

    public void c(Bundle bundle) {
        this.cnu = new av();
        this.cnv = new au((TbPageContext) com.baidu.adp.base.l.C(this.cmH.getPageContext().getPageActivity()), this.cnu);
        this.cnv.a(this);
        this.cnv.setUniqueId(getUniqueId());
        this.cnv.registerListener(this.MF);
        this.cnw = new ak((TbPageContext) com.baidu.adp.base.l.C(this.cmH.getPageContext().getPageActivity()));
        this.cnw.a(this);
        this.cnw.setUniqueId(getUniqueId());
        this.cmM = new ae();
        this.aTd = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KJ() {
        if (!this.cnv.isLoading() && this.aTd.Fc() && ahC()) {
            this.aTd.bx(true);
            this.aTd.bz(true);
            this.cnu.b(this.cmL);
            this.cnv.setNeedCache(false);
            this.cnv.ET();
            this.cmH.ahU().d(this.aTd);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bU(boolean z) {
        if (this.cnv.isLoading() || !ahC()) {
            return false;
        }
        this.cmL = null;
        this.cnu.reset();
        this.cnv.setNeedCache(true);
        this.cnv.ET();
        return true;
    }

    protected boolean ahC() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cmM != null && this.cmM.cnj != null) {
            this.cmM.cnj.clear();
        }
        this.cmH.ahU().ahE();
        this.cmH.ahU().a(this.cmM);
        return false;
    }

    public boolean oR() {
        if (ahC()) {
            if (this.cmH != null && this.cmH.ahU() != null) {
                this.cmH.ahU().ahD();
            }
            this.cnw.a((com.baidu.tbadk.mvc.b.e) this.cnu);
            return true;
        }
        return true;
    }

    protected boolean a(av avVar, aw awVar) {
        if (avVar.getUpdateType() != 4) {
            this.cmM.ahQ().clear();
        }
        this.cmM.a(awVar);
        if (awVar != null && awVar.ahQ() != null && awVar.ahQ().size() > 0) {
            this.cmL = awVar.ahQ().get(awVar.ahQ().size() - 1);
            if (this.cmM.getPage() != null) {
                this.aTd.by(this.cmM.getPage().sv() == 1);
            } else {
                this.aTd.by(true);
            }
            if (avVar != null) {
                avVar.toNextPage();
            }
            this.aTd.bz(true);
        } else {
            this.cmL = null;
            this.aTd.by(false);
            this.aTd.bz(false);
        }
        this.aTd.bx(false);
        this.aTd.bw(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zc();
        this.cmH.ahZ().p(1, true);
        this.cmH.ahU().a(this.cmM);
        this.cmH.ahU().d(this.aTd);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(ReadCacheRespMsg<List<aw>> readCacheRespMsg, ReadCacheMessage<aw> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.cnu, readCacheRespMsg.getData().get(0));
        }
        this.cmL = null;
        this.cnu.reset();
        this.cnv.setNeedCache(true);
        this.cnv.ET();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<aw>> writeCacheRespMsg, WriteCacheMessage<aw> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<aw> mvcHttpResponsedMessage, MvcHttpMessage<av, aw> mvcHttpMessage, MvcNetMessage<av, aw> mvcNetMessage) {
        aw awVar;
        this.cmH.ahU().ahE();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            awVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(0);
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
            this.cmH.a(errorData);
            this.cmH.ahU().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<aw, ?> mvcSocketResponsedMessage, MvcSocketMessage<av, aw> mvcSocketMessage, MvcNetMessage<av, aw> mvcNetMessage) {
        aw awVar;
        this.cmH.ahU().ahE();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            awVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(0);
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
            this.cmH.a(errorData);
            this.cmH.ahU().a(errorData);
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

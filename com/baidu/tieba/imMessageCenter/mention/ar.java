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
public class ar extends com.baidu.adp.base.e<bc> implements NetModel.b<au, av>, a.InterfaceC0054a<av> {
    private com.baidu.tbadk.mvc.d.a aNd;
    private au ceQ;
    private at ceR;
    private aj ceS;
    private bc ceg;
    private FeedData cek;
    private ad cel;
    final CustomMessageListener mNetworkChangedMessageListener;

    public ar(bc bcVar) {
        super(com.baidu.adp.base.l.C(bcVar.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new as(this, 2000994);
        this.ceg = bcVar;
    }

    public void f(Bundle bundle) {
        this.ceQ = new au();
        this.ceR = new at((TbPageContext) com.baidu.adp.base.l.C(this.ceg.getPageContext().getPageActivity()), this.ceQ);
        this.ceR.a(this);
        this.ceR.setUniqueId(getUniqueId());
        this.ceR.registerListener(this.mNetworkChangedMessageListener);
        this.ceS = new aj((TbPageContext) com.baidu.adp.base.l.C(this.ceg.getPageContext().getPageActivity()));
        this.ceS.a(this);
        this.ceS.setUniqueId(getUniqueId());
        this.cel = new ad();
        this.aNd = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Iz() {
        if (!this.ceR.isLoading() && this.aNd.DT() && adj()) {
            this.aNd.bv(true);
            this.aNd.bx(true);
            this.ceQ.b(this.cek);
            this.ceR.setNeedCache(false);
            this.ceR.DJ();
            this.ceg.adD().d(this.aNd);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bO(boolean z) {
        if (this.ceR.isLoading() || !adj()) {
            return false;
        }
        this.cek = null;
        this.ceQ.reset();
        this.ceR.setNeedCache(true);
        this.ceR.DJ();
        return true;
    }

    protected boolean adj() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.cel != null && this.cel.ceH != null) {
            this.cel.ceH.clear();
        }
        this.ceg.adD().adl();
        this.ceg.adD().a(this.cel);
        return false;
    }

    public boolean oY() {
        if (adj()) {
            if (this.ceg != null && this.ceg.adD() != null) {
                this.ceg.adD().adk();
            }
            this.ceS.a((com.baidu.tbadk.mvc.b.e) this.ceQ);
            return true;
        }
        return true;
    }

    protected boolean a(au auVar, av avVar) {
        if (auVar.getUpdateType() != 4) {
            this.cel.adz().clear();
        }
        this.cel.a(avVar);
        if (avVar != null && avVar.adz() != null && avVar.adz().size() > 0) {
            this.cek = avVar.adz().get(avVar.adz().size() - 1);
            if (this.cel.getPage() != null) {
                this.aNd.bw(this.cel.getPage().sf() == 1);
            } else {
                this.aNd.bw(true);
            }
            if (auVar != null) {
                auVar.toNextPage();
            }
            this.aNd.bx(true);
        } else {
            this.cek = null;
            this.aNd.bw(false);
            this.aNd.bx(false);
        }
        this.aNd.bv(false);
        this.aNd.bu(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xY();
        this.ceg.adI().n(1, true);
        this.ceg.adD().a(this.cel);
        this.ceg.adD().d(this.aNd);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<av>> readCacheRespMsg, ReadCacheMessage<av> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.ceQ, readCacheRespMsg.getData().get(0));
        }
        this.cek = null;
        this.ceQ.reset();
        this.ceR.setNeedCache(true);
        this.ceR.DJ();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<av>> writeCacheRespMsg, WriteCacheMessage<av> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<av> mvcHttpResponsedMessage, MvcHttpMessage<au, av> mvcHttpMessage, MvcNetMessage<au, av> mvcNetMessage) {
        av avVar;
        this.ceg.adD().adl();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            avVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgReplyme(0);
            avVar = null;
        }
        if (r1 == null || avVar == null || !a(r1, avVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.ceg.a(errorData);
            this.ceg.adD().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<av, ?> mvcSocketResponsedMessage, MvcSocketMessage<au, av> mvcSocketMessage, MvcNetMessage<au, av> mvcNetMessage) {
        av avVar;
        this.ceg.adD().adl();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            avVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgReplyme(0);
            avVar = null;
        }
        if (r1 == null || avVar == null || !a(r1, avVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.ceg.a(errorData);
            this.ceg.adD().a(errorData);
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

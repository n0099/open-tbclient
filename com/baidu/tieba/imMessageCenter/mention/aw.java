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
public class aw extends com.baidu.adp.base.e<ReplyMessageActivity> implements NetModel.b<az, ba>, a.InterfaceC0047a<ba> {
    final CustomMessageListener FT;
    private com.baidu.tbadk.mvc.d.a bfE;
    private ReplyMessageActivity dcY;
    private az dcZ;
    private FeedData dcf;
    private af dcg;
    private ay dda;
    private ao ddb;

    public aw(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.l.C(replyMessageActivity.getPageContext().getPageActivity()));
        this.FT = new ax(this, 2000994);
        this.dcY = replyMessageActivity;
    }

    public void d(Bundle bundle) {
        this.dcZ = new az();
        this.dda = new ay((TbPageContext) com.baidu.adp.base.l.C(this.dcY.getPageContext().getPageActivity()), this.dcZ);
        this.dda.a(this);
        this.dda.setUniqueId(getUniqueId());
        this.dda.registerListener(this.FT);
        this.ddb = new ao((TbPageContext) com.baidu.adp.base.l.C(this.dcY.getPageContext().getPageActivity()));
        this.ddb.a(this);
        this.ddb.setUniqueId(getUniqueId());
        this.dcg = new af();
        this.bfE = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Pt() {
        if (!this.dda.wv() && this.bfE.EW() && auJ()) {
            this.bfE.bP(true);
            this.bfE.bR(true);
            this.dcZ.f(this.dcf);
            this.dda.setNeedCache(false);
            this.dda.EN();
            this.dcY.d(this.bfE);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cC(boolean z) {
        if (this.dda.wv() || !auJ()) {
            return false;
        }
        this.dcf = null;
        this.dcZ.reset();
        this.dda.setNeedCache(true);
        this.dda.EN();
        return true;
    }

    protected boolean auJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.dcg != null && this.dcg.dcM != null) {
            this.dcg.dcM.clear();
        }
        this.dcY.auK();
        this.dcY.a(this.dcg);
        return false;
    }

    public boolean lV() {
        if (auJ()) {
            if (this.dcY != null) {
                this.dcY.auL();
            }
            this.ddb.a((com.baidu.tbadk.mvc.b.e) this.dcZ);
            return true;
        }
        return true;
    }

    protected boolean a(az azVar, ba baVar) {
        if (azVar.getUpdateType() != 4) {
            this.dcg.auS().clear();
        }
        this.dcg.a(baVar);
        if (baVar != null && baVar.auS() != null && baVar.auS().size() > 0) {
            this.dcf = baVar.auS().get(baVar.auS().size() - 1);
            if (this.dcg.getPage() != null) {
                this.bfE.bQ(this.dcg.getPage().qE() == 1);
            } else {
                this.bfE.bQ(true);
            }
            if (azVar != null) {
                azVar.toNextPage();
            }
            this.bfE.bR(true);
        } else {
            this.dcf = null;
            this.bfE.bQ(false);
            this.bfE.bR(false);
        }
        this.bfE.bP(false);
        this.bfE.bO(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.yy().yN();
        this.dcY.a(this.dcg);
        this.dcY.d(this.bfE);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(ReadCacheRespMsg<List<ba>> readCacheRespMsg, ReadCacheMessage<ba> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.dcZ, readCacheRespMsg.getData().get(0));
        }
        this.dcf = null;
        this.dcZ.reset();
        this.dda.setNeedCache(true);
        this.dda.EN();
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0047a
    public void a(WriteCacheRespMsg<List<ba>> writeCacheRespMsg, WriteCacheMessage<ba> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<ba> mvcHttpResponsedMessage, MvcHttpMessage<az, ba> mvcHttpMessage, MvcNetMessage<az, ba> mvcNetMessage) {
        ba baVar;
        this.dcY.auK();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            baVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgReplyme(0);
            baVar = null;
        }
        if (r1 == null || baVar == null || !a(r1, baVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dcY.a(errorData);
                this.dcY.a(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<ba, ?> mvcSocketResponsedMessage, MvcSocketMessage<az, ba> mvcSocketMessage, MvcNetMessage<az, ba> mvcNetMessage) {
        ba baVar;
        this.dcY.auK();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            baVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgReplyme(0);
            baVar = null;
        }
        if (r1 == null || baVar == null || !a(r1, baVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.dcY.a(errorData);
                this.dcY.a(errorData);
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

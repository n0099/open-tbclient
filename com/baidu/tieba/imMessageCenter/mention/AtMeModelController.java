package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
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
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.mvc.model.NetModel;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a epR;
    private AtMessageActivity gxc;
    private b gxd;
    private AtMeNetModel gxe;
    private AtMeCacheModel gxf;
    private FeedData gxg;
    private f gxh;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gxc.bxq();
                }
            }
        };
        this.gxc = atMessageActivity;
    }

    public void J(Bundle bundle) {
        this.gxd = new b();
        this.gxe = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxc.getPageContext().getPageActivity()), this.gxd);
        this.gxe.a(this);
        if (this.gxc != null) {
            this.gxe.setUniqueId(this.gxc.getUniqueId());
        }
        this.gxe.registerListener(this.mNetworkChangedMessageListener);
        this.gxf = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxc.getPageContext().getPageActivity()));
        this.gxf.a(this);
        if (this.gxc != null) {
            this.gxf.setUniqueId(this.gxc.getUniqueId());
        }
        this.gxh = new f();
        this.epR = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aRP() {
        if (!this.gxe.qz() && this.epR.aoz() && bxp()) {
            this.epR.eY(true);
            this.epR.fa(true);
            this.gxd.d(this.gxg);
            this.gxe.setNeedCache(false);
            this.gxe.aor();
            this.gxc.b(this.epR);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bhl() {
        if (this.gxe.qz() || !bxp()) {
            return false;
        }
        this.gxg = null;
        this.gxd.reset();
        this.gxe.setNeedCache(true);
        this.gxe.aor();
        return true;
    }

    protected boolean bxp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gxh != null && this.gxh.gyc != null) {
            this.gxh.gyc.clear();
        }
        this.gxc.bxq();
        this.gxc.a(this.gxh);
        return false;
    }

    public boolean aRO() {
        if (bxp()) {
            if (this.gxc != null) {
                this.gxc.bxr();
            }
            this.gxf.a((com.baidu.tbadk.mvc.b.e) this.gxd);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gxh.bxJ().clear();
        }
        this.gxh.a(cVar);
        if (cVar != null && cVar.bxJ() != null && cVar.bxJ().size() > 0) {
            this.gxg = cVar.bxJ().get(cVar.bxJ().size() - 1);
            if (this.gxh.getPage() != null) {
                this.epR.eZ(this.gxh.getPage().XH() == 1);
            } else {
                this.epR.eZ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.epR.fa(true);
        } else {
            this.gxg = null;
            this.epR.eZ(false);
            this.epR.fa(false);
        }
        this.epR.eY(false);
        this.epR.eX(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahM();
        if (!TbadkCoreApplication.isLogin()) {
            this.gxh.bxJ().clear();
        } else {
            this.gxc.b(this.epR);
        }
        this.gxc.a(this.gxh);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gxd, readCacheRespMsg.getData().get(0));
        }
        this.gxg = null;
        this.gxd.reset();
        this.gxe.setNeedCache(true);
        this.gxe.aor();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxc.bxq();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgAtme(0);
            cVar = null;
        }
        if (r1 == null || cVar == null || !a(r1, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.gxc.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxc.bxq();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgAtme(0);
            cVar = null;
        }
        if (r1 == null || cVar == null || !a(r1, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.gxc.a(errorData);
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
}

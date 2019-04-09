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
    private com.baidu.tbadk.mvc.d.a epS;
    private AtMessageActivity gxd;
    private b gxe;
    private AtMeNetModel gxf;
    private AtMeCacheModel gxg;
    private FeedData gxh;
    private f gxi;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.aK(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.gxd.bxq();
                }
            }
        };
        this.gxd = atMessageActivity;
    }

    public void J(Bundle bundle) {
        this.gxe = new b();
        this.gxf = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxd.getPageContext().getPageActivity()), this.gxe);
        this.gxf.a(this);
        if (this.gxd != null) {
            this.gxf.setUniqueId(this.gxd.getUniqueId());
        }
        this.gxf.registerListener(this.mNetworkChangedMessageListener);
        this.gxg = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.aK(this.gxd.getPageContext().getPageActivity()));
        this.gxg.a(this);
        if (this.gxd != null) {
            this.gxg.setUniqueId(this.gxd.getUniqueId());
        }
        this.gxi = new f();
        this.epS = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aRP() {
        if (!this.gxf.qz() && this.epS.aoz() && bxp()) {
            this.epS.eY(true);
            this.epS.fa(true);
            this.gxe.d(this.gxh);
            this.gxf.setNeedCache(false);
            this.gxf.aor();
            this.gxd.b(this.epS);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bhl() {
        if (this.gxf.qz() || !bxp()) {
            return false;
        }
        this.gxh = null;
        this.gxe.reset();
        this.gxf.setNeedCache(true);
        this.gxf.aor();
        return true;
    }

    protected boolean bxp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.gxi != null && this.gxi.gyd != null) {
            this.gxi.gyd.clear();
        }
        this.gxd.bxq();
        this.gxd.a(this.gxi);
        return false;
    }

    public boolean aRO() {
        if (bxp()) {
            if (this.gxd != null) {
                this.gxd.bxr();
            }
            this.gxg.a((com.baidu.tbadk.mvc.b.e) this.gxe);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.gxi.bxJ().clear();
        }
        this.gxi.a(cVar);
        if (cVar != null && cVar.bxJ() != null && cVar.bxJ().size() > 0) {
            this.gxh = cVar.bxJ().get(cVar.bxJ().size() - 1);
            if (this.gxi.getPage() != null) {
                this.epS.eZ(this.gxi.getPage().XH() == 1);
            } else {
                this.epS.eZ(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.epS.fa(true);
        } else {
            this.gxh = null;
            this.epS.eZ(false);
            this.epS.fa(false);
        }
        this.epS.eY(false);
        this.epS.eX(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahM();
        if (!TbadkCoreApplication.isLogin()) {
            this.gxi.bxJ().clear();
        } else {
            this.gxd.b(this.epS);
        }
        this.gxd.a(this.gxi);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.gxe, readCacheRespMsg.getData().get(0));
        }
        this.gxh = null;
        this.gxe.reset();
        this.gxf.setNeedCache(true);
        this.gxf.aor();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxd.bxq();
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
            this.gxd.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.gxd.bxq();
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
            this.gxd.a(errorData);
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

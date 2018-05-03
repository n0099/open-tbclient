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
/* loaded from: classes2.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.a<c>, NetModel.b<b, c> {
    private com.baidu.tbadk.mvc.d.a cwy;
    private AtMessageActivity emu;
    private b emv;
    private AtMeNetModel emw;
    private AtMeCacheModel emx;
    private FeedData emy;
    private f emz;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.i.ab(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.emu.aIo();
                }
            }
        };
        this.emu = atMessageActivity;
    }

    public void i(Bundle bundle) {
        this.emv = new b();
        this.emw = new AtMeNetModel((TbPageContext) com.baidu.adp.base.i.ab(this.emu.getPageContext().getPageActivity()), this.emv);
        this.emw.a(this);
        if (this.emu != null) {
            this.emw.setUniqueId(this.emu.getUniqueId());
        }
        this.emw.registerListener(this.mNetworkChangedMessageListener);
        this.emx = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.i.ab(this.emu.getPageContext().getPageActivity()));
        this.emx.a(this);
        if (this.emu != null) {
            this.emx.setUniqueId(this.emu.getUniqueId());
        }
        this.emz = new f();
        this.cwy = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agL() {
        if (!this.emw.wX() && this.cwy.Gg() && aIn()) {
            this.cwy.bM(true);
            this.cwy.bO(true);
            this.emv.d(this.emy);
            this.emw.setNeedCache(false);
            this.emw.FY();
            this.emu.b(this.cwy);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arj() {
        if (this.emw.wX() || !aIn()) {
            return false;
        }
        this.emy = null;
        this.emv.reset();
        this.emw.setNeedCache(true);
        this.emw.FY();
        return true;
    }

    protected boolean aIn() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.emz != null && this.emz.enw != null) {
            this.emz.enw.clear();
        }
        this.emu.aIo();
        this.emu.a(this.emz);
        return false;
    }

    public boolean agK() {
        if (aIn()) {
            if (this.emu != null) {
                this.emu.aIp();
            }
            this.emx.a((com.baidu.tbadk.mvc.b.e) this.emv);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        if (bVar.getUpdateType() != 4) {
            this.emz.aIH().clear();
        }
        this.emz.a(cVar);
        if (cVar != null && cVar.aIH() != null && cVar.aIH().size() > 0) {
            this.emy = cVar.aIH().get(cVar.aIH().size() - 1);
            if (this.emz.rg() != null) {
                this.cwy.bN(this.emz.rg().rc() == 1);
            } else {
                this.cwy.bN(true);
            }
            if (bVar != null) {
                bVar.toNextPage();
            }
            this.cwy.bO(true);
        } else {
            this.emy = null;
            this.cwy.bN(false);
            this.cwy.bO(false);
        }
        this.cwy.bM(false);
        this.cwy.bL(false);
        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zM();
        if (!TbadkCoreApplication.isLogin()) {
            this.emz.aIH().clear();
        } else {
            this.emu.b(this.cwy);
        }
        this.emu.a(this.emz);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.emv, readCacheRespMsg.getData().get(0));
        }
        this.emy = null;
        this.emv.reset();
        this.emw.setNeedCache(true);
        this.emw.FY();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void a(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.emu.aIo();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
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
            this.emu.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.emu.aIo();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
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
            this.emu.a(errorData);
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

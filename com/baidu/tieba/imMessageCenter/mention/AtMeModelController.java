package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
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
    private com.baidu.tbadk.mvc.d.a iCn;
    private AtMessageActivity kQH;
    private b kQI;
    private AtMeNetModel kQJ;
    private AtMeCacheModel kQK;
    private FeedData kQL;
    private f kQM;
    final CustomMessageListener mNetworkChangedMessageListener;

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(com.baidu.adp.base.j.K(atMessageActivity.getPageContext().getPageActivity()));
        this.mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMeModelController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    AtMeModelController.this.kQH.cZi();
                }
            }
        };
        this.kQH = atMessageActivity;
    }

    public void aj(Bundle bundle) {
        this.kQI = new b();
        this.kQJ = new AtMeNetModel((TbPageContext) com.baidu.adp.base.j.K(this.kQH.getPageContext().getPageActivity()), this.kQI);
        this.kQJ.a(this);
        if (this.kQH != null) {
            this.kQJ.setUniqueId(this.kQH.getUniqueId());
        }
        this.kQJ.registerListener(this.mNetworkChangedMessageListener);
        this.kQK = new AtMeCacheModel((TbPageContext) com.baidu.adp.base.j.K(this.kQH.getPageContext().getPageActivity()));
        this.kQK.a(this);
        if (this.kQH != null) {
            this.kQK.setUniqueId(this.kQH.getUniqueId());
        }
        this.kQM = new f();
        this.iCn = new com.baidu.tbadk.mvc.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ctm() {
        if (!this.kQJ.isLoading() && this.iCn.bDC() && cZh()) {
            this.iCn.li(true);
            this.iCn.lk(true);
            this.kQI.e(this.kQL);
            this.kQJ.setNeedCache(false);
            this.kQJ.loadData();
            this.kQH.c(this.iCn);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cJh() {
        if (this.kQJ.isLoading() || !cZh()) {
            return false;
        }
        this.kQL = null;
        this.kQI.reset();
        this.kQJ.setNeedCache(true);
        this.kQJ.loadData();
        return true;
    }

    protected boolean cZh() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        if (this.kQM != null && this.kQM.kSi != null) {
            this.kQM.kSi.clear();
        }
        this.kQH.cZi();
        this.kQH.a(this.kQM);
        return false;
    }

    public boolean ctl() {
        if (cZh()) {
            if (this.kQH != null) {
                this.kQH.cZj();
            }
            this.kQK.a((com.baidu.tbadk.mvc.b.e) this.kQI);
            return true;
        }
        return true;
    }

    protected boolean a(b bVar, c cVar) {
        this.kQH.WZ();
        if (bVar.getUpdateType() != 4) {
            this.kQM.cZz().clear();
        }
        this.kQM.a(cVar);
        if (cVar != null && cVar.cZz() != null && cVar.cZz().size() > 0) {
            this.kQL = cVar.cZz().get(cVar.cZz().size() - 1);
            if (this.kQM.getPage() != null) {
                this.iCn.lj(this.kQM.getPage().bmF() == 1);
            } else {
                this.iCn.lj(true);
            }
            if (bVar != null) {
                bVar.cZC();
            }
            this.iCn.lk(true);
        } else {
            this.kQL = null;
            this.iCn.lj(false);
            this.iCn.lk(false);
        }
        this.iCn.li(false);
        this.iCn.lh(false);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxP();
        if (!TbadkCoreApplication.isLogin()) {
            this.kQM.cZz().clear();
        } else {
            this.kQH.c(this.iCn);
        }
        this.kQH.a(this.kQM);
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.kQI, readCacheRespMsg.getData().get(0));
        }
        this.kQL = null;
        this.kQI.reset();
        this.kQJ.setNeedCache(true);
        this.kQJ.loadData();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.a
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kQH.cZi();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kQH.a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        b bVar;
        this.kQH.cZi();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            bVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        } else {
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgAtme(0);
            cVar = null;
            bVar = null;
        }
        if (bVar == null || cVar == null || !a(bVar, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.kQH.a(errorData);
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

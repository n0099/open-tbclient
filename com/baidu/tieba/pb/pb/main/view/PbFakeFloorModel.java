package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class PbFakeFloorModel extends DataModel {
    private j hAo;
    private boolean hAp;
    private SubPbRequestMessage hAq;
    private a hAr;
    private com.baidu.adp.framework.listener.a hAs;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hAr = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hAo = null;
        this.hAp = false;
        this.hAr = null;
        this.hAs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hAp = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.j.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    j jVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        jVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (jVar != null && jVar.bIE() != null) {
                        PostData postData = (PostData) v.c(jVar.bIE(), jVar.bIE().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hAo != null && PbFakeFloorModel.this.hAo.bIA() != null) {
                            if (PbFakeFloorModel.this.hAo.WO() != null && PbFakeFloorModel.this.hAo.WO().YO() != null && postData.YO() != null && (userId = PbFakeFloorModel.this.hAo.WO().YO().getUserId()) != null && userId.equals(postData.YO().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hAr != null) {
                            PbFakeFloorModel.this.hAr.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hAs);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hAs);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oO(String str) {
        if (this.hAo == null || this.hAo.bIG() == null || this.hAo.WO() == null || this.hAo.bIA() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aag = this.hAo.WO().aag();
        if (aag) {
            writeData.setVForumId(this.hAo.bIG().getId());
            writeData.setVForumName(this.hAo.bIG().getName());
        } else {
            writeData.setForumName(this.hAo.bIG().getName());
            writeData.setForumId(this.hAo.bIG().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hAo.bIA().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aag);
        writeData.setThreadId(this.hAo.WO().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.hAo = jVar;
    }

    public void bNN() {
        if (!this.hAp) {
            cancelMessage();
            this.hAq = bNO();
            if (this.hAq != null) {
                sendMessage(this.hAq);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hAo.bIA().r(postData);
            this.hAo.bIA().s(postData);
            this.hAo.bIA().pW(true);
        }
    }

    private SubPbRequestMessage bNO() {
        if (this.hAo == null || this.hAo.WO() == null || this.hAo.WO().getId() == null || this.hAo.bIA() == null || this.hAo.bIA().getId() == null) {
            this.hAp = false;
            return null;
        }
        this.hAp = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.hAo.bIA().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.hAo.WO().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amk() {
        bNN();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aml() {
        return this.mPostId;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}

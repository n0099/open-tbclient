package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class PbFakeFloorModel extends DataModel {
    private l iTQ;
    private boolean iTR;
    private SubPbRequestMessage iTS;
    private a iTT;
    private com.baidu.adp.framework.listener.a iTU;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void p(PostData postData);
    }

    public void a(a aVar) {
        this.iTT = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iTQ = null;
        this.iTR = false;
        this.iTT = null;
        this.iTU = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iTR = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    l lVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        lVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (lVar != null && lVar.clk() != null) {
                        PostData postData = (PostData) v.getItem(lVar.clk(), lVar.clk().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iTQ != null && PbFakeFloorModel.this.iTQ.clg() != null) {
                            if (PbFakeFloorModel.this.iTQ.aAg() != null && PbFakeFloorModel.this.iTQ.aAg().aCo() != null && postData.aCo() != null && (userId = PbFakeFloorModel.this.iTQ.aAg().aCo().getUserId()) != null && userId.equals(postData.aCo().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iTT != null) {
                            PbFakeFloorModel.this.iTT.p(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iTU);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iTU);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vj(String str) {
        if (this.iTQ == null || this.iTQ.aPn() == null || this.iTQ.aAg() == null || this.iTQ.clg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aDG = this.iTQ.aAg().aDG();
        if (aDG) {
            writeData.setVForumId(this.iTQ.aPn().getId());
            writeData.setVForumName(this.iTQ.aPn().getName());
        } else {
            writeData.setForumName(this.iTQ.aPn().getName());
            writeData.setForumId(this.iTQ.aPn().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iTQ.clg().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aDG);
        writeData.setThreadId(this.iTQ.aAg().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.iTQ = lVar;
    }

    public void cqX() {
        if (!this.iTR) {
            cancelMessage();
            this.iTS = cqY();
            if (this.iTS != null) {
                sendMessage(this.iTS);
            }
        }
    }

    public void q(PostData postData) {
        if (postData != null) {
            this.iTQ.clg().t(postData);
            this.iTQ.clg().u(postData);
            this.iTQ.clg().sM(true);
        }
    }

    private SubPbRequestMessage cqY() {
        if (this.iTQ == null || this.iTQ.aAg() == null || this.iTQ.aAg().getId() == null || this.iTQ.clg() == null || this.iTQ.clg().getId() == null) {
            this.iTR = false;
            return null;
        }
        this.iTR = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.iTQ.clg().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.iTQ.aAg().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOO() {
        cqX();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOP() {
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

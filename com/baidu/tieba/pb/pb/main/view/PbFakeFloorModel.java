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
    private l jFB;
    private boolean jFC;
    private SubPbRequestMessage jFD;
    private a jFE;
    private com.baidu.adp.framework.listener.a jFF;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void p(PostData postData);
    }

    public void a(a aVar) {
        this.jFE = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jFB = null;
        this.jFC = false;
        this.jFE = null;
        this.jFF = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.jFC = false;
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
                    if (lVar != null && lVar.cwl() != null) {
                        PostData postData = (PostData) v.getItem(lVar.cwl(), lVar.cwl().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.jFB != null && PbFakeFloorModel.this.jFB.cwh() != null) {
                            if (PbFakeFloorModel.this.jFB.aIw() != null && PbFakeFloorModel.this.jFB.aIw().aKE() != null && postData.aKE() != null && (userId = PbFakeFloorModel.this.jFB.aIw().aKE().getUserId()) != null && userId.equals(postData.aKE().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.jFE != null) {
                            PbFakeFloorModel.this.jFE.p(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.jFF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.jFF);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ww(String str) {
        if (this.jFB == null || this.jFB.aXI() == null || this.jFB.aIw() == null || this.jFB.cwh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aLY = this.jFB.aIw().aLY();
        if (aLY) {
            writeData.setVForumId(this.jFB.aXI().getId());
            writeData.setVForumName(this.jFB.aXI().getName());
        } else {
            writeData.setForumName(this.jFB.aXI().getName());
            writeData.setForumId(this.jFB.aXI().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.jFB.cwh().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aLY);
        writeData.setThreadId(this.jFB.aIw().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.jFB = lVar;
    }

    public void cBY() {
        if (!this.jFC) {
            cancelMessage();
            this.jFD = cBZ();
            if (this.jFD != null) {
                sendMessage(this.jFD);
            }
        }
    }

    public void q(PostData postData) {
        if (postData != null) {
            this.jFB.cwh().t(postData);
            this.jFB.cwh().u(postData);
            this.jFB.cwh().tU(true);
        }
    }

    private SubPbRequestMessage cBZ() {
        if (this.jFB == null || this.jFB.aIw() == null || this.jFB.aIw().getId() == null || this.jFB.cwh() == null || this.jFB.cwh().getId() == null) {
            this.jFC = false;
            return null;
        }
        this.jFC = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.jFB.cwh().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jFB.aIw().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aXj() {
        cBY();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aXk() {
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

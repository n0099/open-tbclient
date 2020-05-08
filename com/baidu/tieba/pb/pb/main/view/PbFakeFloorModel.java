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
    private l jFF;
    private boolean jFG;
    private SubPbRequestMessage jFH;
    private a jFI;
    private com.baidu.adp.framework.listener.a jFJ;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void p(PostData postData);
    }

    public void a(a aVar) {
        this.jFI = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jFF = null;
        this.jFG = false;
        this.jFI = null;
        this.jFJ = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.jFG = false;
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
                    if (lVar != null && lVar.cwi() != null) {
                        PostData postData = (PostData) v.getItem(lVar.cwi(), lVar.cwi().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.jFF != null && PbFakeFloorModel.this.jFF.cwe() != null) {
                            if (PbFakeFloorModel.this.jFF.aIu() != null && PbFakeFloorModel.this.jFF.aIu().aKC() != null && postData.aKC() != null && (userId = PbFakeFloorModel.this.jFF.aIu().aKC().getUserId()) != null && userId.equals(postData.aKC().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.jFI != null) {
                            PbFakeFloorModel.this.jFI.p(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.jFJ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.jFJ);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData wz(String str) {
        if (this.jFF == null || this.jFF.aXG() == null || this.jFF.aIu() == null || this.jFF.cwe() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aLW = this.jFF.aIu().aLW();
        if (aLW) {
            writeData.setVForumId(this.jFF.aXG().getId());
            writeData.setVForumName(this.jFF.aXG().getName());
        } else {
            writeData.setForumName(this.jFF.aXG().getName());
            writeData.setForumId(this.jFF.aXG().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.jFF.cwe().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aLW);
        writeData.setThreadId(this.jFF.aIu().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.jFF = lVar;
    }

    public void cBV() {
        if (!this.jFG) {
            cancelMessage();
            this.jFH = cBW();
            if (this.jFH != null) {
                sendMessage(this.jFH);
            }
        }
    }

    public void q(PostData postData) {
        if (postData != null) {
            this.jFF.cwe().t(postData);
            this.jFF.cwe().u(postData);
            this.jFF.cwe().tU(true);
        }
    }

    private SubPbRequestMessage cBW() {
        if (this.jFF == null || this.jFF.aIu() == null || this.jFF.aIu().getId() == null || this.jFF.cwe() == null || this.jFF.cwe().getId() == null) {
            this.jFG = false;
            return null;
        }
        this.jFG = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.jFF.cwe().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jFF.aIu().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aXh() {
        cBV();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aXi() {
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

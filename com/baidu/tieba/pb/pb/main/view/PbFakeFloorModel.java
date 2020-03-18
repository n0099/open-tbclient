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
    private l iVr;
    private boolean iVs;
    private SubPbRequestMessage iVt;
    private a iVu;
    private com.baidu.adp.framework.listener.a iVv;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void p(PostData postData);
    }

    public void a(a aVar) {
        this.iVu = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iVr = null;
        this.iVs = false;
        this.iVu = null;
        this.iVv = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iVs = false;
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
                    if (lVar != null && lVar.clF() != null) {
                        PostData postData = (PostData) v.getItem(lVar.clF(), lVar.clF().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iVr != null && PbFakeFloorModel.this.iVr.clB() != null) {
                            if (PbFakeFloorModel.this.iVr.aAj() != null && PbFakeFloorModel.this.iVr.aAj().aCr() != null && postData.aCr() != null && (userId = PbFakeFloorModel.this.iVr.aAj().aCr().getUserId()) != null && userId.equals(postData.aCr().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iVu != null) {
                            PbFakeFloorModel.this.iVu.p(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iVv);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iVv);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iVr == null || this.iVr.aPr() == null || this.iVr.aAj() == null || this.iVr.clB() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aDK = this.iVr.aAj().aDK();
        if (aDK) {
            writeData.setVForumId(this.iVr.aPr().getId());
            writeData.setVForumName(this.iVr.aPr().getName());
        } else {
            writeData.setForumName(this.iVr.aPr().getName());
            writeData.setForumId(this.iVr.aPr().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iVr.clB().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aDK);
        writeData.setThreadId(this.iVr.aAj().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.iVr = lVar;
    }

    public void crs() {
        if (!this.iVs) {
            cancelMessage();
            this.iVt = crt();
            if (this.iVt != null) {
                sendMessage(this.iVt);
            }
        }
    }

    public void q(PostData postData) {
        if (postData != null) {
            this.iVr.clB().t(postData);
            this.iVr.clB().u(postData);
            this.iVr.clB().sS(true);
        }
    }

    private SubPbRequestMessage crt() {
        if (this.iVr == null || this.iVr.aAj() == null || this.iVr.aAj().getId() == null || this.iVr.clB() == null || this.iVr.clB().getId() == null) {
            this.iVs = false;
            return null;
        }
        this.iVs = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.iVr.clB().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.iVr.aAj().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOS() {
        crs();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOT() {
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

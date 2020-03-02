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
    private l iTE;
    private boolean iTF;
    private SubPbRequestMessage iTG;
    private a iTH;
    private com.baidu.adp.framework.listener.a iTI;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void p(PostData postData);
    }

    public void a(a aVar) {
        this.iTH = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iTE = null;
        this.iTF = false;
        this.iTH = null;
        this.iTI = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iTF = false;
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
                    if (lVar != null && lVar.clj() != null) {
                        PostData postData = (PostData) v.getItem(lVar.clj(), lVar.clj().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iTE != null && PbFakeFloorModel.this.iTE.clf() != null) {
                            if (PbFakeFloorModel.this.iTE.aAg() != null && PbFakeFloorModel.this.iTE.aAg().aCo() != null && postData.aCo() != null && (userId = PbFakeFloorModel.this.iTE.aAg().aCo().getUserId()) != null && userId.equals(postData.aCo().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iTH != null) {
                            PbFakeFloorModel.this.iTH.p(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iTI);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iTI);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iTE == null || this.iTE.aPm() == null || this.iTE.aAg() == null || this.iTE.clf() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aDG = this.iTE.aAg().aDG();
        if (aDG) {
            writeData.setVForumId(this.iTE.aPm().getId());
            writeData.setVForumName(this.iTE.aPm().getName());
        } else {
            writeData.setForumName(this.iTE.aPm().getName());
            writeData.setForumId(this.iTE.aPm().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iTE.clf().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aDG);
        writeData.setThreadId(this.iTE.aAg().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.iTE = lVar;
    }

    public void cqW() {
        if (!this.iTF) {
            cancelMessage();
            this.iTG = cqX();
            if (this.iTG != null) {
                sendMessage(this.iTG);
            }
        }
    }

    public void q(PostData postData) {
        if (postData != null) {
            this.iTE.clf().t(postData);
            this.iTE.clf().u(postData);
            this.iTE.clf().sM(true);
        }
    }

    private SubPbRequestMessage cqX() {
        if (this.iTE == null || this.iTE.aAg() == null || this.iTE.aAg().getId() == null || this.iTE.clf() == null || this.iTE.clf().getId() == null) {
            this.iTF = false;
            return null;
        }
        this.iTF = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.iTE.clf().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.iTE.aAg().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aON() {
        cqW();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOO() {
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

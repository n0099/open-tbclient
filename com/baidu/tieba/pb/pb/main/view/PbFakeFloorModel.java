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
    private l iTC;
    private boolean iTD;
    private SubPbRequestMessage iTE;
    private a iTF;
    private com.baidu.adp.framework.listener.a iTG;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void p(PostData postData);
    }

    public void a(a aVar) {
        this.iTF = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iTC = null;
        this.iTD = false;
        this.iTF = null;
        this.iTG = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iTD = false;
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
                    if (lVar != null && lVar.clh() != null) {
                        PostData postData = (PostData) v.getItem(lVar.clh(), lVar.clh().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iTC != null && PbFakeFloorModel.this.iTC.cld() != null) {
                            if (PbFakeFloorModel.this.iTC.aAe() != null && PbFakeFloorModel.this.iTC.aAe().aCm() != null && postData.aCm() != null && (userId = PbFakeFloorModel.this.iTC.aAe().aCm().getUserId()) != null && userId.equals(postData.aCm().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iTF != null) {
                            PbFakeFloorModel.this.iTF.p(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iTG);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iTG);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iTC == null || this.iTC.aPk() == null || this.iTC.aAe() == null || this.iTC.cld() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aDE = this.iTC.aAe().aDE();
        if (aDE) {
            writeData.setVForumId(this.iTC.aPk().getId());
            writeData.setVForumName(this.iTC.aPk().getName());
        } else {
            writeData.setForumName(this.iTC.aPk().getName());
            writeData.setForumId(this.iTC.aPk().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iTC.cld().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aDE);
        writeData.setThreadId(this.iTC.aAe().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.iTC = lVar;
    }

    public void cqU() {
        if (!this.iTD) {
            cancelMessage();
            this.iTE = cqV();
            if (this.iTE != null) {
                sendMessage(this.iTE);
            }
        }
    }

    public void q(PostData postData) {
        if (postData != null) {
            this.iTC.cld().t(postData);
            this.iTC.cld().u(postData);
            this.iTC.cld().sM(true);
        }
    }

    private SubPbRequestMessage cqV() {
        if (this.iTC == null || this.iTC.aAe() == null || this.iTC.aAe().getId() == null || this.iTC.cld() == null || this.iTC.cld().getId() == null) {
            this.iTD = false;
            return null;
        }
        this.iTD = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.iTC.cld().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.iTC.aAe().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOL() {
        cqU();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOM() {
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

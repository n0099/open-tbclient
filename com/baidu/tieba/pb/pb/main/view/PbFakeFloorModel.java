package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class PbFakeFloorModel extends DataModel {
    private p lBj;
    private boolean lBk;
    private SubPbRequestMessage lBl;
    private a lBm;
    private com.baidu.adp.framework.listener.a lBn;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes22.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.lBm = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lBj = null;
        this.lBk = false;
        this.lBm = null;
        this.lBn = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.lBk = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    p pVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        pVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (pVar != null && pVar.dgG() != null) {
                        PostData postData = (PostData) y.getItem(pVar.dgG(), pVar.dgG().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.lBj != null && PbFakeFloorModel.this.lBj.dgy() != null) {
                            if (PbFakeFloorModel.this.lBj.bhz() != null && PbFakeFloorModel.this.lBj.bhz().bka() != null && postData.bka() != null && (userId = PbFakeFloorModel.this.lBj.bhz().bka().getUserId()) != null && userId.equals(postData.bka().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.lBm != null) {
                            PbFakeFloorModel.this.lBm.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.lBn);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.lBn);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dw(String str) {
        if (this.lBj == null || this.lBj.bya() == null || this.lBj.bhz() == null || this.lBj.dgy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean blx = this.lBj.bhz().blx();
        if (blx) {
            writeData.setVForumId(this.lBj.bya().getId());
            writeData.setVForumName(this.lBj.bya().getName());
        } else {
            writeData.setForumName(this.lBj.bya().getName());
            writeData.setForumId(this.lBj.bya().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.lBj.dgy().getId());
        writeData.setType(2);
        writeData.setCanNoForum(blx);
        writeData.setThreadId(this.lBj.bhz().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.lBj = pVar;
    }

    public void dmz() {
        if (!this.lBk) {
            cancelMessage();
            this.lBl = dmA();
            if (this.lBl != null) {
                sendMessage(this.lBl);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.lBj.dgy().w(postData);
            this.lBj.dgy().x(postData);
            this.lBj.dgy().xj(true);
        }
    }

    private SubPbRequestMessage dmA() {
        if (this.lBj == null || this.lBj.bhz() == null || this.lBj.bhz().getId() == null || this.lBj.dgy() == null || this.lBj.dgy().getId() == null) {
            this.lBk = false;
            return null;
        }
        this.lBk = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.lBj.dgy().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lBj.bhz().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bxz() {
        dmz();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bxA() {
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

package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;
    private p maI;
    private boolean maJ;
    private SubPbRequestMessage maK;
    private a maL;
    private com.baidu.adp.framework.listener.a maM;

    /* loaded from: classes2.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.maL = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.maI = null;
        this.maJ = false;
        this.maL = null;
        this.maM = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.maJ = false;
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
                    if (pVar != null && pVar.dnG() != null) {
                        PostData postData = (PostData) x.getItem(pVar.dnG(), pVar.dnG().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.maI != null && PbFakeFloorModel.this.maI.dny() != null) {
                            if (PbFakeFloorModel.this.maI.boP() != null && PbFakeFloorModel.this.maI.boP().brr() != null && postData.brr() != null && (userId = PbFakeFloorModel.this.maI.boP().brr().getUserId()) != null && userId.equals(postData.brr().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.maL != null) {
                            PbFakeFloorModel.this.maL.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.maM);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.maM);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DN(String str) {
        if (this.maI == null || this.maI.bFL() == null || this.maI.boP() == null || this.maI.dny() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bsR = this.maI.boP().bsR();
        if (bsR) {
            writeData.setVForumId(this.maI.bFL().getId());
            writeData.setVForumName(this.maI.bFL().getName());
        } else {
            writeData.setForumName(this.maI.bFL().getName());
            writeData.setForumId(this.maI.bFL().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.maI.dny().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bsR);
        writeData.setThreadId(this.maI.boP().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.maI = pVar;
    }

    public void dtJ() {
        if (!this.maJ) {
            cancelMessage();
            this.maK = dtK();
            if (this.maK != null) {
                sendMessage(this.maK);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.maI.dny().y(postData);
            this.maI.dny().z(postData);
            this.maI.dny().yf(true);
        }
    }

    private SubPbRequestMessage dtK() {
        if (this.maI == null || this.maI.boP() == null || this.maI.boP().getId() == null || this.maI.dny() == null || this.maI.dny().getId() == null) {
            this.maJ = false;
            return null;
        }
        this.maJ = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.maI.dny().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.maI.boP().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bFk() {
        dtJ();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bFl() {
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

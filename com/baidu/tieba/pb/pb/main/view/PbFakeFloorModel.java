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
    private p loK;
    private boolean loL;
    private SubPbRequestMessage loM;
    private a loN;
    private com.baidu.adp.framework.listener.a loO;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes22.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.loN = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.loK = null;
        this.loL = false;
        this.loN = null;
        this.loO = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.loL = false;
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
                    if (pVar != null && pVar.ddy() != null) {
                        PostData postData = (PostData) y.getItem(pVar.ddy(), pVar.ddy().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.loK != null && PbFakeFloorModel.this.loK.ddq() != null) {
                            if (PbFakeFloorModel.this.loK.bfG() != null && PbFakeFloorModel.this.loK.bfG().bih() != null && postData.bih() != null && (userId = PbFakeFloorModel.this.loK.bfG().bih().getUserId()) != null && userId.equals(postData.bih().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.loN != null) {
                            PbFakeFloorModel.this.loN.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.loO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.loO);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dd(String str) {
        if (this.loK == null || this.loK.bwh() == null || this.loK.bfG() == null || this.loK.ddq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bjE = this.loK.bfG().bjE();
        if (bjE) {
            writeData.setVForumId(this.loK.bwh().getId());
            writeData.setVForumName(this.loK.bwh().getName());
        } else {
            writeData.setForumName(this.loK.bwh().getName());
            writeData.setForumId(this.loK.bwh().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.loK.ddq().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bjE);
        writeData.setThreadId(this.loK.bfG().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.loK = pVar;
    }

    public void djs() {
        if (!this.loL) {
            cancelMessage();
            this.loM = djt();
            if (this.loM != null) {
                sendMessage(this.loM);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.loK.ddq().w(postData);
            this.loK.ddq().x(postData);
            this.loK.ddq().wS(true);
        }
    }

    private SubPbRequestMessage djt() {
        if (this.loK == null || this.loK.bfG() == null || this.loK.bfG().getId() == null || this.loK.ddq() == null || this.loK.ddq().getId() == null) {
            this.loL = false;
            return null;
        }
        this.loL = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.loK.ddq().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.loK.bfG().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bvG() {
        djs();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bvH() {
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

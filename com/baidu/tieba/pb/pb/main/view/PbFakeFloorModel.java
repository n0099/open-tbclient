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
    private p lVu;
    private boolean lVv;
    private SubPbRequestMessage lVw;
    private a lVx;
    private com.baidu.adp.framework.listener.a lVy;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes22.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.lVx = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lVu = null;
        this.lVv = false;
        this.lVx = null;
        this.lVy = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.lVv = false;
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
                    if (pVar != null && pVar.dnV() != null) {
                        PostData postData = (PostData) y.getItem(pVar.dnV(), pVar.dnV().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.lVu != null && PbFakeFloorModel.this.lVu.dnN() != null) {
                            if (PbFakeFloorModel.this.lVu.bmn() != null && PbFakeFloorModel.this.lVu.bmn().boP() != null && postData.boP() != null && (userId = PbFakeFloorModel.this.lVu.bmn().boP().getUserId()) != null && userId.equals(postData.boP().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.lVx != null) {
                            PbFakeFloorModel.this.lVx.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.lVy);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.lVy);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DR(String str) {
        if (this.lVu == null || this.lVu.bDp() == null || this.lVu.bmn() == null || this.lVu.dnN() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bqo = this.lVu.bmn().bqo();
        if (bqo) {
            writeData.setVForumId(this.lVu.bDp().getId());
            writeData.setVForumName(this.lVu.bDp().getName());
        } else {
            writeData.setForumName(this.lVu.bDp().getName());
            writeData.setForumId(this.lVu.bDp().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.lVu.dnN().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bqo);
        writeData.setThreadId(this.lVu.bmn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.lVu = pVar;
    }

    public void dtT() {
        if (!this.lVv) {
            cancelMessage();
            this.lVw = dtU();
            if (this.lVw != null) {
                sendMessage(this.lVw);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.lVu.dnN().y(postData);
            this.lVu.dnN().z(postData);
            this.lVu.dnN().ya(true);
        }
    }

    private SubPbRequestMessage dtU() {
        if (this.lVu == null || this.lVu.bmn() == null || this.lVu.bmn().getId() == null || this.lVu.dnN() == null || this.lVu.dnN().getId() == null) {
            this.lVv = false;
            return null;
        }
        this.lVv = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.lVu.dnN().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lVu.bmn().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bCO() {
        dtT();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bCP() {
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

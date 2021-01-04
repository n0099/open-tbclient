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
    private p maJ;
    private boolean maK;
    private SubPbRequestMessage maL;
    private a maM;
    private com.baidu.adp.framework.listener.a maN;

    /* loaded from: classes2.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.maM = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.maJ = null;
        this.maK = false;
        this.maM = null;
        this.maN = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.maK = false;
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
                    if (pVar != null && pVar.dnF() != null) {
                        PostData postData = (PostData) x.getItem(pVar.dnF(), pVar.dnF().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.maJ != null && PbFakeFloorModel.this.maJ.dnx() != null) {
                            if (PbFakeFloorModel.this.maJ.boO() != null && PbFakeFloorModel.this.maJ.boO().brq() != null && postData.brq() != null && (userId = PbFakeFloorModel.this.maJ.boO().brq().getUserId()) != null && userId.equals(postData.brq().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.maM != null) {
                            PbFakeFloorModel.this.maM.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.maN);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.maN);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DO(String str) {
        if (this.maJ == null || this.maJ.bFK() == null || this.maJ.boO() == null || this.maJ.dnx() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bsQ = this.maJ.boO().bsQ();
        if (bsQ) {
            writeData.setVForumId(this.maJ.bFK().getId());
            writeData.setVForumName(this.maJ.bFK().getName());
        } else {
            writeData.setForumName(this.maJ.bFK().getName());
            writeData.setForumId(this.maJ.bFK().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.maJ.dnx().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bsQ);
        writeData.setThreadId(this.maJ.boO().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.maJ = pVar;
    }

    public void dtI() {
        if (!this.maK) {
            cancelMessage();
            this.maL = dtJ();
            if (this.maL != null) {
                sendMessage(this.maL);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.maJ.dnx().y(postData);
            this.maJ.dnx().z(postData);
            this.maJ.dnx().yf(true);
        }
    }

    private SubPbRequestMessage dtJ() {
        if (this.maJ == null || this.maJ.boO() == null || this.maJ.boO().getId() == null || this.maJ.dnx() == null || this.maJ.dnx().getId() == null) {
            this.maK = false;
            return null;
        }
        this.maK = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.maJ.dnx().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.maJ.boO().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bFj() {
        dtI();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bFk() {
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

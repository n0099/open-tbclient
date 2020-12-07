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
    private p lVs;
    private boolean lVt;
    private SubPbRequestMessage lVu;
    private a lVv;
    private com.baidu.adp.framework.listener.a lVw;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes22.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.lVv = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lVs = null;
        this.lVt = false;
        this.lVv = null;
        this.lVw = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.lVt = false;
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
                    if (pVar != null && pVar.dnU() != null) {
                        PostData postData = (PostData) y.getItem(pVar.dnU(), pVar.dnU().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.lVs != null && PbFakeFloorModel.this.lVs.dnM() != null) {
                            if (PbFakeFloorModel.this.lVs.bmn() != null && PbFakeFloorModel.this.lVs.bmn().boP() != null && postData.boP() != null && (userId = PbFakeFloorModel.this.lVs.bmn().boP().getUserId()) != null && userId.equals(postData.boP().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.lVv != null) {
                            PbFakeFloorModel.this.lVv.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.lVw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.lVw);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DR(String str) {
        if (this.lVs == null || this.lVs.bDp() == null || this.lVs.bmn() == null || this.lVs.dnM() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bqo = this.lVs.bmn().bqo();
        if (bqo) {
            writeData.setVForumId(this.lVs.bDp().getId());
            writeData.setVForumName(this.lVs.bDp().getName());
        } else {
            writeData.setForumName(this.lVs.bDp().getName());
            writeData.setForumId(this.lVs.bDp().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.lVs.dnM().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bqo);
        writeData.setThreadId(this.lVs.bmn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.lVs = pVar;
    }

    public void dtS() {
        if (!this.lVt) {
            cancelMessage();
            this.lVu = dtT();
            if (this.lVu != null) {
                sendMessage(this.lVu);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.lVs.dnM().y(postData);
            this.lVs.dnM().z(postData);
            this.lVs.dnM().ya(true);
        }
    }

    private SubPbRequestMessage dtT() {
        if (this.lVs == null || this.lVs.bmn() == null || this.lVs.bmn().getId() == null || this.lVs.dnM() == null || this.lVs.dnM().getId() == null) {
            this.lVt = false;
            return null;
        }
        this.lVt = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.lVs.dnM().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lVs.bmn().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bCO() {
        dtS();
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

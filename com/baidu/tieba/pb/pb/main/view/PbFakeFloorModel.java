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
    private p lHf;
    private boolean lHg;
    private SubPbRequestMessage lHh;
    private a lHi;
    private com.baidu.adp.framework.listener.a lHj;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes22.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.lHi = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lHf = null;
        this.lHg = false;
        this.lHi = null;
        this.lHj = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.lHg = false;
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
                    if (pVar != null && pVar.dji() != null) {
                        PostData postData = (PostData) y.getItem(pVar.dji(), pVar.dji().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.lHf != null && PbFakeFloorModel.this.lHf.dja() != null) {
                            if (PbFakeFloorModel.this.lHf.bjZ() != null && PbFakeFloorModel.this.lHf.bjZ().bmA() != null && postData.bmA() != null && (userId = PbFakeFloorModel.this.lHf.bjZ().bmA().getUserId()) != null && userId.equals(postData.bmA().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.lHi != null) {
                            PbFakeFloorModel.this.lHi.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.lHj);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.lHj);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DK(String str) {
        if (this.lHf == null || this.lHf.bAz() == null || this.lHf.bjZ() == null || this.lHf.dja() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bnX = this.lHf.bjZ().bnX();
        if (bnX) {
            writeData.setVForumId(this.lHf.bAz().getId());
            writeData.setVForumName(this.lHf.bAz().getName());
        } else {
            writeData.setForumName(this.lHf.bAz().getName());
            writeData.setForumId(this.lHf.bAz().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.lHf.dja().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bnX);
        writeData.setThreadId(this.lHf.bjZ().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.lHf = pVar;
    }

    public void dpc() {
        if (!this.lHg) {
            cancelMessage();
            this.lHh = dpd();
            if (this.lHh != null) {
                sendMessage(this.lHh);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.lHf.dja().w(postData);
            this.lHf.dja().x(postData);
            this.lHf.dja().xs(true);
        }
    }

    private SubPbRequestMessage dpd() {
        if (this.lHf == null || this.lHf.bjZ() == null || this.lHf.bjZ().getId() == null || this.lHf.dja() == null || this.lHf.dja().getId() == null) {
            this.lHg = false;
            return null;
        }
        this.lHg = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.lHf.dja().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lHf.bjZ().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bzY() {
        dpc();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bzZ() {
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

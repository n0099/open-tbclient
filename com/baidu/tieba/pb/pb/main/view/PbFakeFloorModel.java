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
    private p lWb;
    private boolean lWc;
    private SubPbRequestMessage lWd;
    private a lWe;
    private com.baidu.adp.framework.listener.a lWf;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.lWe = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lWb = null;
        this.lWc = false;
        this.lWe = null;
        this.lWf = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.lWc = false;
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
                    if (pVar != null && pVar.djN() != null) {
                        PostData postData = (PostData) x.getItem(pVar.djN(), pVar.djN().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.lWb != null && PbFakeFloorModel.this.lWb.djF() != null) {
                            if (PbFakeFloorModel.this.lWb.bkV() != null && PbFakeFloorModel.this.lWb.bkV().bnx() != null && postData.bnx() != null && (userId = PbFakeFloorModel.this.lWb.bkV().bnx().getUserId()) != null && userId.equals(postData.bnx().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.lWe != null) {
                            PbFakeFloorModel.this.lWe.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.lWf);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.lWf);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CC(String str) {
        if (this.lWb == null || this.lWb.bBS() == null || this.lWb.bkV() == null || this.lWb.djF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean boX = this.lWb.bkV().boX();
        if (boX) {
            writeData.setVForumId(this.lWb.bBS().getId());
            writeData.setVForumName(this.lWb.bBS().getName());
        } else {
            writeData.setForumName(this.lWb.bBS().getName());
            writeData.setForumId(this.lWb.bBS().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.lWb.djF().getId());
        writeData.setType(2);
        writeData.setCanNoForum(boX);
        writeData.setThreadId(this.lWb.bkV().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.lWb = pVar;
    }

    public void dpR() {
        if (!this.lWc) {
            cancelMessage();
            this.lWd = dpS();
            if (this.lWd != null) {
                sendMessage(this.lWd);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.lWb.djF().y(postData);
            this.lWb.djF().z(postData);
            this.lWb.djF().yb(true);
        }
    }

    private SubPbRequestMessage dpS() {
        if (this.lWb == null || this.lWb.bkV() == null || this.lWb.bkV().getId() == null || this.lWb.djF() == null || this.lWb.djF().getId() == null) {
            this.lWc = false;
            return null;
        }
        this.lWc = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.lWb.djF().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lWb.bkV().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBq() {
        dpR();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBr() {
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

package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class PbFakeFloorModel extends DataModel {
    private k iad;
    private boolean iae;
    private SubPbRequestMessage iaf;
    private a iag;
    private com.baidu.adp.framework.listener.a iah;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.iag = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iad = null;
        this.iae = false;
        this.iag = null;
        this.iah = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iae = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    k kVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        kVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (kVar != null && kVar.bRm() != null) {
                        PostData postData = (PostData) v.getItem(kVar.bRm(), kVar.bRm().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iad != null && PbFakeFloorModel.this.iad.bRi() != null) {
                            if (PbFakeFloorModel.this.iad.agI() != null && PbFakeFloorModel.this.iad.agI().aiG() != null && postData.aiG() != null && (userId = PbFakeFloorModel.this.iad.agI().aiG().getUserId()) != null && userId.equals(postData.aiG().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iag != null) {
                            PbFakeFloorModel.this.iag.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iah);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iah);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pG(String str) {
        if (this.iad == null || this.iad.bRo() == null || this.iad.agI() == null || this.iad.bRi() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean ajX = this.iad.agI().ajX();
        if (ajX) {
            writeData.setVForumId(this.iad.bRo().getId());
            writeData.setVForumName(this.iad.bRo().getName());
        } else {
            writeData.setForumName(this.iad.bRo().getName());
            writeData.setForumId(this.iad.bRo().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iad.bRi().getId());
        writeData.setType(2);
        writeData.setCanNoForum(ajX);
        writeData.setThreadId(this.iad.agI().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.iad = kVar;
    }

    public void bWE() {
        if (!this.iae) {
            cancelMessage();
            this.iaf = bWF();
            if (this.iaf != null) {
                sendMessage(this.iaf);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.iad.bRi().r(postData);
            this.iad.bRi().s(postData);
            this.iad.bRi().qO(true);
        }
    }

    private SubPbRequestMessage bWF() {
        if (this.iad == null || this.iad.agI() == null || this.iad.agI().getId() == null || this.iad.bRi() == null || this.iad.bRi().getId() == null) {
            this.iae = false;
            return null;
        }
        this.iae = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.g.b.toLong(this.iad.bRi().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.toLong(this.iad.agI().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aut() {
        bWE();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String auu() {
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

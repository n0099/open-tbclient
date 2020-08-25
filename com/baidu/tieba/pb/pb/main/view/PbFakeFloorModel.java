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
/* loaded from: classes16.dex */
public class PbFakeFloorModel extends DataModel {
    private p kQJ;
    private boolean kQK;
    private SubPbRequestMessage kQL;
    private a kQM;
    private com.baidu.adp.framework.listener.a kQN;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes16.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.kQM = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kQJ = null;
        this.kQK = false;
        this.kQM = null;
        this.kQN = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.kQK = false;
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
                    if (pVar != null && pVar.cWl() != null) {
                        PostData postData = (PostData) y.getItem(pVar.cWl(), pVar.cWl().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.kQJ != null && PbFakeFloorModel.this.kQJ.cWh() != null) {
                            if (PbFakeFloorModel.this.kQJ.bce() != null && PbFakeFloorModel.this.kQJ.bce().beE() != null && postData.beE() != null && (userId = PbFakeFloorModel.this.kQJ.bce().beE().getUserId()) != null && userId.equals(postData.beE().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.kQM != null) {
                            PbFakeFloorModel.this.kQM.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.kQN);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.kQN);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData BU(String str) {
        if (this.kQJ == null || this.kQJ.bss() == null || this.kQJ.bce() == null || this.kQJ.cWh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bgb = this.kQJ.bce().bgb();
        if (bgb) {
            writeData.setVForumId(this.kQJ.bss().getId());
            writeData.setVForumName(this.kQJ.bss().getName());
        } else {
            writeData.setForumName(this.kQJ.bss().getName());
            writeData.setForumId(this.kQJ.bss().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.kQJ.cWh().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bgb);
        writeData.setThreadId(this.kQJ.bce().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.kQJ = pVar;
    }

    public void dce() {
        if (!this.kQK) {
            cancelMessage();
            this.kQL = dcf();
            if (this.kQL != null) {
                sendMessage(this.kQL);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.kQJ.cWh().w(postData);
            this.kQJ.cWh().x(postData);
            this.kQJ.cWh().wa(true);
        }
    }

    private SubPbRequestMessage dcf() {
        if (this.kQJ == null || this.kQJ.bce() == null || this.kQJ.bce().getId() == null || this.kQJ.cWh() == null || this.kQJ.cWh().getId() == null) {
            this.kQK = false;
            return null;
        }
        this.kQK = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.kQJ.cWh().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kQJ.bce().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean brR() {
        dce();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String brS() {
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

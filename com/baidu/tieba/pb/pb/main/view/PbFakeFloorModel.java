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
    private k hZm;
    private boolean hZn;
    private SubPbRequestMessage hZo;
    private a hZp;
    private com.baidu.adp.framework.listener.a hZq;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hZp = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hZm = null;
        this.hZn = false;
        this.hZp = null;
        this.hZq = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hZn = false;
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
                    if (kVar != null && kVar.bRk() != null) {
                        PostData postData = (PostData) v.getItem(kVar.bRk(), kVar.bRk().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hZm != null && PbFakeFloorModel.this.hZm.bRg() != null) {
                            if (PbFakeFloorModel.this.hZm.agG() != null && PbFakeFloorModel.this.hZm.agG().aiE() != null && postData.aiE() != null && (userId = PbFakeFloorModel.this.hZm.agG().aiE().getUserId()) != null && userId.equals(postData.aiE().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hZp != null) {
                            PbFakeFloorModel.this.hZp.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hZq);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hZq);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pG(String str) {
        if (this.hZm == null || this.hZm.bRm() == null || this.hZm.agG() == null || this.hZm.bRg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean ajV = this.hZm.agG().ajV();
        if (ajV) {
            writeData.setVForumId(this.hZm.bRm().getId());
            writeData.setVForumName(this.hZm.bRm().getName());
        } else {
            writeData.setForumName(this.hZm.bRm().getName());
            writeData.setForumId(this.hZm.bRm().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hZm.bRg().getId());
        writeData.setType(2);
        writeData.setCanNoForum(ajV);
        writeData.setThreadId(this.hZm.agG().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.hZm = kVar;
    }

    public void bWC() {
        if (!this.hZn) {
            cancelMessage();
            this.hZo = bWD();
            if (this.hZo != null) {
                sendMessage(this.hZo);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hZm.bRg().r(postData);
            this.hZm.bRg().s(postData);
            this.hZm.bRg().qO(true);
        }
    }

    private SubPbRequestMessage bWD() {
        if (this.hZm == null || this.hZm.agG() == null || this.hZm.agG().getId() == null || this.hZm.bRg() == null || this.hZm.bRg().getId() == null) {
            this.hZn = false;
            return null;
        }
        this.hZn = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.g.b.toLong(this.hZm.bRg().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.toLong(this.hZm.agG().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aur() {
        bWC();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aus() {
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

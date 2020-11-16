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
/* loaded from: classes21.dex */
public class PbFakeFloorModel extends DataModel {
    private a lHA;
    private com.baidu.adp.framework.listener.a lHB;
    private p lHx;
    private boolean lHy;
    private SubPbRequestMessage lHz;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes21.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.lHA = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lHx = null;
        this.lHy = false;
        this.lHA = null;
        this.lHB = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.lHy = false;
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
                    if (pVar != null && pVar.diF() != null) {
                        PostData postData = (PostData) y.getItem(pVar.diF(), pVar.diF().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.lHx != null && PbFakeFloorModel.this.lHx.dix() != null) {
                            if (PbFakeFloorModel.this.lHx.bjd() != null && PbFakeFloorModel.this.lHx.bjd().blC() != null && postData.blC() != null && (userId = PbFakeFloorModel.this.lHx.bjd().blC().getUserId()) != null && userId.equals(postData.blC().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.lHA != null) {
                            PbFakeFloorModel.this.lHA.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.lHB);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.lHB);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dj(String str) {
        if (this.lHx == null || this.lHx.bzP() == null || this.lHx.bjd() == null || this.lHx.dix() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bnb = this.lHx.bjd().bnb();
        if (bnb) {
            writeData.setVForumId(this.lHx.bzP().getId());
            writeData.setVForumName(this.lHx.bzP().getName());
        } else {
            writeData.setForumName(this.lHx.bzP().getName());
            writeData.setForumId(this.lHx.bzP().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.lHx.dix().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bnb);
        writeData.setThreadId(this.lHx.bjd().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.lHx = pVar;
    }

    public void doB() {
        if (!this.lHy) {
            cancelMessage();
            this.lHz = doC();
            if (this.lHz != null) {
                sendMessage(this.lHz);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.lHx.dix().x(postData);
            this.lHx.dix().y(postData);
            this.lHx.dix().xw(true);
        }
    }

    private SubPbRequestMessage doC() {
        if (this.lHx == null || this.lHx.bjd() == null || this.lHx.bjd().getId() == null || this.lHx.dix() == null || this.lHx.dix().getId() == null) {
            this.lHy = false;
            return null;
        }
        this.lHy = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.lHx.dix().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.lHx.bjd().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bzo() {
        doB();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bzp() {
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

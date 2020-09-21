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
    private p kZs;
    private boolean kZt;
    private SubPbRequestMessage kZu;
    private a kZv;
    private com.baidu.adp.framework.listener.a kZw;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes21.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.kZv = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kZs = null;
        this.kZt = false;
        this.kZv = null;
        this.kZw = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.kZt = false;
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
                    if (pVar != null && pVar.cZP() != null) {
                        PostData postData = (PostData) y.getItem(pVar.cZP(), pVar.cZP().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.kZs != null && PbFakeFloorModel.this.kZs.cZH() != null) {
                            if (PbFakeFloorModel.this.kZs.bcY() != null && PbFakeFloorModel.this.kZs.bcY().bfy() != null && postData.bfy() != null && (userId = PbFakeFloorModel.this.kZs.bcY().bfy().getUserId()) != null && userId.equals(postData.bfy().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.kZv != null) {
                            PbFakeFloorModel.this.kZv.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.kZw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.kZw);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Cr(String str) {
        if (this.kZs == null || this.kZs.btx() == null || this.kZs.bcY() == null || this.kZs.cZH() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bgV = this.kZs.bcY().bgV();
        if (bgV) {
            writeData.setVForumId(this.kZs.btx().getId());
            writeData.setVForumName(this.kZs.btx().getName());
        } else {
            writeData.setForumName(this.kZs.btx().getName());
            writeData.setForumId(this.kZs.btx().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.kZs.cZH().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bgV);
        writeData.setThreadId(this.kZs.bcY().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.kZs = pVar;
    }

    public void dfJ() {
        if (!this.kZt) {
            cancelMessage();
            this.kZu = dfK();
            if (this.kZu != null) {
                sendMessage(this.kZu);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.kZs.cZH().w(postData);
            this.kZs.cZH().x(postData);
            this.kZs.cZH().wl(true);
        }
    }

    private SubPbRequestMessage dfK() {
        if (this.kZs == null || this.kZs.bcY() == null || this.kZs.bcY().getId() == null || this.kZs.cZH() == null || this.kZs.cZH().getId() == null) {
            this.kZt = false;
            return null;
        }
        this.kZt = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.kZs.cZH().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kZs.bcY().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bsW() {
        dfJ();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bsX() {
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

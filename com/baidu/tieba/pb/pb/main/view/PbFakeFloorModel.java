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
/* loaded from: classes16.dex */
public class PbFakeFloorModel extends DataModel {
    private p kBe;
    private boolean kBf;
    private SubPbRequestMessage kBg;
    private a kBh;
    private com.baidu.adp.framework.listener.a kBi;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes16.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.kBh = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kBe = null;
        this.kBf = false;
        this.kBh = null;
        this.kBi = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.kBf = false;
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
                    if (pVar != null && pVar.cLx() != null) {
                        PostData postData = (PostData) x.getItem(pVar.cLx(), pVar.cLx().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.kBe != null && PbFakeFloorModel.this.kBe.cLt() != null) {
                            if (PbFakeFloorModel.this.kBe.aTN() != null && PbFakeFloorModel.this.kBe.aTN().aWl() != null && postData.aWl() != null && (userId = PbFakeFloorModel.this.kBe.aTN().aWl().getUserId()) != null && userId.equals(postData.aWl().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.kBh != null) {
                            PbFakeFloorModel.this.kBh.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.kBi);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.kBi);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData zE(String str) {
        if (this.kBe == null || this.kBe.bjG() == null || this.kBe.aTN() == null || this.kBe.cLt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aXI = this.kBe.aTN().aXI();
        if (aXI) {
            writeData.setVForumId(this.kBe.bjG().getId());
            writeData.setVForumName(this.kBe.bjG().getName());
        } else {
            writeData.setForumName(this.kBe.bjG().getName());
            writeData.setForumId(this.kBe.bjG().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.kBe.cLt().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aXI);
        writeData.setThreadId(this.kBe.aTN().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.kBe = pVar;
    }

    public void cRo() {
        if (!this.kBf) {
            cancelMessage();
            this.kBg = cRp();
            if (this.kBg != null) {
                sendMessage(this.kBg);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.kBe.cLt().w(postData);
            this.kBe.cLt().x(postData);
            this.kBe.cLt().vl(true);
        }
    }

    private SubPbRequestMessage cRp() {
        if (this.kBe == null || this.kBe.aTN() == null || this.kBe.aTN().getId() == null || this.kBe.cLt() == null || this.kBe.cLt().getId() == null) {
            this.kBf = false;
            return null;
        }
        this.kBf = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.kBe.cLt().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kBe.aTN().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bjf() {
        cRo();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bjg() {
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

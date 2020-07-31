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
    private p kBc;
    private boolean kBd;
    private SubPbRequestMessage kBe;
    private a kBf;
    private com.baidu.adp.framework.listener.a kBg;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes16.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.kBf = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kBc = null;
        this.kBd = false;
        this.kBf = null;
        this.kBg = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.kBd = false;
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
                        if (postData != null && PbFakeFloorModel.this.kBc != null && PbFakeFloorModel.this.kBc.cLt() != null) {
                            if (PbFakeFloorModel.this.kBc.aTN() != null && PbFakeFloorModel.this.kBc.aTN().aWl() != null && postData.aWl() != null && (userId = PbFakeFloorModel.this.kBc.aTN().aWl().getUserId()) != null && userId.equals(postData.aWl().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.kBf != null) {
                            PbFakeFloorModel.this.kBf.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.kBg);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.kBg);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData zE(String str) {
        if (this.kBc == null || this.kBc.bjG() == null || this.kBc.aTN() == null || this.kBc.cLt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aXI = this.kBc.aTN().aXI();
        if (aXI) {
            writeData.setVForumId(this.kBc.bjG().getId());
            writeData.setVForumName(this.kBc.bjG().getName());
        } else {
            writeData.setForumName(this.kBc.bjG().getName());
            writeData.setForumId(this.kBc.bjG().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.kBc.cLt().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aXI);
        writeData.setThreadId(this.kBc.aTN().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.kBc = pVar;
    }

    public void cRo() {
        if (!this.kBd) {
            cancelMessage();
            this.kBe = cRp();
            if (this.kBe != null) {
                sendMessage(this.kBe);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.kBc.cLt().w(postData);
            this.kBc.cLt().x(postData);
            this.kBc.cLt().vl(true);
        }
    }

    private SubPbRequestMessage cRp() {
        if (this.kBc == null || this.kBc.aTN() == null || this.kBc.aTN().getId() == null || this.kBc.cLt() == null || this.kBc.cLt().getId() == null) {
            this.kBd = false;
            return null;
        }
        this.kBd = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.kBc.cLt().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kBc.aTN().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
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

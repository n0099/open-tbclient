package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class PbFakeFloorModel extends DataModel {
    private n kse;
    private boolean ksf;
    private SubPbRequestMessage ksg;
    private a ksh;
    private com.baidu.adp.framework.listener.a ksi;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.ksh = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kse = null;
        this.ksf = false;
        this.ksh = null;
        this.ksi = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ksf = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    n nVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        nVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (nVar != null && nVar.cHM() != null) {
                        PostData postData = (PostData) w.getItem(nVar.cHM(), nVar.cHM().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.kse != null && PbFakeFloorModel.this.kse.cHI() != null) {
                            if (PbFakeFloorModel.this.kse.aPS() != null && PbFakeFloorModel.this.kse.aPS().aSp() != null && postData.aSp() != null && (userId = PbFakeFloorModel.this.kse.aPS().aSp().getUserId()) != null && userId.equals(postData.aSp().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.ksh != null) {
                            PbFakeFloorModel.this.ksh.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.ksi);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ksi);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yy(String str) {
        if (this.kse == null || this.kse.bfV() == null || this.kse.aPS() == null || this.kse.cHI() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aTM = this.kse.aPS().aTM();
        if (aTM) {
            writeData.setVForumId(this.kse.bfV().getId());
            writeData.setVForumName(this.kse.bfV().getName());
        } else {
            writeData.setForumName(this.kse.bfV().getName());
            writeData.setForumId(this.kse.bfV().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.kse.cHI().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aTM);
        writeData.setThreadId(this.kse.aPS().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.kse = nVar;
    }

    public void cNA() {
        if (!this.ksf) {
            cancelMessage();
            this.ksg = cNB();
            if (this.ksg != null) {
                sendMessage(this.ksg);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.kse.cHI().w(postData);
            this.kse.cHI().x(postData);
            this.kse.cHI().uH(true);
        }
    }

    private SubPbRequestMessage cNB() {
        if (this.kse == null || this.kse.aPS() == null || this.kse.aPS().getId() == null || this.kse.cHI() == null || this.kse.cHI().getId() == null) {
            this.ksf = false;
            return null;
        }
        this.ksf = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.kse.cHI().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kse.aPS().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bfv() {
        cNA();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bfw() {
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

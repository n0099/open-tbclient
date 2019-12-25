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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class PbFakeFloorModel extends DataModel {
    private m iOD;
    private boolean iOE;
    private SubPbRequestMessage iOF;
    private a iOG;
    private com.baidu.adp.framework.listener.a iOH;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void q(PostData postData);
    }

    public void a(a aVar) {
        this.iOG = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iOD = null;
        this.iOE = false;
        this.iOG = null;
        this.iOH = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iOE = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    m mVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        mVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (mVar != null && mVar.ciB() != null) {
                        PostData postData = (PostData) v.getItem(mVar.ciB(), mVar.ciB().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iOD != null && PbFakeFloorModel.this.iOD.cix() != null) {
                            if (PbFakeFloorModel.this.iOD.axx() != null && PbFakeFloorModel.this.iOD.axx().azE() != null && postData.azE() != null && (userId = PbFakeFloorModel.this.iOD.axx().azE().getUserId()) != null && userId.equals(postData.azE().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iOG != null) {
                            PbFakeFloorModel.this.iOG.q(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iOH);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iOH);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData uM(String str) {
        if (this.iOD == null || this.iOD.aMv() == null || this.iOD.axx() == null || this.iOD.cix() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aAY = this.iOD.axx().aAY();
        if (aAY) {
            writeData.setVForumId(this.iOD.aMv().getId());
            writeData.setVForumName(this.iOD.aMv().getName());
        } else {
            writeData.setForumName(this.iOD.aMv().getName());
            writeData.setForumId(this.iOD.aMv().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iOD.cix().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aAY);
        writeData.setThreadId(this.iOD.axx().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.iOD = mVar;
    }

    public void cou() {
        if (!this.iOE) {
            cancelMessage();
            this.iOF = cov();
            if (this.iOF != null) {
                sendMessage(this.iOF);
            }
        }
    }

    public void r(PostData postData) {
        if (postData != null) {
            this.iOD.cix().u(postData);
            this.iOD.cix().v(postData);
            this.iOD.cix().sw(true);
        }
    }

    private SubPbRequestMessage cov() {
        if (this.iOD == null || this.iOD.axx() == null || this.iOD.axx().getId() == null || this.iOD.cix() == null || this.iOD.cix().getId() == null) {
            this.iOE = false;
            return null;
        }
        this.iOE = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.iOD.cix().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.iOD.axx().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aLW() {
        cou();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aLX() {
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

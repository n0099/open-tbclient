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
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;
    private a mhA;
    private com.baidu.adp.framework.listener.a mhB;
    private q mhx;
    private boolean mhy;
    private SubPbRequestMessage mhz;

    /* loaded from: classes2.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.mhA = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mhx = null;
        this.mhy = false;
        this.mhA = null;
        this.mhB = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.mhy = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    q qVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        qVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        qVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (qVar != null && qVar.dmq() != null) {
                        PostData postData = (PostData) y.getItem(qVar.dmq(), qVar.dmq().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.mhx != null && PbFakeFloorModel.this.mhx.dmh() != null) {
                            if (PbFakeFloorModel.this.mhx.blp() != null && PbFakeFloorModel.this.mhx.blp().bnS() != null && postData.bnS() != null && (userId = PbFakeFloorModel.this.mhx.blp().bnS().getUserId()) != null && userId.equals(postData.bnS().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.mhA != null) {
                            PbFakeFloorModel.this.mhA.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.mhB);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.mhB);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CY(String str) {
        if (this.mhx == null || this.mhx.bCn() == null || this.mhx.blp() == null || this.mhx.dmh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bpr = this.mhx.blp().bpr();
        if (bpr) {
            writeData.setVForumId(this.mhx.bCn().getId());
            writeData.setVForumName(this.mhx.bCn().getName());
        } else {
            writeData.setForumName(this.mhx.bCn().getName());
            writeData.setForumId(this.mhx.bCn().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.mhx.dmh().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bpr);
        writeData.setThreadId(this.mhx.blp().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(q qVar) {
        this.mhx = qVar;
    }

    public void dsv() {
        if (!this.mhy) {
            cancelMessage();
            this.mhz = dsw();
            if (this.mhz != null) {
                sendMessage(this.mhz);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.mhx.dmh().y(postData);
            this.mhx.dmh().z(postData);
            this.mhx.dmh().yt(true);
        }
    }

    private SubPbRequestMessage dsw() {
        if (this.mhx == null || this.mhx.blp() == null || this.mhx.blp().getId() == null || this.mhx.dmh() == null || this.mhx.dmh().getId() == null) {
            this.mhy = false;
            return null;
        }
        this.mhy = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.mhx.dmh().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mhx.blp().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBL() {
        dsv();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBM() {
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

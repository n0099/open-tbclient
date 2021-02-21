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
    private q mfv;
    private boolean mfw;
    private SubPbRequestMessage mfx;
    private a mfy;
    private com.baidu.adp.framework.listener.a mfz;

    /* loaded from: classes2.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.mfy = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mfv = null;
        this.mfw = false;
        this.mfy = null;
        this.mfz = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.mfw = false;
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
                    if (qVar != null && qVar.dmh() != null) {
                        PostData postData = (PostData) y.getItem(qVar.dmh(), qVar.dmh().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.mfv != null && PbFakeFloorModel.this.mfv.dlY() != null) {
                            if (PbFakeFloorModel.this.mfv.bln() != null && PbFakeFloorModel.this.mfv.bln().bnQ() != null && postData.bnQ() != null && (userId = PbFakeFloorModel.this.mfv.bln().bnQ().getUserId()) != null && userId.equals(postData.bnQ().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.mfy != null) {
                            PbFakeFloorModel.this.mfy.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.mfz);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.mfz);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CR(String str) {
        if (this.mfv == null || this.mfv.bCk() == null || this.mfv.bln() == null || this.mfv.dlY() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bpp = this.mfv.bln().bpp();
        if (bpp) {
            writeData.setVForumId(this.mfv.bCk().getId());
            writeData.setVForumName(this.mfv.bCk().getName());
        } else {
            writeData.setForumName(this.mfv.bCk().getName());
            writeData.setForumId(this.mfv.bCk().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.mfv.dlY().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bpp);
        writeData.setThreadId(this.mfv.bln().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(q qVar) {
        this.mfv = qVar;
    }

    public void dsm() {
        if (!this.mfw) {
            cancelMessage();
            this.mfx = dsn();
            if (this.mfx != null) {
                sendMessage(this.mfx);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.mfv.dlY().y(postData);
            this.mfv.dlY().z(postData);
            this.mfv.dlY().yu(true);
        }
    }

    private SubPbRequestMessage dsn() {
        if (this.mfv == null || this.mfv.bln() == null || this.mfv.bln().getId() == null || this.mfv.dlY() == null || this.mfv.dlY().getId() == null) {
            this.mfw = false;
            return null;
        }
        this.mfw = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.mfv.dlY().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mfv.bln().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBI() {
        dsm();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBJ() {
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

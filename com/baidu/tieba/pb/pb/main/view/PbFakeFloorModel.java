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
    private q mfg;
    private boolean mfh;
    private SubPbRequestMessage mfi;
    private a mfj;
    private com.baidu.adp.framework.listener.a mfk;

    /* loaded from: classes2.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.mfj = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mfg = null;
        this.mfh = false;
        this.mfj = null;
        this.mfk = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.mfh = false;
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
                    if (qVar != null && qVar.dma() != null) {
                        PostData postData = (PostData) y.getItem(qVar.dma(), qVar.dma().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.mfg != null && PbFakeFloorModel.this.mfg.dlR() != null) {
                            if (PbFakeFloorModel.this.mfg.bln() != null && PbFakeFloorModel.this.mfg.bln().bnQ() != null && postData.bnQ() != null && (userId = PbFakeFloorModel.this.mfg.bln().bnQ().getUserId()) != null && userId.equals(postData.bnQ().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.mfj != null) {
                            PbFakeFloorModel.this.mfj.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.mfk);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.mfk);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CT(String str) {
        if (this.mfg == null || this.mfg.bCk() == null || this.mfg.bln() == null || this.mfg.dlR() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bpp = this.mfg.bln().bpp();
        if (bpp) {
            writeData.setVForumId(this.mfg.bCk().getId());
            writeData.setVForumName(this.mfg.bCk().getName());
        } else {
            writeData.setForumName(this.mfg.bCk().getName());
            writeData.setForumId(this.mfg.bCk().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.mfg.dlR().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bpp);
        writeData.setThreadId(this.mfg.bln().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(q qVar) {
        this.mfg = qVar;
    }

    public void dsf() {
        if (!this.mfh) {
            cancelMessage();
            this.mfi = dsg();
            if (this.mfi != null) {
                sendMessage(this.mfi);
            }
        }
    }

    public void u(PostData postData) {
        if (postData != null) {
            this.mfg.dlR().y(postData);
            this.mfg.dlR().z(postData);
            this.mfg.dlR().yu(true);
        }
    }

    private SubPbRequestMessage dsg() {
        if (this.mfg == null || this.mfg.bln() == null || this.mfg.bln().getId() == null || this.mfg.dlR() == null || this.mfg.dlR().getId() == null) {
            this.mfh = false;
            return null;
        }
        this.mfh = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.mfg.dlR().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mfg.bln().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBI() {
        dsf();
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

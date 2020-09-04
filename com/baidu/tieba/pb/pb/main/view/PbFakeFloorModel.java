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
/* loaded from: classes16.dex */
public class PbFakeFloorModel extends DataModel {
    private p kQQ;
    private boolean kQR;
    private SubPbRequestMessage kQS;
    private a kQT;
    private com.baidu.adp.framework.listener.a kQU;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes16.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.kQT = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kQQ = null;
        this.kQR = false;
        this.kQT = null;
        this.kQU = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.kQR = false;
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
                    if (pVar != null && pVar.cWm() != null) {
                        PostData postData = (PostData) y.getItem(pVar.cWm(), pVar.cWm().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.kQQ != null && PbFakeFloorModel.this.kQQ.cWi() != null) {
                            if (PbFakeFloorModel.this.kQQ.bce() != null && PbFakeFloorModel.this.kQQ.bce().beE() != null && postData.beE() != null && (userId = PbFakeFloorModel.this.kQQ.bce().beE().getUserId()) != null && userId.equals(postData.beE().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.kQT != null) {
                            PbFakeFloorModel.this.kQT.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.kQU);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.kQU);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData BV(String str) {
        if (this.kQQ == null || this.kQQ.bst() == null || this.kQQ.bce() == null || this.kQQ.cWi() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean bgb = this.kQQ.bce().bgb();
        if (bgb) {
            writeData.setVForumId(this.kQQ.bst().getId());
            writeData.setVForumName(this.kQQ.bst().getName());
        } else {
            writeData.setForumName(this.kQQ.bst().getName());
            writeData.setForumId(this.kQQ.bst().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.kQQ.cWi().getId());
        writeData.setType(2);
        writeData.setCanNoForum(bgb);
        writeData.setThreadId(this.kQQ.bce().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(p pVar) {
        this.kQQ = pVar;
    }

    public void dcf() {
        if (!this.kQR) {
            cancelMessage();
            this.kQS = dcg();
            if (this.kQS != null) {
                sendMessage(this.kQS);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.kQQ.cWi().w(postData);
            this.kQQ.cWi().x(postData);
            this.kQQ.cWi().wc(true);
        }
    }

    private SubPbRequestMessage dcg() {
        if (this.kQQ == null || this.kQQ.bce() == null || this.kQQ.bce().getId() == null || this.kQQ.cWi() == null || this.kQQ.cWi().getId() == null) {
            this.kQR = false;
            return null;
        }
        this.kQR = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.kQQ.cWi().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kQQ.bce().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean brS() {
        dcf();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String brT() {
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

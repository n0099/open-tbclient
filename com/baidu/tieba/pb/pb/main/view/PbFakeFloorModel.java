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
/* loaded from: classes7.dex */
public class PbFakeFloorModel extends DataModel {
    private m iSh;
    private boolean iSi;
    private SubPbRequestMessage iSj;
    private a iSk;
    private com.baidu.adp.framework.listener.a iSl;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes7.dex */
    public interface a {
        void q(PostData postData);
    }

    public void a(a aVar) {
        this.iSk = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iSh = null;
        this.iSi = false;
        this.iSk = null;
        this.iSl = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.iSi = false;
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
                    if (mVar != null && mVar.cjJ() != null) {
                        PostData postData = (PostData) v.getItem(mVar.cjJ(), mVar.cjJ().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.iSh != null && PbFakeFloorModel.this.iSh.cjF() != null) {
                            if (PbFakeFloorModel.this.iSh.axQ() != null && PbFakeFloorModel.this.iSh.axQ().azX() != null && postData.azX() != null && (userId = PbFakeFloorModel.this.iSh.axQ().azX().getUserId()) != null && userId.equals(postData.azX().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.iSk != null) {
                            PbFakeFloorModel.this.iSk.q(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.iSl);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.iSl);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData uR(String str) {
        if (this.iSh == null || this.iSh.aMO() == null || this.iSh.axQ() == null || this.iSh.cjF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aBr = this.iSh.axQ().aBr();
        if (aBr) {
            writeData.setVForumId(this.iSh.aMO().getId());
            writeData.setVForumName(this.iSh.aMO().getName());
        } else {
            writeData.setForumName(this.iSh.aMO().getName());
            writeData.setForumId(this.iSh.aMO().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.iSh.cjF().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aBr);
        writeData.setThreadId(this.iSh.axQ().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.iSh = mVar;
    }

    public void cpB() {
        if (!this.iSi) {
            cancelMessage();
            this.iSj = cpC();
            if (this.iSj != null) {
                sendMessage(this.iSj);
            }
        }
    }

    public void r(PostData postData) {
        if (postData != null) {
            this.iSh.cjF().u(postData);
            this.iSh.cjF().v(postData);
            this.iSh.cjF().sI(true);
        }
    }

    private SubPbRequestMessage cpC() {
        if (this.iSh == null || this.iSh.axQ() == null || this.iSh.axQ().getId() == null || this.iSh.cjF() == null || this.iSh.cjF().getId() == null) {
            this.iSi = false;
            return null;
        }
        this.iSi = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.iSh.cjF().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.iSh.axQ().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aMp() {
        cpB();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aMq() {
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

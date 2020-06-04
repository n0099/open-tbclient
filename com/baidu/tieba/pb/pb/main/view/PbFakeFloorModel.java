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
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class PbFakeFloorModel extends DataModel {
    private n jYm;
    private boolean jYn;
    private SubPbRequestMessage jYo;
    private a jYp;
    private com.baidu.adp.framework.listener.a jYq;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.jYp = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jYm = null;
        this.jYn = false;
        this.jYp = null;
        this.jYq = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.jYn = false;
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
                    if (nVar != null && nVar.cDw() != null) {
                        PostData postData = (PostData) v.getItem(nVar.cDw(), nVar.cDw().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.jYm != null && PbFakeFloorModel.this.jYm.cDs() != null) {
                            if (PbFakeFloorModel.this.jYm.aOi() != null && PbFakeFloorModel.this.jYm.aOi().aQx() != null && postData.aQx() != null && (userId = PbFakeFloorModel.this.jYm.aOi().aQx().getUserId()) != null && userId.equals(postData.aQx().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.jYp != null) {
                            PbFakeFloorModel.this.jYp.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.jYq);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.jYq);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yf(String str) {
        if (this.jYm == null || this.jYm.bdQ() == null || this.jYm.aOi() == null || this.jYm.cDs() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aRV = this.jYm.aOi().aRV();
        if (aRV) {
            writeData.setVForumId(this.jYm.bdQ().getId());
            writeData.setVForumName(this.jYm.bdQ().getName());
        } else {
            writeData.setForumName(this.jYm.bdQ().getName());
            writeData.setForumId(this.jYm.bdQ().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.jYm.cDs().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aRV);
        writeData.setThreadId(this.jYm.aOi().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.jYm = nVar;
    }

    public void cJj() {
        if (!this.jYn) {
            cancelMessage();
            this.jYo = cJk();
            if (this.jYo != null) {
                sendMessage(this.jYo);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.jYm.cDs().w(postData);
            this.jYm.cDs().x(postData);
            this.jYm.cDs().us(true);
        }
    }

    private SubPbRequestMessage cJk() {
        if (this.jYm == null || this.jYm.aOi() == null || this.jYm.aOi().getId() == null || this.jYm.cDs() == null || this.jYm.cDs().getId() == null) {
            this.jYn = false;
            return null;
        }
        this.jYn = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.jYm.cDs().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jYm.aOi().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bdr() {
        cJj();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bds() {
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

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
    private n jXg;
    private boolean jXh;
    private SubPbRequestMessage jXi;
    private a jXj;
    private com.baidu.adp.framework.listener.a jXk;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes9.dex */
    public interface a {
        void s(PostData postData);
    }

    public void a(a aVar) {
        this.jXj = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jXg = null;
        this.jXh = false;
        this.jXj = null;
        this.jXk = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.jXh = false;
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
                    if (nVar != null && nVar.cDg() != null) {
                        PostData postData = (PostData) v.getItem(nVar.cDg(), nVar.cDg().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.jXg != null && PbFakeFloorModel.this.jXg.cDc() != null) {
                            if (PbFakeFloorModel.this.jXg.aOi() != null && PbFakeFloorModel.this.jXg.aOi().aQx() != null && postData.aQx() != null && (userId = PbFakeFloorModel.this.jXg.aOi().aQx().getUserId()) != null && userId.equals(postData.aQx().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.jXj != null) {
                            PbFakeFloorModel.this.jXj.s(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.jXk);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.jXk);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yf(String str) {
        if (this.jXg == null || this.jXg.bdP() == null || this.jXg.aOi() == null || this.jXg.cDc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aRV = this.jXg.aOi().aRV();
        if (aRV) {
            writeData.setVForumId(this.jXg.bdP().getId());
            writeData.setVForumName(this.jXg.bdP().getName());
        } else {
            writeData.setForumName(this.jXg.bdP().getName());
            writeData.setForumId(this.jXg.bdP().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.jXg.cDc().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aRV);
        writeData.setThreadId(this.jXg.aOi().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.jXg = nVar;
    }

    public void cIT() {
        if (!this.jXh) {
            cancelMessage();
            this.jXi = cIU();
            if (this.jXi != null) {
                sendMessage(this.jXi);
            }
        }
    }

    public void t(PostData postData) {
        if (postData != null) {
            this.jXg.cDc().w(postData);
            this.jXg.cDc().x(postData);
            this.jXg.cDc().us(true);
        }
    }

    private SubPbRequestMessage cIU() {
        if (this.jXg == null || this.jXg.aOi() == null || this.jXg.aOi().getId() == null || this.jXg.cDc() == null || this.jXg.cDc().getId() == null) {
            this.jXh = false;
            return null;
        }
        this.jXh = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = com.baidu.adp.lib.f.b.toLong(this.jXg.cDc().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jXg.aOi().getId(), 0L), j, 0L, 1, equipmentWidth, equipmentHeight, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bdq() {
        cIT();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bdr() {
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

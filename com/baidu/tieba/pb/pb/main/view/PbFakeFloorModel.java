package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private m eYb;
    private boolean eYc;
    private SubPbRequestMessage eYd;
    private a eYe;
    private com.baidu.adp.framework.listener.a eYf;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eYe = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eYb = null;
        this.eYc = false;
        this.eYe = null;
        this.eYf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eYc = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.j.neterror);
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
                    if (mVar != null && mVar.aQC() != null) {
                        PostData postData = (PostData) v.c(mVar.aQC(), mVar.aQC().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eYb != null && PbFakeFloorModel.this.eYb.aQy() != null) {
                            if (PbFakeFloorModel.this.eYb.Np() != null && PbFakeFloorModel.this.eYb.Np().rt() != null && postData.rt() != null && (userId = PbFakeFloorModel.this.eYb.Np().rt().getUserId()) != null && userId.equals(postData.rt().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.eYe != null) {
                            PbFakeFloorModel.this.eYe.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.eYf);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eYf);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fP(String str) {
        if (this.eYb == null || this.eYb.aQF() == null || this.eYb.Np() == null || this.eYb.aQy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sH = this.eYb.Np().sH();
        if (sH) {
            writeData.setVForumId(this.eYb.aQF().getId());
            writeData.setVForumName(this.eYb.aQF().getName());
        } else {
            writeData.setForumName(this.eYb.aQF().getName());
            writeData.setForumId(this.eYb.aQF().getId());
        }
        writeData.setFloor(this.eYb.aQy().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sH);
        writeData.setThreadId(this.eYb.Np().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.eYb = mVar;
    }

    public void aVS() {
        if (!this.eYc) {
            cancelMessage();
            this.eYd = aVT();
            if (this.eYd != null) {
                sendMessage(this.eYd);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eYb.aQy().z(postData);
            this.eYb.aQy().A(postData);
            this.eYb.aQy().mu(true);
        }
    }

    private SubPbRequestMessage aVT() {
        if (this.eYb == null || this.eYb.Np() == null || this.eYb.Np().getId() == null || this.eYb.aQy() == null || this.eYb.aQy().getId() == null) {
            this.eYc = false;
            return null;
        }
        this.eYc = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eYb.aQy().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eYb.Np().getId(), 0L), c, 0L, 1, ac, ae, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Db() {
        aVS();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dc() {
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

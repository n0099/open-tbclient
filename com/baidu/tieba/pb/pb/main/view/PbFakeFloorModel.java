package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
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
    private m eUB;
    private boolean eUC;
    private SubPbRequestMessage eUD;
    private a eUE;
    private com.baidu.adp.framework.listener.a eUF;
    private TbPageContext mF;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eUE = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUB = null;
        this.eUC = false;
        this.eUE = null;
        this.eUF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eUC = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mF.getPageActivity().getResources().getString(d.l.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mF.showToast(errorString);
                        return;
                    }
                    m mVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        mVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (mVar != null && mVar.aPJ() != null) {
                        PostData postData = (PostData) v.c(mVar.aPJ(), mVar.aPJ().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eUB != null && PbFakeFloorModel.this.eUB.aPF() != null) {
                            if (PbFakeFloorModel.this.eUB.MR() != null && PbFakeFloorModel.this.eUB.MR().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.eUB.MR().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mF, z);
                        }
                        if (PbFakeFloorModel.this.eUE != null) {
                            PbFakeFloorModel.this.eUE.l(postData);
                        }
                    }
                }
            }
        };
        this.mF = tbPageContext;
        registerListener(this.eUF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eUF);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eUB == null || this.eUB.aPM() == null || this.eUB.MR() == null || this.eUB.aPF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sN = this.eUB.MR().sN();
        if (sN) {
            writeData.setVForumId(this.eUB.aPM().getId());
            writeData.setVForumName(this.eUB.aPM().getName());
        } else {
            writeData.setForumName(this.eUB.aPM().getName());
            writeData.setForumId(this.eUB.aPM().getId());
        }
        writeData.setFloor(this.eUB.aPF().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sN);
        writeData.setThreadId(this.eUB.MR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.eUB = mVar;
    }

    public void aUp() {
        if (!this.eUC) {
            cancelMessage();
            this.eUD = aUq();
            if (this.eUD != null) {
                sendMessage(this.eUD);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eUB.aPF().z(postData);
            this.eUB.aPF().A(postData);
            this.eUB.aPF().mF(true);
        }
    }

    private SubPbRequestMessage aUq() {
        if (this.eUB == null || this.eUB.MR() == null || this.eUB.MR().getId() == null || this.eUB.aPF() == null || this.eUB.aPF().getId() == null) {
            this.eUC = false;
            return null;
        }
        this.eUC = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ad = k.ad(TbadkCoreApplication.getInst().getApp());
        int ae = k.ae(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eUB.aPF().getId(), 0L);
        return new SubPbRequestMessage(this.mF.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eUB.MR().getId(), 0L), c, 0L, 1, ad, ae, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dp() {
        aUp();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dq() {
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

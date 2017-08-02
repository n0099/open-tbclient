package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private TbPageContext ako;
    private n eSU;
    private boolean eSV;
    private SubPbRequestMessage eSW;
    private a eSX;
    private com.baidu.adp.framework.listener.a eSY;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eSX = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eSU = null;
        this.eSV = false;
        this.eSX = null;
        this.eSY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eSV = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.ako.getPageActivity().getResources().getString(d.l.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.ako.showToast(errorString);
                        return;
                    }
                    n nVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        nVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (nVar != null && nVar.aPK() != null) {
                        PostData postData = (PostData) u.c(nVar.aPK(), nVar.aPK().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eSU != null && PbFakeFloorModel.this.eSU.aPG() != null) {
                            if (PbFakeFloorModel.this.eSU.MA() != null && PbFakeFloorModel.this.eSU.MA().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.eSU.MA().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.ako, z);
                        }
                        if (PbFakeFloorModel.this.eSX != null) {
                            PbFakeFloorModel.this.eSX.l(postData);
                        }
                    }
                }
            }
        };
        this.ako = tbPageContext;
        registerListener(this.eSY);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eSY);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fM(String str) {
        if (this.eSU == null || this.eSU.aPM() == null || this.eSU.MA() == null || this.eSU.aPG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sH = this.eSU.MA().sH();
        if (sH) {
            writeData.setVForumId(this.eSU.aPM().getId());
            writeData.setVForumName(this.eSU.aPM().getName());
        } else {
            writeData.setForumName(this.eSU.aPM().getName());
            writeData.setForumId(this.eSU.aPM().getId());
        }
        writeData.setFloor(this.eSU.aPG().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sH);
        writeData.setThreadId(this.eSU.MA().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.eSU = nVar;
    }

    public void aUs() {
        if (!this.eSV) {
            cancelMessage();
            this.eSW = aUt();
            if (this.eSW != null) {
                sendMessage(this.eSW);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eSU.aPG().z(postData);
            this.eSU.aPG().A(postData);
            this.eSU.aPG().mw(true);
        }
    }

    private SubPbRequestMessage aUt() {
        if (this.eSU == null || this.eSU.MA() == null || this.eSU.MA().getId() == null || this.eSU.aPG() == null || this.eSU.aPG().getId() == null) {
            this.eSV = false;
            return null;
        }
        this.eSV = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = k.af(TbadkCoreApplication.getInst().getApp());
        int ag = k.ag(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eSU.aPG().getId(), 0L);
        return new SubPbRequestMessage(this.ako.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eSU.MA().getId(), 0L), c, 0L, 1, af, ag, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dm() {
        aUs();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dn() {
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

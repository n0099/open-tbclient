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
    private TbPageContext alI;
    private n eUh;
    private boolean eUi;
    private SubPbRequestMessage eUj;
    private a eUk;
    private com.baidu.adp.framework.listener.a eUl;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eUk = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUh = null;
        this.eUi = false;
        this.eUk = null;
        this.eUl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eUi = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.alI.getPageActivity().getResources().getString(d.l.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.alI.showToast(errorString);
                        return;
                    }
                    n nVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        nVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (nVar != null && nVar.aPV() != null) {
                        PostData postData = (PostData) u.c(nVar.aPV(), nVar.aPV().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eUh != null && PbFakeFloorModel.this.eUh.aPR() != null) {
                            if (PbFakeFloorModel.this.eUh.MF() != null && PbFakeFloorModel.this.eUh.MF().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.eUh.MF().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.alI, z);
                        }
                        if (PbFakeFloorModel.this.eUk != null) {
                            PbFakeFloorModel.this.eUk.l(postData);
                        }
                    }
                }
            }
        };
        this.alI = tbPageContext;
        registerListener(this.eUl);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eUl);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eUh == null || this.eUh.aPX() == null || this.eUh.MF() == null || this.eUh.aPR() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sR = this.eUh.MF().sR();
        if (sR) {
            writeData.setVForumId(this.eUh.aPX().getId());
            writeData.setVForumName(this.eUh.aPX().getName());
        } else {
            writeData.setForumName(this.eUh.aPX().getName());
            writeData.setForumId(this.eUh.aPX().getId());
        }
        writeData.setFloor(this.eUh.aPR().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sR);
        writeData.setThreadId(this.eUh.MF().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.eUh = nVar;
    }

    public void aUD() {
        if (!this.eUi) {
            cancelMessage();
            this.eUj = aUE();
            if (this.eUj != null) {
                sendMessage(this.eUj);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eUh.aPR().z(postData);
            this.eUh.aPR().A(postData);
            this.eUh.aPR().mw(true);
        }
    }

    private SubPbRequestMessage aUE() {
        if (this.eUh == null || this.eUh.MF() == null || this.eUh.MF().getId() == null || this.eUh.aPR() == null || this.eUh.aPR().getId() == null) {
            this.eUi = false;
            return null;
        }
        this.eUi = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ag = k.ag(TbadkCoreApplication.getInst().getApp());
        int ah = k.ah(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.eUh.aPR().getId(), 0L);
        return new SubPbRequestMessage(this.alI.getPageActivity(), com.baidu.adp.lib.g.b.d(this.eUh.MF().getId(), 0L), d, 0L, 1, ag, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Du() {
        aUD();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dv() {
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

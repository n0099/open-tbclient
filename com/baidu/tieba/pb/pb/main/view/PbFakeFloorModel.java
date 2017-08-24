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
    private n eWc;
    private boolean eWd;
    private SubPbRequestMessage eWe;
    private a eWf;
    private com.baidu.adp.framework.listener.a eWg;
    private String mPostId;
    private TbPageContext oW;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eWf = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eWc = null;
        this.eWd = false;
        this.eWf = null;
        this.eWg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eWd = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.oW.getPageActivity().getResources().getString(d.l.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.oW.showToast(errorString);
                        return;
                    }
                    n nVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        nVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (nVar != null && nVar.aQx() != null) {
                        PostData postData = (PostData) u.c(nVar.aQx(), nVar.aQx().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eWc != null && PbFakeFloorModel.this.eWc.aQt() != null) {
                            if (PbFakeFloorModel.this.eWc.MF() != null && PbFakeFloorModel.this.eWc.MF().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.eWc.MF().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.oW, z);
                        }
                        if (PbFakeFloorModel.this.eWf != null) {
                            PbFakeFloorModel.this.eWf.l(postData);
                        }
                    }
                }
            }
        };
        this.oW = tbPageContext;
        registerListener(this.eWg);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eWg);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fW(String str) {
        if (this.eWc == null || this.eWc.aQz() == null || this.eWc.MF() == null || this.eWc.aQt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sS = this.eWc.MF().sS();
        if (sS) {
            writeData.setVForumId(this.eWc.aQz().getId());
            writeData.setVForumName(this.eWc.aQz().getName());
        } else {
            writeData.setForumName(this.eWc.aQz().getName());
            writeData.setForumId(this.eWc.aQz().getId());
        }
        writeData.setFloor(this.eWc.aQt().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sS);
        writeData.setThreadId(this.eWc.MF().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.eWc = nVar;
    }

    public void aVf() {
        if (!this.eWd) {
            cancelMessage();
            this.eWe = aVg();
            if (this.eWe != null) {
                sendMessage(this.eWe);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eWc.aQt().z(postData);
            this.eWc.aQt().A(postData);
            this.eWc.aQt().mz(true);
        }
    }

    private SubPbRequestMessage aVg() {
        if (this.eWc == null || this.eWc.MF() == null || this.eWc.MF().getId() == null || this.eWc.aQt() == null || this.eWc.aQt().getId() == null) {
            this.eWd = false;
            return null;
        }
        this.eWd = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ag = k.ag(TbadkCoreApplication.getInst().getApp());
        int ah = k.ah(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.eWc.aQt().getId(), 0L);
        return new SubPbRequestMessage(this.oW.getPageActivity(), com.baidu.adp.lib.g.b.d(this.eWc.MF().getId(), 0L), d, 0L, 1, ag, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Du() {
        aVf();
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

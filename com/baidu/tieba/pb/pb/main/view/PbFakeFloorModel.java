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
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private SubPbRequestMessage fYA;
    private a fYB;
    private com.baidu.adp.framework.listener.a fYC;
    private k fYy;
    private boolean fYz;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fYB = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYy = null;
        this.fYz = false;
        this.fYB = null;
        this.fYC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fYz = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.j.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    k kVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        kVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (kVar != null && kVar.bbh() != null) {
                        PostData postData = (PostData) v.f(kVar.bbh(), kVar.bbh().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fYy != null && PbFakeFloorModel.this.fYy.bbd() != null) {
                            if (PbFakeFloorModel.this.fYy.WE() != null && PbFakeFloorModel.this.fYy.WE().zn() != null && postData.zn() != null && (userId = PbFakeFloorModel.this.fYy.WE().zn().getUserId()) != null && userId.equals(postData.zn().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fYB != null) {
                            PbFakeFloorModel.this.fYB.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fYC);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fYC);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fYy == null || this.fYy.bbk() == null || this.fYy.WE() == null || this.fYy.bbd() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Aw = this.fYy.WE().Aw();
        if (Aw) {
            writeData.setVForumId(this.fYy.bbk().getId());
            writeData.setVForumName(this.fYy.bbk().getName());
        } else {
            writeData.setForumName(this.fYy.bbk().getName());
            writeData.setForumId(this.fYy.bbk().getId());
        }
        writeData.setFloor(this.fYy.bbd().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Aw);
        writeData.setThreadId(this.fYy.WE().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fYy = kVar;
    }

    public void bge() {
        if (!this.fYz) {
            cancelMessage();
            this.fYA = bgf();
            if (this.fYA != null) {
                sendMessage(this.fYA);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fYy.bbd().p(postData);
            this.fYy.bbd().q(postData);
            this.fYy.bbd().mM(true);
        }
    }

    private SubPbRequestMessage bgf() {
        if (this.fYy == null || this.fYy.WE() == null || this.fYy.WE().getId() == null || this.fYy.bbd() == null || this.fYy.bbd().getId() == null) {
            this.fYz = false;
            return null;
        }
        this.fYz = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fYy.bbd().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fYy.WE().getId(), 0L), c, 0L, 1, ao, aq, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lw() {
        bge();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lx() {
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

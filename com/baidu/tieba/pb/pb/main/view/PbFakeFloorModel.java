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
    private k fYt;
    private boolean fYu;
    private SubPbRequestMessage fYv;
    private a fYw;
    private com.baidu.adp.framework.listener.a fYx;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fYw = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYt = null;
        this.fYu = false;
        this.fYw = null;
        this.fYx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fYu = false;
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
                        if (postData != null && PbFakeFloorModel.this.fYt != null && PbFakeFloorModel.this.fYt.bbd() != null) {
                            if (PbFakeFloorModel.this.fYt.WE() != null && PbFakeFloorModel.this.fYt.WE().zn() != null && postData.zn() != null && (userId = PbFakeFloorModel.this.fYt.WE().zn().getUserId()) != null && userId.equals(postData.zn().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fYw != null) {
                            PbFakeFloorModel.this.fYw.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fYx);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fYx);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fYt == null || this.fYt.bbk() == null || this.fYt.WE() == null || this.fYt.bbd() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Aw = this.fYt.WE().Aw();
        if (Aw) {
            writeData.setVForumId(this.fYt.bbk().getId());
            writeData.setVForumName(this.fYt.bbk().getName());
        } else {
            writeData.setForumName(this.fYt.bbk().getName());
            writeData.setForumId(this.fYt.bbk().getId());
        }
        writeData.setFloor(this.fYt.bbd().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Aw);
        writeData.setThreadId(this.fYt.WE().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fYt = kVar;
    }

    public void bge() {
        if (!this.fYu) {
            cancelMessage();
            this.fYv = bgf();
            if (this.fYv != null) {
                sendMessage(this.fYv);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fYt.bbd().p(postData);
            this.fYt.bbd().q(postData);
            this.fYt.bbd().mH(true);
        }
    }

    private SubPbRequestMessage bgf() {
        if (this.fYt == null || this.fYt.WE() == null || this.fYt.WE().getId() == null || this.fYt.bbd() == null || this.fYt.bbd().getId() == null) {
            this.fYu = false;
            return null;
        }
        this.fYu = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fYt.bbd().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fYt.WE().getId(), 0L), c, 0L, 1, ao, aq, f, "", 1);
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

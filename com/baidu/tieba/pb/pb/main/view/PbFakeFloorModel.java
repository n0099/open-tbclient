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
    private k fYi;
    private boolean fYj;
    private SubPbRequestMessage fYk;
    private a fYl;
    private com.baidu.adp.framework.listener.a fYm;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fYl = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYi = null;
        this.fYj = false;
        this.fYl = null;
        this.fYm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fYj = false;
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
                    if (kVar != null && kVar.bbg() != null) {
                        PostData postData = (PostData) v.f(kVar.bbg(), kVar.bbg().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fYi != null && PbFakeFloorModel.this.fYi.bbc() != null) {
                            if (PbFakeFloorModel.this.fYi.WD() != null && PbFakeFloorModel.this.fYi.WD().zn() != null && postData.zn() != null && (userId = PbFakeFloorModel.this.fYi.WD().zn().getUserId()) != null && userId.equals(postData.zn().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fYl != null) {
                            PbFakeFloorModel.this.fYl.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fYm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fYm);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fYi == null || this.fYi.bbj() == null || this.fYi.WD() == null || this.fYi.bbc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Aw = this.fYi.WD().Aw();
        if (Aw) {
            writeData.setVForumId(this.fYi.bbj().getId());
            writeData.setVForumName(this.fYi.bbj().getName());
        } else {
            writeData.setForumName(this.fYi.bbj().getName());
            writeData.setForumId(this.fYi.bbj().getId());
        }
        writeData.setFloor(this.fYi.bbc().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Aw);
        writeData.setThreadId(this.fYi.WD().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fYi = kVar;
    }

    public void bgd() {
        if (!this.fYj) {
            cancelMessage();
            this.fYk = bge();
            if (this.fYk != null) {
                sendMessage(this.fYk);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fYi.bbc().p(postData);
            this.fYi.bbc().q(postData);
            this.fYi.bbc().mH(true);
        }
    }

    private SubPbRequestMessage bge() {
        if (this.fYi == null || this.fYi.WD() == null || this.fYi.WD().getId() == null || this.fYi.bbc() == null || this.fYi.bbc().getId() == null) {
            this.fYj = false;
            return null;
        }
        this.fYj = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fYi.bbc().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fYi.WD().getId(), 0L), c, 0L, 1, ao, aq, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lv() {
        bgd();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lw() {
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

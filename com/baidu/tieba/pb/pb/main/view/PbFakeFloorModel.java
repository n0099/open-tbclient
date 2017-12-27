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
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private m fTm;
    private boolean fTn;
    private SubPbRequestMessage fTo;
    private a fTp;
    private com.baidu.adp.framework.listener.a fTq;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fTp = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fTm = null;
        this.fTn = false;
        this.fTp = null;
        this.fTq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fTn = false;
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
                    if (mVar != null && mVar.aZt() != null) {
                        PostData postData = (PostData) v.f(mVar.aZt(), mVar.aZt().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fTm != null && PbFakeFloorModel.this.fTm.aZp() != null) {
                            if (PbFakeFloorModel.this.fTm.VW() != null && PbFakeFloorModel.this.fTm.VW().yX() != null && postData.yX() != null && (userId = PbFakeFloorModel.this.fTm.VW().yX().getUserId()) != null && userId.equals(postData.yX().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fTp != null) {
                            PbFakeFloorModel.this.fTp.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fTq);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fTq);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fZ(String str) {
        if (this.fTm == null || this.fTm.aZw() == null || this.fTm.VW() == null || this.fTm.aZp() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Ak = this.fTm.VW().Ak();
        if (Ak) {
            writeData.setVForumId(this.fTm.aZw().getId());
            writeData.setVForumName(this.fTm.aZw().getName());
        } else {
            writeData.setForumName(this.fTm.aZw().getName());
            writeData.setForumId(this.fTm.aZw().getId());
        }
        writeData.setFloor(this.fTm.aZp().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Ak);
        writeData.setThreadId(this.fTm.VW().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.fTm = mVar;
    }

    public void bev() {
        if (!this.fTn) {
            cancelMessage();
            this.fTo = bew();
            if (this.fTo != null) {
                sendMessage(this.fTo);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fTm.aZp().y(postData);
            this.fTm.aZp().z(postData);
            this.fTm.aZp().nv(true);
        }
    }

    private SubPbRequestMessage bew() {
        if (this.fTm == null || this.fTm.VW() == null || this.fTm.VW().getId() == null || this.fTm.aZp() == null || this.fTm.aZp().getId() == null) {
            this.fTn = false;
            return null;
        }
        this.fTn = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fTm.aZp().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fTm.VW().getId(), 0L), c, 0L, 1, ao, aq, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KY() {
        bev();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KZ() {
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

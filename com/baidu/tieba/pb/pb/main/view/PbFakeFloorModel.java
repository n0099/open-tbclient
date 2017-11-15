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
    private com.baidu.adp.framework.listener.a eYA;
    private m eYw;
    private boolean eYx;
    private SubPbRequestMessage eYy;
    private a eYz;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eYz = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eYw = null;
        this.eYx = false;
        this.eYz = null;
        this.eYA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eYx = false;
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
                    if (mVar != null && mVar.aQK() != null) {
                        PostData postData = (PostData) v.c(mVar.aQK(), mVar.aQK().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eYw != null && PbFakeFloorModel.this.eYw.aQG() != null) {
                            if (PbFakeFloorModel.this.eYw.NA() != null && PbFakeFloorModel.this.eYw.NA().rt() != null && postData.rt() != null && (userId = PbFakeFloorModel.this.eYw.NA().rt().getUserId()) != null && userId.equals(postData.rt().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.eYz != null) {
                            PbFakeFloorModel.this.eYz.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.eYA);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eYA);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eYw == null || this.eYw.aQN() == null || this.eYw.NA() == null || this.eYw.aQG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sH = this.eYw.NA().sH();
        if (sH) {
            writeData.setVForumId(this.eYw.aQN().getId());
            writeData.setVForumName(this.eYw.aQN().getName());
        } else {
            writeData.setForumName(this.eYw.aQN().getName());
            writeData.setForumId(this.eYw.aQN().getId());
        }
        writeData.setFloor(this.eYw.aQG().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sH);
        writeData.setThreadId(this.eYw.NA().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.eYw = mVar;
    }

    public void aWa() {
        if (!this.eYx) {
            cancelMessage();
            this.eYy = aWb();
            if (this.eYy != null) {
                sendMessage(this.eYy);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eYw.aQG().z(postData);
            this.eYw.aQG().A(postData);
            this.eYw.aQG().mC(true);
        }
    }

    private SubPbRequestMessage aWb() {
        if (this.eYw == null || this.eYw.NA() == null || this.eYw.NA().getId() == null || this.eYw.aQG() == null || this.eYw.aQG().getId() == null) {
            this.eYx = false;
            return null;
        }
        this.eYx = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eYw.aQG().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eYw.NA().getId(), 0L), c, 0L, 1, ac, ae, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dn() {
        aWa();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Do() {
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

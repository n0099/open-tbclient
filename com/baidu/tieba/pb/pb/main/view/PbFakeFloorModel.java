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
    private m eVv;
    private boolean eVw;
    private SubPbRequestMessage eVx;
    private a eVy;
    private com.baidu.adp.framework.listener.a eVz;
    private TbPageContext mF;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eVy = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eVv = null;
        this.eVw = false;
        this.eVy = null;
        this.eVz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.eVw = false;
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
                    if (mVar != null && mVar.aPU() != null) {
                        PostData postData = (PostData) v.c(mVar.aPU(), mVar.aPU().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.eVv != null && PbFakeFloorModel.this.eVv.aPQ() != null) {
                            if (PbFakeFloorModel.this.eVv.MR() != null && PbFakeFloorModel.this.eVv.MR().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.eVv.MR().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mF, z);
                        }
                        if (PbFakeFloorModel.this.eVy != null) {
                            PbFakeFloorModel.this.eVy.l(postData);
                        }
                    }
                }
            }
        };
        this.mF = tbPageContext;
        registerListener(this.eVz);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eVz);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eVv == null || this.eVv.aPX() == null || this.eVv.MR() == null || this.eVv.aPQ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sN = this.eVv.MR().sN();
        if (sN) {
            writeData.setVForumId(this.eVv.aPX().getId());
            writeData.setVForumName(this.eVv.aPX().getName());
        } else {
            writeData.setForumName(this.eVv.aPX().getName());
            writeData.setForumId(this.eVv.aPX().getId());
        }
        writeData.setFloor(this.eVv.aPQ().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sN);
        writeData.setThreadId(this.eVv.MR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.eVv = mVar;
    }

    public void aUA() {
        if (!this.eVw) {
            cancelMessage();
            this.eVx = aUB();
            if (this.eVx != null) {
                sendMessage(this.eVx);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eVv.aPQ().z(postData);
            this.eVv.aPQ().A(postData);
            this.eVv.aPQ().mG(true);
        }
    }

    private SubPbRequestMessage aUB() {
        if (this.eVv == null || this.eVv.MR() == null || this.eVv.MR().getId() == null || this.eVv.aPQ() == null || this.eVv.aPQ().getId() == null) {
            this.eVw = false;
            return null;
        }
        this.eVw = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ae = k.ae(TbadkCoreApplication.getInst().getApp());
        int af = k.af(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eVv.aPQ().getId(), 0L);
        return new SubPbRequestMessage(this.mF.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eVv.MR().getId(), 0L), c, 0L, 1, ae, af, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dp() {
        aUA();
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

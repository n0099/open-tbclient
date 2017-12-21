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
    private m fgq;
    private boolean fgr;
    private SubPbRequestMessage fgs;
    private a fgt;
    private com.baidu.adp.framework.listener.a fgu;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fgt = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fgq = null;
        this.fgr = false;
        this.fgt = null;
        this.fgu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fgr = false;
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
                    if (mVar != null && mVar.aSg() != null) {
                        PostData postData = (PostData) v.c(mVar.aSg(), mVar.aSg().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fgq != null && PbFakeFloorModel.this.fgq.aSc() != null) {
                            if (PbFakeFloorModel.this.fgq.Ox() != null && PbFakeFloorModel.this.fgq.Ox().rv() != null && postData.rv() != null && (userId = PbFakeFloorModel.this.fgq.Ox().rv().getUserId()) != null && userId.equals(postData.rv().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fgt != null) {
                            PbFakeFloorModel.this.fgt.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fgu);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fgu);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.fgq == null || this.fgq.aSj() == null || this.fgq.Ox() == null || this.fgq.aSc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sI = this.fgq.Ox().sI();
        if (sI) {
            writeData.setVForumId(this.fgq.aSj().getId());
            writeData.setVForumName(this.fgq.aSj().getName());
        } else {
            writeData.setForumName(this.fgq.aSj().getName());
            writeData.setForumId(this.fgq.aSj().getId());
        }
        writeData.setFloor(this.fgq.aSc().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sI);
        writeData.setThreadId(this.fgq.Ox().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.fgq = mVar;
    }

    public void aXh() {
        if (!this.fgr) {
            cancelMessage();
            this.fgs = aXi();
            if (this.fgs != null) {
                sendMessage(this.fgs);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fgq.aSc().z(postData);
            this.fgq.aSc().A(postData);
            this.fgq.aSc().nb(true);
        }
    }

    private SubPbRequestMessage aXi() {
        if (this.fgq == null || this.fgq.Ox() == null || this.fgq.Ox().getId() == null || this.fgq.aSc() == null || this.fgq.aSc().getId() == null) {
            this.fgr = false;
            return null;
        }
        this.fgr = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fgq.aSc().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fgq.Ox().getId(), 0L), c, 0L, 1, ac, ae, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dx() {
        aXh();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dy() {
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

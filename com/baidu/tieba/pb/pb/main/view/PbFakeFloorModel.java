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
    private m ffn;
    private boolean ffo;
    private SubPbRequestMessage ffp;
    private a ffq;
    private com.baidu.adp.framework.listener.a ffr;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.ffq = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ffn = null;
        this.ffo = false;
        this.ffq = null;
        this.ffr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ffo = false;
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
                    if (mVar != null && mVar.aRX() != null) {
                        PostData postData = (PostData) v.c(mVar.aRX(), mVar.aRX().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.ffn != null && PbFakeFloorModel.this.ffn.aRT() != null) {
                            if (PbFakeFloorModel.this.ffn.Ox() != null && PbFakeFloorModel.this.ffn.Ox().rx() != null && postData.rx() != null && (userId = PbFakeFloorModel.this.ffn.Ox().rx().getUserId()) != null && userId.equals(postData.rx().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.ffq != null) {
                            PbFakeFloorModel.this.ffq.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.ffr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ffr);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fT(String str) {
        if (this.ffn == null || this.ffn.aSa() == null || this.ffn.Ox() == null || this.ffn.aRT() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sK = this.ffn.Ox().sK();
        if (sK) {
            writeData.setVForumId(this.ffn.aSa().getId());
            writeData.setVForumName(this.ffn.aSa().getName());
        } else {
            writeData.setForumName(this.ffn.aSa().getName());
            writeData.setForumId(this.ffn.aSa().getId());
        }
        writeData.setFloor(this.ffn.aRT().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sK);
        writeData.setThreadId(this.ffn.Ox().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.ffn = mVar;
    }

    public void aWZ() {
        if (!this.ffo) {
            cancelMessage();
            this.ffp = aXa();
            if (this.ffp != null) {
                sendMessage(this.ffp);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.ffn.aRT().z(postData);
            this.ffn.aRT().A(postData);
            this.ffn.aRT().mZ(true);
        }
    }

    private SubPbRequestMessage aXa() {
        if (this.ffn == null || this.ffn.Ox() == null || this.ffn.Ox().getId() == null || this.ffn.aRT() == null || this.ffn.aRT().getId() == null) {
            this.ffo = false;
            return null;
        }
        this.ffo = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.ffn.aRT().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.ffn.Ox().getId(), 0L), c, 0L, 1, ac, ae, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dw() {
        aWZ();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dx() {
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

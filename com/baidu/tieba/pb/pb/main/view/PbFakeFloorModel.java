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
    private m fgl;
    private boolean fgm;
    private SubPbRequestMessage fgn;
    private a fgo;
    private com.baidu.adp.framework.listener.a fgp;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fgo = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fgl = null;
        this.fgm = false;
        this.fgo = null;
        this.fgp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fgm = false;
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
                    if (mVar != null && mVar.aSf() != null) {
                        PostData postData = (PostData) v.c(mVar.aSf(), mVar.aSf().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fgl != null && PbFakeFloorModel.this.fgl.aSb() != null) {
                            if (PbFakeFloorModel.this.fgl.Ox() != null && PbFakeFloorModel.this.fgl.Ox().rv() != null && postData.rv() != null && (userId = PbFakeFloorModel.this.fgl.Ox().rv().getUserId()) != null && userId.equals(postData.rv().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fgo != null) {
                            PbFakeFloorModel.this.fgo.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fgp);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fgp);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.fgl == null || this.fgl.aSi() == null || this.fgl.Ox() == null || this.fgl.aSb() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sI = this.fgl.Ox().sI();
        if (sI) {
            writeData.setVForumId(this.fgl.aSi().getId());
            writeData.setVForumName(this.fgl.aSi().getName());
        } else {
            writeData.setForumName(this.fgl.aSi().getName());
            writeData.setForumId(this.fgl.aSi().getId());
        }
        writeData.setFloor(this.fgl.aSb().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sI);
        writeData.setThreadId(this.fgl.Ox().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.fgl = mVar;
    }

    public void aXg() {
        if (!this.fgm) {
            cancelMessage();
            this.fgn = aXh();
            if (this.fgn != null) {
                sendMessage(this.fgn);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fgl.aSb().z(postData);
            this.fgl.aSb().A(postData);
            this.fgl.aSb().nb(true);
        }
    }

    private SubPbRequestMessage aXh() {
        if (this.fgl == null || this.fgl.Ox() == null || this.fgl.Ox().getId() == null || this.fgl.aSb() == null || this.fgl.aSb().getId() == null) {
            this.fgm = false;
            return null;
        }
        this.fgm = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fgl.aSb().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fgl.Ox().getId(), 0L), c, 0L, 1, ac, ae, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dx() {
        aXg();
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

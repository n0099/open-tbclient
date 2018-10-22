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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class PbFakeFloorModel extends DataModel {
    private j fYp;
    private boolean fYq;
    private SubPbRequestMessage fYr;
    private a fYs;
    private com.baidu.adp.framework.listener.a fYt;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fYs = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYp = null;
        this.fYq = false;
        this.fYs = null;
        this.fYt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fYq = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(e.j.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    j jVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        jVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (jVar != null && jVar.bfG() != null) {
                        PostData postData = (PostData) v.d(jVar.bfG(), jVar.bfG().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fYp != null && PbFakeFloorModel.this.fYp.bfC() != null) {
                            if (PbFakeFloorModel.this.fYp.YB() != null && PbFakeFloorModel.this.fYp.YB().yv() != null && postData.yv() != null && (userId = PbFakeFloorModel.this.fYp.YB().yv().getUserId()) != null && userId.equals(postData.yv().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fYs != null) {
                            PbFakeFloorModel.this.fYs.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fYt);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fYt);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hr(String str) {
        if (this.fYp == null || this.fYp.bfJ() == null || this.fYp.YB() == null || this.fYp.bfC() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean zG = this.fYp.YB().zG();
        if (zG) {
            writeData.setVForumId(this.fYp.bfJ().getId());
            writeData.setVForumName(this.fYp.bfJ().getName());
        } else {
            writeData.setForumName(this.fYp.bfJ().getName());
            writeData.setForumId(this.fYp.bfJ().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.fYp.bfC().getId());
        writeData.setType(2);
        writeData.setCanNoForum(zG);
        writeData.setThreadId(this.fYp.YB().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.fYp = jVar;
    }

    public void bkM() {
        if (!this.fYq) {
            cancelMessage();
            this.fYr = bkN();
            if (this.fYr != null) {
                sendMessage(this.fYr);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fYp.bfC().p(postData);
            this.fYp.bfC().q(postData);
            this.fYp.bfC().nf(true);
        }
    }

    private SubPbRequestMessage bkN() {
        if (this.fYp == null || this.fYp.YB() == null || this.fYp.YB().getId() == null || this.fYp.bfC() == null || this.fYp.bfC().getId() == null) {
            this.fYq = false;
            return null;
        }
        this.fYq = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.fYp.bfC().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.fYp.YB().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lb() {
        bkM();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lc() {
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

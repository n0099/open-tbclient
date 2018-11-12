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
    private j fZO;
    private boolean fZP;
    private SubPbRequestMessage fZQ;
    private a fZR;
    private com.baidu.adp.framework.listener.a fZS;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fZR = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fZO = null;
        this.fZP = false;
        this.fZR = null;
        this.fZS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fZP = false;
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
                    if (jVar != null && jVar.bfe() != null) {
                        PostData postData = (PostData) v.d(jVar.bfe(), jVar.bfe().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fZO != null && PbFakeFloorModel.this.fZO.bfa() != null) {
                            if (PbFakeFloorModel.this.fZO.YL() != null && PbFakeFloorModel.this.fZO.YL().yC() != null && postData.yC() != null && (userId = PbFakeFloorModel.this.fZO.YL().yC().getUserId()) != null && userId.equals(postData.yC().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fZR != null) {
                            PbFakeFloorModel.this.fZR.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fZS);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fZS);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hs(String str) {
        if (this.fZO == null || this.fZO.bfg() == null || this.fZO.YL() == null || this.fZO.bfa() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean zN = this.fZO.YL().zN();
        if (zN) {
            writeData.setVForumId(this.fZO.bfg().getId());
            writeData.setVForumName(this.fZO.bfg().getName());
        } else {
            writeData.setForumName(this.fZO.bfg().getName());
            writeData.setForumId(this.fZO.bfg().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.fZO.bfa().getId());
        writeData.setType(2);
        writeData.setCanNoForum(zN);
        writeData.setThreadId(this.fZO.YL().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.fZO = jVar;
    }

    public void bkj() {
        if (!this.fZP) {
            cancelMessage();
            this.fZQ = bkk();
            if (this.fZQ != null) {
                sendMessage(this.fZQ);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fZO.bfa().p(postData);
            this.fZO.bfa().q(postData);
            this.fZO.bfa().nq(true);
        }
    }

    private SubPbRequestMessage bkk() {
        if (this.fZO == null || this.fZO.YL() == null || this.fZO.YL().getId() == null || this.fZO.bfa() == null || this.fZO.bfa().getId() == null) {
            this.fZP = false;
            return null;
        }
        this.fZP = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.fZO.bfa().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.fZO.YL().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Ln() {
        bkj();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lo() {
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

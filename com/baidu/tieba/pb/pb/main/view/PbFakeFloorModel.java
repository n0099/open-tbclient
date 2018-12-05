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
    private j ggF;
    private boolean ggG;
    private SubPbRequestMessage ggH;
    private a ggI;
    private com.baidu.adp.framework.listener.a ggJ;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.ggI = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ggF = null;
        this.ggG = false;
        this.ggI = null;
        this.ggJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ggG = false;
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
                    if (jVar != null && jVar.bgV() != null) {
                        PostData postData = (PostData) v.d(jVar.bgV(), jVar.bgV().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.ggF != null && PbFakeFloorModel.this.ggF.bgR() != null) {
                            if (PbFakeFloorModel.this.ggF.ZR() != null && PbFakeFloorModel.this.ggF.ZR().zG() != null && postData.zG() != null && (userId = PbFakeFloorModel.this.ggF.ZR().zG().getUserId()) != null && userId.equals(postData.zG().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.ggI != null) {
                            PbFakeFloorModel.this.ggI.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.ggJ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ggJ);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hK(String str) {
        if (this.ggF == null || this.ggF.bgX() == null || this.ggF.ZR() == null || this.ggF.bgR() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean AR = this.ggF.ZR().AR();
        if (AR) {
            writeData.setVForumId(this.ggF.bgX().getId());
            writeData.setVForumName(this.ggF.bgX().getName());
        } else {
            writeData.setForumName(this.ggF.bgX().getName());
            writeData.setForumId(this.ggF.bgX().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.ggF.bgR().getId());
        writeData.setType(2);
        writeData.setCanNoForum(AR);
        writeData.setThreadId(this.ggF.ZR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.ggF = jVar;
    }

    public void bmc() {
        if (!this.ggG) {
            cancelMessage();
            this.ggH = bmd();
            if (this.ggH != null) {
                sendMessage(this.ggH);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.ggF.bgR().p(postData);
            this.ggF.bgR().q(postData);
            this.ggF.bgR().ns(true);
        }
    }

    private SubPbRequestMessage bmd() {
        if (this.ggF == null || this.ggF.ZR() == null || this.ggF.ZR().getId() == null || this.ggF.bgR() == null || this.ggF.bgR().getId() == null) {
            this.ggG = false;
            return null;
        }
        this.ggG = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.ggF.bgR().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.ggF.ZR().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Mr() {
        bmc();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ms() {
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

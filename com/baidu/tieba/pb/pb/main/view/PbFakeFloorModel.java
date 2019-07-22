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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class PbFakeFloorModel extends DataModel {
    private k hYD;
    private boolean hYE;
    private SubPbRequestMessage hYF;
    private a hYG;
    private com.baidu.adp.framework.listener.a hYH;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hYG = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hYD = null;
        this.hYE = false;
        this.hYG = null;
        this.hYH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hYE = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
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
                    if (kVar != null && kVar.bTk() != null) {
                        PostData postData = (PostData) v.c(kVar.bTk(), kVar.bTk().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hYD != null && PbFakeFloorModel.this.hYD.bTg() != null) {
                            if (PbFakeFloorModel.this.hYD.acx() != null && PbFakeFloorModel.this.hYD.acx().aex() != null && postData.aex() != null && (userId = PbFakeFloorModel.this.hYD.acx().aex().getUserId()) != null && userId.equals(postData.aex().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hYG != null) {
                            PbFakeFloorModel.this.hYG.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hYH);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hYH);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qm(String str) {
        if (this.hYD == null || this.hYD.bTm() == null || this.hYD.acx() == null || this.hYD.bTg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean afP = this.hYD.acx().afP();
        if (afP) {
            writeData.setVForumId(this.hYD.bTm().getId());
            writeData.setVForumName(this.hYD.bTm().getName());
        } else {
            writeData.setForumName(this.hYD.bTm().getName());
            writeData.setForumId(this.hYD.bTm().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hYD.bTg().getId());
        writeData.setType(2);
        writeData.setCanNoForum(afP);
        writeData.setThreadId(this.hYD.acx().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.hYD = kVar;
    }

    public void bYy() {
        if (!this.hYE) {
            cancelMessage();
            this.hYF = bYz();
            if (this.hYF != null) {
                sendMessage(this.hYF);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hYD.bTg().r(postData);
            this.hYD.bTg().s(postData);
            this.hYD.bTg().rb(true);
        }
    }

    private SubPbRequestMessage bYz() {
        if (this.hYD == null || this.hYD.acx() == null || this.hYD.acx().getId() == null || this.hYD.bTg() == null || this.hYD.bTg().getId() == null) {
            this.hYE = false;
            return null;
        }
        this.hYE = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.hYD.bTg().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.hYD.acx().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean ast() {
        bYy();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asu() {
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

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
    private boolean hZA;
    private SubPbRequestMessage hZB;
    private a hZC;
    private com.baidu.adp.framework.listener.a hZD;
    private k hZz;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hZC = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hZz = null;
        this.hZA = false;
        this.hZC = null;
        this.hZD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hZA = false;
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
                    if (kVar != null && kVar.bTy() != null) {
                        PostData postData = (PostData) v.c(kVar.bTy(), kVar.bTy().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hZz != null && PbFakeFloorModel.this.hZz.bTu() != null) {
                            if (PbFakeFloorModel.this.hZz.acy() != null && PbFakeFloorModel.this.hZz.acy().aey() != null && postData.aey() != null && (userId = PbFakeFloorModel.this.hZz.acy().aey().getUserId()) != null && userId.equals(postData.aey().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hZC != null) {
                            PbFakeFloorModel.this.hZC.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hZD);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hZD);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qm(String str) {
        if (this.hZz == null || this.hZz.bTA() == null || this.hZz.acy() == null || this.hZz.bTu() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean afQ = this.hZz.acy().afQ();
        if (afQ) {
            writeData.setVForumId(this.hZz.bTA().getId());
            writeData.setVForumName(this.hZz.bTA().getName());
        } else {
            writeData.setForumName(this.hZz.bTA().getName());
            writeData.setForumId(this.hZz.bTA().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hZz.bTu().getId());
        writeData.setType(2);
        writeData.setCanNoForum(afQ);
        writeData.setThreadId(this.hZz.acy().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.hZz = kVar;
    }

    public void bYP() {
        if (!this.hZA) {
            cancelMessage();
            this.hZB = bYQ();
            if (this.hZB != null) {
                sendMessage(this.hZB);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hZz.bTu().r(postData);
            this.hZz.bTu().s(postData);
            this.hZz.bTu().rc(true);
        }
    }

    private SubPbRequestMessage bYQ() {
        if (this.hZz == null || this.hZz.acy() == null || this.hZz.acy().getId() == null || this.hZz.bTu() == null || this.hZz.bTu().getId() == null) {
            this.hZA = false;
            return null;
        }
        this.hZA = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.hZz.bTu().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.hZz.acy().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean asv() {
        bYP();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asw() {
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

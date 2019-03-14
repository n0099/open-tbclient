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
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class PbFakeFloorModel extends DataModel {
    private j hAB;
    private boolean hAC;
    private SubPbRequestMessage hAD;
    private a hAE;
    private com.baidu.adp.framework.listener.a hAF;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hAE = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hAB = null;
        this.hAC = false;
        this.hAE = null;
        this.hAF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hAC = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.j.neterror);
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
                    if (jVar != null && jVar.bIH() != null) {
                        PostData postData = (PostData) v.c(jVar.bIH(), jVar.bIH().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hAB != null && PbFakeFloorModel.this.hAB.bID() != null) {
                            if (PbFakeFloorModel.this.hAB.WR() != null && PbFakeFloorModel.this.hAB.WR().YR() != null && postData.YR() != null && (userId = PbFakeFloorModel.this.hAB.WR().YR().getUserId()) != null && userId.equals(postData.YR().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hAE != null) {
                            PbFakeFloorModel.this.hAE.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hAF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hAF);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hAB == null || this.hAB.bIJ() == null || this.hAB.WR() == null || this.hAB.bID() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aaj = this.hAB.WR().aaj();
        if (aaj) {
            writeData.setVForumId(this.hAB.bIJ().getId());
            writeData.setVForumName(this.hAB.bIJ().getName());
        } else {
            writeData.setForumName(this.hAB.bIJ().getName());
            writeData.setForumId(this.hAB.bIJ().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hAB.bID().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aaj);
        writeData.setThreadId(this.hAB.WR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.hAB = jVar;
    }

    public void bNQ() {
        if (!this.hAC) {
            cancelMessage();
            this.hAD = bNR();
            if (this.hAD != null) {
                sendMessage(this.hAD);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hAB.bID().r(postData);
            this.hAB.bID().s(postData);
            this.hAB.bID().pW(true);
        }
    }

    private SubPbRequestMessage bNR() {
        if (this.hAB == null || this.hAB.WR() == null || this.hAB.WR().getId() == null || this.hAB.bID() == null || this.hAB.bID().getId() == null) {
            this.hAC = false;
            return null;
        }
        this.hAC = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.hAB.bID().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.hAB.WR().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amn() {
        bNQ();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amo() {
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

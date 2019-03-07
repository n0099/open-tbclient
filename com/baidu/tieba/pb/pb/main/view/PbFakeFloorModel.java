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
    private j hAG;
    private boolean hAH;
    private SubPbRequestMessage hAI;
    private a hAJ;
    private com.baidu.adp.framework.listener.a hAK;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hAJ = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hAG = null;
        this.hAH = false;
        this.hAJ = null;
        this.hAK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hAH = false;
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
                        if (postData != null && PbFakeFloorModel.this.hAG != null && PbFakeFloorModel.this.hAG.bID() != null) {
                            if (PbFakeFloorModel.this.hAG.WR() != null && PbFakeFloorModel.this.hAG.WR().YR() != null && postData.YR() != null && (userId = PbFakeFloorModel.this.hAG.WR().YR().getUserId()) != null && userId.equals(postData.YR().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hAJ != null) {
                            PbFakeFloorModel.this.hAJ.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hAK);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hAK);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hAG == null || this.hAG.bIJ() == null || this.hAG.WR() == null || this.hAG.bID() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aaj = this.hAG.WR().aaj();
        if (aaj) {
            writeData.setVForumId(this.hAG.bIJ().getId());
            writeData.setVForumName(this.hAG.bIJ().getName());
        } else {
            writeData.setForumName(this.hAG.bIJ().getName());
            writeData.setForumId(this.hAG.bIJ().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hAG.bID().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aaj);
        writeData.setThreadId(this.hAG.WR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.hAG = jVar;
    }

    public void bNP() {
        if (!this.hAH) {
            cancelMessage();
            this.hAI = bNQ();
            if (this.hAI != null) {
                sendMessage(this.hAI);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hAG.bID().r(postData);
            this.hAG.bID().s(postData);
            this.hAG.bID().pW(true);
        }
    }

    private SubPbRequestMessage bNQ() {
        if (this.hAG == null || this.hAG.WR() == null || this.hAG.WR().getId() == null || this.hAG.bID() == null || this.hAG.bID().getId() == null) {
            this.hAH = false;
            return null;
        }
        this.hAH = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.hAG.bID().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.hAG.WR().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amo() {
        bNP();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amp() {
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

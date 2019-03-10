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
    private j hAH;
    private boolean hAI;
    private SubPbRequestMessage hAJ;
    private a hAK;
    private com.baidu.adp.framework.listener.a hAL;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hAK = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hAH = null;
        this.hAI = false;
        this.hAK = null;
        this.hAL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hAI = false;
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
                    if (jVar != null && jVar.bII() != null) {
                        PostData postData = (PostData) v.c(jVar.bII(), jVar.bII().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hAH != null && PbFakeFloorModel.this.hAH.bIE() != null) {
                            if (PbFakeFloorModel.this.hAH.WR() != null && PbFakeFloorModel.this.hAH.WR().YR() != null && postData.YR() != null && (userId = PbFakeFloorModel.this.hAH.WR().YR().getUserId()) != null && userId.equals(postData.YR().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hAK != null) {
                            PbFakeFloorModel.this.hAK.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hAL);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hAL);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hAH == null || this.hAH.bIK() == null || this.hAH.WR() == null || this.hAH.bIE() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aaj = this.hAH.WR().aaj();
        if (aaj) {
            writeData.setVForumId(this.hAH.bIK().getId());
            writeData.setVForumName(this.hAH.bIK().getName());
        } else {
            writeData.setForumName(this.hAH.bIK().getName());
            writeData.setForumId(this.hAH.bIK().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hAH.bIE().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aaj);
        writeData.setThreadId(this.hAH.WR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.hAH = jVar;
    }

    public void bNQ() {
        if (!this.hAI) {
            cancelMessage();
            this.hAJ = bNR();
            if (this.hAJ != null) {
                sendMessage(this.hAJ);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hAH.bIE().r(postData);
            this.hAH.bIE().s(postData);
            this.hAH.bIE().pW(true);
        }
    }

    private SubPbRequestMessage bNR() {
        if (this.hAH == null || this.hAH.WR() == null || this.hAH.WR().getId() == null || this.hAH.bIE() == null || this.hAH.bIE().getId() == null) {
            this.hAI = false;
            return null;
        }
        this.hAI = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.hAH.bIE().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.hAH.WR().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amo() {
        bNQ();
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

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
    private j hAn;
    private boolean hAo;
    private SubPbRequestMessage hAp;
    private a hAq;
    private com.baidu.adp.framework.listener.a hAr;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hAq = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hAn = null;
        this.hAo = false;
        this.hAq = null;
        this.hAr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hAo = false;
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
                    if (jVar != null && jVar.bIE() != null) {
                        PostData postData = (PostData) v.c(jVar.bIE(), jVar.bIE().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hAn != null && PbFakeFloorModel.this.hAn.bIA() != null) {
                            if (PbFakeFloorModel.this.hAn.WO() != null && PbFakeFloorModel.this.hAn.WO().YO() != null && postData.YO() != null && (userId = PbFakeFloorModel.this.hAn.WO().YO().getUserId()) != null && userId.equals(postData.YO().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hAq != null) {
                            PbFakeFloorModel.this.hAq.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hAr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hAr);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oO(String str) {
        if (this.hAn == null || this.hAn.bIG() == null || this.hAn.WO() == null || this.hAn.bIA() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aag = this.hAn.WO().aag();
        if (aag) {
            writeData.setVForumId(this.hAn.bIG().getId());
            writeData.setVForumName(this.hAn.bIG().getName());
        } else {
            writeData.setForumName(this.hAn.bIG().getName());
            writeData.setForumId(this.hAn.bIG().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hAn.bIA().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aag);
        writeData.setThreadId(this.hAn.WO().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.hAn = jVar;
    }

    public void bNN() {
        if (!this.hAo) {
            cancelMessage();
            this.hAp = bNO();
            if (this.hAp != null) {
                sendMessage(this.hAp);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hAn.bIA().r(postData);
            this.hAn.bIA().s(postData);
            this.hAn.bIA().pW(true);
        }
    }

    private SubPbRequestMessage bNO() {
        if (this.hAn == null || this.hAn.WO() == null || this.hAn.WO().getId() == null || this.hAn.bIA() == null || this.hAn.bIA().getId() == null) {
            this.hAo = false;
            return null;
        }
        this.hAo = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.hAn.bIA().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.hAn.WO().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amk() {
        bNN();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aml() {
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

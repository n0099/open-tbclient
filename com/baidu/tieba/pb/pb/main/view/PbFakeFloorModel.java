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
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private k fsE;
    private boolean fsF;
    private SubPbRequestMessage fsG;
    private a fsH;
    private com.baidu.adp.framework.listener.a fsI;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void k(PostData postData);
    }

    public void a(a aVar) {
        this.fsH = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fsE = null;
        this.fsF = false;
        this.fsH = null;
        this.fsI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fsF = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.k.neterror);
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
                    if (kVar != null && kVar.aWg() != null) {
                        PostData postData = (PostData) v.c(kVar.aWg(), kVar.aWg().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fsE != null && PbFakeFloorModel.this.fsE.aWc() != null) {
                            if (PbFakeFloorModel.this.fsE.Pe() != null && PbFakeFloorModel.this.fsE.Pe().rQ() != null && postData.rQ() != null && (userId = PbFakeFloorModel.this.fsE.Pe().rQ().getUserId()) != null && userId.equals(postData.rQ().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fsH != null) {
                            PbFakeFloorModel.this.fsH.k(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fsI);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fsI);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fsE == null || this.fsE.aWj() == null || this.fsE.Pe() == null || this.fsE.aWc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sY = this.fsE.Pe().sY();
        if (sY) {
            writeData.setVForumId(this.fsE.aWj().getId());
            writeData.setVForumName(this.fsE.aWj().getName());
        } else {
            writeData.setForumName(this.fsE.aWj().getName());
            writeData.setForumId(this.fsE.aWj().getId());
        }
        writeData.setFloor(this.fsE.aWc().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sY);
        writeData.setThreadId(this.fsE.Pe().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fsE = kVar;
    }

    public void bbb() {
        if (!this.fsF) {
            cancelMessage();
            this.fsG = bbc();
            if (this.fsG != null) {
                sendMessage(this.fsG);
            }
        }
    }

    public void l(PostData postData) {
        if (postData != null) {
            this.fsE.aWc().o(postData);
            this.fsE.aWc().p(postData);
            this.fsE.aWc().mo(true);
        }
    }

    private SubPbRequestMessage bbc() {
        if (this.fsE == null || this.fsE.Pe() == null || this.fsE.Pe().getId() == null || this.fsE.aWc() == null || this.fsE.aWc().getId() == null) {
            this.fsF = false;
            return null;
        }
        this.fsF = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fsE.aWc().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fsE.Pe().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DZ() {
        bbb();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ea() {
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

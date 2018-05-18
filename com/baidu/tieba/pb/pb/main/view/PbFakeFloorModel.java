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
    private k ftI;
    private boolean ftJ;
    private SubPbRequestMessage ftK;
    private a ftL;
    private com.baidu.adp.framework.listener.a ftM;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void k(PostData postData);
    }

    public void a(a aVar) {
        this.ftL = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ftI = null;
        this.ftJ = false;
        this.ftL = null;
        this.ftM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ftJ = false;
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
                        if (postData != null && PbFakeFloorModel.this.ftI != null && PbFakeFloorModel.this.ftI.aWc() != null) {
                            if (PbFakeFloorModel.this.ftI.Pb() != null && PbFakeFloorModel.this.ftI.Pb().rP() != null && postData.rP() != null && (userId = PbFakeFloorModel.this.ftI.Pb().rP().getUserId()) != null && userId.equals(postData.rP().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.ftL != null) {
                            PbFakeFloorModel.this.ftL.k(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.ftM);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ftM);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.ftI == null || this.ftI.aWj() == null || this.ftI.Pb() == null || this.ftI.aWc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sX = this.ftI.Pb().sX();
        if (sX) {
            writeData.setVForumId(this.ftI.aWj().getId());
            writeData.setVForumName(this.ftI.aWj().getName());
        } else {
            writeData.setForumName(this.ftI.aWj().getName());
            writeData.setForumId(this.ftI.aWj().getId());
        }
        writeData.setFloor(this.ftI.aWc().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sX);
        writeData.setThreadId(this.ftI.Pb().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.ftI = kVar;
    }

    public void bbb() {
        if (!this.ftJ) {
            cancelMessage();
            this.ftK = bbc();
            if (this.ftK != null) {
                sendMessage(this.ftK);
            }
        }
    }

    public void l(PostData postData) {
        if (postData != null) {
            this.ftI.aWc().o(postData);
            this.ftI.aWc().p(postData);
            this.ftI.aWc().mp(true);
        }
    }

    private SubPbRequestMessage bbc() {
        if (this.ftI == null || this.ftI.Pb() == null || this.ftI.Pb().getId() == null || this.ftI.aWc() == null || this.ftI.aWc().getId() == null) {
            this.ftJ = false;
            return null;
        }
        this.ftJ = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.ftI.aWc().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.ftI.Pb().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DX() {
        bbb();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DY() {
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

package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
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
    private k fEZ;
    private boolean fFa;
    private SubPbRequestMessage fFb;
    private a fFc;
    private com.baidu.adp.framework.listener.a fFd;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void k(PostData postData);
    }

    public void a(a aVar) {
        this.fFc = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fEZ = null;
        this.fFa = false;
        this.fFc = null;
        this.fFd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fFa = false;
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
                    if (kVar != null && kVar.bbc() != null) {
                        PostData postData = (PostData) w.c(kVar.bbc(), kVar.bbc().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fEZ != null && PbFakeFloorModel.this.fEZ.baY() != null) {
                            if (PbFakeFloorModel.this.fEZ.Sz() != null && PbFakeFloorModel.this.fEZ.Sz().vm() != null && postData.vm() != null && (userId = PbFakeFloorModel.this.fEZ.Sz().vm().getUserId()) != null && userId.equals(postData.vm().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fFc != null) {
                            PbFakeFloorModel.this.fFc.k(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fFd);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fFd);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fEZ == null || this.fEZ.bbf() == null || this.fEZ.Sz() == null || this.fEZ.baY() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean wu = this.fEZ.Sz().wu();
        if (wu) {
            writeData.setVForumId(this.fEZ.bbf().getId());
            writeData.setVForumName(this.fEZ.bbf().getName());
        } else {
            writeData.setForumName(this.fEZ.bbf().getName());
            writeData.setForumId(this.fEZ.bbf().getId());
        }
        writeData.setFloor(this.fEZ.baY().getId());
        writeData.setType(2);
        writeData.setCanNoForum(wu);
        writeData.setThreadId(this.fEZ.Sz().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fEZ = kVar;
    }

    public void bga() {
        if (!this.fFa) {
            cancelMessage();
            this.fFb = bgb();
            if (this.fFb != null) {
                sendMessage(this.fFb);
            }
        }
    }

    public void l(PostData postData) {
        if (postData != null) {
            this.fEZ.baY().o(postData);
            this.fEZ.baY().p(postData);
            this.fEZ.baY().mv(true);
        }
    }

    private SubPbRequestMessage bgb() {
        if (this.fEZ == null || this.fEZ.Sz() == null || this.fEZ.Sz().getId() == null || this.fEZ.baY() == null || this.fEZ.baY().getId() == null) {
            this.fFa = false;
            return null;
        }
        this.fFa = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = l.aj(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fEZ.baY().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fEZ.Sz().getId(), 0L), c, 0L, 1, ah, aj, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HA() {
        bga();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HB() {
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

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
    private k fJa;
    private boolean fJb;
    private SubPbRequestMessage fJc;
    private a fJd;
    private com.baidu.adp.framework.listener.a fJe;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void k(PostData postData);
    }

    public void a(a aVar) {
        this.fJd = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJa = null;
        this.fJb = false;
        this.fJd = null;
        this.fJe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fJb = false;
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
                    if (kVar != null && kVar.bbK() != null) {
                        PostData postData = (PostData) w.d(kVar.bbK(), kVar.bbK().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fJa != null && PbFakeFloorModel.this.fJa.bbG() != null) {
                            if (PbFakeFloorModel.this.fJa.SV() != null && PbFakeFloorModel.this.fJa.SV().vw() != null && postData.vw() != null && (userId = PbFakeFloorModel.this.fJa.SV().vw().getUserId()) != null && userId.equals(postData.vw().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fJd != null) {
                            PbFakeFloorModel.this.fJd.k(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fJe);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fJe);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gL(String str) {
        if (this.fJa == null || this.fJa.bbN() == null || this.fJa.SV() == null || this.fJa.bbG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean wE = this.fJa.SV().wE();
        if (wE) {
            writeData.setVForumId(this.fJa.bbN().getId());
            writeData.setVForumName(this.fJa.bbN().getName());
        } else {
            writeData.setForumName(this.fJa.bbN().getName());
            writeData.setForumId(this.fJa.bbN().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.fJa.bbG().getId());
        writeData.setType(2);
        writeData.setCanNoForum(wE);
        writeData.setThreadId(this.fJa.SV().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fJa = kVar;
    }

    public void bgI() {
        if (!this.fJb) {
            cancelMessage();
            this.fJc = bgJ();
            if (this.fJc != null) {
                sendMessage(this.fJc);
            }
        }
    }

    public void l(PostData postData) {
        if (postData != null) {
            this.fJa.bbG().o(postData);
            this.fJa.bbG().p(postData);
            this.fJa.bbG().mG(true);
        }
    }

    private SubPbRequestMessage bgJ() {
        if (this.fJa == null || this.fJa.SV() == null || this.fJa.SV().getId() == null || this.fJa.bbG() == null || this.fJa.bbG().getId() == null) {
            this.fJb = false;
            return null;
        }
        this.fJb = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = l.aj(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fJa.bbG().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fJa.SV().getId(), 0L), c, 0L, 1, ah, aj, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HS() {
        bgI();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HT() {
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

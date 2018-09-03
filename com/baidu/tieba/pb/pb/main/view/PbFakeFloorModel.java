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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private k fJi;
    private boolean fJj;
    private SubPbRequestMessage fJk;
    private a fJl;
    private com.baidu.adp.framework.listener.a fJm;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void k(PostData postData);
    }

    public void a(a aVar) {
        this.fJl = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJi = null;
        this.fJj = false;
        this.fJl = null;
        this.fJm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fJj = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(f.j.neterror);
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
                    if (kVar != null && kVar.aZY() != null) {
                        PostData postData = (PostData) w.d(kVar.aZY(), kVar.aZY().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fJi != null && PbFakeFloorModel.this.fJi.aZU() != null) {
                            if (PbFakeFloorModel.this.fJi.Tg() != null && PbFakeFloorModel.this.fJi.Tg().vj() != null && postData.vj() != null && (userId = PbFakeFloorModel.this.fJi.Tg().vj().getUserId()) != null && userId.equals(postData.vj().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fJl != null) {
                            PbFakeFloorModel.this.fJl.k(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fJm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fJm);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fJi == null || this.fJi.bab() == null || this.fJi.Tg() == null || this.fJi.aZU() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean ws = this.fJi.Tg().ws();
        if (ws) {
            writeData.setVForumId(this.fJi.bab().getId());
            writeData.setVForumName(this.fJi.bab().getName());
        } else {
            writeData.setForumName(this.fJi.bab().getName());
            writeData.setForumId(this.fJi.bab().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.fJi.aZU().getId());
        writeData.setType(2);
        writeData.setCanNoForum(ws);
        writeData.setThreadId(this.fJi.Tg().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fJi = kVar;
    }

    public void beW() {
        if (!this.fJj) {
            cancelMessage();
            this.fJk = beX();
            if (this.fJk != null) {
                sendMessage(this.fJk);
            }
        }
    }

    public void l(PostData postData) {
        if (postData != null) {
            this.fJi.aZU().o(postData);
            this.fJi.aZU().p(postData);
            this.fJi.aZU().mr(true);
        }
    }

    private SubPbRequestMessage beX() {
        if (this.fJi == null || this.fJi.Tg() == null || this.fJi.Tg().getId() == null || this.fJi.aZU() == null || this.fJi.aZU().getId() == null) {
            this.fJj = false;
            return null;
        }
        this.fJj = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = l.aj(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fJi.aZU().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fJi.Tg().getId(), 0L), c, 0L, 1, ah, aj, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HN() {
        beW();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HO() {
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

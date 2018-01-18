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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private m fUM;
    private boolean fUN;
    private SubPbRequestMessage fUO;
    private a fUP;
    private com.baidu.adp.framework.listener.a fUQ;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fUP = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fUM = null;
        this.fUN = false;
        this.fUP = null;
        this.fUQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fUN = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.j.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mPageContext.showToast(errorString);
                        return;
                    }
                    m mVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        mVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (mVar != null && mVar.aZx() != null) {
                        PostData postData = (PostData) v.f(mVar.aZx(), mVar.aZx().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fUM != null && PbFakeFloorModel.this.fUM.aZt() != null) {
                            if (PbFakeFloorModel.this.fUM.VK() != null && PbFakeFloorModel.this.fUM.VK().yS() != null && postData.yS() != null && (userId = PbFakeFloorModel.this.fUM.VK().yS().getUserId()) != null && userId.equals(postData.yS().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fUP != null) {
                            PbFakeFloorModel.this.fUP.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fUQ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fUQ);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ga(String str) {
        if (this.fUM == null || this.fUM.aZA() == null || this.fUM.VK() == null || this.fUM.aZt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Ac = this.fUM.VK().Ac();
        if (Ac) {
            writeData.setVForumId(this.fUM.aZA().getId());
            writeData.setVForumName(this.fUM.aZA().getName());
        } else {
            writeData.setForumName(this.fUM.aZA().getName());
            writeData.setForumId(this.fUM.aZA().getId());
        }
        writeData.setFloor(this.fUM.aZt().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Ac);
        writeData.setThreadId(this.fUM.VK().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.fUM = mVar;
    }

    public void bez() {
        if (!this.fUN) {
            cancelMessage();
            this.fUO = beA();
            if (this.fUO != null) {
                sendMessage(this.fUO);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fUM.aZt().s(postData);
            this.fUM.aZt().t(postData);
            this.fUM.aZt().mx(true);
        }
    }

    private SubPbRequestMessage beA() {
        if (this.fUM == null || this.fUM.VK() == null || this.fUM.VK().getId() == null || this.fUM.aZt() == null || this.fUM.aZt().getId() == null) {
            this.fUN = false;
            return null;
        }
        this.fUN = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fUM.aZt().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fUM.VK().getId(), 0L), c, 0L, 1, ao, aq, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KN() {
        bez();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KO() {
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

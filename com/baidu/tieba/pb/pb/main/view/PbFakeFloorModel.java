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
    private m fVh;
    private boolean fVi;
    private SubPbRequestMessage fVj;
    private a fVk;
    private com.baidu.adp.framework.listener.a fVl;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fVk = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fVh = null;
        this.fVi = false;
        this.fVk = null;
        this.fVl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fVi = false;
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
                    if (mVar != null && mVar.aZC() != null) {
                        PostData postData = (PostData) v.f(mVar.aZC(), mVar.aZC().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fVh != null && PbFakeFloorModel.this.fVh.aZy() != null) {
                            if (PbFakeFloorModel.this.fVh.VM() != null && PbFakeFloorModel.this.fVh.VM().yT() != null && postData.yT() != null && (userId = PbFakeFloorModel.this.fVh.VM().yT().getUserId()) != null && userId.equals(postData.yT().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fVk != null) {
                            PbFakeFloorModel.this.fVk.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fVl);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fVl);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fVh == null || this.fVh.aZF() == null || this.fVh.VM() == null || this.fVh.aZy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Ad = this.fVh.VM().Ad();
        if (Ad) {
            writeData.setVForumId(this.fVh.aZF().getId());
            writeData.setVForumName(this.fVh.aZF().getName());
        } else {
            writeData.setForumName(this.fVh.aZF().getName());
            writeData.setForumId(this.fVh.aZF().getId());
        }
        writeData.setFloor(this.fVh.aZy().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Ad);
        writeData.setThreadId(this.fVh.VM().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.fVh = mVar;
    }

    public void beE() {
        if (!this.fVi) {
            cancelMessage();
            this.fVj = beF();
            if (this.fVj != null) {
                sendMessage(this.fVj);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fVh.aZy().s(postData);
            this.fVh.aZy().t(postData);
            this.fVh.aZy().mA(true);
        }
    }

    private SubPbRequestMessage beF() {
        if (this.fVh == null || this.fVh.VM() == null || this.fVh.VM().getId() == null || this.fVh.aZy() == null || this.fVh.aZy().getId() == null) {
            this.fVi = false;
            return null;
        }
        this.fVi = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fVh.aZy().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fVh.VM().getId(), 0L), c, 0L, 1, ao, aq, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KP() {
        beE();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KQ() {
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

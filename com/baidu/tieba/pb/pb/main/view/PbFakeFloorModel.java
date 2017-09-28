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
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private a ePA;
    private com.baidu.adp.framework.listener.a ePB;
    private m ePx;
    private boolean ePy;
    private SubPbRequestMessage ePz;
    private TbPageContext mG;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void m(PostData postData);
    }

    public void a(a aVar) {
        this.ePA = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ePx = null;
        this.ePy = false;
        this.ePA = null;
        this.ePB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ePy = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mG.getPageActivity().getResources().getString(d.l.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mG.showToast(errorString);
                        return;
                    }
                    m mVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        mVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (mVar != null && mVar.aNO() != null) {
                        PostData postData = (PostData) v.c(mVar.aNO(), mVar.aNO().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.ePx != null && PbFakeFloorModel.this.ePx.aNK() != null) {
                            if (PbFakeFloorModel.this.ePx.Nj() != null && PbFakeFloorModel.this.ePx.Nj().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.ePx.Nj().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mG, z);
                        }
                        if (PbFakeFloorModel.this.ePA != null) {
                            PbFakeFloorModel.this.ePA.m(postData);
                        }
                    }
                }
            }
        };
        this.mG = tbPageContext;
        registerListener(this.ePB);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ePB);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fJ(String str) {
        if (this.ePx == null || this.ePx.aNR() == null || this.ePx.Nj() == null || this.ePx.aNK() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sH = this.ePx.Nj().sH();
        if (sH) {
            writeData.setVForumId(this.ePx.aNR().getId());
            writeData.setVForumName(this.ePx.aNR().getName());
        } else {
            writeData.setForumName(this.ePx.aNR().getName());
            writeData.setForumId(this.ePx.aNR().getId());
        }
        writeData.setFloor(this.ePx.aNK().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sH);
        writeData.setThreadId(this.ePx.Nj().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.ePx = mVar;
    }

    public void aSJ() {
        if (!this.ePy) {
            cancelMessage();
            this.ePz = aSK();
            if (this.ePz != null) {
                sendMessage(this.ePz);
            }
        }
    }

    public void n(PostData postData) {
        if (postData != null) {
            this.ePx.aNK().A(postData);
            this.ePx.aNK().B(postData);
            this.ePx.aNK().mA(true);
        }
    }

    private SubPbRequestMessage aSK() {
        if (this.ePx == null || this.ePx.Nj() == null || this.ePx.Nj().getId() == null || this.ePx.aNK() == null || this.ePx.aNK().getId() == null) {
            this.ePy = false;
            return null;
        }
        this.ePy = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ad = l.ad(TbadkCoreApplication.getInst().getApp());
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.ePx.aNK().getId(), 0L);
        return new SubPbRequestMessage(this.mG.getPageActivity(), com.baidu.adp.lib.g.b.c(this.ePx.Nj().getId(), 0L), c, 0L, 1, ad, af, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CT() {
        aSJ();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CU() {
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

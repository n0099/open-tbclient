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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class PbFakeFloorModel extends DataModel {
    private j gkB;
    private boolean gkC;
    private SubPbRequestMessage gkD;
    private a gkE;
    private com.baidu.adp.framework.listener.a gkF;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.gkE = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gkB = null;
        this.gkC = false;
        this.gkE = null;
        this.gkF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.gkC = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(e.j.neterror);
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
                    if (jVar != null && jVar.bik() != null) {
                        PostData postData = (PostData) v.d(jVar.bik(), jVar.bik().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.gkB != null && PbFakeFloorModel.this.gkB.big() != null) {
                            if (PbFakeFloorModel.this.gkB.aaq() != null && PbFakeFloorModel.this.gkB.aaq().zT() != null && postData.zT() != null && (userId = PbFakeFloorModel.this.gkB.aaq().zT().getUserId()) != null && userId.equals(postData.zT().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.gkE != null) {
                            PbFakeFloorModel.this.gkE.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.gkF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.gkF);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hZ(String str) {
        if (this.gkB == null || this.gkB.bim() == null || this.gkB.aaq() == null || this.gkB.big() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Be = this.gkB.aaq().Be();
        if (Be) {
            writeData.setVForumId(this.gkB.bim().getId());
            writeData.setVForumName(this.gkB.bim().getName());
        } else {
            writeData.setForumName(this.gkB.bim().getName());
            writeData.setForumId(this.gkB.bim().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.gkB.big().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Be);
        writeData.setThreadId(this.gkB.aaq().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.gkB = jVar;
    }

    public void bnv() {
        if (!this.gkC) {
            cancelMessage();
            this.gkD = bnw();
            if (this.gkD != null) {
                sendMessage(this.gkD);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.gkB.big().r(postData);
            this.gkB.big().s(postData);
            this.gkB.big().nw(true);
        }
    }

    private SubPbRequestMessage bnw() {
        if (this.gkB == null || this.gkB.aaq() == null || this.gkB.aaq().getId() == null || this.gkB.big() == null || this.gkB.big().getId() == null) {
            this.gkC = false;
            return null;
        }
        this.gkC = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.gkB.big().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.gkB.aaq().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean MJ() {
        bnv();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String MK() {
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

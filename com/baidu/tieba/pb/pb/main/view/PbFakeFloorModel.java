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
    private j gkC;
    private boolean gkD;
    private SubPbRequestMessage gkE;
    private a gkF;
    private com.baidu.adp.framework.listener.a gkG;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.gkF = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gkC = null;
        this.gkD = false;
        this.gkF = null;
        this.gkG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.gkD = false;
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
                        if (postData != null && PbFakeFloorModel.this.gkC != null && PbFakeFloorModel.this.gkC.big() != null) {
                            if (PbFakeFloorModel.this.gkC.aaq() != null && PbFakeFloorModel.this.gkC.aaq().zT() != null && postData.zT() != null && (userId = PbFakeFloorModel.this.gkC.aaq().zT().getUserId()) != null && userId.equals(postData.zT().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.gkF != null) {
                            PbFakeFloorModel.this.gkF.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.gkG);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.gkG);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hZ(String str) {
        if (this.gkC == null || this.gkC.bim() == null || this.gkC.aaq() == null || this.gkC.big() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean Be = this.gkC.aaq().Be();
        if (Be) {
            writeData.setVForumId(this.gkC.bim().getId());
            writeData.setVForumName(this.gkC.bim().getName());
        } else {
            writeData.setForumName(this.gkC.bim().getName());
            writeData.setForumId(this.gkC.bim().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.gkC.big().getId());
        writeData.setType(2);
        writeData.setCanNoForum(Be);
        writeData.setThreadId(this.gkC.aaq().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.gkC = jVar;
    }

    public void bnv() {
        if (!this.gkD) {
            cancelMessage();
            this.gkE = bnw();
            if (this.gkE != null) {
                sendMessage(this.gkE);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.gkC.big().r(postData);
            this.gkC.big().s(postData);
            this.gkC.big().nw(true);
        }
    }

    private SubPbRequestMessage bnw() {
        if (this.gkC == null || this.gkC.aaq() == null || this.gkC.aaq().getId() == null || this.gkC.big() == null || this.gkC.big().getId() == null) {
            this.gkD = false;
            return null;
        }
        this.gkD = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.gkC.big().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.gkC.aaq().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
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

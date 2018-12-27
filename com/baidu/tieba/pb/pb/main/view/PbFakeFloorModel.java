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
    private SubPbRequestMessage gjA;
    private a gjB;
    private com.baidu.adp.framework.listener.a gjC;
    private j gjy;
    private boolean gjz;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes6.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.gjB = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gjy = null;
        this.gjz = false;
        this.gjB = null;
        this.gjC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.gjz = false;
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
                    if (jVar != null && jVar.bhG() != null) {
                        PostData postData = (PostData) v.d(jVar.bhG(), jVar.bhG().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.gjy != null && PbFakeFloorModel.this.gjy.bhC() != null) {
                            if (PbFakeFloorModel.this.gjy.ZT() != null && PbFakeFloorModel.this.gjy.ZT().zG() != null && postData.zG() != null && (userId = PbFakeFloorModel.this.gjy.ZT().zG().getUserId()) != null && userId.equals(postData.zG().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.gjB != null) {
                            PbFakeFloorModel.this.gjB.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.gjC);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.gjC);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hL(String str) {
        if (this.gjy == null || this.gjy.bhI() == null || this.gjy.ZT() == null || this.gjy.bhC() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean AR = this.gjy.ZT().AR();
        if (AR) {
            writeData.setVForumId(this.gjy.bhI().getId());
            writeData.setVForumName(this.gjy.bhI().getName());
        } else {
            writeData.setForumName(this.gjy.bhI().getName());
            writeData.setForumId(this.gjy.bhI().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.gjy.bhC().getId());
        writeData.setType(2);
        writeData.setCanNoForum(AR);
        writeData.setThreadId(this.gjy.ZT().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.gjy = jVar;
    }

    public void bmN() {
        if (!this.gjz) {
            cancelMessage();
            this.gjA = bmO();
            if (this.gjA != null) {
                sendMessage(this.gjA);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.gjy.bhC().p(postData);
            this.gjy.bhC().q(postData);
            this.gjy.bhC().nv(true);
        }
    }

    private SubPbRequestMessage bmO() {
        if (this.gjy == null || this.gjy.ZT() == null || this.gjy.ZT().getId() == null || this.gjy.bhC() == null || this.gjy.bhC().getId() == null) {
            this.gjz = false;
            return null;
        }
        this.gjz = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.gjy.bhC().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.gjy.ZT().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Ms() {
        bmN();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Mt() {
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

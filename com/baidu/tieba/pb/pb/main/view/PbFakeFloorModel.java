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
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private j fQO;
    private boolean fQP;
    private SubPbRequestMessage fQQ;
    private a fQR;
    private com.baidu.adp.framework.listener.a fQS;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.fQR = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fQO = null;
        this.fQP = false;
        this.fQR = null;
        this.fQS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fQP = false;
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
                    if (jVar != null && jVar.bcu() != null) {
                        PostData postData = (PostData) v.d(jVar.bcu(), jVar.bcu().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fQO != null && PbFakeFloorModel.this.fQO.bcq() != null) {
                            if (PbFakeFloorModel.this.fQO.UT() != null && PbFakeFloorModel.this.fQO.UT().wm() != null && postData.wm() != null && (userId = PbFakeFloorModel.this.fQO.UT().wm().getUserId()) != null && userId.equals(postData.wm().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fQR != null) {
                            PbFakeFloorModel.this.fQR.l(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fQS);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fQS);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hd(String str) {
        if (this.fQO == null || this.fQO.bcx() == null || this.fQO.UT() == null || this.fQO.bcq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean xx = this.fQO.UT().xx();
        if (xx) {
            writeData.setVForumId(this.fQO.bcx().getId());
            writeData.setVForumName(this.fQO.bcx().getName());
        } else {
            writeData.setForumName(this.fQO.bcx().getName());
            writeData.setForumId(this.fQO.bcx().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.fQO.bcq().getId());
        writeData.setType(2);
        writeData.setCanNoForum(xx);
        writeData.setThreadId(this.fQO.UT().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(j jVar) {
        this.fQO = jVar;
    }

    public void bhA() {
        if (!this.fQP) {
            cancelMessage();
            this.fQQ = bhB();
            if (this.fQQ != null) {
                sendMessage(this.fQQ);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.fQO.bcq().p(postData);
            this.fQO.bcq().q(postData);
            this.fQO.bcq().mO(true);
        }
    }

    private SubPbRequestMessage bhB() {
        if (this.fQO == null || this.fQO.UT() == null || this.fQO.UT().getId() == null || this.fQO.bcq() == null || this.fQO.bcq().getId() == null) {
            this.fQP = false;
            return null;
        }
        this.fQP = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long d = com.baidu.adp.lib.g.b.d(this.fQO.bcq().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.d(this.fQO.UT().getId(), 0L), d, 0L, 1, aO, aQ, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Jd() {
        bhA();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Je() {
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

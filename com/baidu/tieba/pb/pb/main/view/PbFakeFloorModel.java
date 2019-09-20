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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class PbFakeFloorModel extends DataModel {
    private com.baidu.adp.framework.listener.a ibA;
    private k ibw;
    private boolean ibx;
    private SubPbRequestMessage iby;
    private a ibz;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.ibz = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ibw = null;
        this.ibx = false;
        this.ibz = null;
        this.ibA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ibx = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(R.string.neterror);
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
                    if (kVar != null && kVar.bUl() != null) {
                        PostData postData = (PostData) v.c(kVar.bUl(), kVar.bUl().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.ibw != null && PbFakeFloorModel.this.ibw.bUh() != null) {
                            if (PbFakeFloorModel.this.ibw.acC() != null && PbFakeFloorModel.this.ibw.acC().aeC() != null && postData.aeC() != null && (userId = PbFakeFloorModel.this.ibw.acC().aeC().getUserId()) != null && userId.equals(postData.aeC().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.ibz != null) {
                            PbFakeFloorModel.this.ibz.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.ibA);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ibA);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qx(String str) {
        if (this.ibw == null || this.ibw.bUn() == null || this.ibw.acC() == null || this.ibw.bUh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean afU = this.ibw.acC().afU();
        if (afU) {
            writeData.setVForumId(this.ibw.bUn().getId());
            writeData.setVForumName(this.ibw.bUn().getName());
        } else {
            writeData.setForumName(this.ibw.bUn().getName());
            writeData.setForumId(this.ibw.bUn().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.ibw.bUh().getId());
        writeData.setType(2);
        writeData.setCanNoForum(afU);
        writeData.setThreadId(this.ibw.acC().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.ibw = kVar;
    }

    public void bZC() {
        if (!this.ibx) {
            cancelMessage();
            this.iby = bZD();
            if (this.iby != null) {
                sendMessage(this.iby);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.ibw.bUh().r(postData);
            this.ibw.bUh().s(postData);
            this.ibw.bUh().rf(true);
        }
    }

    private SubPbRequestMessage bZD() {
        if (this.ibw == null || this.ibw.acC() == null || this.ibw.acC().getId() == null || this.ibw.bUh() == null || this.ibw.bUh().getId() == null) {
            this.ibx = false;
            return null;
        }
        this.ibx = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long e = com.baidu.adp.lib.g.b.e(this.ibw.bUh().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.e(this.ibw.acC().getId(), 0L), e, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean asH() {
        bZC();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asI() {
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

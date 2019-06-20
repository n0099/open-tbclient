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
    private k hSq;
    private boolean hSr;
    private SubPbRequestMessage hSs;
    private a hSt;
    private com.baidu.adp.framework.listener.a hSu;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hSt = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSq = null;
        this.hSr = false;
        this.hSt = null;
        this.hSu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hSr = false;
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
                    if (kVar != null && kVar.bQz() != null) {
                        PostData postData = (PostData) v.c(kVar.bQz(), kVar.bQz().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hSq != null && PbFakeFloorModel.this.hSq.bQv() != null) {
                            if (PbFakeFloorModel.this.hSq.abv() != null && PbFakeFloorModel.this.hSq.abv().adv() != null && postData.adv() != null && (userId = PbFakeFloorModel.this.hSq.abv().adv().getUserId()) != null && userId.equals(postData.adv().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hSt != null) {
                            PbFakeFloorModel.this.hSt.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hSu);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hSu);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pV(String str) {
        if (this.hSq == null || this.hSq.bQB() == null || this.hSq.abv() == null || this.hSq.bQv() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aeN = this.hSq.abv().aeN();
        if (aeN) {
            writeData.setVForumId(this.hSq.bQB().getId());
            writeData.setVForumName(this.hSq.bQB().getName());
        } else {
            writeData.setForumName(this.hSq.bQB().getName());
            writeData.setForumId(this.hSq.bQB().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hSq.bQv().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aeN);
        writeData.setThreadId(this.hSq.abv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.hSq = kVar;
    }

    public void bVK() {
        if (!this.hSr) {
            cancelMessage();
            this.hSs = bVL();
            if (this.hSs != null) {
                sendMessage(this.hSs);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hSq.bQv().r(postData);
            this.hSq.bQv().s(postData);
            this.hSq.bQv().qM(true);
        }
    }

    private SubPbRequestMessage bVL() {
        if (this.hSq == null || this.hSq.abv() == null || this.hSq.abv().getId() == null || this.hSq.bQv() == null || this.hSq.bQv().getId() == null) {
            this.hSr = false;
            return null;
        }
        this.hSr = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.hSq.bQv().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.hSq.abv().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        bVK();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aro() {
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

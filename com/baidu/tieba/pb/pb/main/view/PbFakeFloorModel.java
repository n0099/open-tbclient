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
    private k hSp;
    private boolean hSq;
    private SubPbRequestMessage hSr;
    private a hSs;
    private com.baidu.adp.framework.listener.a hSt;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hSs = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSp = null;
        this.hSq = false;
        this.hSs = null;
        this.hSt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hSq = false;
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
                    if (kVar != null && kVar.bQy() != null) {
                        PostData postData = (PostData) v.c(kVar.bQy(), kVar.bQy().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hSp != null && PbFakeFloorModel.this.hSp.bQu() != null) {
                            if (PbFakeFloorModel.this.hSp.abv() != null && PbFakeFloorModel.this.hSp.abv().adv() != null && postData.adv() != null && (userId = PbFakeFloorModel.this.hSp.abv().adv().getUserId()) != null && userId.equals(postData.adv().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hSs != null) {
                            PbFakeFloorModel.this.hSs.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hSt);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hSt);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pW(String str) {
        if (this.hSp == null || this.hSp.bQA() == null || this.hSp.abv() == null || this.hSp.bQu() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aeN = this.hSp.abv().aeN();
        if (aeN) {
            writeData.setVForumId(this.hSp.bQA().getId());
            writeData.setVForumName(this.hSp.bQA().getName());
        } else {
            writeData.setForumName(this.hSp.bQA().getName());
            writeData.setForumId(this.hSp.bQA().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hSp.bQu().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aeN);
        writeData.setThreadId(this.hSp.abv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.hSp = kVar;
    }

    public void bVJ() {
        if (!this.hSq) {
            cancelMessage();
            this.hSr = bVK();
            if (this.hSr != null) {
                sendMessage(this.hSr);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hSp.bQu().r(postData);
            this.hSp.bQu().s(postData);
            this.hSp.bQu().qL(true);
        }
    }

    private SubPbRequestMessage bVK() {
        if (this.hSp == null || this.hSp.abv() == null || this.hSp.abv().getId() == null || this.hSp.bQu() == null || this.hSp.bQu().getId() == null) {
            this.hSq = false;
            return null;
        }
        this.hSq = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.hSp.bQu().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.hSp.abv().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        bVJ();
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

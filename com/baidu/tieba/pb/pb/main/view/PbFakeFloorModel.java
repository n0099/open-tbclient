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
    private k hSm;
    private boolean hSn;
    private SubPbRequestMessage hSo;
    private a hSp;
    private com.baidu.adp.framework.listener.a hSq;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes4.dex */
    public interface a {
        void n(PostData postData);
    }

    public void a(a aVar) {
        this.hSp = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSm = null;
        this.hSn = false;
        this.hSp = null;
        this.hSq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.hSn = false;
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
                    if (kVar != null && kVar.bQv() != null) {
                        PostData postData = (PostData) v.c(kVar.bQv(), kVar.bQv().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.hSm != null && PbFakeFloorModel.this.hSm.bQr() != null) {
                            if (PbFakeFloorModel.this.hSm.abv() != null && PbFakeFloorModel.this.hSm.abv().adv() != null && postData.adv() != null && (userId = PbFakeFloorModel.this.hSm.abv().adv().getUserId()) != null && userId.equals(postData.adv().getUserId())) {
                                z = true;
                            }
                            postData.a(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.hSp != null) {
                            PbFakeFloorModel.this.hSp.n(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.hSq);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.hSq);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pW(String str) {
        if (this.hSm == null || this.hSm.bQx() == null || this.hSm.abv() == null || this.hSm.bQr() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean aeN = this.hSm.abv().aeN();
        if (aeN) {
            writeData.setVForumId(this.hSm.bQx().getId());
            writeData.setVForumName(this.hSm.bQx().getName());
        } else {
            writeData.setForumName(this.hSm.bQx().getName());
            writeData.setForumId(this.hSm.bQx().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.hSm.bQr().getId());
        writeData.setType(2);
        writeData.setCanNoForum(aeN);
        writeData.setThreadId(this.hSm.abv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.hSm = kVar;
    }

    public void bVG() {
        if (!this.hSn) {
            cancelMessage();
            this.hSo = bVH();
            if (this.hSo != null) {
                sendMessage(this.hSo);
            }
        }
    }

    public void o(PostData postData) {
        if (postData != null) {
            this.hSm.bQr().r(postData);
            this.hSm.bQr().s(postData);
            this.hSm.bQr().qL(true);
        }
    }

    private SubPbRequestMessage bVH() {
        if (this.hSm == null || this.hSm.abv() == null || this.hSm.abv().getId() == null || this.hSm.bQr() == null || this.hSm.bQr().getId() == null) {
            this.hSn = false;
            return null;
        }
        this.hSn = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.hSm.bQr().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.hSm.abv().getId(), 0L), c, 0L, 1, af, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        bVG();
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

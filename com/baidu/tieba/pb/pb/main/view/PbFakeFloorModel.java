package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PbFakeFloorModel extends DataModel {
    private k fJp;
    private boolean fJq;
    private SubPbRequestMessage fJr;
    private a fJs;
    private com.baidu.adp.framework.listener.a fJt;
    private String mFromForumId;
    private TbPageContext mPageContext;
    private String mPostId;

    /* loaded from: classes2.dex */
    public interface a {
        void k(PostData postData);
    }

    public void a(a aVar) {
        this.fJs = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJp = null;
        this.fJq = false;
        this.fJs = null;
        this.fJt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.fJq = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mPageContext.getPageActivity().getResources().getString(d.j.neterror);
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
                    if (kVar != null && kVar.bad() != null) {
                        PostData postData = (PostData) w.d(kVar.bad(), kVar.bad().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.fJp != null && PbFakeFloorModel.this.fJp.aZZ() != null) {
                            if (PbFakeFloorModel.this.fJp.Td() != null && PbFakeFloorModel.this.fJp.Td().vk() != null && postData.vk() != null && (userId = PbFakeFloorModel.this.fJp.Td().vk().getUserId()) != null && userId.equals(postData.vk().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mPageContext, z);
                        }
                        if (PbFakeFloorModel.this.fJs != null) {
                            PbFakeFloorModel.this.fJs.k(postData);
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.fJt);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.fJt);
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fJp == null || this.fJp.bag() == null || this.fJp.Td() == null || this.fJp.aZZ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean wt = this.fJp.Td().wt();
        if (wt) {
            writeData.setVForumId(this.fJp.bag().getId());
            writeData.setVForumName(this.fJp.bag().getName());
        } else {
            writeData.setForumName(this.fJp.bag().getName());
            writeData.setForumId(this.fJp.bag().getId());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.setFloor(this.fJp.aZZ().getId());
        writeData.setType(2);
        writeData.setCanNoForum(wt);
        writeData.setThreadId(this.fJp.Td().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(k kVar) {
        this.fJp = kVar;
    }

    public void bfb() {
        if (!this.fJq) {
            cancelMessage();
            this.fJr = bfc();
            if (this.fJr != null) {
                sendMessage(this.fJr);
            }
        }
    }

    public void l(PostData postData) {
        if (postData != null) {
            this.fJp.aZZ().o(postData);
            this.fJp.aZZ().p(postData);
            this.fJp.aZZ().mr(true);
        }
    }

    private SubPbRequestMessage bfc() {
        if (this.fJp == null || this.fJp.Td() == null || this.fJp.Td().getId() == null || this.fJp.aZZ() == null || this.fJp.aZZ().getId() == null) {
            this.fJq = false;
            return null;
        }
        this.fJq = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = l.aj(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.fJp.aZZ().getId(), 0L);
        return new SubPbRequestMessage(this.mPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(this.fJp.Td().getId(), 0L), c, 0L, 1, ah, aj, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HN() {
        bfb();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HO() {
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

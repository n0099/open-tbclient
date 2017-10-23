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
    private m ePj;
    private boolean ePk;
    private SubPbRequestMessage ePl;
    private a ePm;
    private com.baidu.adp.framework.listener.a ePn;
    private TbPageContext mH;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void m(PostData postData);
    }

    public void a(a aVar) {
        this.ePm = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ePj = null;
        this.ePk = false;
        this.ePm = null;
        this.ePn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String userId;
                String errorString;
                boolean z = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && PbFakeFloorModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    PbFakeFloorModel.this.ePk = false;
                    if (responsedMessage.hasError()) {
                        if (StringUtils.isNull(responsedMessage.getErrorString())) {
                            errorString = PbFakeFloorModel.this.mH.getPageActivity().getResources().getString(d.l.neterror);
                        } else {
                            errorString = responsedMessage.getErrorString();
                        }
                        PbFakeFloorModel.this.mH.showToast(errorString);
                        return;
                    }
                    m mVar = null;
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        mVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                    }
                    if (mVar != null && mVar.aNJ() != null) {
                        PostData postData = (PostData) v.c(mVar.aNJ(), mVar.aNJ().size() - 1);
                        if (postData != null && PbFakeFloorModel.this.ePj != null && PbFakeFloorModel.this.ePj.aNF() != null) {
                            if (PbFakeFloorModel.this.ePj.Nd() != null && PbFakeFloorModel.this.ePj.Nd().getAuthor() != null && postData.getAuthor() != null && (userId = PbFakeFloorModel.this.ePj.Nd().getAuthor().getUserId()) != null && userId.equals(postData.getAuthor().getUserId())) {
                                z = true;
                            }
                            postData.b(PbFakeFloorModel.this.mH, z);
                        }
                        if (PbFakeFloorModel.this.ePm != null) {
                            PbFakeFloorModel.this.ePm.m(postData);
                        }
                    }
                }
            }
        };
        this.mH = tbPageContext;
        registerListener(this.ePn);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.ePn);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fI(String str) {
        if (this.ePj == null || this.ePj.aNM() == null || this.ePj.Nd() == null || this.ePj.aNF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sA = this.ePj.Nd().sA();
        if (sA) {
            writeData.setVForumId(this.ePj.aNM().getId());
            writeData.setVForumName(this.ePj.aNM().getName());
        } else {
            writeData.setForumName(this.ePj.aNM().getName());
            writeData.setForumId(this.ePj.aNM().getId());
        }
        writeData.setFloor(this.ePj.aNF().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sA);
        writeData.setThreadId(this.ePj.Nd().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(m mVar) {
        this.ePj = mVar;
    }

    public void aSE() {
        if (!this.ePk) {
            cancelMessage();
            this.ePl = aSF();
            if (this.ePl != null) {
                sendMessage(this.ePl);
            }
        }
    }

    public void n(PostData postData) {
        if (postData != null) {
            this.ePj.aNF().A(postData);
            this.ePj.aNF().B(postData);
            this.ePj.aNF().mz(true);
        }
    }

    private SubPbRequestMessage aSF() {
        if (this.ePj == null || this.ePj.Nd() == null || this.ePj.Nd().getId() == null || this.ePj.aNF() == null || this.ePj.aNF().getId() == null) {
            this.ePk = false;
            return null;
        }
        this.ePk = true;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ad = l.ad(TbadkCoreApplication.getInst().getApp());
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.ePj.aNF().getId(), 0L);
        return new SubPbRequestMessage(this.mH.getPageActivity(), com.baidu.adp.lib.g.b.c(this.ePj.Nd().getId(), 0L), c, 0L, 1, ad, af, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CN() {
        aSE();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CO() {
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

package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private TbPageContext ajP;
    private com.baidu.tieba.pb.data.n eGs;
    private boolean eGt;
    private SubPbRequestMessage eGu;
    private a eGv;
    private com.baidu.adp.framework.listener.a eGw;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void l(PostData postData);
    }

    public void a(a aVar) {
        this.eGv = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eGs = null;
        this.eGt = false;
        this.eGv = null;
        this.eGw = new e(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.ajP = tbPageContext;
        registerListener(this.eGw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eGw);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fI(String str) {
        if (this.eGs == null || this.eGs.aNj() == null || this.eGs.Mv() == null || this.eGs.aNd() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sC = this.eGs.Mv().sC();
        if (sC) {
            writeData.setVForumId(this.eGs.aNj().getId());
            writeData.setVForumName(this.eGs.aNj().getName());
        } else {
            writeData.setForumName(this.eGs.aNj().getName());
            writeData.setForumId(this.eGs.aNj().getId());
        }
        writeData.setFloor(this.eGs.aNd().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sC);
        writeData.setThreadId(this.eGs.Mv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(com.baidu.tieba.pb.data.n nVar) {
        this.eGs = nVar;
    }

    public void aRv() {
        if (!this.eGt) {
            cancelMessage();
            this.eGu = aRw();
            if (this.eGu != null) {
                sendMessage(this.eGu);
            }
        }
    }

    public void m(PostData postData) {
        if (postData != null) {
            this.eGs.aNd().y(postData);
            this.eGs.aNd().z(postData);
            this.eGs.aNd().lQ(true);
        }
    }

    private SubPbRequestMessage aRw() {
        if (this.eGs == null || this.eGs.Mv() == null || this.eGs.Mv().getId() == null || this.eGs.aNd() == null || this.eGs.aNd().getId() == null) {
            this.eGt = false;
            return null;
        }
        this.eGt = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eGs.aNd().getId(), 0L);
        return new SubPbRequestMessage(this.ajP.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eGs.Mv().getId(), 0L), c, 0L, 1, af, ag, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Da() {
        aRv();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Db() {
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

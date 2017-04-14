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
    private TbPageContext ajT;
    private com.baidu.tieba.pb.data.j erT;
    private boolean erU;
    private SubPbRequestMessage erV;
    private a erW;
    private com.baidu.adp.framework.listener.a erX;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void i(PostData postData);
    }

    public void a(a aVar) {
        this.erW = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.erT = null;
        this.erU = false;
        this.erW = null;
        this.erX = new c(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.ajT = tbPageContext;
        registerListener(this.erX);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.erX);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
        if (this.erT == null || this.erT.aKb() == null || this.erT.Kn() == null || this.erT.aJV() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.erT.aKb().getName());
        writeData.setForumId(this.erT.aKb().getId());
        writeData.setFloor(this.erT.aJV().getId());
        writeData.setType(2);
        writeData.setThreadId(this.erT.Kn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        this.erT = jVar;
    }

    public void aNV() {
        if (!this.erU) {
            cancelMessage();
            this.erV = aNW();
            if (this.erV != null) {
                sendMessage(this.erV);
            }
        }
    }

    public void j(PostData postData) {
        if (postData != null) {
            this.erT.aJV().t(postData);
            this.erT.aJV().u(postData);
            this.erT.aJV().li(true);
        }
    }

    private SubPbRequestMessage aNW() {
        if (this.erT == null || this.erT.Kn() == null || this.erT.Kn().getId() == null || this.erT.aJV() == null || this.erT.aJV().getId() == null) {
            this.erU = false;
            return null;
        }
        this.erU = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.erT.aJV().getId(), 0L);
        return new SubPbRequestMessage(this.ajT.getPageActivity(), com.baidu.adp.lib.g.b.c(this.erT.Kn().getId(), 0L), c, 0L, 1, af, ag, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DI() {
        aNV();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DJ() {
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

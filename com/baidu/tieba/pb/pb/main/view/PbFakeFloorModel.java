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
    private TbPageContext ajU;
    private com.baidu.tieba.pb.data.j eul;
    private boolean eum;
    private SubPbRequestMessage eun;
    private a euo;
    private com.baidu.adp.framework.listener.a eup;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void i(PostData postData);
    }

    public void a(a aVar) {
        this.euo = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eul = null;
        this.eum = false;
        this.euo = null;
        this.eup = new c(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.ajU = tbPageContext;
        registerListener(this.eup);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eup);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
        if (this.eul == null || this.eul.aLc() == null || this.eul.Kn() == null || this.eul.aKW() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eul.aLc().getName());
        writeData.setForumId(this.eul.aLc().getId());
        writeData.setFloor(this.eul.aKW().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eul.Kn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        this.eul = jVar;
    }

    public void aOW() {
        if (!this.eum) {
            cancelMessage();
            this.eun = aOX();
            if (this.eun != null) {
                sendMessage(this.eun);
            }
        }
    }

    public void j(PostData postData) {
        if (postData != null) {
            this.eul.aKW().t(postData);
            this.eul.aKW().u(postData);
            this.eul.aKW().ls(true);
        }
    }

    private SubPbRequestMessage aOX() {
        if (this.eul == null || this.eul.Kn() == null || this.eul.Kn().getId() == null || this.eul.aKW() == null || this.eul.aKW().getId() == null) {
            this.eum = false;
            return null;
        }
        this.eum = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eul.aKW().getId(), 0L);
        return new SubPbRequestMessage(this.ajU.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eul.Kn().getId(), 0L), c, 0L, 1, af, ag, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DI() {
        aOW();
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

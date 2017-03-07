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
    private TbPageContext ajF;
    private com.baidu.tieba.pb.data.j etQ;
    private boolean etR;
    private SubPbRequestMessage etS;
    private a etT;
    private com.baidu.adp.framework.listener.a etU;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void i(PostData postData);
    }

    public void a(a aVar) {
        this.etT = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.etQ = null;
        this.etR = false;
        this.etT = null;
        this.etU = new c(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.ajF = tbPageContext;
        registerListener(this.etU);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.etU);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fn(String str) {
        if (this.etQ == null || this.etQ.aJU() == null || this.etQ.JN() == null || this.etQ.aJO() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.etQ.aJU().getName());
        writeData.setForumId(this.etQ.aJU().getId());
        writeData.setFloor(this.etQ.aJO().getId());
        writeData.setType(2);
        writeData.setThreadId(this.etQ.JN().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        this.etQ = jVar;
    }

    public void aNM() {
        if (!this.etR) {
            cancelMessage();
            this.etS = aNN();
            if (this.etS != null) {
                sendMessage(this.etS);
            }
        }
    }

    public void j(PostData postData) {
        if (postData != null) {
            this.etQ.aJO().t(postData);
            this.etQ.aJO().u(postData);
            this.etQ.aJO().lf(true);
        }
    }

    private SubPbRequestMessage aNN() {
        if (this.etQ == null || this.etQ.JN() == null || this.etQ.JN().getId() == null || this.etQ.aJO() == null || this.etQ.aJO().getId() == null) {
            this.etR = false;
            return null;
        }
        this.etR = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.etQ.aJO().getId(), 0L);
        return new SubPbRequestMessage(this.ajF.getPageActivity(), com.baidu.adp.lib.g.b.c(this.etQ.JN().getId(), 0L), c, 0L, 1, ag, ah, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dk() {
        aNM();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dl() {
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

package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.e.a {
    private TbPageContext GO;
    private com.baidu.adp.framework.listener.a bCL;
    private com.baidu.tieba.pb.data.j ehB;
    private boolean ehC;
    private SubPbRequestMessage ehD;
    private a ehE;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void i(q qVar);
    }

    public void a(a aVar) {
        this.ehE = aVar;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ehB = null;
        this.ehC = false;
        this.ehE = null;
        this.bCL = new d(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.GO = tbPageContext;
        registerListener(this.bCL);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.bCL);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fB(String str) {
        if (this.ehB == null || this.ehB.aIL() == null || this.ehB.IU() == null || this.ehB.aIF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ehB.aIL().getName());
        writeData.setForumId(this.ehB.aIL().getId());
        writeData.setFloor(this.ehB.aIF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ehB.IU().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        this.ehB = jVar;
    }

    public void aMC() {
        if (!this.ehC) {
            cancelMessage();
            this.ehD = aMD();
            if (this.ehD != null) {
                sendMessage(this.ehD);
            }
        }
    }

    public void j(q qVar) {
        if (qVar != null) {
            this.ehB.aIF().t(qVar);
            this.ehB.aIF().u(qVar);
            this.ehB.aIF().kV(true);
        }
    }

    private SubPbRequestMessage aMD() {
        if (this.ehB == null || this.ehB.IU() == null || this.ehB.IU().getId() == null || this.ehB.aIF() == null || this.ehB.aIF().getId() == null) {
            this.ehC = false;
            return null;
        }
        this.ehC = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.h.b.c(this.ehB.aIF().getId(), 0L);
        return new SubPbRequestMessage(this.GO.getPageActivity(), com.baidu.adp.lib.h.b.c(this.ehB.IU().getId(), 0L), c, 0L, 1, I, J, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean CW() {
        aMC();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String CX() {
        return this.mPostId;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}

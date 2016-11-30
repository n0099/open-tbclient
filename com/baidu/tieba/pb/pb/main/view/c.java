package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.e.a {
    private TbPageContext GO;
    private com.baidu.adp.framework.listener.a bWB;
    private n eDA;
    private boolean eDB;
    private SubPbRequestMessage eDC;
    private a eDD;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void i(q qVar);
    }

    public void a(a aVar) {
        this.eDD = aVar;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eDA = null;
        this.eDB = false;
        this.eDD = null;
        this.bWB = new d(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.GO = tbPageContext;
        registerListener(this.bWB);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.bWB);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fF(String str) {
        if (this.eDA == null || this.eDA.aOM() == null || this.eDA.Jz() == null || this.eDA.aOG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eDA.aOM().getName());
        writeData.setForumId(this.eDA.aOM().getId());
        writeData.setFloor(this.eDA.aOG().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eDA.Jz().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void c(n nVar) {
        this.eDA = nVar;
    }

    public void aSL() {
        if (!this.eDB) {
            cancelMessage();
            this.eDC = aSM();
            if (this.eDC != null) {
                sendMessage(this.eDC);
            }
        }
    }

    public void j(q qVar) {
        if (qVar != null) {
            this.eDA.aOG().t(qVar);
            this.eDA.aOG().u(qVar);
            this.eDA.aOG().ll(true);
        }
    }

    private SubPbRequestMessage aSM() {
        if (this.eDA == null || this.eDA.Jz() == null || this.eDA.Jz().getId() == null || this.eDA.aOG() == null || this.eDA.aOG().getId() == null) {
            this.eDB = false;
            return null;
        }
        this.eDB = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.h.b.c(this.eDA.aOG().getId(), 0L);
        return new SubPbRequestMessage(this.GO.getPageActivity(), com.baidu.adp.lib.h.b.c(this.eDA.Jz().getId(), 0L), c, 0L, 1, K, L, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean Dn() {
        aSL();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String Do() {
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

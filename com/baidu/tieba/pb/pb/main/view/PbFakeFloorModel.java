package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private TbPageContext FY;
    private com.baidu.tieba.pb.data.j eqJ;
    private boolean eqK;
    private SubPbRequestMessage eqL;
    private a eqM;
    private com.baidu.adp.framework.listener.a eqN;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void h(p pVar);
    }

    public void a(a aVar) {
        this.eqM = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eqJ = null;
        this.eqK = false;
        this.eqM = null;
        this.eqN = new c(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.FY = tbPageContext;
        registerListener(this.eqN);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.eqN);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fy(String str) {
        if (this.eqJ == null || this.eqJ.aKC() == null || this.eqJ.Ji() == null || this.eqJ.aKw() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eqJ.aKC().getName());
        writeData.setForumId(this.eqJ.aKC().getId());
        writeData.setFloor(this.eqJ.aKw().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eqJ.Ji().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        this.eqJ = jVar;
    }

    public void aOu() {
        if (!this.eqK) {
            cancelMessage();
            this.eqL = aOv();
            if (this.eqL != null) {
                sendMessage(this.eqL);
            }
        }
    }

    public void i(p pVar) {
        if (pVar != null) {
            this.eqJ.aKw().s(pVar);
            this.eqJ.aKw().t(pVar);
            this.eqJ.aKw().lh(true);
        }
    }

    private SubPbRequestMessage aOv() {
        if (this.eqJ == null || this.eqJ.Ji() == null || this.eqJ.Ji().getId() == null || this.eqJ.aKw() == null || this.eqJ.aKw().getId() == null) {
            this.eqK = false;
            return null;
        }
        this.eqK = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.eqJ.aKw().getId(), 0L);
        return new SubPbRequestMessage(this.FY.getPageActivity(), com.baidu.adp.lib.g.b.c(this.eqJ.Ji().getId(), 0L), c, 0L, 1, I, J, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CR() {
        aOu();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CS() {
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

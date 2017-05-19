package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private TbPageContext ajr;
    private l epO;
    private boolean epP;
    private SubPbRequestMessage epQ;
    private a epR;
    private com.baidu.adp.framework.listener.a epS;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void j(PostData postData);
    }

    public void a(a aVar) {
        this.epR = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.epO = null;
        this.epP = false;
        this.epR = null;
        this.epS = new c(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.ajr = tbPageContext;
        registerListener(this.epS);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.epS);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fq(String str) {
        if (this.epO == null || this.epO.aIx() == null || this.epO.JB() == null || this.epO.aIr() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sG = this.epO.JB().sG();
        if (sG) {
            writeData.setVForumId(this.epO.aIx().getId());
            writeData.setVForumName(this.epO.aIx().getName());
        } else {
            writeData.setForumName(this.epO.aIx().getName());
            writeData.setForumId(this.epO.aIx().getId());
        }
        writeData.setFloor(this.epO.aIr().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sG);
        writeData.setThreadId(this.epO.JB().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(l lVar) {
        this.epO = lVar;
    }

    public void aMl() {
        if (!this.epP) {
            cancelMessage();
            this.epQ = aMm();
            if (this.epQ != null) {
                sendMessage(this.epQ);
            }
        }
    }

    public void k(PostData postData) {
        if (postData != null) {
            this.epO.aIr().v(postData);
            this.epO.aIr().w(postData);
            this.epO.aIr().kW(true);
        }
    }

    private SubPbRequestMessage aMm() {
        if (this.epO == null || this.epO.JB() == null || this.epO.JB().getId() == null || this.epO.aIr() == null || this.epO.aIr().getId() == null) {
            this.epP = false;
            return null;
        }
        this.epP = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.epO.aIr().getId(), 0L);
        return new SubPbRequestMessage(this.ajr.getPageActivity(), com.baidu.adp.lib.g.b.c(this.epO.JB().getId(), 0L), c, 0L, 1, af, ag, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CM() {
        aMl();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CN() {
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

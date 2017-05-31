package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class PbFakeFloorModel extends DataModel {
    private TbPageContext ajh;
    private n ewW;
    private boolean ewX;
    private SubPbRequestMessage ewY;
    private a ewZ;
    private com.baidu.adp.framework.listener.a exa;
    private String mPostId;

    /* loaded from: classes.dex */
    public interface a {
        void j(PostData postData);
    }

    public void a(a aVar) {
        this.ewZ = aVar;
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ewW = null;
        this.ewX = false;
        this.ewZ = null;
        this.exa = new e(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.ajh = tbPageContext;
        registerListener(this.exa);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.exa);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fo(String str) {
        if (this.ewW == null || this.ewW.aJp() == null || this.ewW.LH() == null || this.ewW.aJj() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean sE = this.ewW.LH().sE();
        if (sE) {
            writeData.setVForumId(this.ewW.aJp().getId());
            writeData.setVForumName(this.ewW.aJp().getName());
        } else {
            writeData.setForumName(this.ewW.aJp().getName());
            writeData.setForumId(this.ewW.aJp().getId());
        }
        writeData.setFloor(this.ewW.aJj().getId());
        writeData.setType(2);
        writeData.setCanNoForum(sE);
        writeData.setThreadId(this.ewW.LH().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void d(n nVar) {
        this.ewW = nVar;
    }

    public void aNv() {
        if (!this.ewX) {
            cancelMessage();
            this.ewY = aNw();
            if (this.ewY != null) {
                sendMessage(this.ewY);
            }
        }
    }

    public void k(PostData postData) {
        if (postData != null) {
            this.ewW.aJj().w(postData);
            this.ewW.aJj().x(postData);
            this.ewW.aJj().lr(true);
        }
    }

    private SubPbRequestMessage aNw() {
        if (this.ewW == null || this.ewW.LH() == null || this.ewW.LH().getId() == null || this.ewW.aJj() == null || this.ewW.aJj().getId() == null) {
            this.ewX = false;
            return null;
        }
        this.ewX = true;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        long c = com.baidu.adp.lib.g.b.c(this.ewW.aJj().getId(), 0L);
        return new SubPbRequestMessage(this.ajh.getPageActivity(), com.baidu.adp.lib.g.b.c(this.ewW.LH().getId(), 0L), c, 0L, 1, af, ag, f, "", 1);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CG() {
        aNv();
        return true;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CH() {
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

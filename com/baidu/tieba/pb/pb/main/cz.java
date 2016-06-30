package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class cz {
    private BaseActivity bkc;
    private dg dOf;
    private boolean dQD = false;
    private final CustomMessageListener dQE = new da(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener dQF = new db(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public cz(dg dgVar, BaseActivity baseActivity) {
        this.dOf = dgVar;
        this.bkc = baseActivity;
        this.bkc.registerListener(this.dQE);
        this.bkc.registerListener(this.dQF);
    }

    public boolean aFu() {
        return (this.dOf == null || this.dOf.getPbData() == null || this.dOf.getPbData().aDL() == null || this.dOf.getPbData().getPage() == null || !this.dOf.aFM() || this.dOf.getPbData().aDL().pm() || !aFz() || com.baidu.tbadk.core.util.y.s(this.dOf.getPbData().aDL().getItems()) == 0 || this.dOf.getPbData().getPage().pE() != 0 || this.dOf.getPbData().getPage().pz() < 4 || this.dOf.getPbData().aDL().po()) ? false : true;
    }

    public boolean aFv() {
        return (this.dOf == null || this.dOf.getPbData() == null || this.dOf.getPbData().aDL() == null || this.dOf.getPbData().getPage() == null || !this.dOf.aFM() || this.dOf.getPbData().aDL().pm() || !aFz() || com.baidu.tbadk.core.util.y.s(this.dOf.getPbData().aDL().getItems()) == 0 || this.dOf.getPbData().getPage().pC() != 2 || this.dOf.getPbData().aDL().pn()) ? false : true;
    }

    public void aFw() {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDL() != null) {
            this.dOf.getPbData().aDL().ak(true);
        }
    }

    public void aFx() {
        if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDL() != null) {
            this.dOf.getPbData().aDL().aj(true);
        }
    }

    public com.baidu.tbadk.core.data.x aFy() {
        if (!aFz() || this.dOf == null || this.dOf.getPbData() == null) {
            return null;
        }
        return this.dOf.getPbData().aDL();
    }

    public boolean aFz() {
        return com.baidu.tieba.graffiti.d.aet() && aFA();
    }

    private boolean aFA() {
        if (this.dOf == null || this.dOf.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(this.dOf.getPbData().aDP(), 0);
        return sVar != null && (sVar.getType() == com.baidu.tieba.tbadkCore.data.s.eXE || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.Qh || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.eXH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aFB() {
        if (com.baidu.tieba.graffiti.d.aet() && !this.dQD) {
            this.dQD = true;
            int i = com.baidu.tbadk.core.sharedPref.b.sO().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.sO().putInt("graffiti_tips_show_config", i + 1);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.dOf != null && this.dOf.getPbData() != null && this.dOf.getPbData().aDL() != null && str.equals(this.dOf.getThreadID())) {
                this.dOf.getPbData().aDL().ai(true);
            }
        }
    }
}

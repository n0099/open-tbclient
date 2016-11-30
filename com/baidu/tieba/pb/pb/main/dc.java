package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class dc {
    private BaseActivity aTb;
    private dj euf;
    private boolean ewM = false;
    private final CustomMessageListener ewN = new dd(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener ewO = new de(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public dc(dj djVar, BaseActivity baseActivity) {
        this.euf = djVar;
        this.aTb = baseActivity;
        this.aTb.registerListener(this.ewN);
        this.aTb.registerListener(this.ewO);
    }

    public boolean aPX() {
        return (this.euf == null || this.euf.getPbData() == null || this.euf.getPbData().aOi() == null || this.euf.getPbData().getPage() == null || !this.euf.aQp() || this.euf.getPbData().aOi().ql() || !aQc() || com.baidu.tbadk.core.util.x.s(this.euf.getPbData().aOi().getItems()) == 0 || this.euf.getPbData().getPage().qD() != 0 || this.euf.getPbData().getPage().qy() < 4 || this.euf.getPbData().aOi().qn()) ? false : true;
    }

    public boolean aPY() {
        return (this.euf == null || this.euf.getPbData() == null || this.euf.getPbData().aOi() == null || this.euf.getPbData().getPage() == null || !this.euf.aQp() || this.euf.getPbData().aOi().ql() || !aQc() || com.baidu.tbadk.core.util.x.s(this.euf.getPbData().aOi().getItems()) == 0 || this.euf.getPbData().getPage().qB() != 2 || this.euf.getPbData().aOi().qm()) ? false : true;
    }

    public void aPZ() {
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOi() != null) {
            this.euf.getPbData().aOi().aq(true);
        }
    }

    public void aQa() {
        if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOi() != null) {
            this.euf.getPbData().aOi().ap(true);
        }
    }

    public com.baidu.tbadk.core.data.af aQb() {
        if (!aQc() || this.euf == null || this.euf.getPbData() == null) {
            return null;
        }
        return this.euf.getPbData().aOi();
    }

    public boolean aQc() {
        return com.baidu.tieba.graffiti.d.alQ() && aQd();
    }

    private boolean aQd() {
        if (this.euf == null || this.euf.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(this.euf.getPbData().aOm(), 0);
        return qVar != null && (qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fCr || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.TP || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fCt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aQe() {
        if (com.baidu.tieba.graffiti.d.alQ() && !this.ewM) {
            this.ewM = true;
            int i = com.baidu.tbadk.core.sharedPref.b.um().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.um().putInt("graffiti_tips_show_config", i + 1);
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
            if (this.euf != null && this.euf.getPbData() != null && this.euf.getPbData().aOi() != null && str.equals(this.euf.getThreadID())) {
                this.euf.getPbData().aOi().ao(true);
            }
        }
    }
}

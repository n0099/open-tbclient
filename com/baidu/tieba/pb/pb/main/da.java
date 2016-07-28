package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class da {
    private BaseActivity bem;
    private dh eas;
    private boolean ecS = false;
    private final CustomMessageListener ecT = new db(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener ecU = new dc(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public da(dh dhVar, BaseActivity baseActivity) {
        this.eas = dhVar;
        this.bem = baseActivity;
        this.bem.registerListener(this.ecT);
        this.bem.registerListener(this.ecU);
    }

    public boolean aIF() {
        return (this.eas == null || this.eas.getPbData() == null || this.eas.getPbData().aGV() == null || this.eas.getPbData().getPage() == null || !this.eas.aIX() || this.eas.getPbData().aGV().oV() || !aIK() || com.baidu.tbadk.core.util.y.s(this.eas.getPbData().aGV().getItems()) == 0 || this.eas.getPbData().getPage().pn() != 0 || this.eas.getPbData().getPage().pi() < 4 || this.eas.getPbData().aGV().oX()) ? false : true;
    }

    public boolean aIG() {
        return (this.eas == null || this.eas.getPbData() == null || this.eas.getPbData().aGV() == null || this.eas.getPbData().getPage() == null || !this.eas.aIX() || this.eas.getPbData().aGV().oV() || !aIK() || com.baidu.tbadk.core.util.y.s(this.eas.getPbData().aGV().getItems()) == 0 || this.eas.getPbData().getPage().pl() != 2 || this.eas.getPbData().aGV().oW()) ? false : true;
    }

    public void aIH() {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGV() != null) {
            this.eas.getPbData().aGV().am(true);
        }
    }

    public void aII() {
        if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGV() != null) {
            this.eas.getPbData().aGV().al(true);
        }
    }

    public com.baidu.tbadk.core.data.aa aIJ() {
        if (!aIK() || this.eas == null || this.eas.getPbData() == null) {
            return null;
        }
        return this.eas.getPbData().aGV();
    }

    public boolean aIK() {
        return com.baidu.tieba.graffiti.d.aeW() && aIL();
    }

    private boolean aIL() {
        if (this.eas == null || this.eas.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(this.eas.getPbData().aGZ(), 0);
        return sVar != null && (sVar.getType() == com.baidu.tieba.tbadkCore.data.s.fkG || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.QC || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.fkJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aIM() {
        if (com.baidu.tieba.graffiti.d.aeW() && !this.ecS) {
            this.ecS = true;
            int i = com.baidu.tbadk.core.sharedPref.b.sN().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.sN().putInt("graffiti_tips_show_config", i + 1);
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
            if (this.eas != null && this.eas.getPbData() != null && this.eas.getPbData().aGV() != null && str.equals(this.eas.getThreadID())) {
                this.eas.getPbData().aGV().ak(true);
            }
        }
    }
}

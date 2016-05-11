package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class cp {
    private BaseActivity bek;
    private cw dih;
    private boolean dkM = false;
    private final CustomMessageListener dkN = new cq(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener dkO = new cr(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public cp(cw cwVar, BaseActivity baseActivity) {
        this.dih = cwVar;
        this.bek = baseActivity;
        this.bek.registerListener(this.dkN);
        this.bek.registerListener(this.dkO);
    }

    public boolean axj() {
        return (this.dih == null || this.dih.getPbData() == null || this.dih.getPbData().avy() == null || this.dih.getPbData().getPage() == null || !this.dih.axB() || this.dih.getPbData().avy().pt() || !axo() || com.baidu.tbadk.core.util.y.r(this.dih.getPbData().avy().getItems()) == 0 || this.dih.getPbData().getPage().pK() != 0 || this.dih.getPbData().getPage().pF() < 4 || this.dih.getPbData().avy().pv()) ? false : true;
    }

    public boolean axk() {
        return (this.dih == null || this.dih.getPbData() == null || this.dih.getPbData().avy() == null || this.dih.getPbData().getPage() == null || !this.dih.axB() || this.dih.getPbData().avy().pt() || !axo() || com.baidu.tbadk.core.util.y.r(this.dih.getPbData().avy().getItems()) == 0 || this.dih.getPbData().getPage().pI() != 2 || this.dih.getPbData().avy().pu()) ? false : true;
    }

    public void axl() {
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avy() != null) {
            this.dih.getPbData().avy().am(true);
        }
    }

    public void axm() {
        if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avy() != null) {
            this.dih.getPbData().avy().al(true);
        }
    }

    public com.baidu.tbadk.core.data.v axn() {
        if (!axo() || this.dih == null || this.dih.getPbData() == null) {
            return null;
        }
        return this.dih.getPbData().avy();
    }

    public boolean axo() {
        return com.baidu.tieba.graffiti.d.XZ() && axp();
    }

    private boolean axp() {
        if (this.dih == null || this.dih.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(this.dih.getPbData().avC(), 0);
        return sVar != null && (sVar.getType() == com.baidu.tieba.tbadkCore.data.s.esQ || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.PV || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.esT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean axq() {
        if (com.baidu.tieba.graffiti.d.XZ() && !this.dkM) {
            this.dkM = true;
            int i = com.baidu.tbadk.core.sharedPref.b.sQ().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.sQ().putInt("graffiti_tips_show_config", i + 1);
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
            if (this.dih != null && this.dih.getPbData() != null && this.dih.getPbData().avy() != null && str.equals(this.dih.getThreadID())) {
                this.dih.getPbData().avy().ak(true);
            }
        }
    }
}

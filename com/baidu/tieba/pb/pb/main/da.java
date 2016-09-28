package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class da {
    private BaseActivity aRd;
    private dh eov;
    private boolean eqV = false;
    private final CustomMessageListener eqW = new db(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener eqX = new dc(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public da(dh dhVar, BaseActivity baseActivity) {
        this.eov = dhVar;
        this.aRd = baseActivity;
        this.aRd.registerListener(this.eqW);
        this.aRd.registerListener(this.eqX);
    }

    public boolean aOe() {
        return (this.eov == null || this.eov.getPbData() == null || this.eov.getPbData().aMp() == null || this.eov.getPbData().getPage() == null || !this.eov.aOw() || this.eov.getPbData().aMp().qj() || !aOj() || com.baidu.tbadk.core.util.y.s(this.eov.getPbData().aMp().getItems()) == 0 || this.eov.getPbData().getPage().qB() != 0 || this.eov.getPbData().getPage().qw() < 4 || this.eov.getPbData().aMp().ql()) ? false : true;
    }

    public boolean aOf() {
        return (this.eov == null || this.eov.getPbData() == null || this.eov.getPbData().aMp() == null || this.eov.getPbData().getPage() == null || !this.eov.aOw() || this.eov.getPbData().aMp().qj() || !aOj() || com.baidu.tbadk.core.util.y.s(this.eov.getPbData().aMp().getItems()) == 0 || this.eov.getPbData().getPage().qz() != 2 || this.eov.getPbData().aMp().qk()) ? false : true;
    }

    public void aOg() {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMp() != null) {
            this.eov.getPbData().aMp().ao(true);
        }
    }

    public void aOh() {
        if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMp() != null) {
            this.eov.getPbData().aMp().an(true);
        }
    }

    public com.baidu.tbadk.core.data.ad aOi() {
        if (!aOj() || this.eov == null || this.eov.getPbData() == null) {
            return null;
        }
        return this.eov.getPbData().aMp();
    }

    public boolean aOj() {
        return com.baidu.tieba.graffiti.d.ajV() && aOk();
    }

    private boolean aOk() {
        if (this.eov == null || this.eov.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(this.eov.getPbData().aMt(), 0);
        return qVar != null && (qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fvf || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.Tt || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fvi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aOl() {
        if (com.baidu.tieba.graffiti.d.ajV() && !this.eqV) {
            this.eqV = true;
            int i = com.baidu.tbadk.core.sharedPref.b.uh().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.uh().putInt("graffiti_tips_show_config", i + 1);
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
            if (this.eov != null && this.eov.getPbData() != null && this.eov.getPbData().aMp() != null && str.equals(this.eov.getThreadID())) {
                this.eov.getPbData().aMp().am(true);
            }
        }
    }
}

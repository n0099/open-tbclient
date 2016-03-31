package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class dc {
    private BaseActivity bix;
    private df dfV;
    private boolean diy = false;
    private final CustomMessageListener diz = new dd(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener diA = new de(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public dc(df dfVar, BaseActivity baseActivity) {
        this.dfV = dfVar;
        this.bix = baseActivity;
        this.bix.registerListener(this.diz);
        this.bix.registerListener(this.diA);
    }

    public boolean awS() {
        return (this.dfV == null || this.dfV.getPbData() == null || this.dfV.getPbData().avs() == null || this.dfV.getPbData().getPage() == null || !this.dfV.axe() || this.dfV.getPbData().avs().sa() || !awX() || com.baidu.tbadk.core.util.y.p(this.dfV.getPbData().avs().getItems()) == 0 || this.dfV.getPbData().getPage().sq() != 0 || this.dfV.getPbData().getPage().sl() < 4 || this.dfV.getPbData().avs().sc()) ? false : true;
    }

    public boolean awT() {
        return (this.dfV == null || this.dfV.getPbData() == null || this.dfV.getPbData().avs() == null || this.dfV.getPbData().getPage() == null || !this.dfV.axe() || this.dfV.getPbData().avs().sa() || !awX() || com.baidu.tbadk.core.util.y.p(this.dfV.getPbData().avs().getItems()) == 0 || this.dfV.getPbData().getPage().so() != 2 || this.dfV.getPbData().avs().sb()) ? false : true;
    }

    public void awU() {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avs() != null) {
            this.dfV.getPbData().avs().aj(true);
        }
    }

    public void awV() {
        if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avs() != null) {
            this.dfV.getPbData().avs().ai(true);
        }
    }

    public com.baidu.tbadk.core.data.v awW() {
        if (!awX() || this.dfV == null || this.dfV.getPbData() == null) {
            return null;
        }
        return this.dfV.getPbData().avs();
    }

    public boolean awX() {
        return com.baidu.tieba.graffiti.d.Yf() && awY();
    }

    private boolean awY() {
        if (this.dfV == null || this.dfV.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(this.dfV.getPbData().avw(), 0);
        return sVar != null && (sVar.getType() == com.baidu.tieba.tbadkCore.data.s.epG || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.UX || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.epJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean awZ() {
        if (com.baidu.tieba.graffiti.d.Yf() && !this.diy) {
            this.diy = true;
            int i = com.baidu.tbadk.core.sharedPref.b.vk().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.vk().putInt("graffiti_tips_show_config", i + 1);
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
            if (this.dfV != null && this.dfV.getPbData() != null && this.dfV.getPbData().avs() != null && str.equals(this.dfV.getThreadID())) {
                this.dfV.getPbData().avs().ah(true);
            }
        }
    }
}

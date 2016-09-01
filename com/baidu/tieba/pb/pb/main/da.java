package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class da {
    private BaseActivity aPR;
    private dh emx;
    private boolean eoX = false;
    private final CustomMessageListener eoY = new db(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener eoZ = new dc(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public da(dh dhVar, BaseActivity baseActivity) {
        this.emx = dhVar;
        this.aPR = baseActivity;
        this.aPR.registerListener(this.eoY);
        this.aPR.registerListener(this.eoZ);
    }

    public boolean aNw() {
        return (this.emx == null || this.emx.getPbData() == null || this.emx.getPbData().aLN() == null || this.emx.getPbData().getPage() == null || !this.emx.aNO() || this.emx.getPbData().aLN().pY() || !aNB() || com.baidu.tbadk.core.util.y.s(this.emx.getPbData().aLN().getItems()) == 0 || this.emx.getPbData().getPage().qq() != 0 || this.emx.getPbData().getPage().ql() < 4 || this.emx.getPbData().aLN().qa()) ? false : true;
    }

    public boolean aNx() {
        return (this.emx == null || this.emx.getPbData() == null || this.emx.getPbData().aLN() == null || this.emx.getPbData().getPage() == null || !this.emx.aNO() || this.emx.getPbData().aLN().pY() || !aNB() || com.baidu.tbadk.core.util.y.s(this.emx.getPbData().aLN().getItems()) == 0 || this.emx.getPbData().getPage().qo() != 2 || this.emx.getPbData().aLN().pZ()) ? false : true;
    }

    public void aNy() {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLN() != null) {
            this.emx.getPbData().aLN().ao(true);
        }
    }

    public void aNz() {
        if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLN() != null) {
            this.emx.getPbData().aLN().an(true);
        }
    }

    public com.baidu.tbadk.core.data.ab aNA() {
        if (!aNB() || this.emx == null || this.emx.getPbData() == null) {
            return null;
        }
        return this.emx.getPbData().aLN();
    }

    public boolean aNB() {
        return com.baidu.tieba.graffiti.d.ajH() && aNC();
    }

    private boolean aNC() {
        if (this.emx == null || this.emx.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(this.emx.getPbData().aLR(), 0);
        return qVar != null && (qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fsz || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.Tl || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fsC);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aND() {
        if (com.baidu.tieba.graffiti.d.ajH() && !this.eoX) {
            this.eoX = true;
            int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt("graffiti_tips_show_config", 0);
            if (i < 3) {
                com.baidu.tbadk.core.sharedPref.b.tS().putInt("graffiti_tips_show_config", i + 1);
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
            if (this.emx != null && this.emx.getPbData() != null && this.emx.getPbData().aLN() != null && str.equals(this.emx.getThreadID())) {
                this.emx.getPbData().aLN().am(true);
            }
        }
    }
}

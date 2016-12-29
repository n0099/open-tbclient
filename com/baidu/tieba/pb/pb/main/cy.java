package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class cy {
    private BaseActivity aSs;
    private dc dYA;
    private final CustomMessageListener ebh = new cz(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener ebi = new da(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public cy(dc dcVar, BaseActivity baseActivity) {
        this.dYA = dcVar;
        this.aSs = baseActivity;
        this.aSs.registerListener(this.ebh);
        this.aSs.registerListener(this.ebi);
    }

    public boolean aJW() {
        return (this.dYA == null || this.dYA.getPbData() == null || this.dYA.getPbData().aIi() == null || this.dYA.getPbData().getPage() == null || !this.dYA.aKl() || this.dYA.getPbData().aIi().qm() || !aKb() || com.baidu.tbadk.core.util.x.s(this.dYA.getPbData().aIi().getItems()) == 0 || this.dYA.getPbData().getPage().qE() != 0 || this.dYA.getPbData().getPage().qz() < 4 || this.dYA.getPbData().aIi().qo()) ? false : true;
    }

    public boolean aJX() {
        return (this.dYA == null || this.dYA.getPbData() == null || this.dYA.getPbData().aIi() == null || this.dYA.getPbData().getPage() == null || !this.dYA.aKl() || this.dYA.getPbData().aIi().qm() || !aKb() || com.baidu.tbadk.core.util.x.s(this.dYA.getPbData().aIi().getItems()) == 0 || this.dYA.getPbData().getPage().qC() != 2 || this.dYA.getPbData().aIi().qn()) ? false : true;
    }

    public void aJY() {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIi() != null) {
            this.dYA.getPbData().aIi().aq(true);
        }
    }

    public void aJZ() {
        if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIi() != null) {
            this.dYA.getPbData().aIi().ap(true);
        }
    }

    public com.baidu.tbadk.core.data.ae aKa() {
        if (!aKb() || this.dYA == null || this.dYA.getPbData() == null) {
            return null;
        }
        return this.dYA.getPbData().aIi();
    }

    public boolean aKb() {
        return com.baidu.tieba.graffiti.d.agr() && aKc();
    }

    private boolean aKc() {
        if (this.dYA == null || this.dYA.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(this.dYA.getPbData().aIm(), 0);
        return qVar != null && (qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fgw || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.Tp || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.dYA != null && this.dYA.getPbData() != null && this.dYA.getPbData().aIi() != null && str.equals(this.dYA.getThreadID())) {
                this.dYA.getPbData().aIi().ao(true);
            }
        }
    }
}

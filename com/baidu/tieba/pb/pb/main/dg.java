package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class dg {
    private BaseActivity aWr;
    private PbModel ehh;
    private final CustomMessageListener ejZ = new dh(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener eka = new di(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public dg(PbModel pbModel, BaseActivity baseActivity) {
        this.ehh = pbModel;
        this.aWr = baseActivity;
        this.aWr.registerListener(this.ejZ);
        this.aWr.registerListener(this.eka);
    }

    public boolean aLJ() {
        return (this.ehh == null || this.ehh.getPbData() == null || this.ehh.getPbData().aJW() == null || this.ehh.getPbData().getPage() == null || !this.ehh.aLY() || this.ehh.getPbData().aJW().qf() || !aLO() || com.baidu.tbadk.core.util.w.r(this.ehh.getPbData().aJW().getItems()) == 0 || this.ehh.getPbData().getPage().qx() != 0 || this.ehh.getPbData().getPage().qs() < 4 || this.ehh.getPbData().aJW().qh()) ? false : true;
    }

    public boolean aLK() {
        return (this.ehh == null || this.ehh.getPbData() == null || this.ehh.getPbData().aJW() == null || this.ehh.getPbData().getPage() == null || !this.ehh.aLY() || this.ehh.getPbData().aJW().qf() || !aLO() || com.baidu.tbadk.core.util.w.r(this.ehh.getPbData().aJW().getItems()) == 0 || this.ehh.getPbData().getPage().qv() != 2 || this.ehh.getPbData().aJW().qg()) ? false : true;
    }

    public void aLL() {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJW() != null) {
            this.ehh.getPbData().aJW().aq(true);
        }
    }

    public void aLM() {
        if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJW() != null) {
            this.ehh.getPbData().aJW().ap(true);
        }
    }

    public com.baidu.tbadk.core.data.af aLN() {
        if (!aLO() || this.ehh == null || this.ehh.getPbData() == null) {
            return null;
        }
        return this.ehh.getPbData().aJW();
    }

    public boolean aLO() {
        return com.baidu.tieba.graffiti.c.ahy() && aLP();
    }

    private boolean aLP() {
        if (this.ehh == null || this.ehh.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(this.ehh.getPbData().aKb(), 0);
        return pVar != null && (pVar.getType() == com.baidu.tieba.tbadkCore.data.p.fpL || pVar.getType() == com.baidu.tieba.tbadkCore.data.p.Sz || pVar.getType() == com.baidu.tieba.tbadkCore.data.p.fpN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.ehh != null && this.ehh.getPbData() != null && this.ehh.getPbData().aJW() != null && str.equals(this.ehh.getThreadID())) {
                this.ehh.getPbData().aJW().ao(true);
            }
        }
    }
}

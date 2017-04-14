package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class df {
    private BaseActivity bcy;
    private PbModel eif;
    private final CustomMessageListener eld = new dg(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener ele = new dh(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public df(PbModel pbModel, BaseActivity baseActivity) {
        this.eif = pbModel;
        this.bcy = baseActivity;
        this.bcy.registerListener(this.eld);
        this.bcy.registerListener(this.ele);
    }

    public boolean aLn() {
        return (this.eif == null || this.eif.getPbData() == null || this.eif.getPbData().aJu() == null || this.eif.getPbData().rr() == null || !this.eif.aLC() || this.eif.getPbData().aJu().qU() || !aLs() || com.baidu.tbadk.core.util.x.p(this.eif.getPbData().aJu().getItems()) == 0 || this.eif.getPbData().rr().rn() != 0 || this.eif.getPbData().rr().ri() < 4 || this.eif.getPbData().aJu().qW()) ? false : true;
    }

    public boolean aLo() {
        return (this.eif == null || this.eif.getPbData() == null || this.eif.getPbData().aJu() == null || this.eif.getPbData().rr() == null || !this.eif.aLC() || this.eif.getPbData().aJu().qU() || !aLs() || com.baidu.tbadk.core.util.x.p(this.eif.getPbData().aJu().getItems()) == 0 || this.eif.getPbData().rr().rl() != 2 || this.eif.getPbData().aJu().qV()) ? false : true;
    }

    public void aLp() {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJu() != null) {
            this.eif.getPbData().aJu().ar(true);
        }
    }

    public void aLq() {
        if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJu() != null) {
            this.eif.getPbData().aJu().aq(true);
        }
    }

    public com.baidu.tbadk.core.data.af aLr() {
        if (!aLs() || this.eif == null || this.eif.getPbData() == null) {
            return null;
        }
        return this.eif.getPbData().aJu();
    }

    public boolean aLs() {
        return com.baidu.tieba.graffiti.c.agD() && aLt();
    }

    private boolean aLt() {
        if (this.eif == null || this.eif.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(this.eif.getPbData().aJz(), 0);
        return postData != null && (postData.getType() == PostData.fvP || postData.getType() == PostData.Yc || postData.getType() == PostData.fvR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eif != null && this.eif.getPbData() != null && this.eif.getPbData().aJu() != null && str.equals(this.eif.getThreadID())) {
                this.eif.getPbData().aJu().ap(true);
            }
        }
    }
}

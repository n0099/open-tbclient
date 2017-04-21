package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class df {
    private BaseActivity bdG;
    private PbModel ekv;
    private final CustomMessageListener env = new dg(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener enw = new dh(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public df(PbModel pbModel, BaseActivity baseActivity) {
        this.ekv = pbModel;
        this.bdG = baseActivity;
        this.bdG.registerListener(this.env);
        this.bdG.registerListener(this.enw);
    }

    public boolean aMo() {
        return (this.ekv == null || this.ekv.getPbData() == null || this.ekv.getPbData().aKv() == null || this.ekv.getPbData().rr() == null || !this.ekv.aMD() || this.ekv.getPbData().aKv().qU() || !aMt() || com.baidu.tbadk.core.util.x.p(this.ekv.getPbData().aKv().getItems()) == 0 || this.ekv.getPbData().rr().rn() != 0 || this.ekv.getPbData().rr().ri() < 4 || this.ekv.getPbData().aKv().qW()) ? false : true;
    }

    public boolean aMp() {
        return (this.ekv == null || this.ekv.getPbData() == null || this.ekv.getPbData().aKv() == null || this.ekv.getPbData().rr() == null || !this.ekv.aMD() || this.ekv.getPbData().aKv().qU() || !aMt() || com.baidu.tbadk.core.util.x.p(this.ekv.getPbData().aKv().getItems()) == 0 || this.ekv.getPbData().rr().rl() != 2 || this.ekv.getPbData().aKv().qV()) ? false : true;
    }

    public void aMq() {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKv() != null) {
            this.ekv.getPbData().aKv().ar(true);
        }
    }

    public void aMr() {
        if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKv() != null) {
            this.ekv.getPbData().aKv().aq(true);
        }
    }

    public com.baidu.tbadk.core.data.af aMs() {
        if (!aMt() || this.ekv == null || this.ekv.getPbData() == null) {
            return null;
        }
        return this.ekv.getPbData().aKv();
    }

    public boolean aMt() {
        return com.baidu.tieba.graffiti.c.ahE() && aMu();
    }

    private boolean aMu() {
        if (this.ekv == null || this.ekv.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(this.ekv.getPbData().aKA(), 0);
        return postData != null && (postData.getType() == PostData.fyg || postData.getType() == PostData.Yd || postData.getType() == PostData.fyi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.ekv != null && this.ekv.getPbData() != null && this.ekv.getPbData().aKv() != null && str.equals(this.ekv.getThreadID())) {
                this.ekv.getPbData().aKv().ap(true);
            }
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class dt {
    private BaseActivity bdY;
    private PbModel efE;
    private final CustomMessageListener ejr = new du(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener ejs = new dv(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public dt(PbModel pbModel, BaseActivity baseActivity) {
        this.efE = pbModel;
        this.bdY = baseActivity;
        this.bdY.registerListener(this.ejr);
        this.bdY.registerListener(this.ejs);
    }

    public com.baidu.tbadk.core.data.af aJN() {
        if (!aJO() || this.efE == null || this.efE.getPbData() == null) {
            return null;
        }
        return this.efE.getPbData().aHC();
    }

    public boolean aJO() {
        return com.baidu.tieba.graffiti.c.afn() && aJP();
    }

    private boolean aJP() {
        if (this.efE == null || this.efE.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(this.efE.getPbData().aHI(), 0);
        return postData != null && (postData.getType() == PostData.fuk || postData.getType() == PostData.Xv || postData.getType() == PostData.fun);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.efE != null && this.efE.getPbData() != null && this.efE.getPbData().aHC() != null && str.equals(this.efE.getThreadID())) {
                this.efE.getPbData().aHC().ao(true);
            }
        }
    }
}

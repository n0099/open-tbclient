package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ec {
    private BaseActivity bfa;
    private PbModel ele;
    private final CustomMessageListener epd = new ed(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener epe = new ee(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public ec(PbModel pbModel, BaseActivity baseActivity) {
        this.ele = pbModel;
        this.bfa = baseActivity;
        this.bfa.registerListener(this.epd);
        this.bfa.registerListener(this.epe);
    }

    public com.baidu.tbadk.core.data.af aKH() {
        if (!aKI() || this.ele == null || this.ele.getPbData() == null) {
            return null;
        }
        return this.ele.getPbData().aIx();
    }

    public boolean aKI() {
        return com.baidu.tieba.graffiti.c.agC() && aKJ();
    }

    private boolean aKJ() {
        if (this.ele == null || this.ele.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(this.ele.getPbData().aID(), 0);
        return postData != null && (postData.getType() == PostData.fCb || postData.getType() == PostData.Xr || postData.getType() == PostData.fCe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.ele != null && this.ele.getPbData() != null && this.ele.getPbData().aIx() != null && str.equals(this.ele.getThreadID())) {
                this.ele.getPbData().aIx().an(true);
            }
        }
    }
}

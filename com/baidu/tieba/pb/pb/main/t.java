package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class t {
    private BaseActivity bnd;
    private PbModel eGP;
    private final CustomMessageListener eKW = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };
    private final CustomMessageListener eKX = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };

    public t(PbModel pbModel, BaseActivity baseActivity) {
        this.eGP = pbModel;
        this.bnd = baseActivity;
        this.bnd.registerListener(this.eKW);
        this.bnd.registerListener(this.eKX);
    }

    public com.baidu.tbadk.core.data.af aRl() {
        if (!aRm() || this.eGP == null || this.eGP.getPbData() == null) {
            return null;
        }
        return this.eGP.getPbData().aOT();
    }

    public boolean aRm() {
        return com.baidu.tieba.graffiti.b.aoh() && aRn();
    }

    private boolean aRn() {
        if (this.eGP == null || this.eGP.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(this.eGP.getPbData().aOZ(), 0);
        return postData != null && (postData.getType() == PostData.gii || postData.getType() == PostData.Yk || postData.getType() == PostData.gil);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOT() != null && str.equals(this.eGP.getThreadID())) {
                this.eGP.getPbData().aOT().an(true);
            }
        }
    }
}

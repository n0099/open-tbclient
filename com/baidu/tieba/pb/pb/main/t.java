package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class t {
    private BaseActivity bnc;
    private PbModel eHJ;
    private final CustomMessageListener eLQ = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };
    private final CustomMessageListener eLR = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };

    public t(PbModel pbModel, BaseActivity baseActivity) {
        this.eHJ = pbModel;
        this.bnc = baseActivity;
        this.bnc.registerListener(this.eLQ);
        this.bnc.registerListener(this.eLR);
    }

    public com.baidu.tbadk.core.data.af aRw() {
        if (!aRx() || this.eHJ == null || this.eHJ.getPbData() == null) {
            return null;
        }
        return this.eHJ.getPbData().aPe();
    }

    public boolean aRx() {
        return com.baidu.tieba.graffiti.b.aos() && aRy();
    }

    private boolean aRy() {
        if (this.eHJ == null || this.eHJ.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(this.eHJ.getPbData().aPk(), 0);
        return postData != null && (postData.getType() == PostData.gjc || postData.getType() == PostData.Yk || postData.getType() == PostData.gjf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPe() != null && str.equals(this.eHJ.getThreadID())) {
                this.eHJ.getPbData().aPe().an(true);
            }
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class t {
    private BaseActivity bmE;
    private PbModel eIt;
    private final CustomMessageListener eMD = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };
    private final CustomMessageListener eME = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };

    public t(PbModel pbModel, BaseActivity baseActivity) {
        this.eIt = pbModel;
        this.bmE = baseActivity;
        this.bmE.registerListener(this.eMD);
        this.bmE.registerListener(this.eME);
    }

    public com.baidu.tbadk.core.data.af aRZ() {
        if (!aSa() || this.eIt == null || this.eIt.getPbData() == null) {
            return null;
        }
        return this.eIt.getPbData().aPM();
    }

    public boolean aSa() {
        return com.baidu.tieba.graffiti.b.amF() && aSb();
    }

    private boolean aSb() {
        if (this.eIt == null || this.eIt.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(this.eIt.getPbData().aPS(), 0);
        return postData != null && (postData.getType() == PostData.gjG || postData.getType() == PostData.Zf || postData.getType() == PostData.gjJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPM() != null && str.equals(this.eIt.getThreadID())) {
                this.eIt.getPbData().aPM().an(true);
            }
        }
    }
}

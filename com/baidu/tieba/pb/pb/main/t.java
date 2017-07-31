package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class t {
    private BaseActivity bmv;
    private PbModel eGz;
    private final CustomMessageListener eKJ = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };
    private final CustomMessageListener eKK = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };

    public t(PbModel pbModel, BaseActivity baseActivity) {
        this.eGz = pbModel;
        this.bmv = baseActivity;
        this.bmv.registerListener(this.eKJ);
        this.bmv.registerListener(this.eKK);
    }

    public com.baidu.tbadk.core.data.af aRs() {
        if (!aRt() || this.eGz == null || this.eGz.getPbData() == null) {
            return null;
        }
        return this.eGz.getPbData().aPf();
    }

    public boolean aRt() {
        return com.baidu.tieba.graffiti.b.alZ() && aRu();
    }

    private boolean aRu() {
        if (this.eGz == null || this.eGz.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(this.eGz.getPbData().aPl(), 0);
        return postData != null && (postData.getType() == PostData.ghN || postData.getType() == PostData.Zd || postData.getType() == PostData.ghQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPf() != null && str.equals(this.eGz.getThreadID())) {
                this.eGz.getPbData().aPf().an(true);
            }
        }
    }
}

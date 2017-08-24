package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class t {
    private BaseActivity bmG;
    private PbModel eIv;
    private final CustomMessageListener eMF = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };
    private final CustomMessageListener eMG = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };

    public t(PbModel pbModel, BaseActivity baseActivity) {
        this.eIv = pbModel;
        this.bmG = baseActivity;
        this.bmG.registerListener(this.eMF);
        this.bmG.registerListener(this.eMG);
    }

    public com.baidu.tbadk.core.data.af aRU() {
        if (!aRV() || this.eIv == null || this.eIv.getPbData() == null) {
            return null;
        }
        return this.eIv.getPbData().aPH();
    }

    public boolean aRV() {
        return com.baidu.tieba.graffiti.b.amz() && aRW();
    }

    private boolean aRW() {
        if (this.eIv == null || this.eIv.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(this.eIv.getPbData().aPN(), 0);
        return postData != null && (postData.getType() == PostData.gjG || postData.getType() == PostData.Zg || postData.getType() == PostData.gjJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPH() != null && str.equals(this.eIv.getThreadID())) {
                this.eIv.getPbData().aPH().an(true);
            }
        }
    }
}

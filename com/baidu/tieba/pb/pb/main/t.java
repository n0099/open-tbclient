package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class t {
    private BaseActivity bll;
    private PbModel eFm;
    private final CustomMessageListener eJw = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };
    private final CustomMessageListener eJx = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.t.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t.this.h(customResponsedMessage);
        }
    };

    public t(PbModel pbModel, BaseActivity baseActivity) {
        this.eFm = pbModel;
        this.bll = baseActivity;
        this.bll.registerListener(this.eJw);
        this.bll.registerListener(this.eJx);
    }

    public com.baidu.tbadk.core.data.af aRh() {
        if (!aRi() || this.eFm == null || this.eFm.getPbData() == null) {
            return null;
        }
        return this.eFm.getPbData().aOU();
    }

    public boolean aRi() {
        return com.baidu.tieba.graffiti.b.alM() && aRj();
    }

    private boolean aRj() {
        if (this.eFm == null || this.eFm.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(this.eFm.getPbData().aPa(), 0);
        return postData != null && (postData.getType() == PostData.ggC || postData.getType() == PostData.XH || postData.getType() == PostData.ggF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOU() != null && str.equals(this.eFm.getThreadID())) {
                this.eFm.getPbData().aOU().an(true);
            }
        }
    }
}

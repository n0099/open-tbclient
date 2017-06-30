package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class el {
    private BaseActivity bhX;
    private PbModel eue;
    private final CustomMessageListener eyn = new em(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener eyo = new en(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public el(PbModel pbModel, BaseActivity baseActivity) {
        this.eue = pbModel;
        this.bhX = baseActivity;
        this.bhX.registerListener(this.eyn);
        this.bhX.registerListener(this.eyo);
    }

    public com.baidu.tbadk.core.data.ag aOE() {
        if (!aOF() || this.eue == null || this.eue.getPbData() == null) {
            return null;
        }
        return this.eue.getPbData().aMr();
    }

    public boolean aOF() {
        return com.baidu.tieba.graffiti.c.akm() && aOG();
    }

    private boolean aOG() {
        if (this.eue == null || this.eue.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(this.eue.getPbData().aMx(), 0);
        return postData != null && (postData.getType() == PostData.fMf || postData.getType() == PostData.Xr || postData.getType() == PostData.fMi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.eue != null && this.eue.getPbData() != null && this.eue.getPbData().aMr() != null && str.equals(this.eue.getThreadID())) {
                this.eue.getPbData().aMr().an(true);
            }
        }
    }
}

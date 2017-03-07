package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class dh {
    private BaseActivity bcF;
    private PbModel ejZ;
    private final CustomMessageListener emV = new di(this, CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS);
    private final CustomMessageListener emW = new dj(this, CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS);

    public dh(PbModel pbModel, BaseActivity baseActivity) {
        this.ejZ = pbModel;
        this.bcF = baseActivity;
        this.bcF.registerListener(this.emV);
        this.bcF.registerListener(this.emW);
    }

    public boolean aLf() {
        return (this.ejZ == null || this.ejZ.getPbData() == null || this.ejZ.getPbData().aJn() == null || this.ejZ.getPbData().getPage() == null || !this.ejZ.aLu() || this.ejZ.getPbData().aJn().qx() || !aLk() || com.baidu.tbadk.core.util.x.p(this.ejZ.getPbData().aJn().getItems()) == 0 || this.ejZ.getPbData().getPage().qQ() != 0 || this.ejZ.getPbData().getPage().qL() < 4 || this.ejZ.getPbData().aJn().qz()) ? false : true;
    }

    public boolean aLg() {
        return (this.ejZ == null || this.ejZ.getPbData() == null || this.ejZ.getPbData().aJn() == null || this.ejZ.getPbData().getPage() == null || !this.ejZ.aLu() || this.ejZ.getPbData().aJn().qx() || !aLk() || com.baidu.tbadk.core.util.x.p(this.ejZ.getPbData().aJn().getItems()) == 0 || this.ejZ.getPbData().getPage().qO() != 2 || this.ejZ.getPbData().aJn().qy()) ? false : true;
    }

    public void aLh() {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJn() != null) {
            this.ejZ.getPbData().aJn().ap(true);
        }
    }

    public void aLi() {
        if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJn() != null) {
            this.ejZ.getPbData().aJn().ao(true);
        }
    }

    public com.baidu.tbadk.core.data.ag aLj() {
        if (!aLk() || this.ejZ == null || this.ejZ.getPbData() == null) {
            return null;
        }
        return this.ejZ.getPbData().aJn();
    }

    public boolean aLk() {
        return com.baidu.tieba.graffiti.c.agJ() && aLl();
    }

    private boolean aLl() {
        if (this.ejZ == null || this.ejZ.getPbData() == null) {
            return false;
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(this.ejZ.getPbData().aJs(), 0);
        return postData != null && (postData.getType() == PostData.fug || postData.getType() == PostData.XM || postData.getType() == PostData.fui);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.ejZ != null && this.ejZ.getPbData() != null && this.ejZ.getPbData().aJn() != null && str.equals(this.ejZ.getThreadID())) {
                this.ejZ.getPbData().aJn().an(true);
            }
        }
    }
}

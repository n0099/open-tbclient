package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes15.dex */
public class c extends Thread {
    private String eaJ;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.eaJ = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.eaJ = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            zVar.addPostData("obj", this.eaJ);
            zVar.addPostData("obj_tp", this.mObjTp);
            zVar.addPostData("group_id", this.mGroupId);
            zVar.postNetData();
        }
    }
}

package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class c extends Thread {
    private String ciT;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.ciT = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.ciT = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            xVar.addPostData("obj", this.ciT);
            xVar.addPostData("obj_tp", this.mObjTp);
            xVar.addPostData("group_id", this.mGroupId);
            xVar.postNetData();
        }
    }
}

package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes8.dex */
public class c extends Thread {
    private String dzw;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.dzw = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.dzw = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            xVar.addPostData("obj", this.dzw);
            xVar.addPostData("obj_tp", this.mObjTp);
            xVar.addPostData("group_id", this.mGroupId);
            xVar.postNetData();
        }
    }
}

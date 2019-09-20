package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class c extends Thread {
    private String bTH;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.bTH = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.bTH = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            xVar.o("obj", this.bTH);
            xVar.o("obj_tp", this.mObjTp);
            xVar.o("group_id", this.mGroupId);
            xVar.aim();
        }
    }
}

package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class g extends Thread {
    private String Vh;
    private String mGroupId;
    private String mObjTp;

    public g(String str, String str2, String str3) {
        this.Vh = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.Vh = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        aaVar.o("obj", this.Vh);
        aaVar.o("obj_tp", this.mObjTp);
        aaVar.o("group_id", this.mGroupId);
        aaVar.rO();
    }
}

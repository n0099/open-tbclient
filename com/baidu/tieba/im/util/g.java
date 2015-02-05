package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class g extends Thread {
    private String Jv;
    private String mGroupId;
    private String mObjTp;

    public g(String str, String str2, String str3) {
        this.Jv = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.Jv = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        adVar.o("obj", this.Jv);
        adVar.o("obj_tp", this.mObjTp);
        adVar.o("group_id", this.mGroupId);
        adVar.or();
    }
}

package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class f extends Thread {
    private String aaQ;
    private String mGroupId;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.aaQ = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.aaQ = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        wVar.o("obj", this.aaQ);
        wVar.o("obj_tp", this.mObjTp);
        wVar.o("group_id", this.mGroupId);
        wVar.tG();
    }
}

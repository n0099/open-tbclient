package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class f extends Thread {
    private String aaN;
    private String mGroupId;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.aaN = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.aaN = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        v vVar = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        vVar.o("obj", this.aaN);
        vVar.o("obj_tp", this.mObjTp);
        vVar.o("group_id", this.mGroupId);
        vVar.tD();
    }
}

package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class f extends Thread {
    private String aaA;
    private String mGroupId;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.aaA = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.aaA = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        yVar.n("obj", this.aaA);
        yVar.n("obj_tp", this.mObjTp);
        yVar.n("group_id", this.mGroupId);
        yVar.ud();
    }
}

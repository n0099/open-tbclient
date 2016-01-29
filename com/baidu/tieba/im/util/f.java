package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class f extends Thread {
    private String aVe;
    private String acJ;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.acJ = null;
        this.mObjTp = null;
        this.aVe = null;
        this.acJ = str;
        this.mObjTp = str2;
        this.aVe = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        aaVar.p("obj", this.acJ);
        aaVar.p("obj_tp", this.mObjTp);
        aaVar.p("group_id", this.aVe);
        aaVar.uZ();
    }
}

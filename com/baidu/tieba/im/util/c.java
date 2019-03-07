package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class c extends Thread {
    private String bKl;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.bKl = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.bKl = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.x("obj", this.bKl);
        xVar.x("obj_tp", this.mObjTp);
        xVar.x("group_id", this.mGroupId);
        xVar.acj();
    }
}

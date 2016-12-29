package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class f extends Thread {
    private String abo;
    private String mGroupId;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.abo = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.abo = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        zVar.n("obj", this.abo);
        zVar.n("obj_tp", this.mObjTp);
        zVar.n("group_id", this.mGroupId);
        zVar.uk();
    }
}

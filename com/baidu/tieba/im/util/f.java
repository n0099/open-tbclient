package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class f extends Thread {
    private String Xw;
    private String mGroupId;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.Xw = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.Xw = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("obj", this.Xw);
        abVar.n("obj_tp", this.mObjTp);
        abVar.n("group_id", this.mGroupId);
        abVar.tc();
    }
}

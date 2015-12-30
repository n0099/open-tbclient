package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class f extends Thread {
    private String acn;
    private String mGroupId;
    private String mObjTp;

    public f(String str, String str2, String str3) {
        this.acn = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.acn = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.o("obj", this.acn);
        abVar.o("obj_tp", this.mObjTp);
        abVar.o("group_id", this.mGroupId);
        abVar.tV();
    }
}

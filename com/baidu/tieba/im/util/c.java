package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes2.dex */
public class c extends Thread {
    private String aqQ;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.aqQ = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.aqQ = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        yVar.o("obj", this.aqQ);
        yVar.o("obj_tp", this.mObjTp);
        yVar.o("group_id", this.mGroupId);
        yVar.yz();
    }
}

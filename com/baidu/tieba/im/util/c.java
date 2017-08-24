package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class c extends Thread {
    private String ahO;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.ahO = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.ahO = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        w wVar = new w(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        wVar.n("obj", this.ahO);
        wVar.n("obj_tp", this.mObjTp);
        wVar.n("group_id", this.mGroupId);
        wVar.uP();
    }
}

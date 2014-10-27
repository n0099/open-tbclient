package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class h extends Thread {
    private String ET;
    private String mGroupId;
    private String mObjTp;

    public h(String str, String str2, String str3) {
        this.ET = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.ET = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ac acVar = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        acVar.k("obj", this.ET);
        acVar.k("obj_tp", this.mObjTp);
        acVar.k("group_id", this.mGroupId);
        acVar.lA();
    }
}

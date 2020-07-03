package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes8.dex */
public class c extends Thread {
    private String dUq;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.dUq = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.dUq = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            yVar.addPostData("obj", this.dUq);
            yVar.addPostData("obj_tp", this.mObjTp);
            yVar.addPostData("group_id", this.mGroupId);
            yVar.postNetData();
        }
    }
}

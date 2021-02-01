package com.baidu.tieba.im.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class a extends Thread {
    private String mGroupId;
    private String mObj;
    private String mObjTp;

    public a(String str, String str2, String str3) {
        this.mObj = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.mObj = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            aaVar.addPostData("obj", this.mObj);
            aaVar.addPostData("obj_tp", this.mObjTp);
            aaVar.addPostData("group_id", this.mGroupId);
            aaVar.postNetData();
        }
    }
}

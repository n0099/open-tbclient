package com.baidu.tieba.im.util;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes15.dex */
public class c extends Thread {
    private String ekw;
    private String mGroupId;
    private String mObjTp;

    public c(String str, String str2, String str3) {
        this.ekw = null;
        this.mObjTp = null;
        this.mGroupId = null;
        this.ekw = str;
        this.mObjTp = str2;
        this.mGroupId = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            aaVar.addPostData(MapBundleKey.MapObjKey.OBJ_SL_OBJ, this.ekw);
            aaVar.addPostData("obj_tp", this.mObjTp);
            aaVar.addPostData("group_id", this.mGroupId);
            aaVar.postNetData();
        }
    }
}

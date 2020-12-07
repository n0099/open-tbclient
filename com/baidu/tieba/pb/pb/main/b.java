package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes22.dex */
public class b extends Thread {
    private final String amY;
    private final String eRY;
    private final String lDM;

    public b(String str, String str2, String str3) {
        this.amY = str;
        this.lDM = str2;
        this.eRY = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.amY);
        aaVar.addPostData("phonenum", this.lDM);
        aaVar.addPostData("optype", this.eRY);
        aaVar.postNetData();
    }
}

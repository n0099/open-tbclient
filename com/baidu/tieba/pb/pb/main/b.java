package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes21.dex */
public class b extends Thread {
    private final String alZ;
    private final String eKM;
    private final String lqd;

    public b(String str, String str2, String str3) {
        this.alZ = str;
        this.lqd = str2;
        this.eKM = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.alZ);
        aaVar.addPostData("phonenum", this.lqd);
        aaVar.addPostData("optype", this.eKM);
        aaVar.postNetData();
    }
}

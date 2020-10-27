package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes22.dex */
public class b extends Thread {
    private final String alT;
    private final String eFY;
    private final String ljN;

    public b(String str, String str2, String str3) {
        this.alT = str;
        this.ljN = str2;
        this.eFY = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.alT);
        aaVar.addPostData("phonenum", this.ljN);
        aaVar.addPostData("optype", this.eFY);
        aaVar.postNetData();
    }
}

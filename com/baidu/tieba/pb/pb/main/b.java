package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class b extends Thread {
    private final String anD;
    private final String fbX;
    private final String lIU;

    public b(String str, String str2, String str3) {
        this.anD = str;
        this.lIU = str2;
        this.fbX = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        zVar.addPostData("tid", this.anD);
        zVar.addPostData("phonenum", this.lIU);
        zVar.addPostData("optype", this.fbX);
        zVar.postNetData();
    }
}

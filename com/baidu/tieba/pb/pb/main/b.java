package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes16.dex */
public class b extends Thread {
    private final String ajJ;
    private final String dZs;
    private final String kkf;

    public b(String str, String str2, String str3) {
        this.ajJ = str;
        this.kkf = str2;
        this.dZs = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        zVar.addPostData("tid", this.ajJ);
        zVar.addPostData("phonenum", this.kkf);
        zVar.addPostData("optype", this.dZs);
        zVar.postNetData();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class b extends Thread {
    private final String ajO;
    private final String dTa;
    private final String kbB;

    public b(String str, String str2, String str3) {
        this.ajO = str;
        this.kbB = str2;
        this.dTa = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        yVar.addPostData("tid", this.ajO);
        yVar.addPostData("phonenum", this.kbB);
        yVar.addPostData("optype", this.dTa);
        yVar.postNetData();
    }
}

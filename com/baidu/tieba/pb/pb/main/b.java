package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes22.dex */
public class b extends Thread {
    private final String alS;
    private final String exA;
    private final String kXo;

    public b(String str, String str2, String str3) {
        this.alS = str;
        this.kXo = str2;
        this.exA = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.alS);
        aaVar.addPostData("phonenum", this.kXo);
        aaVar.addPostData("optype", this.exA);
        aaVar.postNetData();
    }
}

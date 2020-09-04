package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes16.dex */
public class b extends Thread {
    private final String ala;
    private final String ejc;
    private final String kzG;

    public b(String str, String str2, String str3) {
        this.ala = str;
        this.kzG = str2;
        this.ejc = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.ala);
        aaVar.addPostData("phonenum", this.kzG);
        aaVar.addPostData("optype", this.ejc);
        aaVar.postNetData();
    }
}

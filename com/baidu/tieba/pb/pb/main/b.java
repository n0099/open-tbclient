package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class b extends Thread {
    private final String anU;
    private final String fbe;
    private final String lPu;

    public b(String str, String str2, String str3) {
        this.anU = str;
        this.lPu = str2;
        this.fbe = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.anU);
        aaVar.addPostData("phonenum", this.lPu);
        aaVar.addPostData("optype", this.fbe);
        aaVar.postNetData();
    }
}

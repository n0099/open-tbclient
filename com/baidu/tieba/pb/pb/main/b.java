package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class b extends Thread {
    private final String amC;
    private final String eZF;
    private final String lNd;

    public b(String str, String str2, String str3) {
        this.amC = str;
        this.lNd = str2;
        this.eZF = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.amC);
        aaVar.addPostData("phonenum", this.lNd);
        aaVar.addPostData("optype", this.eZF);
        aaVar.postNetData();
    }
}

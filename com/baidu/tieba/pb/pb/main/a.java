package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aMR;
    private final String afk;
    private final String eRD;

    public a(String str, String str2, String str3) {
        this.aMR = str;
        this.eRD = str2;
        this.afk = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.aMR);
        xVar.n("phonenum", this.eRD);
        xVar.n("optype", this.afk);
        xVar.us();
    }
}

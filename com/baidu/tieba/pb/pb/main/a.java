package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aMi;
    private final String eJD;
    private final String eJE;

    public a(String str, String str2, String str3) {
        this.aMi = str;
        this.eJD = str2;
        this.eJE = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.aMi);
        xVar.n("phonenum", this.eJD);
        xVar.n("optype", this.eJE);
        xVar.up();
    }
}

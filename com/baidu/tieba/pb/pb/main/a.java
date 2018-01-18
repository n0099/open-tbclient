package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aTr;
    private final String bAT;
    private final String fGM;

    public a(String str, String str2, String str3) {
        this.bAT = str;
        this.fGM = str2;
        this.aTr = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bAT);
        xVar.n("phonenum", this.fGM);
        xVar.n("optype", this.aTr);
        xVar.BH();
    }
}

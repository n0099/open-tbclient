package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bGH;
    private final String eGM;
    private final String eGN;

    public a(String str, String str2, String str3) {
        this.bGH = str;
        this.eGM = str2;
        this.eGN = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bGH);
        xVar.n("phonenum", this.eGM);
        xVar.n("optype", this.eGN);
        xVar.uM();
    }
}

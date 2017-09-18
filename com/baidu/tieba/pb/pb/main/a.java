package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bHy;
    private final String eHG;
    private final String eHH;

    public a(String str, String str2, String str3) {
        this.bHy = str;
        this.eHG = str2;
        this.eHH = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bHy);
        xVar.n("phonenum", this.eHG);
        xVar.n("optype", this.eHH);
        xVar.uM();
    }
}

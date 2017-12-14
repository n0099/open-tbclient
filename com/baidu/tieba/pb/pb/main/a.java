package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aMU;
    private final String afe;
    private final String eSG;

    public a(String str, String str2, String str3) {
        this.aMU = str;
        this.eSG = str2;
        this.afe = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.aMU);
        xVar.n("phonenum", this.eSG);
        xVar.n("optype", this.afe);
        xVar.up();
    }
}

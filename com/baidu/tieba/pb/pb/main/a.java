package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aZG;
    private final String aqX;
    private final String fCE;

    public a(String str, String str2, String str3) {
        this.aZG = str;
        this.fCE = str2;
        this.aqX = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.u("tid", this.aZG);
        xVar.u("phonenum", this.fCE);
        xVar.u("optype", this.aqX);
        xVar.zt();
    }
}

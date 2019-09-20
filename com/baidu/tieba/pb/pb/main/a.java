package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bRT;
    private final String bXN;
    private final String hMN;

    public a(String str, String str2, String str3) {
        this.bXN = str;
        this.hMN = str2;
        this.bRT = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.o("tid", this.bXN);
        xVar.o("phonenum", this.hMN);
        xVar.o("optype", this.bRT);
        xVar.aim();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bRm;
    private final String bWO;
    private final String hJX;

    public a(String str, String str2, String str3) {
        this.bWO = str;
        this.hJX = str2;
        this.bRm = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.o("tid", this.bWO);
        xVar.o("phonenum", this.hJX);
        xVar.o("optype", this.bRm);
        xVar.aig();
    }
}

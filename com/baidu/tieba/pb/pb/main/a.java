package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bQl;
    private final String bVL;
    private final String hDJ;

    public a(String str, String str2, String str3) {
        this.bVL = str;
        this.hDJ = str2;
        this.bQl = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.o("tid", this.bVL);
        xVar.o("phonenum", this.hDJ);
        xVar.o("optype", this.bQl);
        xVar.ahe();
    }
}

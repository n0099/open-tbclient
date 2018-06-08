package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aVt;
    private final String aop;
    private final String fqP;

    public a(String str, String str2, String str3) {
        this.aVt = str;
        this.fqP = str2;
        this.aop = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        yVar.o("tid", this.aVt);
        yVar.o("phonenum", this.fqP);
        yVar.o("optype", this.aop);
        yVar.yl();
    }
}

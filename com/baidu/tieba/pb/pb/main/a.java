package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bLn;
    private final String cbt;
    private final String cbu;

    public a(String str, String str2, String str3) {
        this.bLn = str;
        this.cbt = str2;
        this.cbu = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        vVar.o("tid", this.bLn);
        vVar.o("phonenum", this.cbt);
        vVar.o("optype", this.cbu);
        vVar.tI();
    }
}

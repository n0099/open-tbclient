package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String cEO;
    private final String cEP;
    private final String cjE;

    public a(String str, String str2, String str3) {
        this.cjE = str;
        this.cEO = str2;
        this.cEP = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.o("tid", this.cjE);
        abVar.o("phonenum", this.cEO);
        abVar.o("optype", this.cEP);
        abVar.tV();
    }
}

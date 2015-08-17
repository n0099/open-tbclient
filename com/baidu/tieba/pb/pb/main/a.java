package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bKG;
    private final String cay;
    private final String caz;

    public a(String str, String str2, String str3) {
        this.bKG = str;
        this.cay = str2;
        this.caz = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        vVar.o("tid", this.bKG);
        vVar.o("phonenum", this.cay);
        vVar.o("optype", this.caz);
        vVar.tD();
    }
}

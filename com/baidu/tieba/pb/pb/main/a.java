package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bPn;
    private final String ciN;
    private final String ciO;

    public a(String str, String str2, String str3) {
        this.bPn = str;
        this.ciN = str2;
        this.ciO = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        wVar.o("tid", this.bPn);
        wVar.o("phonenum", this.ciN);
        wVar.o("optype", this.ciO);
        wVar.tG();
    }
}

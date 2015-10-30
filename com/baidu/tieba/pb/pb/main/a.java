package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bOS;
    private final String chT;
    private final String chU;

    public a(String str, String str2, String str3) {
        this.bOS = str;
        this.chT = str2;
        this.chU = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        wVar.o("tid", this.bOS);
        wVar.o("phonenum", this.chT);
        wVar.o("optype", this.chU);
        wVar.tD();
    }
}

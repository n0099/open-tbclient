package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bOH;
    private final String chI;
    private final String chJ;

    public a(String str, String str2, String str3) {
        this.bOH = str;
        this.chI = str2;
        this.chJ = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        wVar.o("tid", this.bOH);
        wVar.o("phonenum", this.chI);
        wVar.o("optype", this.chJ);
        wVar.tG();
    }
}

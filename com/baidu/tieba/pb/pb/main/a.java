package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bDd;
    private final String eGx;
    private final String eGy;

    public a(String str, String str2, String str3) {
        this.bDd = str;
        this.eGx = str2;
        this.eGy = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        wVar.n("tid", this.bDd);
        wVar.n("phonenum", this.eGx);
        wVar.n("optype", this.eGy);
        wVar.uO();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bBT;
    private final String eFk;
    private final String eFl;

    public a(String str, String str2, String str3) {
        this.bBT = str;
        this.eFk = str2;
        this.eFl = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        wVar.n("tid", this.bBT);
        wVar.n("phonenum", this.eFk);
        wVar.n("optype", this.eFl);
        wVar.uE();
    }
}

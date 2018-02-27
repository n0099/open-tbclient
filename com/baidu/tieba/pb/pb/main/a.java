package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aUN;
    private final String bCS;
    private final String fKt;

    public a(String str, String str2, String str3) {
        this.bCS = str;
        this.fKt = str2;
        this.aUN = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bCS);
        xVar.n("phonenum", this.fKt);
        xVar.n("optype", this.aUN);
        xVar.Ca();
    }
}

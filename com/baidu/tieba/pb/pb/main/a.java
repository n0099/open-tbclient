package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aTu;
    private final String bBb;
    private final String fHh;

    public a(String str, String str2, String str3) {
        this.bBb = str;
        this.fHh = str2;
        this.aTu = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bBb);
        xVar.n("phonenum", this.fHh);
        xVar.n("optype", this.aTu);
        xVar.BI();
    }
}

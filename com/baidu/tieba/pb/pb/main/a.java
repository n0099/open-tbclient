package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aUP;
    private final String bCV;
    private final String fKJ;

    public a(String str, String str2, String str3) {
        this.bCV = str;
        this.fKJ = str2;
        this.aUP = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bCV);
        xVar.n("phonenum", this.fKJ);
        xVar.n("optype", this.aUP);
        xVar.Cb();
    }
}

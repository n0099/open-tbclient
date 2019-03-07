package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bIx;
    private final String ctx;
    private final String hmw;

    public a(String str, String str2, String str3) {
        this.ctx = str;
        this.hmw = str2;
        this.bIx = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.ctx);
        xVar.x("phonenum", this.hmw);
        xVar.x("optype", this.bIx);
        xVar.acj();
    }
}

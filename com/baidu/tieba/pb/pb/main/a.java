package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bRs;
    private final String bWU;
    private final String hKQ;

    public a(String str, String str2, String str3) {
        this.bWU = str;
        this.hKQ = str2;
        this.bRs = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.o("tid", this.bWU);
        xVar.o("phonenum", this.hKQ);
        xVar.o("optype", this.bRs);
        xVar.aii();
    }
}

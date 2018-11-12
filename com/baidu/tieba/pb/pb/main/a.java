package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String awA;
    private final String beV;
    private final String fLF;

    public a(String str, String str2, String str3) {
        this.beV = str;
        this.fLF = str2;
        this.awA = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.beV);
        xVar.x("phonenum", this.fLF);
        xVar.x("optype", this.awA);
        xVar.BH();
    }
}

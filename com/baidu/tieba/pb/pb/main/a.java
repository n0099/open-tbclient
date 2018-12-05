package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String aAa;
    private final String biw;
    private final String fSv;

    public a(String str, String str2, String str3) {
        this.biw = str;
        this.fSv = str2;
        this.aAa = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.biw);
        xVar.x("phonenum", this.fSv);
        xVar.x("optype", this.aAa);
        xVar.CL();
    }
}

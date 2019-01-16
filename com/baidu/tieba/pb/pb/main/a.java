package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String aAC;
    private final String bjm;
    private final String fWk;

    public a(String str, String str2, String str3) {
        this.bjm = str;
        this.fWk = str2;
        this.aAC = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.bjm);
        xVar.x("phonenum", this.fWk);
        xVar.x("optype", this.aAC);
        xVar.CY();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String aAD;
    private final String bjn;
    private final String fWl;

    public a(String str, String str2, String str3) {
        this.bjn = str;
        this.fWl = str2;
        this.aAD = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.bjn);
        xVar.x("phonenum", this.fWl);
        xVar.x("optype", this.aAD);
        xVar.CY();
    }
}

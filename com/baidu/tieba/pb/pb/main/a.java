package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String cMf;
    private final String cMg;
    private final String coe;

    public a(String str, String str2, String str3) {
        this.coe = str;
        this.cMf = str2;
        this.cMg = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        aaVar.p("tid", this.coe);
        aaVar.p("phonenum", this.cMf);
        aaVar.p("optype", this.cMg);
        aaVar.uZ();
    }
}

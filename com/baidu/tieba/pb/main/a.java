package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String a;
    private final String b;
    private final String c;

    public a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        anVar.a("tid", this.a);
        anVar.a("phonenum", this.b);
        anVar.a("optype", this.c);
        anVar.i();
    }
}

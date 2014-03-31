package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
public final class a extends Thread {
    private final String a;
    private final String b;
    private final String c;

    public a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/clientcall");
        akVar.a("tid", this.a);
        akVar.a("phonenum", this.b);
        akVar.a("optype", this.c);
        akVar.i();
    }
}

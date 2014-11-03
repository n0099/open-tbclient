package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bkv;
    private final String buE;
    private final String buF;

    public a(String str, String str2, String str3) {
        this.bkv = str;
        this.buE = str2;
        this.buF = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        acVar.k("tid", this.bkv);
        acVar.k("phonenum", this.buE);
        acVar.k("optype", this.buF);
        acVar.lA();
    }
}

package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bkh;
    private final String buq;
    private final String bur;

    public a(String str, String str2, String str3) {
        this.bkh = str;
        this.buq = str2;
        this.bur = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        acVar.k("tid", this.bkh);
        acVar.k("phonenum", this.buq);
        acVar.k("optype", this.bur);
        acVar.lA();
    }
}

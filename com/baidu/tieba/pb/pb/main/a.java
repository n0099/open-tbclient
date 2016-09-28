package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aPH;
    private final String eot;
    private final String eou;

    public a(String str, String str2, String str3) {
        this.aPH = str;
        this.eot = str2;
        this.eou = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.n("tid", this.aPH);
        abVar.n("phonenum", this.eot);
        abVar.n("optype", this.eou);
        abVar.uu();
    }
}

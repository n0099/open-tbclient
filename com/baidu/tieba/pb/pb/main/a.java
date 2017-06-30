package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bxL;
    private final String euc;
    private final String eud;

    public a(String str, String str2, String str3) {
        this.bxL = str;
        this.euc = str2;
        this.eud = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.n("tid", this.bxL);
        abVar.n("phonenum", this.euc);
        abVar.n("optype", this.eud);
        abVar.uy();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bqq;
    private final String dif;
    private final String dig;

    public a(String str, String str2, String str3) {
        this.bqq = str;
        this.dif = str2;
        this.dig = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.n("tid", this.bqq);
        abVar.n("phonenum", this.dif);
        abVar.n("optype", this.dig);
        abVar.td();
    }
}

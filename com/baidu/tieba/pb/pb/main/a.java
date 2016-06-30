package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aJa;
    private final String dOd;
    private final String dOe;

    public a(String str, String str2, String str3) {
        this.aJa = str;
        this.dOd = str2;
        this.dOe = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.n("tid", this.aJa);
        abVar.n("phonenum", this.dOd);
        abVar.n("optype", this.dOe);
        abVar.ta();
    }
}

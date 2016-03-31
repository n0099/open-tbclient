package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bNe;
    private final String dfD;
    private final String dfE;

    public a(String str, String str2, String str3) {
        this.bNe = str;
        this.dfD = str2;
        this.dfE = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.p("tid", this.bNe);
        abVar.p("phonenum", this.dfD);
        abVar.p("optype", this.dfE);
        abVar.vw();
    }
}

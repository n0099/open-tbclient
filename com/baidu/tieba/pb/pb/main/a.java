package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String ahi;
    private final String emv;
    private final String emw;

    public a(String str, String str2, String str3) {
        this.ahi = str;
        this.emv = str2;
        this.emw = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.n("tid", this.ahi);
        abVar.n("phonenum", this.emv);
        abVar.n("optype", this.emw);
        abVar.ue();
    }
}

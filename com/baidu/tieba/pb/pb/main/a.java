package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aep;
    private final String eaq;
    private final String ear;

    public a(String str, String str2, String str3) {
        this.aep = str;
        this.eaq = str2;
        this.ear = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.n("tid", this.aep);
        abVar.n("phonenum", this.eaq);
        abVar.n("optype", this.ear);
        abVar.sZ();
    }
}

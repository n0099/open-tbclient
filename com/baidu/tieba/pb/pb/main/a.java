package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bsL;
    private final String ekt;
    private final String eku;

    public a(String str, String str2, String str3) {
        this.bsL = str;
        this.ekt = str2;
        this.eku = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.bsL);
        zVar.n("phonenum", this.ekt);
        zVar.n("optype", this.eku);
        zVar.uY();
    }
}

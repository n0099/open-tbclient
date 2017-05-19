package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bti;
    private final String efC;
    private final String efD;

    public a(String str, String str2, String str3) {
        this.bti = str;
        this.efC = str2;
        this.efD = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.bti);
        zVar.n("phonenum", this.efC);
        zVar.n("optype", this.efD);
        zVar.ul();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bqB;
    private final String ejX;
    private final String ejY;

    public a(String str, String str2, String str3) {
        this.bqB = str;
        this.ejX = str2;
        this.ejY = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.bqB);
        zVar.n("phonenum", this.ejX);
        zVar.n("optype", this.ejY);
        zVar.uB();
    }
}

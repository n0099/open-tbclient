package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aRf;
    private final String dYy;
    private final String dYz;

    public a(String str, String str2, String str3) {
        this.aRf = str;
        this.dYy = str2;
        this.dYz = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.aRf);
        zVar.n("phonenum", this.dYy);
        zVar.n("optype", this.dYz);
        zVar.uk();
    }
}

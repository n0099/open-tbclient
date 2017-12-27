package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aTs;
    private final String bAK;
    private final String fFm;

    public a(String str, String str2, String str3) {
        this.bAK = str;
        this.fFm = str2;
        this.aTs = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.bAK);
        xVar.n("phonenum", this.fFm);
        xVar.n("optype", this.aTs);
        xVar.BP();
    }
}

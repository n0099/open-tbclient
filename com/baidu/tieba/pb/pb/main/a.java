package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bDN;
    private final String eIt;
    private final String eIu;

    public a(String str, String str2, String str3) {
        this.bDN = str;
        this.eIt = str2;
        this.eIu = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        wVar.n("tid", this.bDN);
        wVar.n("phonenum", this.eIt);
        wVar.n("optype", this.eIu);
        wVar.uP();
    }
}

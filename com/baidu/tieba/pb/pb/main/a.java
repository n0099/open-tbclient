package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bDM;
    private final String eIr;
    private final String eIs;

    public a(String str, String str2, String str3) {
        this.bDM = str;
        this.eIr = str2;
        this.eIs = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        wVar.n("tid", this.bDM);
        wVar.n("phonenum", this.eIr);
        wVar.n("optype", this.eIs);
        wVar.uO();
    }
}

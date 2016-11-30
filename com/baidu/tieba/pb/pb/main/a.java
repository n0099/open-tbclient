package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aRO;
    private final String eud;
    private final String eue;

    public a(String str, String str2, String str3) {
        this.aRO = str;
        this.eud = str2;
        this.eue = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.aRO);
        zVar.n("phonenum", this.eud);
        zVar.n("optype", this.eue);
        zVar.uy();
    }
}

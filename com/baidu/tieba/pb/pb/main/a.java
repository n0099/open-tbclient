package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bIy;
    private final String ctu;
    private final String hms;

    public a(String str, String str2, String str3) {
        this.ctu = str;
        this.hms = str2;
        this.bIy = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.ctu);
        xVar.x("phonenum", this.hms);
        xVar.x("optype", this.bIy);
        xVar.acj();
    }
}

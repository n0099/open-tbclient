package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String cyX;
    private final String eBe;
    private final String eBf;

    public a(String str, String str2, String str3) {
        this.cyX = str;
        this.eBe = str2;
        this.eBf = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.cyX);
        xVar.n("phonenum", this.eBe);
        xVar.n("optype", this.eBf);
        xVar.up();
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aMq;
    private final String eJX;
    private final String eJY;

    public a(String str, String str2, String str3) {
        this.aMq = str;
        this.eJX = str2;
        this.eJY = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.aMq);
        xVar.n("phonenum", this.eJX);
        xVar.n("optype", this.eJY);
        xVar.up();
    }
}

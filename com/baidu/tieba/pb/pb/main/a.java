package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String aMX;
    private final String afh;
    private final String eSL;

    public a(String str, String str2, String str3) {
        this.aMX = str;
        this.eSL = str2;
        this.afh = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.aMX);
        xVar.n("phonenum", this.eSL);
        xVar.n("optype", this.afh);
        xVar.up();
    }
}

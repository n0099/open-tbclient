package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String cyL;
    private final String eAQ;
    private final String eAR;

    public a(String str, String str2, String str3) {
        this.cyL = str;
        this.eAQ = str2;
        this.eAR = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.cyL);
        xVar.n("phonenum", this.eAQ);
        xVar.n("optype", this.eAR);
        xVar.ui();
    }
}

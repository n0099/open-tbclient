package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bIA;
    private final String ctw;
    private final String hmf;

    public a(String str, String str2, String str3) {
        this.ctw = str;
        this.hmf = str2;
        this.bIA = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.ctw);
        xVar.x("phonenum", this.hmf);
        xVar.x("optype", this.bIA);
        xVar.acg();
    }
}

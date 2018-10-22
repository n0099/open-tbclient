package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String avN;
    private final String beh;
    private final String fKg;

    public a(String str, String str2, String str3) {
        this.beh = str;
        this.fKg = str2;
        this.avN = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.beh);
        xVar.x("phonenum", this.fKg);
        xVar.x("optype", this.avN);
        xVar.BA();
    }
}

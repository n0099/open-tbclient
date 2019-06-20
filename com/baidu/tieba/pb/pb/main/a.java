package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String bQm;
    private final String bVM;
    private final String hDK;

    public a(String str, String str2, String str3) {
        this.bVM = str;
        this.hDK = str2;
        this.bQm = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.o("tid", this.bVM);
        xVar.o("phonenum", this.hDK);
        xVar.o("optype", this.bQm);
        xVar.ahe();
    }
}

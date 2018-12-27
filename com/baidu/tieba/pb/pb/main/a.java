package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String aAa;
    private final String biz;
    private final String fVn;

    public a(String str, String str2, String str3) {
        this.biz = str;
        this.fVn = str2;
        this.aAa = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.x("tid", this.biz);
        xVar.x("phonenum", this.fVn);
        xVar.x("optype", this.aAa);
        xVar.CL();
    }
}

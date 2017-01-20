package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bjS;
    private final String ehf;
    private final String ehg;

    public a(String str, String str2, String str3) {
        this.bjS = str;
        this.ehf = str2;
        this.ehg = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        yVar.n("tid", this.bjS);
        yVar.n("phonenum", this.ehf);
        yVar.n("optype", this.ehg);
        yVar.ud();
    }
}

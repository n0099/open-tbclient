package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String buq;
    private final String elc;
    private final String eld;

    public a(String str, String str2, String str3) {
        this.buq = str;
        this.elc = str2;
        this.eld = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.buq);
        zVar.n("phonenum", this.elc);
        zVar.n("optype", this.eld);
        zVar.ug();
    }
}

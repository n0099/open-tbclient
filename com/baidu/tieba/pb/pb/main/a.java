package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bqu;
    private final String eid;
    private final String eie;

    public a(String str, String str2, String str3) {
        this.bqu = str;
        this.eid = str2;
        this.eie = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        zVar.n("tid", this.bqu);
        zVar.n("phonenum", this.eid);
        zVar.n("optype", this.eie);
        zVar.uY();
    }
}

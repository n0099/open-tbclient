package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aNu;
    private final String agj;
    private final String feo;

    public a(String str, String str2, String str3) {
        this.aNu = str;
        this.feo = str2;
        this.agj = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        xVar.n("tid", this.aNu);
        xVar.n("phonenum", this.feo);
        xVar.n("optype", this.agj);
        xVar.uL();
    }
}

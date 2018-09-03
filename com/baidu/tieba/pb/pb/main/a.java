package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aWq;
    private final String aor;
    private final String fuM;

    public a(String str, String str2, String str3) {
        this.aWq = str;
        this.fuM = str2;
        this.aor = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        yVar.o("tid", this.aWq);
        yVar.o("phonenum", this.fuM);
        yVar.o("optype", this.aor);
        yVar.yo();
    }
}

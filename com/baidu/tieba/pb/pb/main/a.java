package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class a extends Thread {
    private final String aWo;
    private final String aoO;
    private final String fuI;

    public a(String str, String str2, String str3) {
        this.aWo = str;
        this.fuI = str2;
        this.aoO = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        yVar.o("tid", this.aWo);
        yVar.o("phonenum", this.fuI);
        yVar.o("optype", this.aoO);
        yVar.yz();
    }
}

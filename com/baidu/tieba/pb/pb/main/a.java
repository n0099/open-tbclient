package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String cBj;
    private final String cBk;
    private final String cfA;

    public a(String str, String str2, String str3) {
        this.cfA = str;
        this.cBj = str2;
        this.cBk = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        abVar.o("tid", this.cfA);
        abVar.o("phonenum", this.cBj);
        abVar.o("optype", this.cBk);
        abVar.ul();
    }
}

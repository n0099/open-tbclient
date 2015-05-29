package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bKg;
    private final String bwP;
    private final String mPhoneNumber;

    public a(String str, String str2, String str3) {
        this.bwP = str;
        this.mPhoneNumber = str2;
        this.bKg = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        aaVar.o("tid", this.bwP);
        aaVar.o("phonenum", this.mPhoneNumber);
        aaVar.o("optype", this.bKg);
        aaVar.sw();
    }
}

package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bpK;
    private final String byv;
    private final String mPhoneNumber;

    public a(String str, String str2, String str3) {
        this.bpK = str;
        this.mPhoneNumber = str2;
        this.byv = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        adVar.o("tid", this.bpK);
        adVar.o("phonenum", this.mPhoneNumber);
        adVar.o("optype", this.byv);
        adVar.ov();
    }
}

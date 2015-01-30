package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bAe;
    private final String bri;
    private final String mPhoneNumber;

    public a(String str, String str2, String str3) {
        this.bri = str;
        this.mPhoneNumber = str2;
        this.bAe = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        adVar.o("tid", this.bri);
        adVar.o("phonenum", this.mPhoneNumber);
        adVar.o("optype", this.bAe);
        adVar.oy();
    }
}

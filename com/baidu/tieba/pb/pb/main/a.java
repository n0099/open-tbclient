package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends Thread {
    private final String bHE;
    private final String btQ;
    private final String mPhoneNumber;

    public a(String str, String str2, String str3) {
        this.btQ = str;
        this.mPhoneNumber = str2;
        this.bHE = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/clientcall");
        aaVar.o("tid", this.btQ);
        aaVar.o("phonenum", this.mPhoneNumber);
        aaVar.o("optype", this.bHE);
        aaVar.rO();
    }
}

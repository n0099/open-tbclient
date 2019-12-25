package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends Thread {
    private final String OC;
    private final String cUq;
    private final String iyO;

    public a(String str, String str2, String str3) {
        this.OC = str;
        this.iyO = str2;
        this.cUq = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.OC);
        xVar.addPostData("phonenum", this.iyO);
        xVar.addPostData("optype", this.cUq);
        xVar.postNetData();
    }
}

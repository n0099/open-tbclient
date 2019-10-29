package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String cix;
    private final String cmS;
    private final String hLr;

    public a(String str, String str2, String str3) {
        this.cmS = str;
        this.hLr = str2;
        this.cix = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.cmS);
        xVar.addPostData("phonenum", this.hLr);
        xVar.addPostData("optype", this.cix);
        xVar.postNetData();
    }
}

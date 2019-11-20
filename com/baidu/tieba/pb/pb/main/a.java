package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class a extends Thread {
    private final String chF;
    private final String cma;
    private final String hKA;

    public a(String str, String str2, String str3) {
        this.cma = str;
        this.hKA = str2;
        this.chF = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.cma);
        xVar.addPostData("phonenum", this.hKA);
        xVar.addPostData("optype", this.chF);
        xVar.postNetData();
    }
}

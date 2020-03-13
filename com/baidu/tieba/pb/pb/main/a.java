package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a extends Thread {
    private final String Pj;
    private final String cYE;
    private final String iEq;

    public a(String str, String str2, String str3) {
        this.Pj = str;
        this.iEq = str2;
        this.cYE = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.Pj);
        xVar.addPostData("phonenum", this.iEq);
        xVar.addPostData("optype", this.cYE);
        xVar.postNetData();
    }
}

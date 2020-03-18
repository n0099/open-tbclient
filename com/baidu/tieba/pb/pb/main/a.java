package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a extends Thread {
    private final String Pk;
    private final String cYR;
    private final String iFR;

    public a(String str, String str2, String str3) {
        this.Pk = str;
        this.iFR = str2;
        this.cYR = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.Pk);
        xVar.addPostData("phonenum", this.iFR);
        xVar.addPostData("optype", this.cYR);
        xVar.postNetData();
    }
}

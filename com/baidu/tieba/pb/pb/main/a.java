package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class a extends Thread {
    private final String OG;
    private final String cUA;
    private final String iCs;

    public a(String str, String str2, String str3) {
        this.OG = str;
        this.iCs = str2;
        this.cUA = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.OG);
        xVar.addPostData("phonenum", this.iCs);
        xVar.addPostData("optype", this.cUA);
        xVar.postNetData();
    }
}

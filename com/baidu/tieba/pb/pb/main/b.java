package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class b extends Thread {
    private final String ais;
    private final String dMk;
    private final String jGL;

    public b(String str, String str2, String str3) {
        this.ais = str;
        this.jGL = str2;
        this.dMk = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.ais);
        xVar.addPostData("phonenum", this.jGL);
        xVar.addPostData("optype", this.dMk);
        xVar.postNetData();
    }
}

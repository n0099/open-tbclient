package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a extends Thread {
    private final String ahO;
    private final String dyf;
    private final String jqc;

    public a(String str, String str2, String str3) {
        this.ahO = str;
        this.jqc = str2;
        this.dyf = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.ahO);
        xVar.addPostData("phonenum", this.jqc);
        xVar.addPostData("optype", this.dyf);
        xVar.postNetData();
    }
}

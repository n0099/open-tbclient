package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a extends Thread {
    private final String Pj;
    private final String cYC;
    private final String iEc;

    public a(String str, String str2, String str3) {
        this.Pj = str;
        this.iEc = str2;
        this.cYC = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.Pj);
        xVar.addPostData("phonenum", this.iEc);
        xVar.addPostData("optype", this.cYC);
        xVar.postNetData();
    }
}

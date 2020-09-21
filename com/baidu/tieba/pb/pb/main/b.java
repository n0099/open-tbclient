package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes21.dex */
public class b extends Thread {
    private final String alA;
    private final String elr;
    private final String kId;

    public b(String str, String str2, String str3) {
        this.alA = str;
        this.kId = str2;
        this.elr = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.alA);
        aaVar.addPostData("phonenum", this.kId);
        aaVar.addPostData("optype", this.elr);
        aaVar.postNetData();
    }
}

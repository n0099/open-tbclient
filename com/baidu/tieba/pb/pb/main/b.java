package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class b extends Thread {
    private final String amM;
    private final String eXp;
    private final String lEo;

    public b(String str, String str2, String str3) {
        this.amM = str;
        this.lEo = str2;
        this.eXp = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        zVar.addPostData("tid", this.amM);
        zVar.addPostData("phonenum", this.lEo);
        zVar.addPostData("optype", this.eXp);
        zVar.postNetData();
    }
}

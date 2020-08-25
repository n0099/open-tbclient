package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes16.dex */
public class b extends Thread {
    private final String akY;
    private final String eiY;
    private final String kzz;

    public b(String str, String str2, String str3) {
        this.akY = str;
        this.kzz = str2;
        this.eiY = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        aaVar.addPostData("tid", this.akY);
        aaVar.addPostData("phonenum", this.kzz);
        aaVar.addPostData("optype", this.eiY);
        aaVar.postNetData();
    }
}

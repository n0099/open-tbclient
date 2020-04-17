package com.baidu.tieba.pb.pb.main;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a extends Thread {
    private final String ahL;
    private final String dyb;
    private final String jpY;

    public a(String str, String str2, String str3) {
        this.ahL = str;
        this.jpY = str2;
        this.dyb = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + Config.CLIENT_CALL_ADDRESS);
        xVar.addPostData("tid", this.ahL);
        xVar.addPostData("phonenum", this.jpY);
        xVar.addPostData("optype", this.dyb);
        xVar.postNetData();
    }
}

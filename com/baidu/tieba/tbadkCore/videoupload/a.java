package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int fnh = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a fni;

    public VideoFinishResult a(String str, String str2, a.InterfaceC0079a interfaceC0079a) {
        try {
            File file = new File(str2);
            if (file == null || !file.exists()) {
                return null;
            }
            this.fni = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, fnh);
            this.fni.a(interfaceC0079a);
            return this.fni.d(str2, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bgE() {
        if (this.fni != null) {
            this.fni.cancel();
        }
    }

    public static void rk(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void rl(int i) {
        if (i <= 0) {
            fnh = 6144000;
        } else {
            fnh = i;
        }
    }
}

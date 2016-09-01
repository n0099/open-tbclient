package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int fvb = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a fvc;

    public VideoFinishResult a(String str, String str2, a.InterfaceC0079a interfaceC0079a) {
        try {
            File file = new File(str2);
            if (file == null || !file.exists()) {
                return null;
            }
            this.fvc = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, fvb);
            this.fvc.a(interfaceC0079a);
            return this.fvc.d(str2, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bkf() {
        if (this.fvc != null) {
            this.fvc.cancel();
        }
    }

    public static void rK(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void rL(int i) {
        if (i <= 0) {
            fvb = 6144000;
        } else {
            fvb = i;
        }
    }
}

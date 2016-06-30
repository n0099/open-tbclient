package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int fad = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a fae;

    public VideoFinishResult a(String str, String str2, a.InterfaceC0080a interfaceC0080a) {
        try {
            File file = new File(str2);
            if (file == null || !file.exists()) {
                return null;
            }
            this.fae = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, fad);
            this.fae.a(interfaceC0080a);
            return this.fae.c(str2, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bdm() {
        if (this.fae != null) {
            this.fae.cancel();
        }
    }

    public static void qP(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void qQ(int i) {
        if (i <= 0) {
            fad = 6144000;
        } else {
            fad = i;
        }
    }
}

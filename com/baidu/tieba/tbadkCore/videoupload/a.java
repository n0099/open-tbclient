package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int ese = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a esf;

    public VideoFinishResult a(String str, String str2, a.InterfaceC0086a interfaceC0086a) {
        try {
            File file = new File(str2);
            if (file == null || !file.exists()) {
                return null;
            }
            this.esf = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, ese);
            this.esf.a(interfaceC0086a);
            return this.esf.c(str2, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void aUx() {
        if (this.esf != null) {
            this.esf.cancel();
        }
    }

    public static void pF(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void pG(int i) {
        if (i <= 0) {
            ese = 6144000;
        } else {
            ese = i;
        }
    }
}

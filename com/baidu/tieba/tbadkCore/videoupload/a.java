package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int fxI = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a fxJ;

    public VideoFinishResult a(String str, String str2, long j, a.InterfaceC0082a interfaceC0082a) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                this.fxJ = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, fxI);
                this.fxJ.a(interfaceC0082a);
                return this.fxJ.a(str2, file, j);
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bkR() {
        if (this.fxJ != null) {
            this.fxJ.cancel();
        }
    }

    public static void rY(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void rZ(int i) {
        if (i <= 0) {
            fxI = 6144000;
        } else {
            fxI = i;
        }
    }
}

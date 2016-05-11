package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int evn = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a evo;

    public VideoFinishResult a(String str, String str2, a.InterfaceC0078a interfaceC0078a) {
        try {
            File file = new File(str2);
            if (file == null || !file.exists()) {
                return null;
            }
            this.evo = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, evn);
            this.evo.a(interfaceC0078a);
            return this.evo.c(str2, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void aUS() {
        if (this.evo != null) {
            this.evo.cancel();
        }
    }

    public static void pA(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void pB(int i) {
        if (i <= 0) {
            evn = 6144000;
        } else {
            evn = i;
        }
    }
}

package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.a;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 512000;
    private static int dZo = 6144000;
    private com.baidu.tieba.tbadkCore.videoupload.a.a dZp;

    public VideoFinishResult a(String str, String str2, a.InterfaceC0088a interfaceC0088a) {
        try {
            File file = new File(str2);
            if (file == null || !file.exists()) {
                return null;
            }
            this.dZp = new com.baidu.tieba.tbadkCore.videoupload.a.a(str, chunkLength, dZo);
            this.dZp.a(interfaceC0088a);
            return this.dZp.c(str2, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void aNw() {
        if (this.dZp != null) {
            this.dZp.cancel();
        }
    }

    public static void ov(int i) {
        if (i <= 0) {
            chunkLength = 512000;
        } else {
            chunkLength = i;
        }
    }

    public static void ow(int i) {
        if (i <= 0) {
            dZo = 6144000;
        } else {
            dZo = i;
        }
    }
}

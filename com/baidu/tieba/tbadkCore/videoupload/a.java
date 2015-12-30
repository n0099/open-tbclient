package com.baidu.tieba.tbadkCore.videoupload;

import android.os.SystemClock;
import com.baidu.adp.lib.c.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.tbadkCore.videoupload.a.b dJn;

    public VideoFinishResult mD(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void aGr() {
        if (this.dJn != null) {
            this.dJn.cancel();
        }
    }

    private VideoFinishResult b(String str, File file) {
        boolean z = e.gw().aj("movideo_split") == 0 && (file != null ? file.length() : 0L) < 2097152;
        if (z) {
            this.dJn = new d();
        } else {
            this.dJn = new com.baidu.tieba.tbadkCore.videoupload.a.c();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VideoFinishResult c = this.dJn.c(str, file);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        av avVar = new av("c10659");
        avVar.aa("obj_duration", String.valueOf(elapsedRealtime2 - elapsedRealtime));
        if (c != null && c.isSuccess()) {
            avVar.r("obj_type", 1);
        } else {
            avVar.r("obj_type", 0);
        }
        avVar.r("obj_source", i.iW());
        avVar.r("obj_name", z ? 0 : 1);
        TiebaStatic.log(avVar);
        return c;
    }
}

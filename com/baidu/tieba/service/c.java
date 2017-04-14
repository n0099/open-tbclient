package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
class c extends Thread {
    final /* synthetic */ ClearTempService fgD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClearTempService clearTempService) {
        this.fgD = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(l.yq + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
            File file2 = new File(l.yq + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME);
            File file3 = new File(l.yq + "/" + TbConfig.getTempDirName() + "/voice");
            this.fgD.deleteCache(file, false);
            this.fgD.deleteDir(file2);
            this.fgD.deleteDir(file3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        handler = this.fgD.handler;
        handler2 = this.fgD.handler;
        handler.sendMessage(handler2.obtainMessage());
    }
}

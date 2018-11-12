package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long fxX;
    private long fxY;
    private boolean fxZ;

    public void baT() {
        this.fxZ = true;
        this.fxX = SystemClock.elapsedRealtime();
    }

    public void baU() {
        this.fxY = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2, QuickVideoView quickVideoView) {
        if (this.fxZ) {
            this.fxZ = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.fxY - this.fxX;
            long j4 = elapsedRealtime - this.fxY;
            long j5 = elapsedRealtime - this.fxX;
            if (com.baidu.adp.lib.util.j.lb() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.h("obj_param1", j3);
                amVar.h("obj_param2", j4);
                amVar.h("obj_param3", j5);
                amVar.h("obj_duration", j2);
                amVar.h("resource_id", j);
                amVar.x("ptype", com.baidu.adp.lib.util.j.lb());
                amVar.ax("tid", str);
                amVar.ax("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, aa.gb(rG(str2)) ? 1 : 0);
                amVar.h(ETAG.KEY_TIME_STAMP, System.currentTimeMillis());
                TiebaStatic.log(amVar);
                if (quickVideoView != null) {
                    quickVideoView.a(str2, j3, j4, j5, j2, j, str, aa.gb(rG(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int rG(String str) {
        if ("frs".equals(str)) {
            return 2;
        }
        if ("homepage".equals(str)) {
            return 1;
        }
        if ("middle".equals(str)) {
            return 4;
        }
        return 0;
    }
}

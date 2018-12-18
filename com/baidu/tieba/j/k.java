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
    private long fEN;
    private long fEO;
    private boolean fEP;

    public void bcJ() {
        this.fEP = true;
        this.fEN = SystemClock.elapsedRealtime();
    }

    public void bcK() {
        this.fEO = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2, QuickVideoView quickVideoView) {
        if (this.fEP) {
            this.fEP = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.fEO - this.fEN;
            long j4 = elapsedRealtime - this.fEO;
            long j5 = elapsedRealtime - this.fEN;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.i("obj_param1", j3);
                amVar.i("obj_param2", j4);
                amVar.i("obj_param3", j5);
                amVar.i("obj_duration", j2);
                amVar.i("resource_id", j);
                amVar.x("ptype", com.baidu.adp.lib.util.j.netType());
                amVar.aA("tid", str);
                amVar.aA("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, aa.gp(si(str2)) ? 1 : 0);
                amVar.i(ETAG.KEY_TIME_STAMP, System.currentTimeMillis());
                TiebaStatic.log(amVar);
                if (quickVideoView != null) {
                    quickVideoView.a(str2, j3, j4, j5, j2, j, str, aa.gp(si(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int si(String str) {
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

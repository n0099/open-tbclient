package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.play.QuickVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long hpU;
    private long hpV;
    private boolean hpW;

    public void bMl() {
        this.hpW = true;
        this.hpU = SystemClock.elapsedRealtime();
    }

    public void bMm() {
        this.hpV = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2, QuickVideoView quickVideoView) {
        if (this.hpW) {
            this.hpW = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.hpV - this.hpU;
            long j4 = elapsedRealtime - this.hpV;
            long j5 = elapsedRealtime - this.hpU;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.l("obj_param1", j3);
                amVar.l("obj_param2", j4);
                amVar.l("obj_param3", j5);
                amVar.l("obj_duration", j2);
                amVar.l("resource_id", j);
                amVar.P("ptype", com.baidu.adp.lib.util.j.netType());
                amVar.bT("tid", str);
                amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.P(VideoPlayActivityConfig.OBJ_ID, ad.kS(At(str2)) ? 1 : 0);
                amVar.l("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(amVar);
                if (quickVideoView != null) {
                    quickVideoView.a(str2, j3, j4, j5, j2, j, str, ad.kS(At(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int At(String str) {
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

package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.adp.lib.util.j;
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
    private long gYN;
    private long gYO;
    private boolean gYP;

    public void bEB() {
        this.gYP = true;
        this.gYN = SystemClock.elapsedRealtime();
    }

    public void bEC() {
        this.gYO = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2, QuickVideoView quickVideoView) {
        if (this.gYP) {
            this.gYP = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.gYO - this.gYN;
            long j4 = elapsedRealtime - this.gYO;
            long j5 = elapsedRealtime - this.gYN;
            if (j.netType() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.k("obj_param1", j3);
                amVar.k("obj_param2", j4);
                amVar.k("obj_param3", j5);
                amVar.k("obj_duration", j2);
                amVar.k("resource_id", j);
                amVar.T("ptype", j.netType());
                amVar.bJ("tid", str);
                amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.T(VideoPlayActivityConfig.OBJ_ID, ad.ke(zg(str2)) ? 1 : 0);
                amVar.k("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(amVar);
                if (quickVideoView != null) {
                    quickVideoView.a(str2, j3, j4, j5, j2, j, str, ad.ke(zg(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int zg(String str) {
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

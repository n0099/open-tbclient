package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.play.QuickVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long hwh;
    private long hwi;
    private boolean hwj;

    public void bOU() {
        this.hwj = true;
        this.hwh = SystemClock.elapsedRealtime();
    }

    public void bOV() {
        this.hwi = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2, QuickVideoView quickVideoView) {
        if (this.hwj) {
            this.hwj = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.hwi - this.hwh;
            long j4 = elapsedRealtime - this.hwi;
            long j5 = elapsedRealtime - this.hwh;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                an anVar = new an("c13171");
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                anVar.l("obj_param1", j3);
                anVar.l("obj_param2", j4);
                anVar.l("obj_param3", j5);
                anVar.l("obj_duration", j2);
                anVar.l("resource_id", j);
                anVar.P("ptype", com.baidu.adp.lib.util.j.netType());
                anVar.bT("tid", str);
                anVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
                anVar.P(VideoPlayActivityConfig.OBJ_ID, ad.kY(Bg(str2)) ? 1 : 0);
                anVar.l("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(anVar);
                if (quickVideoView != null) {
                    quickVideoView.a(str2, j3, j4, j5, j2, j, str, ad.kY(Bg(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int Bg(String str) {
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

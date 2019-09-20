package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ac;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long hyT;
    private long hyU;
    private long hyV;
    private boolean hyW;
    private String hyX = "";

    public void bPV() {
        this.hyW = true;
        this.hyT = SystemClock.elapsedRealtime();
    }

    public void bPW() {
        this.hyU = SystemClock.elapsedRealtime();
    }

    public void bPX() {
        this.hyV = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, com.baidu.tieba.play.a.a aVar) {
        a(str, j, j2, this.hyX, aVar);
    }

    public void a(String str, long j, long j2, String str2, com.baidu.tieba.play.a.a aVar) {
        if (this.hyW) {
            this.hyW = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.hyU - this.hyT;
            long j4 = elapsedRealtime - this.hyV;
            long j5 = j4 + j3;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                an anVar = new an("c13171");
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                anVar.n("obj_param1", j3);
                anVar.n("obj_param2", j4);
                anVar.n("obj_param3", j5);
                anVar.n("obj_duration", j2);
                anVar.n("resource_id", j);
                anVar.P("ptype", com.baidu.adp.lib.util.j.netType());
                anVar.bT("tid", str);
                anVar.bT(DpStatConstants.KEY_CUID, TbadkCoreApplication.getInst().getCuid());
                anVar.P(VideoPlayActivityConfig.OBJ_ID, ac.ld(BG(str2)) ? 1 : 0);
                anVar.n("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(anVar);
                if (aVar != null) {
                    aVar.a(str2, j3, j4, j5, j2, j, str, ac.ld(BG(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int BG(String str) {
        if ("frs".equals(str)) {
            return 2;
        }
        if ("homepage".equals(str)) {
            return 1;
        }
        if ("middle".equals(str)) {
            return 4;
        }
        if ("pb".equals(str)) {
            return 3;
        }
        return 0;
    }

    public void setPageTypeForPerfStat(String str) {
        this.hyX = str;
    }
}

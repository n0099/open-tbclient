package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.y;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long fhw;
    private long fhx;
    private boolean fhy;

    public void aVU() {
        this.fhy = true;
        this.fhw = SystemClock.elapsedRealtime();
    }

    public void aVV() {
        this.fhx = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2) {
        if (this.fhy) {
            this.fhy = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.fhx - this.fhw;
            long j4 = elapsedRealtime - this.fhx;
            long j5 = elapsedRealtime - this.fhw;
            if (com.baidu.adp.lib.util.j.jK() == 2 || j3 <= 17500) {
                an anVar = new an("c13171");
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                anVar.f("obj_param1", j3);
                anVar.f("obj_param2", j4);
                anVar.f("obj_param3", j5);
                anVar.f("obj_duration", j2);
                anVar.f("resource_id", j);
                anVar.r("ptype", com.baidu.adp.lib.util.j.jK());
                anVar.ae("tid", str);
                anVar.ae("cuid", TbadkCoreApplication.getInst().getCuid());
                anVar.r(VideoPlayActivityConfig.OBJ_ID, y.fs(qA(str2)) ? 1 : 0);
                anVar.f("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(anVar);
            }
        }
    }

    private int qA(String str) {
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

package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long fhC;
    private long fhD;
    private boolean fhE;

    public void aVY() {
        this.fhE = true;
        this.fhC = SystemClock.elapsedRealtime();
    }

    public void aVZ() {
        this.fhD = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2) {
        if (this.fhE) {
            this.fhE = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.fhD - this.fhC;
            long j4 = elapsedRealtime - this.fhD;
            long j5 = elapsedRealtime - this.fhC;
            if (j3 <= 17500) {
                an anVar = new an("c13171");
                anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                anVar.f("obj_param1", j3);
                anVar.f("obj_param2", j4);
                anVar.f("obj_param3", j5);
                anVar.f("obj_duration", j2);
                anVar.f("resource_id", j);
                anVar.r("ptype", com.baidu.adp.lib.util.j.jK());
                anVar.af("tid", str);
                TiebaStatic.log(anVar);
            }
        }
    }
}

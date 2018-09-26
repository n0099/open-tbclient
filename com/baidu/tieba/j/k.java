package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.aa;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long foT;
    private long foU;
    private boolean foV;

    public void aYi() {
        this.foV = true;
        this.foT = SystemClock.elapsedRealtime();
    }

    public void aYj() {
        this.foU = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2) {
        if (this.foV) {
            this.foV = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.foU - this.foT;
            long j4 = elapsedRealtime - this.foU;
            long j5 = elapsedRealtime - this.foT;
            if (com.baidu.adp.lib.util.j.kQ() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.g("obj_param1", j3);
                amVar.g("obj_param2", j4);
                amVar.g("obj_param3", j5);
                amVar.g("obj_duration", j2);
                amVar.g("resource_id", j);
                amVar.w("ptype", com.baidu.adp.lib.util.j.kQ());
                amVar.al("tid", str);
                amVar.al("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.w(VideoPlayActivityConfig.OBJ_ID, aa.fE(rf(str2)) ? 1 : 0);
                amVar.g("time_stamp", System.currentTimeMillis());
                TiebaStatic.log(amVar);
            }
        }
    }

    private int rf(String str) {
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

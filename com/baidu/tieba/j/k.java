package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.aa;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long fwA;
    private boolean fwB;
    private long fwz;

    public void bbu() {
        this.fwB = true;
        this.fwz = SystemClock.elapsedRealtime();
    }

    public void bbv() {
        this.fwA = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2) {
        if (this.fwB) {
            this.fwB = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.fwA - this.fwz;
            long j4 = elapsedRealtime - this.fwA;
            long j5 = elapsedRealtime - this.fwz;
            if (com.baidu.adp.lib.util.j.ld() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.h("obj_param1", j3);
                amVar.h("obj_param2", j4);
                amVar.h("obj_param3", j5);
                amVar.h("obj_duration", j2);
                amVar.h("resource_id", j);
                amVar.x("ptype", com.baidu.adp.lib.util.j.ld());
                amVar.ax("tid", str);
                amVar.ax("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.x(VideoPlayActivityConfig.OBJ_ID, aa.fN(rF(str2)) ? 1 : 0);
                amVar.h(ETAG.KEY_TIME_STAMP, System.currentTimeMillis());
                TiebaStatic.log(amVar);
            }
        }
    }

    private int rF(String str) {
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

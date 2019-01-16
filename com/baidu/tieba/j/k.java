package com.baidu.tieba.j;

import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long fIA;
    private boolean fIB;
    private long fIz;

    public void bdX() {
        this.fIB = true;
        this.fIz = SystemClock.elapsedRealtime();
    }

    public void bdY() {
        this.fIA = SystemClock.elapsedRealtime();
    }

    public void a(String str, long j, long j2, String str2, QuickVideoView quickVideoView) {
        if (this.fIB) {
            this.fIB = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.fIA - this.fIz;
            long j4 = elapsedRealtime - this.fIA;
            long j5 = elapsedRealtime - this.fIz;
            if (com.baidu.adp.lib.util.j.netType() == 2 || j3 <= 17500) {
                am amVar = new am("c13171");
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str2);
                amVar.i("obj_param1", j3);
                amVar.i("obj_param2", j4);
                amVar.i("obj_param3", j5);
                amVar.i("obj_duration", j2);
                amVar.i("resource_id", j);
                amVar.y("ptype", com.baidu.adp.lib.util.j.netType());
                amVar.aB("tid", str);
                amVar.aB("cuid", TbadkCoreApplication.getInst().getCuid());
                amVar.y(VideoPlayActivityConfig.OBJ_ID, ab.gq(sC(str2)) ? 1 : 0);
                amVar.i(ETAG.KEY_TIME_STAMP, System.currentTimeMillis());
                TiebaStatic.log(amVar);
                if (quickVideoView != null) {
                    quickVideoView.a(str2, j3, j4, j5, j2, j, str, ab.gq(sC(str2)) ? 1 : 0);
                }
            }
        }
    }

    private int sC(String str) {
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

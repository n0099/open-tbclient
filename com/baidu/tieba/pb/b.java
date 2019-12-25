package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public interface a {
        void k(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "fid", str6, "fname", str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", PraiseDataPassUtil.KEY_FROM_OS, BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            an cp = new an("ad_tpoint").cp("obj_id", String.valueOf(j)).cp("obj_name", str);
            if (str3 != null) {
                cp = cp.cp("page", str3);
            }
            if (str4 != null) {
                cp = cp.cp("loc_param", str4);
            }
            if (str5 != null) {
                cp = cp.cp(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str5);
            }
            if (str6 != null) {
                cp = cp.cp("task", str6);
            }
            if (str7 != null) {
                cp = cp.cp("obj_param", str7);
            }
            if (str8 != null) {
                cp = cp.cp("params", str8);
            }
            if (str9 != null) {
                cp = cp.cp("fid", str9);
            }
            if (str10 != null) {
                cp = cp.cp("fname", str10);
            }
            if (str11 != null) {
                cp = cp.cp("tid", str11);
            }
            an cp2 = cp.cp("line", "PT").cp("locate", "c0114").Z("obj_cpid", 0).Z("obj_good_id", 0).cp("obj_throw_type", "BY_POST").cp("client_type", "MOBILE_APP").cp("user_timestamp", String.valueOf(System.currentTimeMillis())).cp("os", PraiseDataPassUtil.KEY_FROM_OS).cp(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).cp("log_ver", "1.1");
            if (str2 != null) {
                cp2 = cp2.cp("link", str2);
            }
            TiebaStatic.log(cp2);
        }
    }
}

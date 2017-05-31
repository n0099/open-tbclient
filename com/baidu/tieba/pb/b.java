package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public interface a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "fid", str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            as Z = new as("ad_tpoint").Z("obj_id", String.valueOf(j)).Z("obj_name", str);
            if (str3 != null) {
                Z = Z.Z("page", str3);
            }
            if (str4 != null) {
                Z = Z.Z("loc_param", str4);
            }
            if (str5 != null) {
                Z = Z.Z("action_type", str5);
            }
            if (str6 != null) {
                Z = Z.Z("task", str6);
            }
            if (str7 != null) {
                Z = Z.Z("obj_param", str7);
            }
            if (str8 != null) {
                Z = Z.Z(LegoListActivityConfig.PARAMS, str8);
            }
            if (str9 != null) {
                Z = Z.Z("fid", str9);
            }
            if (str10 != null) {
                Z = Z.Z(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                Z = Z.Z("tid", str11);
            }
            as Z2 = Z.Z("line", "PT").Z("locate", "c0114").r("obj_cpid", 0).r("obj_good_id", 0).Z("obj_throw_type", "BY_POST").Z("client_type", "MOBILE_APP").Z("user_timestamp", String.valueOf(System.currentTimeMillis())).Z("os", "android").Z("os_version", Build.VERSION.RELEASE).Z("log_ver", "1.1");
            if (str2 != null) {
                Z2 = Z2.Z("link", str2);
            }
            TiebaStatic.log(Z2);
        }
    }
}

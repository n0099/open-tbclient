package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0135a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            ak ab = new ak("ad_tpoint").ab("obj_id", String.valueOf(j)).ab("obj_name", str);
            if (str3 != null) {
                ab = ab.ab("page", str3);
            }
            if (str4 != null) {
                ab = ab.ab("loc_param", str4);
            }
            if (str5 != null) {
                ab = ab.ab("action_type", str5);
            }
            if (str6 != null) {
                ab = ab.ab("task", str6);
            }
            if (str7 != null) {
                ab = ab.ab("obj_param", str7);
            }
            if (str8 != null) {
                ab = ab.ab(LegoListActivityConfig.PARAMS, str8);
            }
            if (str9 != null) {
                ab = ab.ab(ImageViewerConfig.FORUM_ID, str9);
            }
            if (str10 != null) {
                ab = ab.ab(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                ab = ab.ab("tid", str11);
            }
            ak ab2 = ab.ab("line", "PT").ab("locate", "c0114").s("obj_cpid", 0).s("obj_good_id", 0).ab("obj_throw_type", "BY_POST").ab("client_type", "MOBILE_APP").ab("user_timestamp", String.valueOf(System.currentTimeMillis())).ab("os", "android").ab("os_version", Build.VERSION.RELEASE).ab("log_ver", "1.1");
            if (str2 != null) {
                ab2 = ab2.ab("link", str2);
            }
            TiebaStatic.log(ab2);
        }
    }
}

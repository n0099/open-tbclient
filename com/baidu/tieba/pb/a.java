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
    public interface InterfaceC0109a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "fid", str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            ak ad = new ak("ad_tpoint").ad("obj_id", String.valueOf(j)).ad("obj_name", str);
            if (str3 != null) {
                ad = ad.ad("page", str3);
            }
            if (str4 != null) {
                ad = ad.ad("loc_param", str4);
            }
            if (str5 != null) {
                ad = ad.ad("action_type", str5);
            }
            if (str6 != null) {
                ad = ad.ad("task", str6);
            }
            if (str7 != null) {
                ad = ad.ad("obj_param", str7);
            }
            if (str8 != null) {
                ad = ad.ad(LegoListActivityConfig.PARAMS, str8);
            }
            if (str9 != null) {
                ad = ad.ad("fid", str9);
            }
            if (str10 != null) {
                ad = ad.ad(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                ad = ad.ad("tid", str11);
            }
            ak ad2 = ad.ad("line", "PT").ad("locate", "c0114").r("obj_cpid", 0).r("obj_good_id", 0).ad("obj_throw_type", "BY_POST").ad("client_type", "MOBILE_APP").ad("user_timestamp", String.valueOf(System.currentTimeMillis())).ad("os", "android").ad("os_version", Build.VERSION.RELEASE).ad("log_ver", "1.1");
            if (str2 != null) {
                ad2 = ad2.ad("link", str2);
            }
            TiebaStatic.log(ad2);
        }
    }
}

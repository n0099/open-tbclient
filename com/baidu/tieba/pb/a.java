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
    public interface InterfaceC0110a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            ak ac = new ak("ad_tpoint").ac("obj_id", String.valueOf(j)).ac("obj_name", str);
            if (str3 != null) {
                ac = ac.ac("page", str3);
            }
            if (str4 != null) {
                ac = ac.ac("loc_param", str4);
            }
            if (str5 != null) {
                ac = ac.ac("action_type", str5);
            }
            if (str6 != null) {
                ac = ac.ac("task", str6);
            }
            if (str7 != null) {
                ac = ac.ac("obj_param", str7);
            }
            if (str8 != null) {
                ac = ac.ac(LegoListActivityConfig.PARAMS, str8);
            }
            if (str9 != null) {
                ac = ac.ac(ImageViewerConfig.FORUM_ID, str9);
            }
            if (str10 != null) {
                ac = ac.ac(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                ac = ac.ac("tid", str11);
            }
            ak ac2 = ac.ac("line", "PT").ac("locate", "c0114").r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", "android").ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            if (str2 != null) {
                ac2 = ac2.ac("link", str2);
            }
            TiebaStatic.log(ac2);
        }
    }
}

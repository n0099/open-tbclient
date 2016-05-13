package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public interface a {
        int avk();

        void z(String str, String str2, String str3);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", "fid", str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (j > 0) {
            aw ac = new aw("ad_tpoint").ac("obj_id", String.valueOf(j)).ac("obj_name", str);
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
                ac = ac.ac("fid", str7);
            }
            if (str8 != null) {
                ac = ac.ac(ImageViewerConfig.FORUM_NAME, str8);
            }
            if (str9 != null) {
                ac = ac.ac("tid", str9);
            }
            aw ac2 = ac.ac("line", "PT").ac("locate", "c0114").s("obj_cpid", 0).s("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", SocialConstants.ANDROID_CLIENT_TYPE).ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            if (str2 != null) {
                ac2 = ac2.ac("link", str2);
            }
            TiebaStatic.log(ac2);
        }
    }
}

package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        int aoo();

        void u(String str, String str2, String str3);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (j > 0) {
            au aa = new au("ad_tpoint").aa("obj_id", String.valueOf(j)).aa("obj_name", str);
            if (str3 != null) {
                aa = aa.aa("page", str3);
            }
            if (str4 != null) {
                aa = aa.aa("loc_param", str4);
            }
            if (str5 != null) {
                aa = aa.aa("action_type", str5);
            }
            if (str6 != null) {
                aa = aa.aa("task", str6);
            }
            if (str7 != null) {
                aa = aa.aa(ImageViewerConfig.FORUM_ID, str7);
            }
            if (str8 != null) {
                aa = aa.aa(ImageViewerConfig.FORUM_NAME, str8);
            }
            if (str9 != null) {
                aa = aa.aa("tid", str9);
            }
            au aa2 = aa.aa("line", "PT").aa("locate", "c0114").r("obj_cpid", 0).r("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", SocialConstants.ANDROID_CLIENT_TYPE).aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
            if (str2 != null) {
                aa2 = aa2.aa("link", str2);
            }
            TiebaStatic.log(aa2);
        }
    }
}

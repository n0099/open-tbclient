package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class a {
    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", SocialConstants.ANDROID_CLIENT_TYPE, "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }
}

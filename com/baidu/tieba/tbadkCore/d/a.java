package com.baidu.tieba.tbadkCore.d;

import android.os.Build;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        au auVar = new au("ad_tpoint");
        if (str != null) {
            auVar = auVar.aa("page", str);
        }
        if (str2 != null) {
            auVar = auVar.aa("loc_param", str2);
        }
        if (str3 != null) {
            auVar = auVar.aa("action_type", str3);
        }
        if (str4 != null) {
            auVar = auVar.aa(ImageViewerConfig.FORUM_ID, str4);
        }
        if (str5 != null) {
            auVar = auVar.aa(ImageViewerConfig.FORUM_NAME, str5);
        }
        if (str6 != null) {
            auVar = auVar.aa("tid", str6);
        }
        if (str8 != null) {
            auVar = auVar.aa("obj_url", str8);
        }
        au aa = auVar.aa("task", "ad_plat").aa("line", "PT").aa("locate", "c0112").r("obj_cpid", 0).r("obj_good_id", 0).aa("obj_throw_type", "BY_POST").aa(SocialConstants.PARAM_CLIENT_TYPE, "MOBILE_APP").aa("user_timestamp", String.valueOf(System.currentTimeMillis())).aa("os", SocialConstants.ANDROID_CLIENT_TYPE).aa("os_version", Build.VERSION.RELEASE).aa("log_ver", "1.1");
        if (str7 != null) {
            aa = aa.aa("link", str7);
        }
        TiebaStatic.log(aa);
    }

    public static void bn(String str, String str2) {
        if (!aw.isEmpty(str)) {
            au auVar = new au(str);
            if (str2 != null) {
                auVar = auVar.aa("obj_type", str2);
            }
            TiebaStatic.log(auVar);
        }
    }
}

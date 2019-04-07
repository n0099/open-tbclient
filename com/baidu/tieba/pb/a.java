package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0348a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, VideoPlayActivityConfig.OBJ_ID, String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            am bJ = new am("ad_tpoint").bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(j)).bJ("obj_name", str);
            if (str3 != null) {
                bJ = bJ.bJ("page", str3);
            }
            if (str4 != null) {
                bJ = bJ.bJ("loc_param", str4);
            }
            if (str5 != null) {
                bJ = bJ.bJ("action_type", str5);
            }
            if (str6 != null) {
                bJ = bJ.bJ("task", str6);
            }
            if (str7 != null) {
                bJ = bJ.bJ("obj_param", str7);
            }
            if (str8 != null) {
                bJ = bJ.bJ("params", str8);
            }
            if (str9 != null) {
                bJ = bJ.bJ(ImageViewerConfig.FORUM_ID, str9);
            }
            if (str10 != null) {
                bJ = bJ.bJ(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                bJ = bJ.bJ("tid", str11);
            }
            am bJ2 = bJ.bJ("line", "PT").bJ("locate", "c0114").T("obj_cpid", 0).T("obj_good_id", 0).bJ("obj_throw_type", "BY_POST").bJ("client_type", "MOBILE_APP").bJ("user_timestamp", String.valueOf(System.currentTimeMillis())).bJ("os", "android").bJ("os_version", Build.VERSION.RELEASE).bJ("log_ver", "1.1");
            if (str2 != null) {
                bJ2 = bJ2.bJ(SelectForumActivityConfig.KEY_SHARE_LINK, str2);
            }
            TiebaStatic.log(bJ2);
        }
    }
}

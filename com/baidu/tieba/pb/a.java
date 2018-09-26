package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0206a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str4, "task", str5, VideoPlayActivityConfig.OBJ_ID, String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", HttpConstants.OS_TYPE_VALUE, StatisticConstants.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            am al = new am("ad_tpoint").al(VideoPlayActivityConfig.OBJ_ID, String.valueOf(j)).al("obj_name", str);
            if (str3 != null) {
                al = al.al("page", str3);
            }
            if (str4 != null) {
                al = al.al("loc_param", str4);
            }
            if (str5 != null) {
                al = al.al(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str5);
            }
            if (str6 != null) {
                al = al.al("task", str6);
            }
            if (str7 != null) {
                al = al.al("obj_param", str7);
            }
            if (str8 != null) {
                al = al.al(LegoListActivityConfig.PARAMS, str8);
            }
            if (str9 != null) {
                al = al.al(ImageViewerConfig.FORUM_ID, str9);
            }
            if (str10 != null) {
                al = al.al(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                al = al.al("tid", str11);
            }
            am al2 = al.al("line", "PT").al("locate", "c0114").w("obj_cpid", 0).w("obj_good_id", 0).al("obj_throw_type", "BY_POST").al("client_type", "MOBILE_APP").al("user_timestamp", String.valueOf(System.currentTimeMillis())).al("os", HttpConstants.OS_TYPE_VALUE).al(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).al("log_ver", "1.1");
            if (str2 != null) {
                al2 = al2.al("link", str2);
            }
            TiebaStatic.log(al2);
        }
    }
}

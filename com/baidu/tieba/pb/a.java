package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0203a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str4, "task", str5, VideoPlayActivityConfig.OBJ_ID, String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", HttpConstants.OS_TYPE_VALUE, StatisticConstants.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            an ae = new an("ad_tpoint").ae(VideoPlayActivityConfig.OBJ_ID, String.valueOf(j)).ae("obj_name", str);
            if (str3 != null) {
                ae = ae.ae("page", str3);
            }
            if (str4 != null) {
                ae = ae.ae("loc_param", str4);
            }
            if (str5 != null) {
                ae = ae.ae(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str5);
            }
            if (str6 != null) {
                ae = ae.ae("task", str6);
            }
            if (str7 != null) {
                ae = ae.ae("obj_param", str7);
            }
            if (str8 != null) {
                ae = ae.ae(LegoListActivityConfig.PARAMS, str8);
            }
            if (str9 != null) {
                ae = ae.ae(ImageViewerConfig.FORUM_ID, str9);
            }
            if (str10 != null) {
                ae = ae.ae(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                ae = ae.ae("tid", str11);
            }
            an ae2 = ae.ae("line", "PT").ae("locate", "c0114").r("obj_cpid", 0).r("obj_good_id", 0).ae("obj_throw_type", "BY_POST").ae("client_type", "MOBILE_APP").ae("user_timestamp", String.valueOf(System.currentTimeMillis())).ae("os", HttpConstants.OS_TYPE_VALUE).ae(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).ae("log_ver", "1.1");
            if (str2 != null) {
                ae2 = ae2.ae("link", str2);
            }
            TiebaStatic.log(ae2);
        }
    }
}

package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.ar.util.Constants;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0186a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", WBPageConstants.ParamKey.PAGE, str2, "locate", "c0114", "loc_param", str3, LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str4, "task", str5, VideoPlayActivityConfig.OBJ_ID, String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", Constants.OS_TYPE_VALUE, "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            al ac = new al("ad_tpoint").ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(j)).ac("obj_name", str);
            if (str3 != null) {
                ac = ac.ac(WBPageConstants.ParamKey.PAGE, str3);
            }
            if (str4 != null) {
                ac = ac.ac("loc_param", str4);
            }
            if (str5 != null) {
                ac = ac.ac(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str5);
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
            al ac2 = ac.ac("line", "PT").ac("locate", "c0114").r("obj_cpid", 0).r("obj_good_id", 0).ac("obj_throw_type", "BY_POST").ac("client_type", "MOBILE_APP").ac("user_timestamp", String.valueOf(System.currentTimeMillis())).ac("os", Constants.OS_TYPE_VALUE).ac("os_version", Build.VERSION.RELEASE).ac("log_ver", "1.1");
            if (str2 != null) {
                ac2 = ac2.ac("link", str2);
            }
            TiebaStatic.log(ac2);
        }
    }
}

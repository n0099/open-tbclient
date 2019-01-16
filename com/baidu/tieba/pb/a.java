package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
    public interface InterfaceC0278a {
        void d(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", SystemScreenshotManager.PAGE, str2, "locate", "c0114", "loc_param", str3, LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str4, WebSocketAction.PARAM_KEY_TASK, str5, VideoPlayActivityConfig.OBJ_ID, String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", ImageViewerConfig.FORUM_ID, str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", HttpConstants.OS_TYPE_VALUE, StatisticConstants.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            am aB = new am("ad_tpoint").aB(VideoPlayActivityConfig.OBJ_ID, String.valueOf(j)).aB("obj_name", str);
            if (str3 != null) {
                aB = aB.aB(SystemScreenshotManager.PAGE, str3);
            }
            if (str4 != null) {
                aB = aB.aB("loc_param", str4);
            }
            if (str5 != null) {
                aB = aB.aB(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str5);
            }
            if (str6 != null) {
                aB = aB.aB(WebSocketAction.PARAM_KEY_TASK, str6);
            }
            if (str7 != null) {
                aB = aB.aB("obj_param", str7);
            }
            if (str8 != null) {
                aB = aB.aB("params", str8);
            }
            if (str9 != null) {
                aB = aB.aB(ImageViewerConfig.FORUM_ID, str9);
            }
            if (str10 != null) {
                aB = aB.aB(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                aB = aB.aB("tid", str11);
            }
            am aB2 = aB.aB("line", "PT").aB("locate", "c0114").y("obj_cpid", 0).y("obj_good_id", 0).aB("obj_throw_type", "BY_POST").aB("client_type", "MOBILE_APP").aB("user_timestamp", String.valueOf(System.currentTimeMillis())).aB("os", HttpConstants.OS_TYPE_VALUE).aB(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE).aB("log_ver", "1.1");
            if (str2 != null) {
                aB2 = aB2.aB(SelectForumActivityConfig.KEY_SHARE_LINK, str2);
            }
            TiebaStatic.log(aB2);
        }
    }
}

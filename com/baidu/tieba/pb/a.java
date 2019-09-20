package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0382a {
        void h(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, VideoPlayActivityConfig.OBJ_ID, String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "fid", str6, ImageViewerConfig.FORUM_NAME, str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), IXAdRequestInfo.OS, "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            an bT = new an("ad_tpoint").bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(j)).bT("obj_name", str);
            if (str3 != null) {
                bT = bT.bT("page", str3);
            }
            if (str4 != null) {
                bT = bT.bT("loc_param", str4);
            }
            if (str5 != null) {
                bT = bT.bT("action_type", str5);
            }
            if (str6 != null) {
                bT = bT.bT("task", str6);
            }
            if (str7 != null) {
                bT = bT.bT("obj_param", str7);
            }
            if (str8 != null) {
                bT = bT.bT("params", str8);
            }
            if (str9 != null) {
                bT = bT.bT("fid", str9);
            }
            if (str10 != null) {
                bT = bT.bT(ImageViewerConfig.FORUM_NAME, str10);
            }
            if (str11 != null) {
                bT = bT.bT("tid", str11);
            }
            an bT2 = bT.bT("line", "PT").bT("locate", "c0114").P("obj_cpid", 0).P("obj_good_id", 0).bT("obj_throw_type", "BY_POST").bT("client_type", "MOBILE_APP").bT("user_timestamp", String.valueOf(System.currentTimeMillis())).bT(IXAdRequestInfo.OS, "android").bT("os_version", Build.VERSION.RELEASE).bT("log_ver", "1.1");
            if (str2 != null) {
                bT2 = bT2.bT(SelectForumActivityConfig.KEY_SHARE_LINK, str2);
            }
            TiebaStatic.log(bT2);
        }
    }
}

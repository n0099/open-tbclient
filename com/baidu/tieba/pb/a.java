package com.baidu.tieba.pb;

import android.os.Build;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.pb.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0471a {
        void k(String str, String str2, String str3, String str4, String str5);
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (j != 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", str2, "locate", "c0114", "loc_param", str3, "action_type", str4, "task", str5, "obj_id", String.valueOf(j), "obj_name", String.valueOf(j), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "fid", str6, "fname", str7, "tid", str8, "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
        }
    }

    public static void a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j > 0) {
            an bS = new an("ad_tpoint").bS("obj_id", String.valueOf(j)).bS("obj_name", str);
            if (str3 != null) {
                bS = bS.bS("page", str3);
            }
            if (str4 != null) {
                bS = bS.bS("loc_param", str4);
            }
            if (str5 != null) {
                bS = bS.bS("action_type", str5);
            }
            if (str6 != null) {
                bS = bS.bS("task", str6);
            }
            if (str7 != null) {
                bS = bS.bS("obj_param", str7);
            }
            if (str8 != null) {
                bS = bS.bS("params", str8);
            }
            if (str9 != null) {
                bS = bS.bS("fid", str9);
            }
            if (str10 != null) {
                bS = bS.bS("fname", str10);
            }
            if (str11 != null) {
                bS = bS.bS("tid", str11);
            }
            an bS2 = bS.bS("line", "PT").bS("locate", "c0114").O("obj_cpid", 0).O("obj_good_id", 0).bS("obj_throw_type", "BY_POST").bS("client_type", "MOBILE_APP").bS("user_timestamp", String.valueOf(System.currentTimeMillis())).bS("os", "android").bS(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE).bS("log_ver", "1.1");
            if (str2 != null) {
                bS2 = bS2.bS("link", str2);
            }
            TiebaStatic.log(bS2);
        }
    }
}

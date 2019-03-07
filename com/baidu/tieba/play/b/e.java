package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Build;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class e {
    public static void xu(int i) {
        int i2;
        if (i == -100) {
            i2 = 0;
        } else {
            i2 = i == -200 ? 1 : 2;
        }
        TiebaStatic.log(new am("c12493").T("obj_type", i2));
    }

    public static void xv(int i) {
        int i2;
        int i3 = 2;
        if (i == -100) {
            i2 = 0;
        } else {
            i2 = i == -200 ? 1 : 2;
        }
        if (Build.CPU_ABI.toLowerCase().contains("v7")) {
            i3 = 0;
        } else if (Build.CPU_ABI.toLowerCase().contains("arm")) {
            i3 = 1;
        } else if (!Build.CPU_ABI.toLowerCase().contains("86")) {
            if (Build.CPU_ABI.toLowerCase().contains("mips")) {
                i3 = 3;
            } else {
                i3 = 4;
            }
        }
        TiebaStatic.log(new am("c12029").T("obj_type", i2).T("obj_param1", j.kZ() ? 0 : 1).T("obj_param2", i3));
    }

    public static void AZ(String str) {
        TiebaStatic.log(new am("c12026").bJ("tid", str));
    }

    public static void xw(int i) {
        int i2;
        if (i == -100) {
            i2 = 0;
        } else {
            i2 = i == -200 ? 1 : 2;
        }
        TiebaStatic.log(new am("c12494").T("obj_type", i2).T("obj_param1", j.kZ() ? 0 : 1));
    }

    public static void c(Uri uri, String str) {
        TiebaStatic.log(new am("c12199").bJ("obj_param1", uri == null ? "null" : uri.toString()).bJ("obj_param2", str).bJ("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        Object[] objArr = new Object[6];
        objArr[0] = "url";
        objArr[1] = uri == null ? "null" : uri.toString();
        objArr[2] = "dnsIP";
        objArr[3] = str;
        objArr[4] = "clientip";
        objArr[5] = com.baidu.tbadk.core.util.d.getIp();
        bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
    }

    public static void ac(int i, int i2, int i3) {
        if (i == -100) {
            if (i2 == -24399) {
                TiebaStatic.log(new am("c12512").T("obj_locate", 0));
            } else if (i2 == -34399) {
                TiebaStatic.log(new am("c12512").T("obj_locate", 1));
            } else {
                switch (i2) {
                    case 1:
                        i2 = 0;
                        break;
                    case 100:
                        i2 = 1;
                        break;
                    case 200:
                        i2 = 2;
                        break;
                }
                switch (i3) {
                    case Integer.MIN_VALUE:
                        i3 = 4;
                        break;
                    case -1010:
                        i3 = 2;
                        break;
                    case TbErrInfo.ERR_IMG_FILE /* -1007 */:
                        i3 = 1;
                        break;
                    case TbErrInfo.ERR_IMG_CACHE /* -1004 */:
                        i3 = 0;
                        break;
                    case -110:
                        i3 = 3;
                        break;
                }
                TiebaStatic.log(new am("c12508").T("obj_locate", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i3));
            }
        } else if (i == -200) {
            if (i2 == -24399) {
                TiebaStatic.log(new am("c12512").T("obj_locate", 0));
            } else if (i2 == -34399) {
                TiebaStatic.log(new am("c12512").T("obj_locate", 1));
            } else {
                switch (i3) {
                    case -10028:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 7));
                        return;
                    case -10027:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 6));
                        return;
                    case -10026:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 5));
                        return;
                    case -10025:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 4));
                        return;
                    case -10024:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 3));
                        return;
                    case -10023:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 2));
                        return;
                    case -10022:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 1));
                        return;
                    case -10021:
                        TiebaStatic.log(new am("c12510").T("obj_locate", 0));
                        return;
                    case -10020:
                    case -10019:
                    case -10017:
                    case -10016:
                    default:
                        return;
                    case -10018:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 8));
                        return;
                    case -10015:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 5));
                        return;
                    case -10014:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 4));
                        return;
                    case -10013:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 3));
                        return;
                    case -10012:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 2));
                        return;
                    case -10011:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 1));
                        return;
                    case -10010:
                        TiebaStatic.log(new am("c12509").T("obj_locate", 0));
                        return;
                }
            }
        }
    }

    public static void ca(int i, int i2) {
        switch (i2) {
            case -10040:
                TiebaStatic.log(new am("c12511").T("obj_locate", 6));
                return;
            case -10039:
                TiebaStatic.log(new am("c12511").T("obj_locate", 5));
                return;
            case -10038:
                TiebaStatic.log(new am("c12511").T("obj_locate", 4));
                return;
            case -10037:
                TiebaStatic.log(new am("c12511").T("obj_locate", 3));
                return;
            case -10035:
                TiebaStatic.log(new am("c12511").T("obj_locate", 2));
                return;
            case -10032:
                TiebaStatic.log(new am("c12511").T("obj_locate", 1));
                return;
            case -10031:
                TiebaStatic.log(new am("c12511").T("obj_locate", 0));
                return;
            case -10019:
                TiebaStatic.log(new am("c12509").T("obj_locate", 8));
                return;
            case -10017:
                TiebaStatic.log(new am("c12509").T("obj_locate", 7));
                return;
            case -10016:
                TiebaStatic.log(new am("c12509").T("obj_locate", 6));
                return;
            default:
                return;
        }
    }
}

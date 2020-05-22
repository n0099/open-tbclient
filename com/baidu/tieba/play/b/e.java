package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Build;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.android.util.devices.IDevices;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class e {
    public static void BO(int i) {
        int i2;
        if (i == -100) {
            i2 = 0;
        } else {
            i2 = i == -200 ? 1 : 2;
        }
        TiebaStatic.log(new an("c12493").ag("obj_type", i2));
    }

    public static void BP(int i) {
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
            if (Build.CPU_ABI.toLowerCase().contains(IDevices.ABI_MIPS)) {
                i3 = 3;
            } else {
                i3 = 4;
            }
        }
        TiebaStatic.log(new an("c12029").ag("obj_type", i2).ag("obj_param1", j.isWifiNet() ? 0 : 1).ag(TiebaInitialize.Params.OBJ_PARAM2, i3));
    }

    public static void KE(String str) {
        TiebaStatic.log(new an("c12026").dh("tid", str));
    }

    public static void BQ(int i) {
        int i2;
        if (i == -100) {
            i2 = 0;
        } else {
            i2 = i == -200 ? 1 : 2;
        }
        TiebaStatic.log(new an("c12494").ag("obj_type", i2).ag("obj_param1", j.isWifiNet() ? 0 : 1));
    }

    public static void d(Uri uri, String str) {
        TiebaStatic.log(new an("c12199").dh("obj_param1", uri == null ? "null" : uri.toString()).dh(TiebaInitialize.Params.OBJ_PARAM2, str).dh(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tbadk.core.util.d.getIp()));
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

    public static void aa(int i, int i2, int i3) {
        if (i == -100) {
            if (i2 == -24399) {
                TiebaStatic.log(new an("c12512").ag("obj_locate", 0));
            } else if (i2 == -34399) {
                TiebaStatic.log(new an("c12512").ag("obj_locate", 1));
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
                    case -1007:
                        i3 = 1;
                        break;
                    case -1004:
                        i3 = 0;
                        break;
                    case -110:
                        i3 = 3;
                        break;
                }
                TiebaStatic.log(new an("c12508").ag("obj_locate", i2).ag("obj_source", i3));
            }
        } else if (i == -200) {
            if (i2 == -24399) {
                TiebaStatic.log(new an("c12512").ag("obj_locate", 0));
            } else if (i2 == -34399) {
                TiebaStatic.log(new an("c12512").ag("obj_locate", 1));
            } else {
                switch (i3) {
                    case -10028:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 7));
                        return;
                    case -10027:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 6));
                        return;
                    case -10026:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 5));
                        return;
                    case -10025:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 4));
                        return;
                    case -10024:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 3));
                        return;
                    case -10023:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 2));
                        return;
                    case -10022:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 1));
                        return;
                    case -10021:
                        TiebaStatic.log(new an("c12510").ag("obj_locate", 0));
                        return;
                    case -10020:
                    case -10019:
                    case -10017:
                    case -10016:
                    default:
                        return;
                    case -10018:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 8));
                        return;
                    case -10015:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 5));
                        return;
                    case -10014:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 4));
                        return;
                    case -10013:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 3));
                        return;
                    case -10012:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 2));
                        return;
                    case -10011:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 1));
                        return;
                    case -10010:
                        TiebaStatic.log(new an("c12509").ag("obj_locate", 0));
                        return;
                }
            }
        }
    }

    public static void cK(int i, int i2) {
        switch (i2) {
            case -10040:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 6));
                return;
            case -10039:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 5));
                return;
            case -10038:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 4));
                return;
            case -10037:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 3));
                return;
            case -10035:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 2));
                return;
            case -10032:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 1));
                return;
            case -10031:
                TiebaStatic.log(new an("c12511").ag("obj_locate", 0));
                return;
            case -10019:
                TiebaStatic.log(new an("c12509").ag("obj_locate", 8));
                return;
            case -10017:
                TiebaStatic.log(new an("c12509").ag("obj_locate", 7));
                return;
            case -10016:
                TiebaStatic.log(new an("c12509").ag("obj_locate", 6));
                return;
            default:
                return;
        }
    }
}

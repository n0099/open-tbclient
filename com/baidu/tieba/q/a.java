package com.baidu.tieba.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a {
    public static am a(bg bgVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bgVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static am a(bg bgVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bgVar == null) {
            return null;
        }
        return a(true, bgVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static am a(bg bgVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bgVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static am a(bg bgVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bgVar == null) {
            return null;
        }
        return a(false, bgVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static am b(String str, String str2, boolean z, int i) {
        return b(str, str2, z, i, 0);
    }

    public static am b(String str, String str2, boolean z, int i, int i2) {
        am amVar = new am(str2);
        amVar.bT("page_type", str).P("ad_exp", z ? 1 : 0).P("ad_exp_cnt", i).P("obj_adlocate", i2);
        return amVar;
    }

    public static am a(bg bgVar, String str, String str2, int i, int i2, String str3) {
        if (bgVar == null) {
            return null;
        }
        return a(true, bgVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static am a(bg bgVar, String str, String str2, int i, String str3) {
        if (bgVar == null) {
            return null;
        }
        return a(false, bgVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static am a(boolean z, bg bgVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        am amVar = new am(str2);
        amVar.bT("page_type", str).P("obj_floor", i2).P("obj_isad", z2 ? 1 : 0).bT(VideoPlayActivityConfig.OBJ_ID, a(z2, str3, z3, str5, bgVar.getId())).bT("tid", bgVar.getTid()).P("thread_type", z2 ? -1 : bgVar.getThreadType()).P("obj_adlocate", i3);
        if (!ap.isEmpty(bgVar.aeM())) {
            amVar.bT("list_strategy", bgVar.aeM());
        }
        if (!ap.isEmpty(bgVar.mRecomAbTag)) {
            amVar.bT("ab_tag", bgVar.mRecomAbTag);
        }
        if (z) {
            amVar.P("obj_locate", i);
        }
        if (bgVar.getFid() > 0) {
            amVar.l("fid", bgVar.getFid());
        }
        if (z) {
            if (!StringUtils.isNull(bgVar.adA())) {
                amVar.bT(ImageViewerConfig.FORUM_NAME, bgVar.adA());
            }
            if (!StringUtils.isNull(bgVar.afb())) {
                amVar.bT("first_dir", bgVar.afb());
            }
            if (!StringUtils.isNull(bgVar.afc())) {
                amVar.bT("second_dir", bgVar.afc());
            }
        }
        if (!StringUtils.isNull(str4)) {
            amVar.bT(Info.kBaiduPIDKey, str4);
        }
        return amVar;
    }

    public static am a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        am amVar = new am(str2);
        am P = amVar.bT("page_type", str).P("obj_floor", i2).P("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        P.bT(VideoPlayActivityConfig.OBJ_ID, str3).P("obj_adlocate", i3);
        if (z) {
            amVar.P("obj_locate", i);
        }
        return amVar;
    }

    private static String a(boolean z, String str, boolean z2, String str2, String str3) {
        if (z) {
            return str;
        }
        return z2 ? str2 : str3;
    }
}

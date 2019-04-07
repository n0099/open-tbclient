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
        if (bgVar == null) {
            return null;
        }
        return a(true, bgVar, str, str2, i, i2, z, str3, str4, false, "");
    }

    public static am a(bg bgVar, String str, String str2, int i, boolean z, String str3, String str4) {
        if (bgVar == null) {
            return null;
        }
        return a(false, bgVar, str, str2, -1, i, z, str3, str4, false, "");
    }

    public static am b(String str, String str2, boolean z, int i) {
        am amVar = new am(str2);
        amVar.bJ("page_type", str).T("ad_exp", z ? 1 : 0).T("ad_exp_cnt", i);
        return amVar;
    }

    public static am a(bg bgVar, String str, String str2, int i, int i2, String str3) {
        if (bgVar == null) {
            return null;
        }
        return a(true, bgVar, str, str2, i, i2, false, "", null, true, str3);
    }

    public static am a(bg bgVar, String str, String str2, int i, String str3) {
        if (bgVar == null) {
            return null;
        }
        return a(false, bgVar, str, str2, -1, i, false, "", null, true, str3);
    }

    public static am a(boolean z, bg bgVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5) {
        am amVar = new am(str2);
        amVar.bJ("page_type", str).T("obj_floor", i2).T("obj_isad", z2 ? 1 : 0).bJ(VideoPlayActivityConfig.OBJ_ID, a(z2, str3, z3, str5, bgVar.getId())).bJ("tid", bgVar.getTid()).T("thread_type", z2 ? -1 : bgVar.getThreadType());
        if (!ap.isEmpty(bgVar.aaf())) {
            amVar.bJ("list_strategy", bgVar.aaf());
        }
        if (!ap.isEmpty(bgVar.mRecomAbTag)) {
            amVar.bJ("ab_tag", bgVar.mRecomAbTag);
        }
        if (z) {
            amVar.T("obj_locate", i);
        }
        if (bgVar.getFid() > 0) {
            amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
        }
        if (z) {
            if (!StringUtils.isNull(bgVar.YT())) {
                amVar.bJ(ImageViewerConfig.FORUM_NAME, bgVar.YT());
            }
            if (!StringUtils.isNull(bgVar.aau())) {
                amVar.bJ("first_dir", bgVar.aau());
            }
            if (!StringUtils.isNull(bgVar.aav())) {
                amVar.bJ("second_dir", bgVar.aav());
            }
        }
        if (!StringUtils.isNull(str4)) {
            amVar.bJ(Info.kBaiduPIDKey, str4);
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

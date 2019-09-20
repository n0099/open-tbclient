package com.baidu.tieba.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> jfT = Arrays.asList("a006", "a005", "a008", "a002");

    public static an a(bh bhVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bhVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static an a(bh bhVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bhVar == null) {
            return null;
        }
        return a(true, bhVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static an a(bh bhVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bhVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static an a(bh bhVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bhVar == null) {
            return null;
        }
        return a(false, bhVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static an b(String str, String str2, boolean z, int i) {
        return b(str, str2, z, i, 0);
    }

    public static an b(String str, String str2, boolean z, int i, int i2) {
        an anVar = new an(str2);
        anVar.bT("page_type", str).P("ad_exp", z ? 1 : 0).P("ad_exp_cnt", i).P("obj_adlocate", i2);
        if (str != null && jfT.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cgM);
        }
        return anVar;
    }

    public static an a(bh bhVar, String str, String str2, int i, int i2, String str3) {
        if (bhVar == null) {
            return null;
        }
        return a(true, bhVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static an a(bh bhVar, String str, String str2, int i, String str3) {
        if (bhVar == null) {
            return null;
        }
        return a(false, bhVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static an a(boolean z, bh bhVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        an anVar = new an(str2);
        anVar.bT("page_type", str).P("obj_floor", i2).P("obj_isad", z2 ? 1 : 0).bT(VideoPlayActivityConfig.OBJ_ID, a(z2, str3, z3, str5, bhVar.getId())).bT("tid", bhVar.getTid()).P("thread_type", z2 ? -1 : bhVar.getThreadType()).P("obj_adlocate", i3);
        if (!aq.isEmpty(bhVar.afT())) {
            anVar.bT("list_strategy", bhVar.afT());
        }
        if (str != null && jfT.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().cgM)) {
            anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cgM);
        } else if (!aq.isEmpty(bhVar.mRecomAbTag)) {
            anVar.bT("ab_tag", bhVar.mRecomAbTag);
        }
        if (z) {
            anVar.P("obj_locate", i);
        }
        if (bhVar.getFid() > 0) {
            anVar.n("fid", bhVar.getFid());
        }
        if (z) {
            if (!StringUtils.isNull(bhVar.aeH())) {
                anVar.bT(ImageViewerConfig.FORUM_NAME, bhVar.aeH());
            }
            if (!StringUtils.isNull(bhVar.agi())) {
                anVar.bT("first_dir", bhVar.agi());
            }
            if (!StringUtils.isNull(bhVar.agj())) {
                anVar.bT("second_dir", bhVar.agj());
            }
        }
        if (!StringUtils.isNull(str4)) {
            anVar.bT(Info.kBaiduPIDKey, str4);
        }
        return anVar;
    }

    public static an a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        an anVar = new an(str2);
        an P = anVar.bT("page_type", str).P("obj_floor", i2).P("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        P.bT(VideoPlayActivityConfig.OBJ_ID, str3).P("obj_adlocate", i3);
        if (str != null && jfT.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cgM);
        }
        if (z) {
            anVar.P("obj_locate", i);
        }
        return anVar;
    }

    private static String a(boolean z, String str, boolean z2, String str2, String str3) {
        if (z) {
            return str;
        }
        return z2 ? str2 : str3;
    }
}

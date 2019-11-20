package com.baidu.tieba.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> jeT = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

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
        anVar.bS("page_type", str).O("ad_exp", z ? 1 : 0).O("ad_exp_cnt", i).O("obj_adlocate", i2);
        if (str != null && jeT.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().ctT);
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
        anVar.bS("page_type", str).O("obj_floor", i2).O("obj_isad", z2 ? 1 : 0).bS("obj_id", a(z2, str3, z3, str5, bhVar.getId())).bS("tid", bhVar.getTid()).O("thread_type", z2 ? -1 : bhVar.getThreadType()).O("obj_adlocate", i3);
        if (!aq.isEmpty(bhVar.ajU())) {
            anVar.bS("list_strategy", bhVar.ajU());
        }
        if (str != null && jeT.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().ctT)) {
            anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().ctT);
        } else if (!aq.isEmpty(bhVar.mRecomAbTag)) {
            anVar.bS(TiebaInitialize.Params.AB_TAG, bhVar.mRecomAbTag);
        }
        if (z) {
            anVar.O("obj_locate", i);
        }
        if (bhVar.getFid() > 0) {
            anVar.p("fid", bhVar.getFid());
        }
        if (z) {
            if (!StringUtils.isNull(bhVar.aiJ())) {
                anVar.bS("fname", bhVar.aiJ());
            }
            if (!StringUtils.isNull(bhVar.akj())) {
                anVar.bS("first_dir", bhVar.akj());
            }
            if (!StringUtils.isNull(bhVar.akk())) {
                anVar.bS("second_dir", bhVar.akk());
            }
        }
        if (!StringUtils.isNull(str4)) {
            anVar.bS("pid", str4);
        }
        return anVar;
    }

    public static an a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        an anVar = new an(str2);
        an O = anVar.bS("page_type", str).O("obj_floor", i2).O("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        O.bS("obj_id", str3).O("obj_adlocate", i3);
        if (str != null && jeT.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().ctT);
        }
        if (z) {
            anVar.O("obj_locate", i);
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

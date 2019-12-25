package com.baidu.tieba.r;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> jZf = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Iq(String str) {
        return "enterfourm_att_" + str;
    }

    public static String Ir(String str) {
        return "enterfourm_rec_" + str;
    }

    public static String a(String str, String str2, String str3, BaijiahaoData baijiahaoData) {
        String str4 = "_tid_" + str;
        if (!TextUtils.isEmpty(str2)) {
            str4 = str4 + "_adid_" + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            str4 = str4 + "_appid_" + str3;
        }
        if (baijiahaoData != null) {
            return str4 + "_nid_" + baijiahaoData.oriUgcNid;
        }
        return str4;
    }

    private static String a(boolean z, String str, boolean z2, String str2, String str3, BaijiahaoData baijiahaoData) {
        if (z) {
            return str;
        }
        if (z2) {
            return str2;
        }
        if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
            return baijiahaoData.oriUgcNid;
        }
        return str3;
    }

    public static an a(bj bjVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bjVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static an a(bj bjVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bjVar == null) {
            return null;
        }
        return a(true, bjVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static an a(bj bjVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bjVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static an a(bj bjVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bjVar == null) {
            return null;
        }
        return a(false, bjVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static an b(String str, String str2, boolean z, int i) {
        return b(str, str2, z, i, 0);
    }

    public static an b(String str, String str2, boolean z, int i, int i2) {
        an anVar = new an(str2);
        anVar.cp("page_type", str).Z("ad_exp", z ? 1 : 0).Z("ad_exp_cnt", i).Z("obj_floor", 0).Z("obj_adlocate", i2);
        if (str != null && jZf.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhF);
        }
        return anVar;
    }

    public static an a(bj bjVar, String str, String str2, int i, int i2, String str3) {
        if (bjVar == null) {
            return null;
        }
        return a(true, bjVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static an a(bj bjVar, String str, String str2, int i, String str3) {
        if (bjVar == null) {
            return null;
        }
        return a(false, bjVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static an a(boolean z, bj bjVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        an anVar = new an(str2);
        anVar.cp("page_type", str).Z("obj_floor", i2).Z("obj_isad", z2 ? 1 : 0).cp("obj_id", a(z2, str3, z3, str5, bjVar.getId(), bjVar.getBaijiahaoData())).cp("tid", bjVar.getTid()).Z("thread_type", z2 ? -1 : bjVar.getThreadType()).Z("obj_adlocate", i3);
        if (!aq.isEmpty(bjVar.aAX())) {
            anVar.cp("list_strategy", bjVar.aAX());
        }
        if (str != null && jZf.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().dhF)) {
            anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhF);
        } else if (!aq.isEmpty(bjVar.mRecomAbTag)) {
            anVar.cp(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag);
        }
        if (z) {
            anVar.Z("obj_locate", i);
        }
        if (bjVar.getFid() > 0) {
            anVar.s("fid", bjVar.getFid());
        }
        if (!StringUtils.isNull(bjVar.aBk())) {
            anVar.cp("first_dir", bjVar.aBk());
        }
        if (!StringUtils.isNull(bjVar.aBl())) {
            anVar.cp("second_dir", bjVar.aBl());
        }
        if (bjVar.getBaijiahaoData() != null) {
            anVar.cp("ugc_vid", bjVar.getBaijiahaoData().oriUgcVid);
            anVar.cp("ugc_nid", bjVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.cp("pid", str4);
        }
        return anVar;
    }

    public static an a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        an anVar = new an(str2);
        an Z = anVar.cp("page_type", str).Z("obj_floor", i2).Z("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        Z.cp("obj_id", str3).Z("obj_adlocate", i3);
        if (str != null && jZf.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhF);
        }
        if (z) {
            anVar.Z("obj_locate", i);
        }
        return anVar;
    }
}

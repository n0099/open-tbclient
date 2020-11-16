package com.baidu.tieba.t;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> mVe = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Se(String str) {
        return "enterfourm_att_" + str;
    }

    public static String Sf(String str) {
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

    public static ar a(bx bxVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bxVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static ar a(bx bxVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bxVar == null) {
            return null;
        }
        return a(true, bxVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static ar a(bx bxVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bxVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static ar a(bx bxVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bxVar == null) {
            return null;
        }
        return a(false, bxVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static ar b(String str, String str2, boolean z, int i) {
        return a(str, str2, z, i, 0);
    }

    public static ar a(String str, String str2, boolean z, int i, int i2) {
        ar arVar = new ar(str2);
        arVar.dR("page_type", str).ak("ad_exp", z ? 1 : 0).ak("ad_exp_cnt", i).ak("obj_floor", 0).ak("obj_adlocate", i2);
        if (str != null && mVe.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
        }
        return arVar;
    }

    public static ar a(bx bxVar, String str, String str2, int i, int i2, String str3) {
        if (bxVar == null) {
            return null;
        }
        return a(true, bxVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static ar a(bx bxVar, String str, String str2, int i, String str3) {
        if (bxVar == null) {
            return null;
        }
        return a(false, bxVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static ar a(boolean z, bx bxVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        ar arVar = new ar(str2);
        arVar.dR("page_type", str).ak("obj_floor", i2).ak("obj_isad", z2 ? 1 : 0).dR("obj_id", a(z2, str3, z3, str5, bxVar.getId(), bxVar.getBaijiahaoData())).dR("tid", bxVar.getTid()).ak("thread_type", z2 ? -1 : bxVar.getThreadType()).ak("obj_adlocate", i3).dR("nid", bxVar.getNid());
        if (!au.isEmpty(bxVar.bna())) {
            arVar.dR("list_strategy", bxVar.bna());
        }
        if (str != null && mVe.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().fbE)) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
        } else if (!au.isEmpty(bxVar.mRecomAbTag)) {
            arVar.dR("ab_tag", bxVar.mRecomAbTag);
        }
        if (z) {
            arVar.ak("obj_locate", i);
        }
        if (bxVar.getFid() > 0) {
            arVar.w("fid", bxVar.getFid());
        }
        if (!StringUtils.isNull(bxVar.bnm())) {
            arVar.dR("first_dir", bxVar.bnm());
        }
        if (!StringUtils.isNull(bxVar.bnn())) {
            arVar.dR("second_dir", bxVar.bnn());
        }
        if (bxVar.getBaijiahaoData() != null) {
            arVar.dR("ugc_vid", bxVar.getBaijiahaoData().oriUgcVid);
            arVar.dR("ugc_nid", bxVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            arVar.dR("pid", str4);
        }
        return arVar;
    }

    public static ar a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        ar arVar = new ar(str2);
        ar ak = arVar.dR("page_type", str).ak("obj_floor", i2).ak("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        ak.dR("obj_id", str3).ak("obj_adlocate", i3);
        if (str != null && mVe.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
        }
        if (z) {
            arVar.ak("obj_locate", i);
        }
        return arVar;
    }

    public static ar c(String str, bx bxVar) {
        return a(str, bxVar, 0, 0);
    }

    public static ar a(String str, bx bxVar, int i) {
        return a(str, bxVar, i, 0);
    }

    public static ar a(String str, bx bxVar, int i, int i2) {
        if (bxVar == null) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dR("tid", bxVar.getTid()).w("fid", bxVar.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            arVar.ak("obj_locate", i);
        }
        if (i2 != 0) {
            arVar.ak("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", arVar.toString());
            return arVar;
        }
        return arVar;
    }
}

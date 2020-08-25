package com.baidu.tieba.s;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final List<String> mcg = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Qz(String str) {
        return "enterfourm_att_" + str;
    }

    public static String QA(String str) {
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

    public static aq a(bw bwVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bwVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static aq a(bw bwVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bwVar == null) {
            return null;
        }
        return a(true, bwVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static aq a(bw bwVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bwVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static aq a(bw bwVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bwVar == null) {
            return null;
        }
        return a(false, bwVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static aq b(String str, String str2, boolean z, int i) {
        return a(str, str2, z, i, 0);
    }

    public static aq a(String str, String str2, boolean z, int i, int i2) {
        aq aqVar = new aq(str2);
        aqVar.dD("page_type", str).ai("ad_exp", z ? 1 : 0).ai("ad_exp_cnt", i).ai("obj_floor", 0).ai("obj_adlocate", i2);
        if (str != null && mcg.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ezW);
        }
        return aqVar;
    }

    public static aq a(bw bwVar, String str, String str2, int i, int i2, String str3) {
        if (bwVar == null) {
            return null;
        }
        return a(true, bwVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static aq a(bw bwVar, String str, String str2, int i, String str3) {
        if (bwVar == null) {
            return null;
        }
        return a(false, bwVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static aq a(boolean z, bw bwVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        aq aqVar = new aq(str2);
        aqVar.dD("page_type", str).ai("obj_floor", i2).ai("obj_isad", z2 ? 1 : 0).dD("obj_id", a(z2, str3, z3, str5, bwVar.getId(), bwVar.getBaijiahaoData())).dD("tid", bwVar.getTid()).ai("thread_type", z2 ? -1 : bwVar.getThreadType()).ai("obj_adlocate", i3).dD("nid", bwVar.getNid());
        if (!at.isEmpty(bwVar.bga())) {
            aqVar.dD("list_strategy", bwVar.bga());
        }
        if (str != null && mcg.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().ezW)) {
            aqVar.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ezW);
        } else if (!at.isEmpty(bwVar.mRecomAbTag)) {
            aqVar.dD("ab_tag", bwVar.mRecomAbTag);
        }
        if (z) {
            aqVar.ai("obj_locate", i);
        }
        if (bwVar.getFid() > 0) {
            aqVar.u("fid", bwVar.getFid());
        }
        if (!StringUtils.isNull(bwVar.bgm())) {
            aqVar.dD("first_dir", bwVar.bgm());
        }
        if (!StringUtils.isNull(bwVar.bgn())) {
            aqVar.dD("second_dir", bwVar.bgn());
        }
        if (bwVar.getBaijiahaoData() != null) {
            aqVar.dD("ugc_vid", bwVar.getBaijiahaoData().oriUgcVid);
            aqVar.dD("ugc_nid", bwVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dD("pid", str4);
        }
        return aqVar;
    }

    public static aq a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        aq aqVar = new aq(str2);
        aq ai = aqVar.dD("page_type", str).ai("obj_floor", i2).ai("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        ai.dD("obj_id", str3).ai("obj_adlocate", i3);
        if (str != null && mcg.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ezW);
        }
        if (z) {
            aqVar.ai("obj_locate", i);
        }
        return aqVar;
    }

    public static aq c(String str, bw bwVar) {
        return a(str, bwVar, 0, 0);
    }

    public static aq a(String str, bw bwVar, int i) {
        return a(str, bwVar, i, 0);
    }

    public static aq a(String str, bw bwVar, int i, int i2) {
        if (bwVar == null) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dD("tid", bwVar.getTid()).u("fid", bwVar.getFid()).dD("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            aqVar.ai("obj_locate", i);
        }
        if (i2 != 0) {
            aqVar.ai("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", aqVar.toString());
            return aqVar;
        }
        return aqVar;
    }
}

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
/* loaded from: classes.dex */
public class a {
    private static final List<String> mUj = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String SD(String str) {
        return "enterfourm_att_" + str;
    }

    public static String SE(String str) {
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
        aqVar.dR("page_type", str).al("ad_exp", z ? 1 : 0).al("ad_exp_cnt", i).al("obj_floor", 0).al("obj_adlocate", i2);
        if (str != null && mUj.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
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
        aqVar.dR("page_type", str).al("obj_floor", i2).al("obj_isad", z2 ? 1 : 0).dR("obj_id", a(z2, str3, z3, str5, bwVar.getId(), bwVar.getBaijiahaoData())).dR("tid", bwVar.getTid()).al("thread_type", z2 ? -1 : bwVar.getThreadType()).al("obj_adlocate", i3).dR("nid", bwVar.getNid());
        if (!at.isEmpty(bwVar.bnW())) {
            aqVar.dR("list_strategy", bwVar.bnW());
        }
        if (str != null && mUj.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().fcx)) {
            aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
        } else if (!at.isEmpty(bwVar.mRecomAbTag)) {
            aqVar.dR("ab_tag", bwVar.mRecomAbTag);
        }
        if (z) {
            aqVar.al("obj_locate", i);
        }
        if (bwVar.getFid() > 0) {
            aqVar.w("fid", bwVar.getFid());
        }
        if (!StringUtils.isNull(bwVar.boi())) {
            aqVar.dR("first_dir", bwVar.boi());
        }
        if (!StringUtils.isNull(bwVar.boj())) {
            aqVar.dR("second_dir", bwVar.boj());
        }
        if (bwVar.getBaijiahaoData() != null) {
            aqVar.dR("ugc_vid", bwVar.getBaijiahaoData().oriUgcVid);
            aqVar.dR("ugc_nid", bwVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dR("pid", str4);
        }
        return aqVar;
    }

    public static aq a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        aq aqVar = new aq(str2);
        aq al = aqVar.dR("page_type", str).al("obj_floor", i2).al("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        al.dR("obj_id", str3).al("obj_adlocate", i3);
        if (str != null && mUj.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
        }
        if (z) {
            aqVar.al("obj_locate", i);
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
        aqVar.dR("tid", bwVar.getTid()).w("fid", bwVar.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            aqVar.al("obj_locate", i);
        }
        if (i2 != 0) {
            aqVar.al("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", aqVar.toString());
            return aqVar;
        }
        return aqVar;
    }
}

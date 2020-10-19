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
    private static final List<String> mBx = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String RN(String str) {
        return "enterfourm_att_" + str;
    }

    public static String RO(String str) {
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
        aqVar.dK("page_type", str).aj("ad_exp", z ? 1 : 0).aj("ad_exp_cnt", i).aj("obj_floor", 0).aj("obj_adlocate", i2);
        if (str != null && mBx.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dK("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eOl);
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
        aqVar.dK("page_type", str).aj("obj_floor", i2).aj("obj_isad", z2 ? 1 : 0).dK("obj_id", a(z2, str3, z3, str5, bwVar.getId(), bwVar.getBaijiahaoData())).dK("tid", bwVar.getTid()).aj("thread_type", z2 ? -1 : bwVar.getThreadType()).aj("obj_adlocate", i3).dK("nid", bwVar.getNid());
        if (!at.isEmpty(bwVar.bjD())) {
            aqVar.dK("list_strategy", bwVar.bjD());
        }
        if (str != null && mBx.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().eOl)) {
            aqVar.dK("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eOl);
        } else if (!at.isEmpty(bwVar.mRecomAbTag)) {
            aqVar.dK("ab_tag", bwVar.mRecomAbTag);
        }
        if (z) {
            aqVar.aj("obj_locate", i);
        }
        if (bwVar.getFid() > 0) {
            aqVar.u("fid", bwVar.getFid());
        }
        if (!StringUtils.isNull(bwVar.bjP())) {
            aqVar.dK("first_dir", bwVar.bjP());
        }
        if (!StringUtils.isNull(bwVar.bjQ())) {
            aqVar.dK("second_dir", bwVar.bjQ());
        }
        if (bwVar.getBaijiahaoData() != null) {
            aqVar.dK("ugc_vid", bwVar.getBaijiahaoData().oriUgcVid);
            aqVar.dK("ugc_nid", bwVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dK("pid", str4);
        }
        return aqVar;
    }

    public static aq a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        aq aqVar = new aq(str2);
        aq aj = aqVar.dK("page_type", str).aj("obj_floor", i2).aj("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        aj.dK("obj_id", str3).aj("obj_adlocate", i3);
        if (str != null && mBx.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dK("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eOl);
        }
        if (z) {
            aqVar.aj("obj_locate", i);
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
        aqVar.dK("tid", bwVar.getTid()).u("fid", bwVar.getFid()).dK("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            aqVar.aj("obj_locate", i);
        }
        if (i2 != 0) {
            aqVar.aj("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", aqVar.toString());
            return aqVar;
        }
        return aqVar;
    }
}

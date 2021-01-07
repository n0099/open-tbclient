package com.baidu.tieba.s;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> noK = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Ta(String str) {
        return "enterfourm_att_" + str;
    }

    public static String Tb(String str) {
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

    public static aq a(bz bzVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bzVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static aq a(bz bzVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bzVar == null) {
            return null;
        }
        return a(true, bzVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static aq a(bz bzVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bzVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static aq a(bz bzVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bzVar == null) {
            return null;
        }
        return a(false, bzVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static aq b(String str, String str2, boolean z, int i) {
        return a(str, str2, z, i, 0);
    }

    public static aq a(String str, String str2, boolean z, int i, int i2) {
        aq aqVar = new aq(str2);
        aqVar.dX("page_type", str).an("ad_exp", z ? 1 : 0).an("ad_exp_cnt", i).an("obj_floor", 0).an("obj_adlocate", i2);
        if (str != null && noK.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dX("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fsN);
        }
        return aqVar;
    }

    public static aq a(bz bzVar, String str, String str2, int i, int i2, String str3) {
        if (bzVar == null) {
            return null;
        }
        return a(true, bzVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static aq a(bz bzVar, String str, String str2, int i, String str3) {
        if (bzVar == null) {
            return null;
        }
        return a(false, bzVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static aq a(boolean z, bz bzVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        aq aqVar = new aq(str2);
        aqVar.dX("page_type", str).an("obj_floor", i2).an("obj_isad", z2 ? 1 : 0).dX("obj_id", a(z2, str3, z3, str5, bzVar.getId(), bzVar.getBaijiahaoData())).dX("tid", bzVar.getTid()).an("thread_type", z2 ? -1 : bzVar.getThreadType()).an("obj_adlocate", i3).dX(IntentConfig.NID, bzVar.bpP());
        if (!at.isEmpty(bzVar.bsQ())) {
            aqVar.dX("list_strategy", bzVar.bsQ());
        }
        if (str != null && noK.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().fsN)) {
            aqVar.dX("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fsN);
        } else if (!at.isEmpty(bzVar.mRecomAbTag)) {
            aqVar.dX("ab_tag", bzVar.mRecomAbTag);
        }
        if (z) {
            aqVar.an("obj_locate", i);
        }
        if (bzVar.getFid() > 0) {
            aqVar.w("fid", bzVar.getFid());
        }
        if (!StringUtils.isNull(bzVar.btc())) {
            aqVar.dX("first_dir", bzVar.btc());
        }
        if (!StringUtils.isNull(bzVar.btd())) {
            aqVar.dX("second_dir", bzVar.btd());
        }
        if (bzVar.getBaijiahaoData() != null) {
            aqVar.dX("ugc_vid", bzVar.getBaijiahaoData().oriUgcVid);
            aqVar.dX("ugc_nid", bzVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dX("pid", str4);
        }
        return aqVar;
    }

    public static aq a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        aq aqVar = new aq(str2);
        aq an = aqVar.dX("page_type", str).an("obj_floor", i2).an("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        an.dX("obj_id", str3).an("obj_adlocate", i3);
        if (str != null && noK.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dX("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fsN);
        }
        if (z) {
            aqVar.an("obj_locate", i);
        }
        return aqVar;
    }

    public static aq d(String str, bz bzVar) {
        return a(str, bzVar, 0, 0);
    }

    public static aq a(String str, bz bzVar, int i) {
        return a(str, bzVar, i, 0);
    }

    public static aq a(String str, bz bzVar, int i, int i2) {
        if (bzVar == null) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dX("tid", bzVar.getTid()).w("fid", bzVar.getFid()).dX("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            aqVar.an("obj_locate", i);
        }
        if (i2 != 0) {
            aqVar.an("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", aqVar.toString());
            return aqVar;
        }
        return aqVar;
    }
}

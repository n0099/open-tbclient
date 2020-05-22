package com.baidu.tieba.s;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> lic = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Mn(String str) {
        return "enterfourm_att_" + str;
    }

    public static String Mo(String str) {
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

    public static an a(bk bkVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bkVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static an a(bk bkVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bkVar == null) {
            return null;
        }
        return a(true, bkVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static an a(bk bkVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bkVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static an a(bk bkVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bkVar == null) {
            return null;
        }
        return a(false, bkVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static an b(String str, String str2, boolean z, int i) {
        return b(str, str2, z, i, 0);
    }

    public static an b(String str, String str2, boolean z, int i, int i2) {
        an anVar = new an(str2);
        anVar.dh("page_type", str).ag("ad_exp", z ? 1 : 0).ag("ad_exp_cnt", i).ag("obj_floor", 0).ag("obj_adlocate", i2);
        if (str != null && lic.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.dh("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eaO);
        }
        return anVar;
    }

    public static an a(bk bkVar, String str, String str2, int i, int i2, String str3) {
        if (bkVar == null) {
            return null;
        }
        return a(true, bkVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static an a(bk bkVar, String str, String str2, int i, String str3) {
        if (bkVar == null) {
            return null;
        }
        return a(false, bkVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static an a(boolean z, bk bkVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        an anVar = new an(str2);
        anVar.dh("page_type", str).ag("obj_floor", i2).ag("obj_isad", z2 ? 1 : 0).dh("obj_id", a(z2, str3, z3, str5, bkVar.getId(), bkVar.getBaijiahaoData())).dh("tid", bkVar.getTid()).ag("thread_type", z2 ? -1 : bkVar.getThreadType()).ag("obj_adlocate", i3).dh("nid", bkVar.getNid());
        if (!aq.isEmpty(bkVar.aRU())) {
            anVar.dh("list_strategy", bkVar.aRU());
        }
        if (str != null && lic.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().eaO)) {
            anVar.dh("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eaO);
        } else if (!aq.isEmpty(bkVar.mRecomAbTag)) {
            anVar.dh("ab_tag", bkVar.mRecomAbTag);
        }
        if (z) {
            anVar.ag("obj_locate", i);
        }
        if (bkVar.getFid() > 0) {
            anVar.s("fid", bkVar.getFid());
        }
        if (!StringUtils.isNull(bkVar.aSh())) {
            anVar.dh("first_dir", bkVar.aSh());
        }
        if (!StringUtils.isNull(bkVar.aSi())) {
            anVar.dh("second_dir", bkVar.aSi());
        }
        if (bkVar.getBaijiahaoData() != null) {
            anVar.dh("ugc_vid", bkVar.getBaijiahaoData().oriUgcVid);
            anVar.dh("ugc_nid", bkVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.dh("pid", str4);
        }
        return anVar;
    }

    public static an a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        an anVar = new an(str2);
        an ag = anVar.dh("page_type", str).ag("obj_floor", i2).ag("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        ag.dh("obj_id", str3).ag("obj_adlocate", i3);
        if (str != null && lic.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.dh("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eaO);
        }
        if (z) {
            anVar.ag("obj_locate", i);
        }
        return anVar;
    }

    public static an c(String str, bk bkVar) {
        return a(str, bkVar, 0, 0);
    }

    public static an a(String str, bk bkVar, int i) {
        return a(str, bkVar, i, 0);
    }

    public static an a(String str, bk bkVar, int i, int i2) {
        if (bkVar == null) {
            return null;
        }
        an anVar = new an(str);
        anVar.dh("tid", bkVar.getTid()).s("fid", bkVar.getFid()).dh("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            anVar.ag("obj_locate", i);
        }
        if (i2 != 0) {
            anVar.ag("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", anVar.toString());
            return anVar;
        }
        return anVar;
    }
}

package com.baidu.tieba.s;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> lKv = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Ny(String str) {
        return "enterfourm_att_" + str;
    }

    public static String Nz(String str) {
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

    public static ap a(bv bvVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, bvVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static ap a(bv bvVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (bvVar == null) {
            return null;
        }
        return a(true, bvVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static ap a(bv bvVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, bvVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static ap a(bv bvVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (bvVar == null) {
            return null;
        }
        return a(false, bvVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static ap b(String str, String str2, boolean z, int i) {
        return a(str, str2, z, i, 0);
    }

    public static ap a(String str, String str2, boolean z, int i, int i2) {
        ap apVar = new ap(str2);
        apVar.dn("page_type", str).ah("ad_exp", z ? 1 : 0).ah("ad_exp_cnt", i).ah("obj_floor", 0).ah("obj_adlocate", i2);
        if (str != null && lKv.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            apVar.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
        }
        return apVar;
    }

    public static ap a(bv bvVar, String str, String str2, int i, int i2, String str3) {
        if (bvVar == null) {
            return null;
        }
        return a(true, bvVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static ap a(bv bvVar, String str, String str2, int i, String str3) {
        if (bvVar == null) {
            return null;
        }
        return a(false, bvVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static ap a(boolean z, bv bvVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        ap apVar = new ap(str2);
        apVar.dn("page_type", str).ah("obj_floor", i2).ah("obj_isad", z2 ? 1 : 0).dn("obj_id", a(z2, str3, z3, str5, bvVar.getId(), bvVar.getBaijiahaoData())).dn("tid", bvVar.getTid()).ah("thread_type", z2 ? -1 : bvVar.getThreadType()).ah("obj_adlocate", i3).dn("nid", bvVar.getNid());
        if (!as.isEmpty(bvVar.aXH())) {
            apVar.dn("list_strategy", bvVar.aXH());
        }
        if (str != null && lKv.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().epK)) {
            apVar.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
        } else if (!as.isEmpty(bvVar.mRecomAbTag)) {
            apVar.dn("ab_tag", bvVar.mRecomAbTag);
        }
        if (z) {
            apVar.ah("obj_locate", i);
        }
        if (bvVar.getFid() > 0) {
            apVar.t("fid", bvVar.getFid());
        }
        if (!StringUtils.isNull(bvVar.aXT())) {
            apVar.dn("first_dir", bvVar.aXT());
        }
        if (!StringUtils.isNull(bvVar.aXU())) {
            apVar.dn("second_dir", bvVar.aXU());
        }
        if (bvVar.getBaijiahaoData() != null) {
            apVar.dn("ugc_vid", bvVar.getBaijiahaoData().oriUgcVid);
            apVar.dn("ugc_nid", bvVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            apVar.dn("pid", str4);
        }
        return apVar;
    }

    public static ap a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        ap apVar = new ap(str2);
        ap ah = apVar.dn("page_type", str).ah("obj_floor", i2).ah("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        ah.dn("obj_id", str3).ah("obj_adlocate", i3);
        if (str != null && lKv.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            apVar.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
        }
        if (z) {
            apVar.ah("obj_locate", i);
        }
        return apVar;
    }

    public static ap c(String str, bv bvVar) {
        return a(str, bvVar, 0, 0);
    }

    public static ap a(String str, bv bvVar, int i) {
        return a(str, bvVar, i, 0);
    }

    public static ap a(String str, bv bvVar, int i, int i2) {
        if (bvVar == null) {
            return null;
        }
        ap apVar = new ap(str);
        apVar.dn("tid", bvVar.getTid()).t("fid", bvVar.getFid()).dn("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            apVar.ah("obj_locate", i);
        }
        if (i2 != 0) {
            apVar.ah("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", apVar.toString());
            return apVar;
        }
        return apVar;
    }
}

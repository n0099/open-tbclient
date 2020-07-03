package com.baidu.tieba.s;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> lDg = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String MQ(String str) {
        return "enterfourm_att_" + str;
    }

    public static String MR(String str) {
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

    public static ao a(bu buVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, buVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static ao a(bu buVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (buVar == null) {
            return null;
        }
        return a(true, buVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static ao a(bu buVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, buVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static ao a(bu buVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (buVar == null) {
            return null;
        }
        return a(false, buVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static ao b(String str, String str2, boolean z, int i) {
        return b(str, str2, z, i, 0);
    }

    public static ao b(String str, String str2, boolean z, int i, int i2) {
        ao aoVar = new ao(str2);
        aoVar.dk("page_type", str).ag("ad_exp", z ? 1 : 0).ag("ad_exp_cnt", i).ag("obj_floor", 0).ag("obj_adlocate", i2);
        if (str != null && lDg.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aoVar.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
        }
        return aoVar;
    }

    public static ao a(bu buVar, String str, String str2, int i, int i2, String str3) {
        if (buVar == null) {
            return null;
        }
        return a(true, buVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static ao a(bu buVar, String str, String str2, int i, String str3) {
        if (buVar == null) {
            return null;
        }
        return a(false, buVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static ao a(boolean z, bu buVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        ao aoVar = new ao(str2);
        aoVar.dk("page_type", str).ag("obj_floor", i2).ag("obj_isad", z2 ? 1 : 0).dk("obj_id", a(z2, str3, z3, str5, buVar.getId(), buVar.getBaijiahaoData())).dk("tid", buVar.getTid()).ag("thread_type", z2 ? -1 : buVar.getThreadType()).ag("obj_adlocate", i3).dk("nid", buVar.getNid());
        if (!ar.isEmpty(buVar.aTL())) {
            aoVar.dk("list_strategy", buVar.aTL());
        }
        if (str != null && lDg.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().ejy)) {
            aoVar.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
        } else if (!ar.isEmpty(buVar.mRecomAbTag)) {
            aoVar.dk("ab_tag", buVar.mRecomAbTag);
        }
        if (z) {
            aoVar.ag("obj_locate", i);
        }
        if (buVar.getFid() > 0) {
            aoVar.s("fid", buVar.getFid());
        }
        if (!StringUtils.isNull(buVar.aTX())) {
            aoVar.dk("first_dir", buVar.aTX());
        }
        if (!StringUtils.isNull(buVar.aTY())) {
            aoVar.dk("second_dir", buVar.aTY());
        }
        if (buVar.getBaijiahaoData() != null) {
            aoVar.dk("ugc_vid", buVar.getBaijiahaoData().oriUgcVid);
            aoVar.dk("ugc_nid", buVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            aoVar.dk("pid", str4);
        }
        return aoVar;
    }

    public static ao a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        ao aoVar = new ao(str2);
        ao ag = aoVar.dk("page_type", str).ag("obj_floor", i2).ag("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        ag.dk("obj_id", str3).ag("obj_adlocate", i3);
        if (str != null && lDg.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aoVar.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
        }
        if (z) {
            aoVar.ag("obj_locate", i);
        }
        return aoVar;
    }

    public static ao c(String str, bu buVar) {
        return a(str, buVar, 0, 0);
    }

    public static ao a(String str, bu buVar, int i) {
        return a(str, buVar, i, 0);
    }

    public static ao a(String str, bu buVar, int i, int i2) {
        if (buVar == null) {
            return null;
        }
        ao aoVar = new ao(str);
        aoVar.dk("tid", buVar.getTid()).s("fid", buVar.getFid()).dk("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            aoVar.ag("obj_locate", i);
        }
        if (i2 != 0) {
            aoVar.ag("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", aoVar.toString());
            return aoVar;
        }
        return aoVar;
    }
}

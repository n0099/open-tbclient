package com.baidu.tieba.s;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final List<String> nun = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String Tc(String str) {
        return "enterfourm_att_" + str;
    }

    public static String Td(String str) {
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

    public static ar a(cb cbVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return a(true, cbVar, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static ar a(cb cbVar, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (cbVar == null) {
            return null;
        }
        return a(true, cbVar, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static ar a(cb cbVar, String str, String str2, int i, boolean z, String str3, String str4) {
        return a(false, cbVar, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static ar a(cb cbVar, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (cbVar == null) {
            return null;
        }
        return a(false, cbVar, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static ar b(String str, String str2, boolean z, int i) {
        return a(str, str2, z, i, 0);
    }

    public static ar a(String str, String str2, boolean z, int i, int i2) {
        ar arVar = new ar(str2);
        arVar.dR("page_type", str).ap("ad_exp", z ? 1 : 0).ap("ad_exp_cnt", i).ap("obj_floor", 0).ap("obj_adlocate", i2);
        if (str != null && nun.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fqv);
        }
        return arVar;
    }

    public static ar a(cb cbVar, String str, String str2, int i, int i2, String str3) {
        if (cbVar == null) {
            return null;
        }
        return a(true, cbVar, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static ar a(cb cbVar, String str, String str2, int i, String str3) {
        if (cbVar == null) {
            return null;
        }
        return a(false, cbVar, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static ar a(boolean z, cb cbVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        ar arVar = new ar(str2);
        arVar.dR("page_type", str).ap("obj_floor", i2).ap("obj_isad", z2 ? 1 : 0).dR("obj_id", a(z2, str3, z3, str5, cbVar.getId(), cbVar.getBaijiahaoData())).dR("tid", cbVar.getTid()).ap("thread_type", z2 ? -1 : cbVar.getThreadType()).ap("obj_adlocate", i3).dR(IntentConfig.NID, cbVar.bmo());
        if (!au.isEmpty(cbVar.bpo())) {
            arVar.dR("list_strategy", cbVar.bpo());
        }
        if (str != null && nun.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().fqv)) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fqv);
        } else if (!au.isEmpty(cbVar.mRecomAbTag)) {
            arVar.dR("ab_tag", cbVar.mRecomAbTag);
        }
        if (z) {
            arVar.ap("obj_locate", i);
        }
        if (cbVar.getFid() > 0) {
            arVar.v("fid", cbVar.getFid());
        }
        if (!StringUtils.isNull(cbVar.bpA())) {
            arVar.dR("first_dir", cbVar.bpA());
        }
        if (!StringUtils.isNull(cbVar.bpB())) {
            arVar.dR("second_dir", cbVar.bpB());
        }
        if (cbVar.getBaijiahaoData() != null) {
            arVar.dR("ugc_vid", cbVar.getBaijiahaoData().oriUgcVid);
            arVar.dR("ugc_nid", cbVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            arVar.dR("pid", str4);
        }
        return arVar;
    }

    public static ar a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        ar arVar = new ar(str2);
        ar ap = arVar.dR("page_type", str).ap("obj_floor", i2).ap("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        ap.dR("obj_id", str3).ap("obj_adlocate", i3);
        if (str != null && nun.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fqv);
        }
        if (z) {
            arVar.ap("obj_locate", i);
        }
        return arVar;
    }

    public static ar f(String str, cb cbVar) {
        return a(str, cbVar, 0, 0);
    }

    public static ar a(String str, cb cbVar, int i) {
        return a(str, cbVar, i, 0);
    }

    public static ar a(String str, cb cbVar, int i, int i2) {
        if (cbVar == null) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dR("tid", cbVar.getTid()).v("fid", cbVar.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (i != 0) {
            arVar.ap("obj_locate", i);
        }
        if (i2 != 0) {
            arVar.ap("obj_type", i2);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", arVar.toString());
            return arVar;
        }
        return arVar;
    }
}

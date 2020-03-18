package com.baidu.tieba.s;

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
    private static final List<String> kfD = Arrays.asList(PageStayDurationConstants.PageName.FRS, PageStayDurationConstants.PageName.PB, PageStayDurationConstants.PageName.BIGIMAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);

    public static String IO(String str) {
        return "enterfourm_att_" + str;
    }

    public static String IP(String str) {
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
        anVar.cx("page_type", str).X("ad_exp", z ? 1 : 0).X("ad_exp_cnt", i).X("obj_floor", 0).X("obj_adlocate", i2);
        if (str != null && kfD.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
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
        anVar.cx("page_type", str).X("obj_floor", i2).X("obj_isad", z2 ? 1 : 0).cx("obj_id", a(z2, str3, z3, str5, bjVar.getId(), bjVar.getBaijiahaoData())).cx("tid", bjVar.getTid()).X("thread_type", z2 ? -1 : bjVar.getThreadType()).X("obj_adlocate", i3);
        if (!aq.isEmpty(bjVar.aDJ())) {
            anVar.cx("list_strategy", bjVar.aDJ());
        }
        if (str != null && kfD.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().dmy)) {
            anVar.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
        } else if (!aq.isEmpty(bjVar.mRecomAbTag)) {
            anVar.cx(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag);
        }
        if (z) {
            anVar.X("obj_locate", i);
        }
        if (bjVar.getFid() > 0) {
            anVar.s("fid", bjVar.getFid());
        }
        if (!StringUtils.isNull(bjVar.aDW())) {
            anVar.cx("first_dir", bjVar.aDW());
        }
        if (!StringUtils.isNull(bjVar.aDX())) {
            anVar.cx("second_dir", bjVar.aDX());
        }
        if (bjVar.getBaijiahaoData() != null) {
            anVar.cx("ugc_vid", bjVar.getBaijiahaoData().oriUgcVid);
            anVar.cx("ugc_nid", bjVar.getBaijiahaoData().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.cx("pid", str4);
        }
        return anVar;
    }

    public static an a(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        an anVar = new an(str2);
        an X = anVar.cx("page_type", str).X("obj_floor", i2).X("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        X.cx("obj_id", str3).X("obj_adlocate", i3);
        if (str != null && kfD.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
        }
        if (z) {
            anVar.X("obj_locate", i);
        }
        return anVar;
    }
}

package com.baidu.tieba.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class a {
    public static am a(bb bbVar, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        if (bbVar == null) {
            return null;
        }
        return a(true, bbVar, str, str2, i, i2, z, str3, str4);
    }

    public static am a(bb bbVar, String str, String str2, int i, boolean z, String str3, String str4) {
        if (bbVar == null) {
            return null;
        }
        return a(false, bbVar, str, str2, -1, i, z, str3, str4);
    }

    public static am b(String str, String str2, boolean z, int i) {
        am amVar = new am(str2);
        amVar.aB("page_type", str).y("ad_exp", z ? 1 : 0).y("ad_exp_cnt", i);
        return amVar;
    }

    public static am a(boolean z, bb bbVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4) {
        am amVar = new am(str2);
        am y = amVar.aB("page_type", str).y("obj_floor", i2).y("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = bbVar.getId();
        }
        y.aB(VideoPlayActivityConfig.OBJ_ID, str3).aB("tid", bbVar.getTid()).y("thread_type", z2 ? -1 : bbVar.getThreadType());
        if (!ao.isEmpty(bbVar.Bd())) {
            amVar.aB("list_strategy", bbVar.Bd());
        }
        if (!ao.isEmpty(bbVar.mRecomAbTag)) {
            amVar.aB("ab_tag", bbVar.mRecomAbTag);
        }
        if (z) {
            amVar.y("obj_locate", i);
        }
        if (bbVar.getFid() > 0) {
            amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        }
        if (z) {
            if (!StringUtils.isNull(bbVar.zZ())) {
                amVar.aB(ImageViewerConfig.FORUM_NAME, bbVar.zZ());
            }
            if (!StringUtils.isNull(bbVar.Br())) {
                amVar.aB("first_dir", bbVar.Br());
            }
            if (!StringUtils.isNull(bbVar.Bs())) {
                amVar.aB("second_dir", bbVar.Bs());
            }
        }
        if (!StringUtils.isNull(str4)) {
            amVar.aB(Info.kBaiduPIDKey, str4);
        }
        return amVar;
    }
}

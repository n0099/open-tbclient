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
        amVar.aA("page_type", str).x("ad_exp", z ? 1 : 0).x("ad_exp_cnt", i);
        return amVar;
    }

    public static am a(boolean z, bb bbVar, String str, String str2, int i, int i2, boolean z2, String str3, String str4) {
        am amVar = new am(str2);
        am x = amVar.aA("page_type", str).x("obj_floor", i2).x("obj_isad", z2 ? 1 : 0);
        if (!z2) {
            str3 = bbVar.getId();
        }
        x.aA(VideoPlayActivityConfig.OBJ_ID, str3).aA("tid", bbVar.getTid()).x("thread_type", z2 ? -1 : bbVar.getThreadType());
        if (!ao.isEmpty(bbVar.AQ())) {
            amVar.aA("list_strategy", bbVar.AQ());
        }
        if (!ao.isEmpty(bbVar.mRecomAbTag)) {
            amVar.aA("ab_tag", bbVar.mRecomAbTag);
        }
        if (z) {
            amVar.x("obj_locate", i);
        }
        if (bbVar.getFid() > 0) {
            amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        }
        if (z) {
            if (!StringUtils.isNull(bbVar.zM())) {
                amVar.aA(ImageViewerConfig.FORUM_NAME, bbVar.zM());
            }
            if (!StringUtils.isNull(bbVar.Be())) {
                amVar.aA("first_dir", bbVar.Be());
            }
            if (!StringUtils.isNull(bbVar.Bf())) {
                amVar.aA("second_dir", bbVar.Bf());
            }
        }
        if (!StringUtils.isNull(str4)) {
            amVar.aA(Info.kBaiduPIDKey, str4);
        }
        return amVar;
    }
}

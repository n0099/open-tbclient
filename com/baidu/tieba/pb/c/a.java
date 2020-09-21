package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class a {
    public static void a(BdUniqueId bdUniqueId, f fVar, PostData postData, int i, int i2) {
        String str = null;
        if (postData != null) {
            str = postData.getId();
        }
        a(bdUniqueId, fVar, postData, str, str, i, i2);
    }

    public static void a(BdUniqueId bdUniqueId, f fVar, PostData postData, String str, String str2, int i, int i2) {
        if (bdUniqueId != null && fVar != null) {
            aq aqVar = new aq("common_exp");
            a(aqVar, fVar, postData, i, i2, false, str);
            c.dzC().a(bdUniqueId, str2, aqVar);
        }
    }

    public static void a(f fVar, PostData postData, int i, int i2) {
        String str = null;
        if (postData != null) {
            str = postData.getId();
        }
        a(fVar, postData, str, i, i2);
    }

    public static void a(f fVar, PostData postData, String str, int i, int i2) {
        if (fVar != null) {
            aq aqVar = new aq("common_click");
            a(aqVar, fVar, postData, i, i2, false, str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void a(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar != null) {
            aq aqVar = new aq("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(aqVar, fVar, postData, i, i2, false, str);
            aqVar.ai("obj_locate", i3);
            TiebaStatic.log(aqVar);
        }
    }

    public static aq b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        aq aqVar = new aq("common_click");
        a(aqVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        aqVar.ai("obj_locate", i3);
        return aqVar;
    }

    private static aq a(aq aqVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        aqVar.dF("page_type", PageStayDurationConstants.PageName.PB).ai("obj_floor", i).ai("obj_isad", z ? 1 : 0).dF("fid", fVar.getForumId() + "").dF("tid", fVar.getThreadId() + "").dF("obj_id", str + "").ai("post_type", i2);
        if (postData != null) {
            aqVar.dF("pid", postData.getId() + "");
        }
        if (fVar.cYR() != null) {
            aqVar.ai("thread_type", fVar.cYR().threadType);
            BaijiahaoData baijiahaoData = fVar.cYR().getBaijiahaoData();
            if (baijiahaoData != null) {
                aqVar.dF("ugc_nid", baijiahaoData.oriUgcNid);
                aqVar.dF("ugc_vid", baijiahaoData.oriUgcVid);
                aqVar.ai("ori_ugc_type", baijiahaoData.oriUgcType);
            }
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dF("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eCe);
        }
        return aqVar;
    }
}

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
/* loaded from: classes22.dex */
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
            c.dIX().a(bdUniqueId, str2, aqVar);
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
            aqVar.al("obj_locate", i3);
            TiebaStatic.log(aqVar);
        }
    }

    public static aq b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        aq aqVar = new aq("common_click");
        a(aqVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        aqVar.al("obj_locate", i3);
        return aqVar;
    }

    private static aq a(aq aqVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        int i3 = 1;
        if (fVar != null) {
            aqVar.dR("page_type", PageStayDurationConstants.PageName.PB).al("obj_floor", i).al("obj_isad", z ? 1 : 0).dR("fid", fVar.getForumId() + "").dR("tid", fVar.getThreadId() + "").dR("obj_id", str + "").al("post_type", i2);
            if (postData != null) {
                aqVar.dR("pid", postData.getId() + "");
            }
            if (fVar.dik() != null) {
                aqVar.al("thread_type", fVar.dik().threadType);
                BaijiahaoData baijiahaoData = fVar.dik().getBaijiahaoData();
                if (baijiahaoData != null) {
                    aqVar.dR("ugc_nid", baijiahaoData.oriUgcNid);
                    aqVar.dR("ugc_vid", baijiahaoData.oriUgcVid);
                    aqVar.al("ori_ugc_type", baijiahaoData.oriUgcType);
                }
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
            }
            if (!fVar.diN()) {
                if (fVar.lmU != 2) {
                    i3 = fVar.lmU == 1 ? 3 : 2;
                }
                aqVar.al("list_order", i3);
            }
        }
        return aqVar;
    }
}

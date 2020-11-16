package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.t.c;
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
            ar arVar = new ar("common_exp");
            a(arVar, fVar, postData, i, i2, false, str);
            c.dIO().a(bdUniqueId, str2, arVar);
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
            ar arVar = new ar("common_click");
            a(arVar, fVar, postData, i, i2, false, str);
            TiebaStatic.log(arVar);
        }
    }

    public static void a(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar != null) {
            ar arVar = new ar("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(arVar, fVar, postData, i, i2, false, str);
            arVar.ak("obj_locate", i3);
            TiebaStatic.log(arVar);
        }
    }

    public static ar b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        ar arVar = new ar("common_click");
        a(arVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        arVar.ak("obj_locate", i3);
        return arVar;
    }

    private static ar a(ar arVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        int i3 = 1;
        if (fVar != null) {
            arVar.dR("page_type", PageStayDurationConstants.PageName.PB).ak("obj_floor", i).ak("obj_isad", z ? 1 : 0).dR("fid", fVar.getForumId() + "").dR("tid", fVar.getThreadId() + "").dR("obj_id", str + "").ak("post_type", i2);
            if (postData != null) {
                arVar.dR("pid", postData.getId() + "");
            }
            if (fVar.dhH() != null) {
                arVar.ak("thread_type", fVar.dhH().threadType);
                BaijiahaoData baijiahaoData = fVar.dhH().getBaijiahaoData();
                if (baijiahaoData != null) {
                    arVar.dR("ugc_nid", baijiahaoData.oriUgcNid);
                    arVar.dR("ugc_vid", baijiahaoData.oriUgcVid);
                    arVar.ak("ori_ugc_type", baijiahaoData.oriUgcType);
                }
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
            }
            if (!fVar.dik()) {
                if (fVar.lnl != 2) {
                    i3 = fVar.lnl == 1 ? 3 : 2;
                }
                arVar.ak("list_order", i3);
            }
        }
        return arVar;
    }
}

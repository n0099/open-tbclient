package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.r.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes7.dex */
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
            an anVar = new an("common_exp");
            a(anVar, fVar, postData, i, i2, false, str);
            c.cIu().a(bdUniqueId, str2, anVar);
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
            an anVar = new an("common_click");
            a(anVar, fVar, postData, i, i2, false, str);
            TiebaStatic.log(anVar);
        }
    }

    public static void a(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar != null) {
            an anVar = new an("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(anVar, fVar, postData, i, i2, false, str);
            anVar.Z("obj_locate", i3);
            TiebaStatic.log(anVar);
        }
    }

    public static an b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        an anVar = new an("common_click");
        a(anVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        anVar.Z("obj_locate", i3);
        return anVar;
    }

    private static an a(an anVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        anVar.cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_floor", i).Z("obj_isad", z ? 1 : 0).cp("fid", fVar.getForumId() + "").cp("tid", fVar.getThreadId() + "").cp("obj_id", str + "").Z("post_type", i2);
        if (postData != null) {
            anVar.cp("pid", postData.getId() + "");
        }
        if (fVar.ciS() != null) {
            anVar.Z("thread_type", fVar.ciS().threadType);
            BaijiahaoData baijiahaoData = fVar.ciS().getBaijiahaoData();
            if (baijiahaoData != null) {
                anVar.cp("ugc_nid", baijiahaoData.oriUgcNid);
                anVar.cp("ugc_vid", baijiahaoData.oriUgcVid);
                anVar.Z("ori_ugc_type", baijiahaoData.oriUgcType);
            }
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhR);
        }
        return anVar;
    }
}

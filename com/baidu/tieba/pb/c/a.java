package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class a {
    public static void a(BdUniqueId bdUniqueId, e eVar, PostData postData, int i, int i2) {
        String str = null;
        if (postData != null) {
            str = postData.getId();
        }
        a(bdUniqueId, eVar, postData, str, str, i, i2);
    }

    public static void a(BdUniqueId bdUniqueId, e eVar, PostData postData, String str, String str2, int i, int i2) {
        if (bdUniqueId != null && eVar != null) {
            an anVar = new an("common_exp");
            a(anVar, eVar, postData, i, i2, false, str);
            c.cVp().a(bdUniqueId, str2, anVar);
        }
    }

    public static void a(e eVar, PostData postData, int i, int i2) {
        String str = null;
        if (postData != null) {
            str = postData.getId();
        }
        a(eVar, postData, str, i, i2);
    }

    public static void a(e eVar, PostData postData, String str, int i, int i2) {
        if (eVar != null) {
            an anVar = new an("common_click");
            a(anVar, eVar, postData, i, i2, false, str);
            TiebaStatic.log(anVar);
        }
    }

    public static void a(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar != null) {
            an anVar = new an("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(anVar, eVar, postData, i, i2, false, str);
            anVar.af("obj_locate", i3);
            TiebaStatic.log(anVar);
        }
    }

    public static an b(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar == null) {
            return null;
        }
        an anVar = new an("common_click");
        a(anVar, eVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        anVar.af("obj_locate", i3);
        return anVar;
    }

    private static an a(an anVar, e eVar, PostData postData, int i, int i2, boolean z, String str) {
        anVar.cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_floor", i).af("obj_isad", z ? 1 : 0).cI("fid", eVar.getForumId() + "").cI("tid", eVar.getThreadId() + "").cI("obj_id", str + "").af("post_type", i2);
        if (postData != null) {
            anVar.cI("pid", postData.getId() + "");
        }
        if (eVar.cvs() != null) {
            anVar.af("thread_type", eVar.cvs().threadType);
            BaijiahaoData baijiahaoData = eVar.cvs().getBaijiahaoData();
            if (baijiahaoData != null) {
                anVar.cI("ugc_nid", baijiahaoData.oriUgcNid);
                anVar.cI("ugc_vid", baijiahaoData.oriUgcVid);
                anVar.af("ori_ugc_type", baijiahaoData.oriUgcType);
            }
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMx);
        }
        return anVar;
    }
}

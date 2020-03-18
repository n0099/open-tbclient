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
            c.cKv().a(bdUniqueId, str2, anVar);
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
            anVar.X("obj_locate", i3);
            TiebaStatic.log(anVar);
        }
    }

    public static an b(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar == null) {
            return null;
        }
        an anVar = new an("common_click");
        a(anVar, eVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        anVar.X("obj_locate", i3);
        return anVar;
    }

    private static an a(an anVar, e eVar, PostData postData, int i, int i2, boolean z, String str) {
        anVar.cx("page_type", PageStayDurationConstants.PageName.PB).X("obj_floor", i).X("obj_isad", z ? 1 : 0).cx("fid", eVar.getForumId() + "").cx("tid", eVar.getThreadId() + "").cx("obj_id", str + "").X("post_type", i2);
        if (postData != null) {
            anVar.cx("pid", postData.getId() + "");
        }
        if (eVar.ckP() != null) {
            anVar.X("thread_type", eVar.ckP().threadType);
            BaijiahaoData baijiahaoData = eVar.ckP().getBaijiahaoData();
            if (baijiahaoData != null) {
                anVar.cx("ugc_nid", baijiahaoData.oriUgcNid);
                anVar.cx("ugc_vid", baijiahaoData.oriUgcVid);
                anVar.X("ori_ugc_type", baijiahaoData.oriUgcType);
            }
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
        }
        return anVar;
    }
}

package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
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
            ao aoVar = new ao("common_exp");
            a(aoVar, eVar, postData, i, i2, false, str);
            c.dgY().a(bdUniqueId, str2, aoVar);
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
            ao aoVar = new ao("common_click");
            a(aoVar, eVar, postData, i, i2, false, str);
            TiebaStatic.log(aoVar);
        }
    }

    public static void a(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar != null) {
            ao aoVar = new ao("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(aoVar, eVar, postData, i, i2, false, str);
            aoVar.ag("obj_locate", i3);
            TiebaStatic.log(aoVar);
        }
    }

    public static ao b(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar == null) {
            return null;
        }
        ao aoVar = new ao("common_click");
        a(aoVar, eVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        aoVar.ag("obj_locate", i3);
        return aoVar;
    }

    private static ao a(ao aoVar, e eVar, PostData postData, int i, int i2, boolean z, String str) {
        aoVar.dk("page_type", PageStayDurationConstants.PageName.PB).ag("obj_floor", i).ag("obj_isad", z ? 1 : 0).dk("fid", eVar.getForumId() + "").dk("tid", eVar.getThreadId() + "").dk("obj_id", str + "").ag("post_type", i2);
        if (postData != null) {
            aoVar.dk("pid", postData.getId() + "");
        }
        if (eVar.cGO() != null) {
            aoVar.ag("thread_type", eVar.cGO().threadType);
            BaijiahaoData baijiahaoData = eVar.cGO().getBaijiahaoData();
            if (baijiahaoData != null) {
                aoVar.dk("ugc_nid", baijiahaoData.oriUgcNid);
                aoVar.dk("ugc_vid", baijiahaoData.oriUgcVid);
                aoVar.ag("ori_ugc_type", baijiahaoData.oriUgcType);
            }
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aoVar.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
        }
        return aoVar;
    }
}

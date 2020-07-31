package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
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
            ap apVar = new ap("common_exp");
            a(apVar, fVar, postData, i, i2, false, str);
            c.dkh().a(bdUniqueId, str2, apVar);
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
            ap apVar = new ap("common_click");
            a(apVar, fVar, postData, i, i2, false, str);
            TiebaStatic.log(apVar);
        }
    }

    public static void a(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar != null) {
            ap apVar = new ap("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(apVar, fVar, postData, i, i2, false, str);
            apVar.ah("obj_locate", i3);
            TiebaStatic.log(apVar);
        }
    }

    public static ap b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        ap apVar = new ap("common_click");
        a(apVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        apVar.ah("obj_locate", i3);
        return apVar;
    }

    private static ap a(ap apVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        apVar.dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_floor", i).ah("obj_isad", z ? 1 : 0).dn("fid", fVar.getForumId() + "").dn("tid", fVar.getThreadId() + "").dn("obj_id", str + "").ah("post_type", i2);
        if (postData != null) {
            apVar.dn("pid", postData.getId() + "");
        }
        if (fVar.cKx() != null) {
            apVar.ah("thread_type", fVar.cKx().threadType);
            BaijiahaoData baijiahaoData = fVar.cKx().getBaijiahaoData();
            if (baijiahaoData != null) {
                apVar.dn("ugc_nid", baijiahaoData.oriUgcNid);
                apVar.dn("ugc_vid", baijiahaoData.oriUgcVid);
                apVar.ah("ori_ugc_type", baijiahaoData.oriUgcType);
            }
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            apVar.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
        }
        return apVar;
    }
}

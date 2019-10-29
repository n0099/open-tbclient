package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class a {
    public static void a(BdUniqueId bdUniqueId, d dVar, PostData postData, int i, int i2) {
        String str = null;
        if (postData != null) {
            str = postData.getId();
        }
        a(bdUniqueId, dVar, postData, str, str, i, i2);
    }

    public static void a(BdUniqueId bdUniqueId, d dVar, PostData postData, String str, String str2, int i, int i2) {
        if (bdUniqueId != null && dVar != null) {
            an anVar = new an("common_exp");
            a(anVar, dVar, postData, i, i2, false, str);
            c.cnk().a(bdUniqueId, str2, anVar);
        }
    }

    public static void a(d dVar, PostData postData, int i, int i2) {
        String str = null;
        if (postData != null) {
            str = postData.getId();
        }
        a(dVar, postData, str, i, i2);
    }

    public static void a(d dVar, PostData postData, String str, int i, int i2) {
        if (dVar != null) {
            an anVar = new an("common_click");
            a(anVar, dVar, postData, i, i2, false, str);
            TiebaStatic.log(anVar);
        }
    }

    public static void a(d dVar, PostData postData, int i, int i2, int i3) {
        if (dVar != null) {
            an anVar = new an("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(anVar, dVar, postData, i, i2, false, str);
            anVar.O("obj_locate", i3);
            TiebaStatic.log(anVar);
        }
    }

    public static an b(d dVar, PostData postData, int i, int i2, int i3) {
        if (dVar == null) {
            return null;
        }
        an anVar = new an("common_click");
        a(anVar, dVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        anVar.O("obj_locate", i3);
        return anVar;
    }

    private static an a(an anVar, d dVar, PostData postData, int i, int i2, boolean z, String str) {
        anVar.bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_floor", i).O("obj_isad", z ? 1 : 0).bS("fid", dVar.getForumId() + "").bS("tid", dVar.getThreadId() + "").bS("obj_id", str + "").O("post_type", i2);
        if (postData != null) {
            anVar.bS("pid", postData.getId() + "");
        }
        if (dVar.bQz() != null) {
            anVar.O("thread_type", dVar.bQz().threadType);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().cuL);
        }
        return anVar;
    }
}

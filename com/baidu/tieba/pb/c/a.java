package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
            am amVar = new am("common_exp");
            a(amVar, dVar, postData, i, i2, false, str);
            c.clt().a(bdUniqueId, str2, amVar);
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
            am amVar = new am("common_click");
            a(amVar, dVar, postData, i, i2, false, str);
            TiebaStatic.log(amVar);
        }
    }

    public static void a(d dVar, PostData postData, int i, int i2, int i3) {
        if (dVar != null) {
            am amVar = new am("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(amVar, dVar, postData, i, i2, false, str);
            amVar.P("obj_locate", i3);
            TiebaStatic.log(amVar);
        }
    }

    public static am b(d dVar, PostData postData, int i, int i2, int i3) {
        if (dVar == null) {
            return null;
        }
        am amVar = new am("common_click");
        a(amVar, dVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        amVar.P("obj_locate", i3);
        return amVar;
    }

    private static am a(am amVar, d dVar, PostData postData, int i, int i2, boolean z, String str) {
        amVar.bT("page_type", "a005").P("obj_floor", i).P("obj_isad", z ? 1 : 0).bT("fid", dVar.getForumId() + "").bT("tid", dVar.getThreadId() + "").bT(VideoPlayActivityConfig.OBJ_ID, str + "").P("post_type", i2);
        if (postData != null) {
            amVar.bT(Info.kBaiduPIDKey, postData.getId() + "");
        }
        if (dVar.bPI() != null) {
            amVar.P("thread_type", dVar.bPI().threadType);
        }
        return amVar;
    }
}

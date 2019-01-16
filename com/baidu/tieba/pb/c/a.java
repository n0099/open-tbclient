package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
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
            c.bCC().a(bdUniqueId, str2, amVar);
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
            amVar.y("obj_locate", i3);
            TiebaStatic.log(amVar);
        }
    }

    public static am b(d dVar, PostData postData, int i, int i2, int i3) {
        if (dVar == null) {
            return null;
        }
        am amVar = new am("common_click");
        a(amVar, dVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        amVar.y("obj_locate", i3);
        return amVar;
    }

    private static am a(am amVar, d dVar, PostData postData, int i, int i2, boolean z, String str) {
        amVar.aB("page_type", "a005").y("obj_floor", i).y("obj_isad", z ? 1 : 0).aB(ImageViewerConfig.FORUM_ID, dVar.getForumId() + "").aB("tid", dVar.getThreadId() + "").aB(VideoPlayActivityConfig.OBJ_ID, str + "").y("post_type", i2);
        if (postData != null) {
            amVar.aB(Info.kBaiduPIDKey, postData.getId() + "");
        }
        if (dVar.bhz() != null) {
            amVar.y("thread_type", dVar.bhz().threadType);
        }
        return amVar;
    }
}

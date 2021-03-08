package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
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
            c.dMH().a(bdUniqueId, str2, arVar);
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
            arVar.aq("obj_locate", i3);
            TiebaStatic.log(arVar);
        }
    }

    public static ar b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        ar arVar = new ar("common_click");
        a(arVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        arVar.aq("obj_locate", i3);
        return arVar;
    }

    private static ar a(ar arVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        int i3 = 1;
        if (fVar != null) {
            arVar.dR("page_type", PageStayDurationConstants.PageName.PB).aq("obj_floor", i).aq("obj_isad", z ? 1 : 0).dR("fid", fVar.getForumId() + "").dR("tid", fVar.getThreadId() + "").dR("obj_id", str + "").aq("post_type", i2);
            if (postData != null) {
                arVar.dR("pid", postData.getId() + "");
            }
            if (fVar.dlp() != null) {
                arVar.aq("thread_type", fVar.dlp().threadType);
                BaijiahaoData baijiahaoData = fVar.dlp().getBaijiahaoData();
                if (baijiahaoData != null) {
                    arVar.dR("ugc_nid", baijiahaoData.oriUgcNid);
                    arVar.dR("ugc_vid", baijiahaoData.oriUgcVid);
                    arVar.aq("ori_ugc_type", baijiahaoData.oriUgcType);
                }
            }
            if (fVar.dlp().bqd()) {
                arVar.aq("gua_type", 1);
            } else if (postData.bpY() != null) {
                arVar.aq("gua_type", 2);
            } else {
                arVar.aq("gua_type", 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().frW);
            }
            if (!fVar.dlS()) {
                if (fVar.lMp != 2) {
                    i3 = fVar.lMp == 1 ? 3 : 2;
                }
                arVar.aq("list_order", i3);
            }
        }
        return arVar;
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, int i) {
        if (aVar != null && aVar.blp() != null) {
            ar arVar = new ar("c13992");
            if (aVar.blp().bpI() != null) {
                arVar.aq("obj_type", Qi(aVar.blp().bpI().eRo));
            }
            arVar.aq("obj_locate", aVar.blp().eOa);
            arVar.dR("tid", aVar.blp().getTid());
            arVar.v("fid", aVar.blp().getFid());
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.aq("obj_source", i);
            TiebaStatic.log(arVar);
        }
    }

    public static void i(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null) {
            ar arVar = new ar("c14020");
            if (aVar.blp().bpI() != null) {
                arVar.aq("obj_type", Qi(aVar.blp().bpI().eRo));
            }
            arVar.dR("tid", aVar.blp().getTid());
            arVar.v("fid", aVar.blp().getFid());
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    private static int Qi(String str) {
        if ("游戏".equals(str)) {
            return 1;
        }
        if ("动漫".equals(str)) {
            return 2;
        }
        if ("电脑数码".equals(str)) {
            return 3;
        }
        return 4;
    }
}

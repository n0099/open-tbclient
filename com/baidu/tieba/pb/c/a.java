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
/* loaded from: classes22.dex */
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
            c.dOe().a(bdUniqueId, str2, arVar);
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
            arVar.al("obj_locate", i3);
            TiebaStatic.log(arVar);
        }
    }

    public static ar b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        ar arVar = new ar("common_click");
        a(arVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        arVar.al("obj_locate", i3);
        return arVar;
    }

    private static ar a(ar arVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        int i3 = 1;
        if (fVar != null) {
            arVar.dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_floor", i).al("obj_isad", z ? 1 : 0).dY("fid", fVar.getForumId() + "").dY("tid", fVar.getThreadId() + "").dY("obj_id", str + "").al("post_type", i2);
            if (postData != null) {
                arVar.dY("pid", postData.getId() + "");
            }
            if (fVar.dmT() != null) {
                arVar.al("thread_type", fVar.dmT().threadType);
                BaijiahaoData baijiahaoData = fVar.dmT().getBaijiahaoData();
                if (baijiahaoData != null) {
                    arVar.dY("ugc_nid", baijiahaoData.oriUgcNid);
                    arVar.dY("ugc_vid", baijiahaoData.oriUgcVid);
                    arVar.al("ori_ugc_type", baijiahaoData.oriUgcType);
                }
            }
            if (fVar.dmT().bra()) {
                arVar.al("gua_type", 1);
            } else if (postData.bqV() != null) {
                arVar.al("gua_type", 2);
            } else {
                arVar.al("gua_type", 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                arVar.dY("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fje);
            }
            if (!fVar.dnx()) {
                if (fVar.lAK != 2) {
                    i3 = fVar.lAK == 1 ? 3 : 2;
                }
                arVar.al("list_order", i3);
            }
        }
        return arVar;
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, int i) {
        if (aVar != null && aVar.bmn() != null) {
            ar arVar = new ar("c13992");
            if (aVar.bmn().bqF() != null) {
                arVar.al("obj_type", QM(aVar.bmn().bqF().eIu));
            }
            arVar.al("obj_locate", aVar.bmn().eFi);
            arVar.dY("tid", aVar.bmn().getTid());
            arVar.w("fid", aVar.bmn().getFid());
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.al("obj_source", i);
            TiebaStatic.log(arVar);
        }
    }

    public static void i(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmn() != null) {
            ar arVar = new ar("c14020");
            if (aVar.bmn().bqF() != null) {
                arVar.al("obj_type", QM(aVar.bmn().bqF().eIu));
            }
            arVar.dY("tid", aVar.bmn().getTid());
            arVar.w("fid", aVar.bmn().getFid());
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    private static int QM(String str) {
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

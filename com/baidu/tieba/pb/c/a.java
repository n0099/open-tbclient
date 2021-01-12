package com.baidu.tieba.pb.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
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
            aq aqVar = new aq("common_exp");
            a(aqVar, fVar, postData, i, i2, false, str);
            c.dKg().a(bdUniqueId, str2, aqVar);
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
            aq aqVar = new aq("common_click");
            a(aqVar, fVar, postData, i, i2, false, str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void a(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar != null) {
            aq aqVar = new aq("common_click");
            String str = null;
            if (postData != null) {
                str = postData.getId();
            }
            a(aqVar, fVar, postData, i, i2, false, str);
            aqVar.an("obj_locate", i3);
            TiebaStatic.log(aqVar);
        }
    }

    public static aq b(f fVar, PostData postData, int i, int i2, int i3) {
        if (fVar == null) {
            return null;
        }
        aq aqVar = new aq("common_click");
        a(aqVar, fVar, postData, i, i2, false, postData != null ? postData.getId() : null);
        aqVar.an("obj_locate", i3);
        return aqVar;
    }

    private static aq a(aq aqVar, f fVar, PostData postData, int i, int i2, boolean z, String str) {
        int i3 = 1;
        if (fVar != null) {
            aqVar.dW("page_type", PageStayDurationConstants.PageName.PB).an("obj_floor", i).an("obj_isad", z ? 1 : 0).dW("fid", fVar.getForumId() + "").dW("tid", fVar.getThreadId() + "").dW("obj_id", str + "").an("post_type", i2);
            if (postData != null) {
                aqVar.dW("pid", postData.getId() + "");
            }
            if (fVar.diN() != null) {
                aqVar.an("thread_type", fVar.diN().threadType);
                BaijiahaoData baijiahaoData = fVar.diN().getBaijiahaoData();
                if (baijiahaoData != null) {
                    aqVar.dW("ugc_nid", baijiahaoData.oriUgcNid);
                    aqVar.dW("ugc_vid", baijiahaoData.oriUgcVid);
                    aqVar.an("ori_ugc_type", baijiahaoData.oriUgcType);
                }
            }
            if (fVar.diN().bpJ()) {
                aqVar.an("gua_type", 1);
            } else if (postData.bpE() != null) {
                aqVar.an("gua_type", 2);
            } else {
                aqVar.an("gua_type", 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                aqVar.dW("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().foc);
            }
            if (!fVar.djq()) {
                if (fVar.lBm != 2) {
                    i3 = fVar.lBm == 1 ? 3 : 2;
                }
                aqVar.an("list_order", i3);
            }
        }
        return aqVar;
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, int i) {
        if (aVar != null && aVar.bkV() != null) {
            aq aqVar = new aq("c13992");
            if (aVar.bkV().bpo() != null) {
                aqVar.an("obj_type", Pj(aVar.bkV().bpo().eNB));
            }
            aqVar.an("obj_locate", aVar.bkV().eKn);
            aqVar.dW("tid", aVar.bkV().getTid());
            aqVar.w("fid", aVar.bkV().getFid());
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.an("obj_source", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void i(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bkV() != null) {
            aq aqVar = new aq("c14020");
            if (aVar.bkV().bpo() != null) {
                aqVar.an("obj_type", Pj(aVar.bkV().bpo().eNB));
            }
            aqVar.dW("tid", aVar.bkV().getTid());
            aqVar.w("fid", aVar.bkV().getFid());
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    private static int Pj(String str) {
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

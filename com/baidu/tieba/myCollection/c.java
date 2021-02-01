package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class c {
    public static void OK(String str) {
        if (!StringUtils.isNull(str)) {
            ar arVar = new ar(str);
            arVar.dR("uid", TbadkApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }

    public static void A(String str, Object obj) {
        if (obj instanceof MarkData) {
            MarkData markData = (MarkData) obj;
            if (!StringUtils.isNull(str)) {
                ar arVar = new ar(str);
                arVar.dR("uid", TbadkApplication.getCurrentAccount());
                arVar.dR("tid", markData.getId());
                arVar.dR("fname", markData.getForumName());
                char c = 65535;
                switch (str.hashCode()) {
                    case -1413831834:
                        if (str.equals("c14062")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1413831833:
                        if (str.equals("c14063")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1413831832:
                        if (str.equals("c14064")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1413831831:
                        if (str.equals("c14065")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1413831828:
                        if (str.equals("c14068")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -1413831827:
                        if (str.equals("c14069")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        a(markData, arVar);
                        break;
                    case 1:
                        a(markData, arVar);
                        arVar.dR("obj_id", markData.getUesrId());
                        break;
                    case 2:
                    case 3:
                        arVar.dR("obj_id", markData.getUesrId());
                        break;
                    case 4:
                        a(markData, arVar);
                        arVar.dR("obj_source", "1");
                        break;
                }
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void a(String str, boolean z, MarkData markData) {
        if (markData != null && !StringUtils.isNull(str)) {
            ar arVar = new ar(str);
            arVar.dR("uid", TbadkApplication.getCurrentAccount());
            arVar.dR("tid", markData.getId());
            arVar.dR("fname", markData.getForumName());
            if (z) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, "1");
            } else {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, "2");
            }
            TiebaStatic.log(arVar);
        }
    }

    private static void a(MarkData markData, ar arVar) {
        if (markData.is_deleted()) {
            arVar.dR("obj_param1", "3");
        } else if (markData.isRedTipShow() && !StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) {
            arVar.dR("obj_param1", "1");
        } else {
            arVar.dR("obj_param1", "2");
        }
    }
}

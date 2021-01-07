package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes8.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bl) {
            aq aqVar = new aq(str);
            aqVar.w("fid", ((bl) obj).getForumId());
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bwo();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.eMv != null) {
                aqVar2.dX("tid", bVar.eMv.getTid());
            }
            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bwo();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.boP() != null) {
            bz boP = aVar2.boP();
            aq aqVar = new aq(aVar.djU() ? "c13823" : "c13822");
            aqVar.dX("tid", boP.getTid());
            aqVar.w("fid", boP.getFid());
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bwo();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.boP() != null) {
            bz boP = aVar2.boP();
            aq aqVar = new aq(aVar.djU() ? "c13824" : "c13821");
            aqVar.dX("tid", boP.getTid());
            aqVar.w("fid", boP.getFid());
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bwo();
        }
    }
}

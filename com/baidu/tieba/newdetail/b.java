package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes15.dex */
public class b {
    public static void b(String str, Object obj, int i) {
        if (obj instanceof bh) {
            ap apVar = new ap(str);
            apVar.t("fid", ((bh) obj).getForumId());
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.baO();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            ap apVar2 = new ap(str);
            if (bVar.dLK != null) {
                apVar2.dn("tid", bVar.dLK.getTid());
            }
            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar2.baO();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            ap apVar = new ap(aVar.cHL() ? "c13823" : "c13822");
            apVar.dn("tid", aTN.getTid());
            apVar.t("fid", aTN.getFid());
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.baO();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            ap apVar = new ap(aVar.cHL() ? "c13824" : "c13821");
            apVar.dn("tid", aTN.getTid());
            apVar.t("fid", aTN.getFid());
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.baO();
        }
    }
}

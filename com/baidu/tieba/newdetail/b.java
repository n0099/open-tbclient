package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bi) {
            aq aqVar = new aq(str);
            aqVar.w("fid", ((bi) obj).getForumId());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.boK();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.erH != null) {
                aqVar2.dR("tid", bVar.erH.getTid());
            }
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.boK();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            bw bhz = absThreadDataSupport.bhz();
            aq aqVar = new aq(aVar.dcX() ? "c13823" : "c13822");
            aqVar.dR("tid", bhz.getTid());
            aqVar.w("fid", bhz.getFid());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.boK();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            bw bhz = absThreadDataSupport.bhz();
            aq aqVar = new aq(aVar.dcX() ? "c13824" : "c13821");
            aqVar.dR("tid", bhz.getTid());
            aqVar.w("fid", bhz.getFid());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.boK();
        }
    }
}

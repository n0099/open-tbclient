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
            aqVar.u("fid", ((bi) obj).getForumId());
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bmR();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.eji != null) {
                aqVar2.dK("tid", bVar.eji.getTid());
            }
            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bmR();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            aq aqVar = new aq(aVar.cZP() ? "c13823" : "c13822");
            aqVar.dK("tid", bfG.getTid());
            aqVar.u("fid", bfG.getFid());
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bmR();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            aq aqVar = new aq(aVar.cZP() ? "c13824" : "c13821");
            aqVar.dK("tid", bfG.getTid());
            aqVar.u("fid", bfG.getFid());
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bmR();
        }
    }
}

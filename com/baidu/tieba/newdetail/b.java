package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes20.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bi) {
            aq aqVar = new aq(str);
            aqVar.u("fid", ((bi) obj).getForumId());
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bki();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.dXg != null) {
                aqVar2.dF("tid", bVar.dXg.getTid());
            }
            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bki();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            aq aqVar = new aq(aVar.cWg() ? "c13823" : "c13822");
            aqVar.dF("tid", bcY.getTid());
            aqVar.u("fid", bcY.getFid());
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bki();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            aq aqVar = new aq(aVar.cWg() ? "c13824" : "c13821");
            aqVar.dF("tid", bcY.getTid());
            aqVar.u("fid", bcY.getFid());
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bki();
        }
    }
}

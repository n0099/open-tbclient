package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes15.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bi) {
            aq aqVar = new aq(str);
            aqVar.u("fid", ((bi) obj).getForumId());
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bjn();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.dUS != null) {
                aqVar2.dD("tid", bVar.dUS.getTid());
            }
            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bjn();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            aq aqVar = new aq(aVar.cSA() ? "c13823" : "c13822");
            aqVar.dD("tid", bce.getTid());
            aqVar.u("fid", bce.getFid());
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bjn();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            aq aqVar = new aq(aVar.cSA() ? "c13824" : "c13821");
            aqVar.dD("tid", bce.getTid());
            aqVar.u("fid", bce.getFid());
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bjn();
        }
    }
}

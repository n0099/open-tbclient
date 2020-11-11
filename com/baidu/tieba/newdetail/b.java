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
            aqVar.brk();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.exA != null) {
                aqVar2.dR("tid", bVar.exA.getTid());
            }
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.brk();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null) {
            bw bjZ = absThreadDataSupport.bjZ();
            aq aqVar = new aq(aVar.dfz() ? "c13823" : "c13822");
            aqVar.dR("tid", bjZ.getTid());
            aqVar.w("fid", bjZ.getFid());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.brk();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null) {
            bw bjZ = absThreadDataSupport.bjZ();
            aq aqVar = new aq(aVar.dfz() ? "c13824" : "c13821");
            aqVar.dR("tid", bjZ.getTid());
            aqVar.w("fid", bjZ.getFid());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.brk();
        }
    }
}

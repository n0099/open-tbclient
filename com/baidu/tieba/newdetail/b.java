package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes20.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bj) {
            ar arVar = new ar(str);
            arVar.w("fid", ((bj) obj).getForumId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bqy();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            ar arVar2 = new ar(str);
            if (bVar.evQ != null) {
                arVar2.dR("tid", bVar.evQ.getTid());
            }
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.bqy();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bjd() != null) {
            bx bjd = aVar2.bjd();
            ar arVar = new ar(aVar.deW() ? "c13823" : "c13822");
            arVar.dR("tid", bjd.getTid());
            arVar.w("fid", bjd.getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bqy();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bjd() != null) {
            bx bjd = aVar2.bjd();
            ar arVar = new ar(aVar.deW() ? "c13824" : "c13821");
            arVar.dR("tid", bjd.getTid());
            arVar.w("fid", bjd.getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bqy();
        }
    }
}

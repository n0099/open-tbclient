package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes21.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bk) {
            ar arVar = new ar(str);
            arVar.w("fid", ((bk) obj).getForumId());
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.btT();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            ar arVar2 = new ar(str);
            if (bVar.eCR != null) {
                arVar2.dY("tid", bVar.eCR.getTid());
            }
            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.btT();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bmn() != null) {
            by bmn = aVar2.bmn();
            ar arVar = new ar(aVar.dkj() ? "c13823" : "c13822");
            arVar.dY("tid", bmn.getTid());
            arVar.w("fid", bmn.getFid());
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.btT();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bmn() != null) {
            by bmn = aVar2.bmn();
            ar arVar = new ar(aVar.dkj() ? "c13824" : "c13821");
            arVar.dY("tid", bmn.getTid());
            arVar.w("fid", bmn.getFid());
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.btT();
        }
    }
}

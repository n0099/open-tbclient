package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes7.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bn) {
            ar arVar = new ar(str);
            arVar.v("fid", ((bn) obj).getForumId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsR();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            ar arVar2 = new ar(str);
            if (bVar.eLr != null) {
                arVar2.dR("tid", bVar.eLr.getTid());
            }
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.bsR();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.blp() != null) {
            cb blp = aVar2.blp();
            ar arVar = new ar(aVar.dit() ? "c13823" : "c13822");
            arVar.dR("tid", blp.getTid());
            arVar.v("fid", blp.getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsR();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.blp() != null) {
            cb blp = aVar2.blp();
            ar arVar = new ar(aVar.dit() ? "c13824" : "c13821");
            arVar.dR("tid", blp.getTid());
            arVar.v("fid", blp.getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsR();
        }
    }
}

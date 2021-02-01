package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bn) {
            ar arVar = new ar(str);
            arVar.v("fid", ((bn) obj).getForumId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsO();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            ar arVar2 = new ar(str);
            if (bVar.eJQ != null) {
                arVar2.dR("tid", bVar.eJQ.getTid());
            }
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.bsO();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bln() != null) {
            cb bln = aVar2.bln();
            ar arVar = new ar(aVar.did() ? "c13823" : "c13822");
            arVar.dR("tid", bln.getTid());
            arVar.v("fid", bln.getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsO();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bln() != null) {
            cb bln = aVar2.bln();
            ar arVar = new ar(aVar.did() ? "c13824" : "c13821");
            arVar.dR("tid", bln.getTid());
            arVar.v("fid", bln.getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.bsO();
        }
    }
}

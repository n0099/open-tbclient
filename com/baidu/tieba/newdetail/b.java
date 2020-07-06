package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes8.dex */
public class b {
    public static void b(String str, Object obj, int i) {
        if (obj instanceof bg) {
            ao aoVar = new ao(str);
            aoVar.s("fid", ((bg) obj).getForumId());
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.aWN();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            ao aoVar2 = new ao(str);
            if (bVar.dLi != null) {
                aoVar2.dk("tid", bVar.dLi.getTid());
            }
            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar2.aWN();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            ao aoVar = new ao(aVar.cEd() ? "c13823" : "c13822");
            aoVar.dk("tid", aPS.getTid());
            aoVar.s("fid", aPS.getFid());
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.aWN();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            ao aoVar = new ao(aVar.cEd() ? "c13824" : "c13821");
            aoVar.dk("tid", aPS.getTid());
            aoVar.s("fid", aPS.getFid());
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.aWN();
        }
    }
}

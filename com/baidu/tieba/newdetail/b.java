package com.baidu.tieba.newdetail;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes7.dex */
public class b {
    public static void c(String str, Object obj, int i) {
        if (obj instanceof bl) {
            aq aqVar = new aq(str);
            aqVar.w("fid", ((bl) obj).getForumId());
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bsu();
        } else if (obj instanceof com.baidu.tieba.newdetail.a.b) {
            com.baidu.tieba.newdetail.a.b bVar = (com.baidu.tieba.newdetail.a.b) obj;
            aq aqVar2 = new aq(str);
            if (bVar.eHK != null) {
                aqVar2.dW("tid", bVar.eHK.getTid());
            }
            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bsu();
        }
    }

    public static void a(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bkV() != null) {
            bz bkV = aVar2.bkV();
            aq aqVar = new aq(aVar.dgc() ? "c13823" : "c13822");
            aqVar.dW("tid", bkV.getTid());
            aqVar.w("fid", bkV.getFid());
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bsu();
        }
    }

    public static void b(com.baidu.tieba.newdetail.adapter.a.a aVar, com.baidu.tbadk.core.data.a aVar2) {
        if (aVar2 != null && aVar2.bkV() != null) {
            bz bkV = aVar2.bkV();
            aq aqVar = new aq(aVar.dgc() ? "c13824" : "c13821");
            aqVar.dW("tid", bkV.getTid());
            aqVar.w("fid", bkV.getFid());
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.bsu();
        }
    }
}

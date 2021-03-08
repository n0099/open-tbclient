package com.baidu.tieba.payment;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class d {
    public static void Pl(String str) {
        int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        ar arVar = new ar(str);
        arVar.aq("obj_type", i);
        TiebaStatic.log(arVar);
    }
}

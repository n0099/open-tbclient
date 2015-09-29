package com.baidu.tieba.payment;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class r {
    public static void jz(String str) {
        int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        ap apVar = new ap(str);
        apVar.r("obj_type", i);
        TiebaStatic.log(apVar);
    }
}

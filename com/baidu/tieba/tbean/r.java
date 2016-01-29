package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class r {
    public static void kr(String str) {
        int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        au auVar = new au(str);
        auVar.r("obj_type", i);
        TiebaStatic.log(auVar);
    }
}

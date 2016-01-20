package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class r {
    public static void ko(String str) {
        int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        av avVar = new av(str);
        avVar.r("obj_type", i);
        TiebaStatic.log(avVar);
    }
}

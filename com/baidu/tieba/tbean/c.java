package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes9.dex */
public class c {
    public static void Pu(String str) {
        int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        aq aqVar = new aq(str);
        aqVar.an("obj_type", i);
        TiebaStatic.log(aqVar);
    }
}

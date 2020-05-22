package com.baidu.tieba.pbextra.praise;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
/* loaded from: classes9.dex */
public class PraiseListActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PraiseListActivityConfig.class, PraiseListActivity.class);
    }
}

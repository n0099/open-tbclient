package com.baidu.tieba.newinterest.activity;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import d.a.o0.a2.e.b;
/* loaded from: classes5.dex */
public class InterestGuideActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(InterestGuideActivityConfig.class, InterestGuideActivity.class);
        b.n();
    }
}

package com.baidu.tieba.newinterest.activity;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import d.a.k0.z1.e.b;
/* loaded from: classes4.dex */
public class InterestGuideActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(InterestGuideActivityConfig.class, InterestGuideActivity.class);
        b.l();
    }
}

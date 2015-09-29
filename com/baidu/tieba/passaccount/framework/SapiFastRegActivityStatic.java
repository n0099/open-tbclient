package com.baidu.tieba.passaccount.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tieba.passaccount.app.SapiFastRegActivity;
/* loaded from: classes.dex */
public class SapiFastRegActivityStatic {
    static {
        com.baidu.tbadk.coreExtra.a.b.checkPassV6Switch();
        if (!com.baidu.tbadk.coreExtra.a.b.vY()) {
            TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(RegisterActivityConfig.class, SapiFastRegActivity.class);
        }
    }
}

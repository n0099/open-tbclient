package com.baidu.tieba.passaccount.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.passaccount.app.LoginActivity;
/* loaded from: classes.dex */
public class LoginActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        be.wt().a(new b());
    }
}

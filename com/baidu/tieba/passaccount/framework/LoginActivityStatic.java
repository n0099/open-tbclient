package com.baidu.tieba.passaccount.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.passaccount.app.LoginActivity;
/* loaded from: classes.dex */
public class LoginActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        bg.us().a(new b());
    }
}

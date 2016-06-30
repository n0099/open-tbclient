package com.baidu.tieba.passaccount.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.passaccount.app.LoginActivity;
/* loaded from: classes.dex */
public class LoginActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        bi.us().a(new b());
    }
}

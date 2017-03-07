package com.baidu.tieba.passaccount.framework;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.QALoginActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.baidu.tieba.passaccount.app.QALoginActivity;
/* loaded from: classes.dex */
public class LoginActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(QALoginActivityConfig.class, QALoginActivity.class);
        bb.vQ().a(new b());
    }
}

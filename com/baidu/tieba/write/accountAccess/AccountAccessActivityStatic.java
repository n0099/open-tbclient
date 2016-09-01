package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
/* loaded from: classes.dex */
public class AccountAccessActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(AccountAccessActivityConfig.class, AccountAccessActivity.class);
    }
}

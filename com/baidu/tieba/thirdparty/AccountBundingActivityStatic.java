package com.baidu.tieba.thirdparty;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountBundingActivityConfig;
/* loaded from: classes3.dex */
public class AccountBundingActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(AccountBundingActivityConfig.class, AccountBundlingActivity.class);
    }
}

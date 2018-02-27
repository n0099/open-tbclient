package com.baidu.tieba.thirdparty;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SocialLoginActivityConfig;
/* loaded from: classes2.dex */
public class SocialLoginActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(SocialLoginActivityConfig.class, SocialLoginActivity.class);
    }
}

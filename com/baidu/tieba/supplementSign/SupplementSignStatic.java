package com.baidu.tieba.supplementSign;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
/* loaded from: classes.dex */
public class SupplementSignStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(SupplementSignActivityConfig.class, SupplementSignActivity.class);
    }
}

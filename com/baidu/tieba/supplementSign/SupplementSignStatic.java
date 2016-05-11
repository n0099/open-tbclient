package com.baidu.tieba.supplementSign;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
/* loaded from: classes.dex */
public class SupplementSignStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(SupplementSignActivityConfig.class, SupplementSignActivity.class);
    }
}

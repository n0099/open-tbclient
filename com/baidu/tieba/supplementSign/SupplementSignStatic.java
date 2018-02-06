package com.baidu.tieba.supplementSign;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
/* loaded from: classes3.dex */
public class SupplementSignStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SupplementSignActivityConfig.class, SupplementSignActivity.class);
    }
}

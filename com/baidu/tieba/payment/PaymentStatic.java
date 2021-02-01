package com.baidu.tieba.payment;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
/* loaded from: classes9.dex */
public class PaymentStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(PayVcodeActivityConfig.class, PayVcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(PaymentConfirmActivityConfig.class, PaymentConfirmActivity.class);
    }
}

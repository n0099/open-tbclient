package com.baidu.tieba.payment;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
/* loaded from: classes.dex */
public class PaymentConfirmActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(PaymentConfirmActivityConfig.class, PaymentConfirmActivity.class);
    }
}

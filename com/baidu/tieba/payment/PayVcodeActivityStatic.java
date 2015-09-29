package com.baidu.tieba.payment;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
/* loaded from: classes.dex */
public class PayVcodeActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(PayVcodeActivityConfig.class, PayVcodeActivity.class);
    }
}

package com.baidu.tieba.wxapi;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
/* loaded from: classes.dex */
public class WXEntryActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(WXEntryActivityConfig.class, WXEntryActivity.class);
    }
}

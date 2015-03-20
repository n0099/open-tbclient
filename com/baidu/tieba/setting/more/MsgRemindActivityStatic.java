package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
/* loaded from: classes.dex */
public class MsgRemindActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(MsgRemindActivityConfig.class, MsgRemindActivity.class);
    }
}

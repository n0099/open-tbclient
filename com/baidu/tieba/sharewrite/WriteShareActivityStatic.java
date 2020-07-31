package com.baidu.tieba.sharewrite;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
/* loaded from: classes18.dex */
public class WriteShareActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }
}

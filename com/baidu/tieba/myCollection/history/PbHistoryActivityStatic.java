package com.baidu.tieba.myCollection.history;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
/* loaded from: classes6.dex */
public class PbHistoryActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PbHistoryActivityConfig.class, PbHistoryActivity.class);
    }
}

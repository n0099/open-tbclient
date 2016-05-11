package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
public class WriteImageActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
    }
}

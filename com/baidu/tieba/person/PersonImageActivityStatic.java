package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonImageActivityConfig;
/* loaded from: classes.dex */
public class PersonImageActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonImageActivityConfig.class, PersonImageActivity.class);
    }
}

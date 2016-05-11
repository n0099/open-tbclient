package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.data.PersonImageActivityConfig;
/* loaded from: classes.dex */
public class PersonImageActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(PersonImageActivityConfig.class, PersonImageActivity.class);
    }
}

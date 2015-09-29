package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.data.PersonListActivityConfig;
/* loaded from: classes.dex */
public class PersonListActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
    }
}

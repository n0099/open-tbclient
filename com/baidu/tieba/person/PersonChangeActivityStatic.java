package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
/* loaded from: classes.dex */
public class PersonChangeActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonChangeActivityConfig.class, PersonChangeActivity.class);
    }
}

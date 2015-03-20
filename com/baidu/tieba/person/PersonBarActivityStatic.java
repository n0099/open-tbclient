package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
/* loaded from: classes.dex */
public class PersonBarActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
    }
}

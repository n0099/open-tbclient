package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class PersonPostActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        ad.init();
    }
}

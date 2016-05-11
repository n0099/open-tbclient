package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.god.GodThreadListActivity;
import com.baidu.tieba.person.god.GodThreadListActivityConfig;
/* loaded from: classes.dex */
public class PersonPostActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        TbadkCoreApplication.m11getInst().RegisterIntent(GodThreadListActivityConfig.class, GodThreadListActivity.class);
        ag.init();
    }
}

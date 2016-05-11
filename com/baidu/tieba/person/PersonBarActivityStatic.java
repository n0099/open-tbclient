package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
/* loaded from: classes.dex */
public class PersonBarActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(107129);
        bVar.setResponsedClass(ResponseGetLivableForumList.class);
        bVar.i(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
    }
}

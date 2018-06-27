package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.person.data.PersonFriendActivityConfig;
import com.baidu.tieba.person.data.PersonImageActivityConfig;
import com.baidu.tieba.person.more.PersonCenterMoreActivity;
/* loaded from: classes3.dex */
public class PersonExtraStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(EditHeadActivityConfig.class, EditHeadActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonMoreActivityConfig.class, PersonCenterMoreActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonImageActivityConfig.class, PersonImageActivity.class);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(107129);
        bVar.setResponsedClass(ResponseGetLivableForumList.class);
        bVar.q(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        TbadkCoreApplication.getInst().RegisterIntent(PersonChangeActivityConfig.class, PersonChangeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditNickNameActivityConfig.class, EditNickNameActivity.class);
        SG();
    }

    private static void SG() {
        az.zV().a(new az.a() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.1
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                if (strArr[0].toLowerCase().contains("/interact/modifyname")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(tbPageContext.getPageActivity(), 25020, 0, null)));
                    return 0;
                }
                return 3;
            }
        });
    }
}

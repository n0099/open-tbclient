package com.baidu.tieba.post;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes3.dex */
public class PersonPostActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        m.init();
        ayW();
    }

    private static void ayW() {
        ax.wg().a(new ax.a() { // from class: com.baidu.tieba.post.PersonPostActivityStatic.1
            @Override // com.baidu.tbadk.core.util.ax.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                AccountData currentAccountObj;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                if (!strArr[0].contains("http://tieba.baidu.com/mo/q/myPost") || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(tbPageContext.getPageActivity(), currentAccountObj.getID(), currentAccountObj.getSex(), currentAccountObj.getPortrait())));
                return 0;
            }
        });
    }
}

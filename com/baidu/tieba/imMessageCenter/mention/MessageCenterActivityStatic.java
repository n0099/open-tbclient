package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity;
/* loaded from: classes2.dex */
public class MessageCenterActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(MessageCenterActivityConfig.class, MessageCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtMessageActivityConfig.class, AtMessageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AgreeMeActivityConfig.class, AgreeMeActivity.class);
        aEz();
    }

    private static void aEz() {
        az.zV().a(new az.a() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivityStatic.1
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("http://tieba.baidu.com/mo/q/chat") || str.contains("https://tieba.baidu.com/mo/q/chat")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getContext(), 1)));
                    return 0;
                }
                return 3;
            }
        });
    }
}

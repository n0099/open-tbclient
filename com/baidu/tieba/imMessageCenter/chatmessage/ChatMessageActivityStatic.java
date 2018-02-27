package com.baidu.tieba.imMessageCenter.chatmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes2.dex */
public class ChatMessageActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ChatMessageActivityConfig.class, ChatMessageActivity.class);
        aDW();
    }

    private static void aDW() {
        aw.Dt().a(new aw.a() { // from class: com.baidu.tieba.imMessageCenter.chatmessage.ChatMessageActivityStatic.1
            @Override // com.baidu.tbadk.core.util.aw.a
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

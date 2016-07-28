package com.baidu.tieba.imMessageCenter.chatmessage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
public class ChatMessageActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(ChatMessageActivityConfig.class, ChatMessageActivity.class);
        ajQ();
    }

    private static void ajQ() {
        bi.us().a(new b());
    }
}
